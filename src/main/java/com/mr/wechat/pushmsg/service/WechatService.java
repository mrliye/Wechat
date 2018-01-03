package com.mr.wechat.pushmsg.service;

import com.mr.wechat.pushmsg.domain.Result;
import com.mr.wechat.pushmsg.domain.Token;
import com.mr.wechat.pushmsg.enums.SendType;
import com.mr.wechat.pushmsg.template.Template;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by mr on 2017/12/27.
 */
public interface WechatService {
    /**
     * 给Token赋值或者刷新Token
     * @return 有效的access_token
     */
    String getOrFlushToken(boolean flush);

    /**
     * 发送模板消息
     * @param template 封装消息信息
     * @param sendType 发送给那些人
     * @param touser 如果是worker leader boss all则无需填写，
     */
    List<Result> sendMsg(Template template, SendType sendType, String...touser );

    /**
     * 拉取粉丝信息并保存到数据库
     */
    void saveUsers();

}
