package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
@Controller
@RequestMapping("/hello")
public class TestController {

    @RequestMapping("/world")
    @ResponseBody
    public String hello(){
        return "Hello javaboy";
    }
}
