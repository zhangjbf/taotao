package com.taotao.rest.service.impl;

import com.taotao.rest.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/21
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "javaboy";
    }
}
