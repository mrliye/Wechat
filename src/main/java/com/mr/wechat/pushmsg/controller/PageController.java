package com.mr.wechat.pushmsg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mr on 2017/12/27.
 */
@Controller
public class PageController {

    @RequestMapping("/loadIndexUI")
    public String loadIndexUI(){
        return "index";
    }
    @RequestMapping("/getmain")
    public String getmain(){
        return "main";
    }
    @RequestMapping("/toPaperTemplateUI")
    public String toPaperTemplateUI(){
        return "paperTemplateUI";
    }
    @RequestMapping("/toPeneralTemplateUI")
    public String showUserList(){
        return "generalTemplateUI";
    }
}
