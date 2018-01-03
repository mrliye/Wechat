package com.mr.wechat.pushmsg.controller;

import com.mr.wechat.pushmsg.domain.WCUser;
import com.mr.wechat.pushmsg.service.WCUserService;
import com.mr.wechat.pushmsg.utils.bean.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by mr on 2017/12/27.
 */
@RestController
public class UserController {

    @Autowired
    private WCUserService wcUserService;

    @RequestMapping("/loadUser")
    public DataModel<WCUser> loadUser(Integer page, Integer limit ){
        return wcUserService.loadUserService(page, limit );
    }


}
