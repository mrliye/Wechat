package com.mr.wechat.pushmsg.enums;

/**
 * 发送类型
 */
public enum  SendType {
    ALL("all"),SOME("some"),WORKER("worker"),LEADER("leader"),BOSS("boss");
    private String type;
    private SendType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
