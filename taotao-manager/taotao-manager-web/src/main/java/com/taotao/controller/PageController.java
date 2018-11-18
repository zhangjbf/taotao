package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */

@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{path}")
    public String showPage(@PathVariable String path) {
        return path;
    }

    @RequestMapping("/rest/page/{path}")
    public String showItemEidtPage(@PathVariable String path) {
        return path;
    }

}
