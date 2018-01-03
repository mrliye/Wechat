package com.mr.wechat.pushmsg.template;

import com.mr.wechat.pushmsg.config.WechatParams;
import com.mr.wechat.pushmsg.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件消息模板
 */
public class PaperTemplate extends Template {
    private String head;
    private String title;
    private String date;
    private String feel;
    private String remark;
    private String templateId = WechatParams.PAPER_TEMPLATE_ID;
    private String url = WechatParams.PAPER_TEMPLATE_URL;

    public PaperTemplate(String head, String title,String feel, String remark) {
        super.setTemplate_id(this.templateId);
        super.setUrl(this.url);
        Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
        data.put("head",super.dataItem(head,"#173177"));
        data.put("title",super.dataItem(title,"#173177"));
        data.put("date",super.dataItem(DateUtils.getFormateDate_03(),"#173177"));
        data.put("feel",super.dataItem(feel,"#173177"));
        data.put("remark",super.dataItem(remark,"#173177"));
        super.setData(data);
    }
    public PaperTemplate(Map<String, String> msgParams) {
        super.setTemplate_id(this.templateId);
        super.setUrl(this.url);
        Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
        for(Map.Entry<String, String> entry: msgParams.entrySet()){
            data.put("head",super.dataItem(msgParams.get("head"),"#173177"));
            data.put("title",super.dataItem(msgParams.get("title"),"#173177"));
            data.put("date",super.dataItem(DateUtils.getFormateDate_03(),"#173177"));
            data.put("feel",super.dataItem(msgParams.get("feel"),"#173177"));
            data.put("remark",super.dataItem(msgParams.get("remark"),"#173177"));
        }
        super.setData(data);
    }

}
