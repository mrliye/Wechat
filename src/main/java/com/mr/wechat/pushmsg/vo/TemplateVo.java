package com.mr.wechat.pushmsg.vo;

import java.util.Map;

/**
 * 接受页面传递过来的模板消息的参数
 */
public class TemplateVo {
   private Map<String,String> msgs;
   private  String templateId;

    public Map<String, String> getMsgs() {
        return msgs;
    }

    public void setMsgs(Map<String, String> msgs) {
        this.msgs = msgs;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
