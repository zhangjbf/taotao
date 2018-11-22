package com.taotao.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/22
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public String showPortalIndexPage(){
        return "index";
    }
}
