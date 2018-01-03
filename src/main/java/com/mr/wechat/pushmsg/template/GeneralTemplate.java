package com.mr.wechat.pushmsg.template;

import com.mr.wechat.pushmsg.config.WechatParams;
import com.mr.wechat.pushmsg.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装通用模板消息的模板，模板中标签从页面获取
 */
public class GeneralTemplate extends Template {
    private String url= WechatParams.GENERAL_TEMPLATE_URL;//点击模板消息后跳转路径
    private String color= WechatParams.GENERAL_TEMPLATE_COLOR;//标签颜色

    public GeneralTemplate(String templateId,Map<String, String> lableNameAndValues) {
        super.setTemplate_id(templateId);
        super.setUrl(this.url);
        Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
        for(Map.Entry<String,String> entry : lableNameAndValues.entrySet()){
            data.put(entry.getKey(),super.dataItem(entry.getValue(),this.color));
        }
        super.setData(data);
    }
}
