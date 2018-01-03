//
//package test;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.mr.wechat.pushmsg.domain.Result;
//import com.mr.wechat.pushmsg.template.PaperTemplate;
//import com.mr.wechat.pushmsg.template.Template;
//import com.mr.wechat.pushmsg.utils.DateUtils;
//import com.mr.wechat.pushmsg.vo.WCUserVo;
//import org.junit.Test;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//
//
//
//public class TestDemo {
//
//    @Test
//    public void test(){
//        Template template = new PaperTemplate("11","22","22","22","22","22");
//        template.setTouser("234");
//        System.out.println(JSON.toJSONString(template));
//
//    }
//    @Test
//    public void test02(){
// List<WCUserVo> result;
//        try {
//
//
//           String str = "{\"user_info_list\":[{\"subscribe\":1,\"openid\":\"otvxTs4dckWG7imySrJd6jSi0CWE\",\"nickname\":\"iWithery\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"揭阳\",\"province\":\"广东\",\"country\":\"中国\",\"headimgurl\":\"http://wx.qlogo.cn/mmopen/xbIQx1GRqdvyqkMMhEaGOX802l1CyqMJNgUzKP8MeAeHFicRDSnZH7FY4XB7p8XHXIf6uJA2SCunTPicGKezDC4saKISzRj3nz/0\",\"subscribe_time\":1434093047,\"unionid\":\"oR5GjjgEhCMJFyzaVZdrxZ2zRRF4\",\"remark\":\"\",\"groupid\":0,\"tagid_list\":[128,2]},{\"subscribe\":0,\"openid\":\"otvxTs_JZ6SEiP0imdhpi50fuSZg\"}]}";
//            JSONObject jsonObject = JSON.parseObject(str);
//            JSONArray jsonArray = jsonObject.getJSONArray("user_info_list");
//            result = JSON.parseArray(jsonArray.toJSONString(), WCUserVo.class);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = new ArrayList<>();
//        }
//        for(WCUserVo vo : result){
//            System.out.println(vo.getOpenid()+"==="+vo.getNickname());
//        }
//
//        System.out.println(JSON.toJSONString(result));
//    }
//}

