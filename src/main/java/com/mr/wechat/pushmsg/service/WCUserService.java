package com.mr.wechat.pushmsg.service;

import com.mr.wechat.pushmsg.domain.WCUser;
import com.mr.wechat.pushmsg.enums.Role;
import com.mr.wechat.pushmsg.utils.bean.DataModel;
import com.mr.wechat.pushmsg.vo.WCUserVo;

import java.util.List;

/**
 * Created by mr on 2017/12/27.
 */
public interface WCUserService {
    /**
     * 查询所有用户（粉丝）
     * @return 用户集合
     */
    List<WCUserVo> findAll();

    /**
     * 根据角色查询用户
     * @param role 用户角色
     * @return 用户集合
     */
    List<WCUserVo> findWCUserByRole(Role role);

    /**
     * 添加用户
     * @param wvo 封装用户信息
     */
    void saveWCUserService(WCUserVo wvo);

    /**
     * 查询所有用户（分页）
     * @param page 当前页
     * @param limit 每页显示条数
     */
    DataModel<WCUser> loadUserService(Integer page, Integer limit);
}
