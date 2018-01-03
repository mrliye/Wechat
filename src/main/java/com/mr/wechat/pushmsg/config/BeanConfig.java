package com.mr.wechat.pushmsg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 实例化Bean并注入spring容器
 */
@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate getReference(){
        return new RestTemplate();
    }
    @Bean
    public WechatParams getWechatParams(){
        return new WechatParams();
    }
}
