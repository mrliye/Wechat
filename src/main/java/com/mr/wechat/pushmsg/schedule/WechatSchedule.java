package com.mr.wechat.pushmsg.schedule;

import com.mr.wechat.pushmsg.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class WechatSchedule {
    @Autowired
    private WechatService wechatService;

    /**
     * access_token两个小时后会过期，所以要每隔两个小时刷新一下
     */
    @Scheduled(cron = "? 0 0-2 * * ? ")
    public void flushToken(){
        wechatService.getOrFlushToken(true);
    }
}
