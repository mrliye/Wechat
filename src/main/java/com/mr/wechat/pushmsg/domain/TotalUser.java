package com.mr.wechat.pushmsg.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * 拉取所有用户openid的数据模型
 */
public class TotalUser {
    private Integer total;
    private Integer count;
    private Map<String , List<String>> data;
    @JsonProperty("next_openid")
    private String nextOpenid;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Map<String, List<String>> getData() {
        return data;
    }

    public void setData(Map<String, List<String>> data) {
        this.data = data;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.nextOpenid = nextOpenid;
    }
}
