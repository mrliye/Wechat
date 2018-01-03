package com.mr.wechat.pushmsg.utils.bean;

import com.mr.wechat.pushmsg.domain.WCUser;

import java.util.List;

/**
 * 封装layui表格数据
 */
public class DataModel<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
