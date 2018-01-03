package com.mr.wechat.pushmsg.controller;

import com.mr.wechat.pushmsg.domain.Result;
import com.mr.wechat.pushmsg.enums.SendType;
import com.mr.wechat.pushmsg.service.WechatService;
import com.mr.wechat.pushmsg.template.GeneralTemplate;
import com.mr.wechat.pushmsg.template.PaperTemplate;
import com.mr.wechat.pushmsg.template.Template;
import com.mr.wechat.pushmsg.vo.TemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by mr on 2017/12/27.
 */
@Controller
public class WechatController {
    @Autowired
    private WechatService wechatService;

    /**
     * 发送定义好模板类的消息
     */
    @RequestMapping("/sendPaperMsg")
    @ResponseBody
    public List<Result> sendPaperMsg(TemplateVo templateVo, String[] usres, String sendType){
        List<Result> list = null;
        System.out.println(templateVo.getMsgs());
        Template template = new PaperTemplate(templateVo.getMsgs());
        if(usres!=null&&usres.length!=0){
            list = wechatService.sendMsg(template, SendType.SOME, usres);
        }
        switch (sendType){
            case "all":
                list = wechatService.sendMsg(template, SendType.ALL);
                break;
            case "boss":
                list = wechatService.sendMsg(template, SendType.BOSS);
                break;
            case "leader":
                list = wechatService.sendMsg(template, SendType.LEADER);
                break;
            case "worker":
                list = wechatService.sendMsg(template, SendType.WORKER);
                break;
           /* case "some":
                list = wechatService.sendMsg(template, SendType.SOME, usres);
                break;*/
           default:

               break;
        }
        return list;
    }
    /**
     * 发送通用模板类的消息
     */
    @RequestMapping("/sendGeneralMsg")
    @ResponseBody
    public List<Result> sendGeneralMsg(TemplateVo templateVo,String[] usres,String sendType){
        List<Result> list = null;
        Template template = new GeneralTemplate(templateVo.getTemplateId(),templateVo.getMsgs());
        if(usres!=null&&usres.length!=0){
            list = wechatService.sendMsg(template, SendType.SOME, usres);
        }
        switch (sendType){
            case "all":
                list = wechatService.sendMsg(template, SendType.ALL);
                break;
            case "boss":
                list = wechatService.sendMsg(template, SendType.BOSS);
                break;
            case "leader":
                list = wechatService.sendMsg(template, SendType.LEADER);
                break;
            case "worker":
                list = wechatService.sendMsg(template, SendType.WORKER);
                break;
            case "some":
                list = wechatService.sendMsg(template, SendType.SOME, usres);
                break;
        }
        return list;
    }

    /**
     * 拉取并保存用户
     */
    @GetMapping("/saveAllUsers")
    @ResponseBody
    public void saveAllUsers() {
        wechatService.saveUsers();
    }
}
