package com.mr.wechat.pushmsg.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Token实体类
 */
public class Token {
    @JsonProperty("access_token")//用于json解析和转化
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
