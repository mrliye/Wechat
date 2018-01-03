package com.mr.wechat.pushmsg.dao;

import com.mr.wechat.pushmsg.domain.WCUser;
import com.mr.wechat.pushmsg.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mr on 2017/12/27.
 */
public interface WCUserDao extends JpaRepository<WCUser,Long> {
    /**
     * 根据id查询用户
     * @param id 用户的id
     * @return 用户
     */
    List<WCUser> findWCUserById(Integer id);

    /**
     * 根据角色查询用户
     * @param role
     * @return
     */
    List<WCUser> findWCUserByRole(Role role);


}
