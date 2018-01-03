package com.mr.wechat.pushmsg.enums;

/**
 * Created by mr on 2017/12/27.
 */
public enum Role {
    WORKER(0,"worker"),LEADER(1,"leader"),BOSS(2,"boss");
    private Integer rid;
    private String role;

   private Role(Integer rid, String role) {
        this.rid = rid;
        this.role = role;
    }
}
