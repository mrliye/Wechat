package com.mr.wechat.pushmsg.template;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mr on 2017/12/27.
 */
public class Template {
    private String touser;//用户的openid
    @JsonProperty("template_id")
    private String template_id;//模板消息的id
    private String url;//点击消息跳转的页面
    private Map<String,Map<String,String>> data;//消息内容

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

    public Map<String,String> dataItem(String value,String color){
        Map<String, String> map = new HashMap<>();
        map.put("value",value);
        map.put("color",color);
        return map;
    }
}
