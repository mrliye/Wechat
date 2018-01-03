package com.mr.wechat.pushmsg.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mr.wechat.pushmsg.config.WechatParams;
import com.mr.wechat.pushmsg.domain.Result;
import com.mr.wechat.pushmsg.domain.Token;
import com.mr.wechat.pushmsg.domain.TotalUser;
import com.mr.wechat.pushmsg.enums.Role;
import com.mr.wechat.pushmsg.enums.SendType;
import com.mr.wechat.pushmsg.service.WCUserService;
import com.mr.wechat.pushmsg.service.WechatService;
import com.mr.wechat.pushmsg.template.Template;
import com.mr.wechat.pushmsg.vo.WCUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by mr on 2017/12/27.
 */
@Service
public class WechatServiceImpl implements WechatService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WechatParams wechatParams;
    @Autowired
    private WCUserService wcUserService;

    private String access_token;
    @Override
    public String getOrFlushToken(boolean flush) {
        synchronized (WechatServiceImpl.class){
            if(flush||this.access_token==null){
                Token token = restTemplate.getForObject(String.format(WechatParams.GET_TOKEN_URL, wechatParams.getAppID(), wechatParams.getAppsecret()), Token.class);
                this.access_token=token.getAccessToken();
                System.out.println("access_token="+access_token);
            }
        }
        return this.access_token;
    }

    @Override
    public List<Result> sendMsg(Template template, SendType sendType, String... touser) {
        List<Result> result = null;
        switch (sendType){
            case ALL:
                result = this.sendMsgToAll(template);
                break;
            case BOSS:
                result = this.sendMsgToBoss(template);
                break;
            case LEADER:
                result = this.sendMsgToLeader(template);
                break;
            case WORKER:
                result = this.sendMsgToWorker(template);
                break;
            case SOME:
                result = this.sendMsgToSome(template,touser);
                break;
        }
        return result;
    }

    @Override
    public void saveUsers() {
        //拉取所有用户
        List<String> openids = getAllOUser();
        //拉取用户的详细信息
        List<WCUserVo> vlist = getAllOUserInfo(openids);
        for(WCUserVo vo : vlist){
            wcUserService.saveWCUserService(vo);
        }
    }



    private List<Result> sendMsgToWorker(Template template) {
        //查询所有员工
        List<WCUserVo> users = wcUserService.findWCUserByRole(Role.WORKER);
        //获取员工的openid
        List<String> openids = new ArrayList<>();
        users.forEach(user->openids.add(user.getOpenid()));
        //推送消息
        List<Result> rlist = this.sendMsgToSome(template, openids.toArray(new String[]{}));
        return rlist;
    }

    private List<Result> sendMsgToLeader(Template template) {
        //查询所有部门领导
        List<WCUserVo> users = wcUserService.findWCUserByRole(Role.LEADER);
        //获取员工的openid
        List<String> openids = new ArrayList<>();
        users.forEach(user->openids.add(user.getOpenid()));
        //推送消息
        List<Result> rlist = this.sendMsgToSome(template, openids.toArray(new String[]{}));
        return rlist;
    }

    private List<Result> sendMsgToBoss(Template template) {
        //查询所有大领导
        List<WCUserVo> users = wcUserService.findWCUserByRole(Role.BOSS);
        //获取员工的openid
        List<String> openids = new ArrayList<>();
        users.forEach(user->openids.add(user.getOpenid()));
        //推送消息
        List<Result> rlist = this.sendMsgToSome(template, openids.toArray(new String[]{}));
        return rlist;
    }

    private List<Result> sendMsgToAll(Template template) {
        //查询所有人
        List<WCUserVo> users = wcUserService.findAll();
        //获取员工的openid
        List<String> openids = new ArrayList<>();
        users.forEach(user->openids.add(user.getOpenid()));
        //推送消息
        List<Result> rlist = this.sendMsgToSome(template, openids.toArray(new String[]{}));
        return rlist;
    }

    private List<Result> sendMsgToSome(Template template, String[] touser) {
        List<Result> rlist = new ArrayList<>();
        for(String user : touser){
            //模板消息设置发送人
            template.setTouser(user);
            //设置编码
            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            //封装发送参数
            HttpEntity<Template> request = new HttpEntity<Template>(template,headers);
            //拼接发送地址
            String url = String.format(WechatParams.SEND_MSG_URL, this.getOrFlushToken(false));
            //推送消息
            Result result = restTemplate.postForObject(url, request, Result.class);
            rlist.add(result);
        }
        return rlist;
    }

    /**
     * 获取所有用户的openid
     * @return
     */
    public List<String> getAllOUser() {
        List<String> openids = new ArrayList<>();
        String firstOpenid="";
        while(true){
            //获取所有用户
            TotalUser totalUser = restTemplate.getForObject(String.format(WechatParams.GET_ALL_USER_OPENID_URL, this.getOrFlushToken(false), firstOpenid), TotalUser.class);
            //将用户的openid存放到集合中
            openids.addAll(totalUser.getData().get("openid"));
            //因为一次拉取调用最多拉取10000个关注者的OpenID，如果集合的大小小于总用户（粉丝）数，就继续拉取；
            if(openids.size()>=totalUser.getTotal()){
                //设置下一次拉取的起始位置
                firstOpenid = totalUser.getNextOpenid();
                break;
            }
        }
        return openids;
    }

    /**
     * 拉取用户的详细信息
     * @param openids 用户openid集合
     * @return 用户集合
     */
    private List<WCUserVo> getAllOUserInfo(List<String> openids) {
        List<WCUserVo> vlist = new ArrayList<>();
        //设置编码
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //拉取用户详细信息的路径
        String url= String.format(WechatParams.GET_ALL_USER_INFO_URL,this.getOrFlushToken(false));
        //因为每次最多支持一次拉取100条，所以要计算拉取次数
        int count = (openids.size()%100 == 0 ? (openids.size()/100) : (openids.size()/100+1));
        //封装请求参数
        for(int i = 0; i<count; i++){
            String data = "";
            if(i !=(count-1)){
                data = this.getRequestParame(openids.subList(i*100,(i+1)*100));
            }else {
               data = this.getRequestParame(openids.subList(i*100,openids.size()));
            }
            HttpEntity<String> request = new HttpEntity<>(data,headers);
            String result = restTemplate.postForObject(url, request, String.class);
            try {
                //处理乱码
                result = new String(result.getBytes("ISO-8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //解析返回结果，获得用户的详细信息
            JSONObject jsonObject = JSON.parseObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("user_info_list");
            List<WCUserVo> voList = JSON.parseArray(jsonArray.toJSONString(), WCUserVo.class);
            vlist.addAll(voList);
        }
        return vlist;
    }

    /**
     * 根据接口的请求参数模型，封装请求参数
     * @param openids 用户的openid
     * @return 请求参数
     */
    private String getRequestParame(List<String> openids) {
        Map<String,List<Map<String , String>>>  parame = new HashMap<>();
        List<Map<String , String>> list = new ArrayList<>();
        openids.forEach(openid->list.add(this.putInMap(openid)));
        parame.put("user_list",list);
        return JSON.toJSONString(parame);
    }
    private Map<String , String> putInMap(String openid) {
        Map<String , String> map = new HashMap<>();
        map.put("openid",openid);
        map.put( "lang","zh_CN");
        return map;
    }
}
