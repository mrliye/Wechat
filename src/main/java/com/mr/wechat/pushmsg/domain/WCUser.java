package com.mr.wechat.pushmsg.domain;

import com.mr.wechat.pushmsg.enums.Role;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户实体类
 */
@Entity(name = "t_wcuser")
public class WCUser {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String openid;
    @Column
    private String nickname;//昵称
    @Column
    private String city;//城市
    @Column
    private String province;//省份
    @Column
    private String country;//国家
    @Column
    private String remark;//备注
    @Column
    private Integer sex;//值为1时是男性，值为2时是女性，值为0时是未知
    @Column
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
