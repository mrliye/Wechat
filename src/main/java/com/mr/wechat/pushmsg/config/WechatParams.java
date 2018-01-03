package com.mr.wechat.pushmsg.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by mr on 2017/12/27.
 */
public class WechatParams {
    @Value("${wechatparam.appID}")
    private String appID;
    @Value("${wechatparam.appsecret}")
    private String appsecret;
    //获取token的url
    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    //发送模板消息的url
    public static final String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";
    //获取所有用户openid的url
    public static final String GET_ALL_USER_OPENID_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";
    //获得单个用户详细信息的url
    public static final String GET_USER_INFO_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
    //批量获取用户基本信息url
    public static final String GET_ALL_USER_INFO_URL="https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s";
    //配置PaperTemplate参数
    public static  String PAPER_TEMPLATE_ID;
    public static  String PAPER_TEMPLATE_URL;
    //配置generalTemplate参数
    public static  String GENERAL_TEMPLATE_COLOR;
    public static  String GENERAL_TEMPLATE_URL;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    @Value("${paperTemplate.templateId}")
    public void setPaperTemplateId(String paperTemplateId) {
        PAPER_TEMPLATE_ID = paperTemplateId;
    }

    @Value("${paperTemplate.url}")
    public void setPaperTemplateUrl(String paperTemplateUrl) {
        PAPER_TEMPLATE_URL = paperTemplateUrl;
    }
    @Value("${generalTemplate.url}")
    public void setGeneralTemplateColor(String generalTemplateColor) {
        GENERAL_TEMPLATE_COLOR = generalTemplateColor;
    }
    @Value("${generalTemplate.color}")
    public void setGeneralTemplateUrl(String generalTemplateUrl) {
        GENERAL_TEMPLATE_URL = generalTemplateUrl;
    }
}
