package com.mr.wechat.pushmsg.domain;

/**
 * 封装发送模板后的返回信息
 */
public class Result {
    private Integer errcode;
    private String errmsg;
    private String msgid;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
}
