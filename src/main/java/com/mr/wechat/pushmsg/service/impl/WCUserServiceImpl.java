package com.mr.wechat.pushmsg.service.impl;

import com.mr.wechat.pushmsg.dao.WCUserDao;
import com.mr.wechat.pushmsg.domain.WCUser;
import com.mr.wechat.pushmsg.enums.Role;
import com.mr.wechat.pushmsg.service.WCUserService;
import com.mr.wechat.pushmsg.utils.CopyUtils;
import com.mr.wechat.pushmsg.utils.bean.DataModel;
import com.mr.wechat.pushmsg.vo.WCUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by mr on 2017/12/27.
 */
@Service
public class WCUserServiceImpl implements WCUserService {
    @Autowired
    private WCUserDao wcUserDao;
    @Override
    public List<WCUserVo> findAll() {
        List<WCUser> wcUsers = wcUserDao.findAll();
        return CopyUtils.copyPropreties(wcUsers, WCUserVo.class);
    }

    @Override
    public List<WCUserVo> findWCUserByRole(Role role) {
        List<WCUser> wcUsers = wcUserDao.findWCUserByRole(role);
        return CopyUtils.copyPropreties(wcUsers, WCUserVo.class);
    }

    @Override
    public void saveWCUserService(WCUserVo wvo) {
        WCUser user = new WCUser();
        BeanUtils.copyProperties(wvo,user);
        wcUserDao.save(user);
    }

    @Override
    public DataModel<WCUser> loadUserService(Integer page, Integer limit) {
        PageRequest pageable = new PageRequest(page,limit);
        Page<WCUser> all = wcUserDao.findAll(pageable);
        List<WCUser> wcUsers = all.getContent();
        DataModel<WCUser> dm = new DataModel<WCUser>();
        dm.setData(all.getContent());
        dm.setCount(all.getTotalElements());
        dm.setCode(0);
        dm.setMsg("");
        return dm;
    }
}
