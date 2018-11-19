package com.taotao.controller;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/19
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer size) {
        EUDataGridResult list = itemParamService.list(page, size);
        return list;
    }


    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public WebAppResult queryItemParamById(@PathVariable Long cid) {
        WebAppResult webAppResult = itemParamService.queryItemParamById(cid);
        return webAppResult;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public WebAppResult saveItemParam(@PathVariable Long cid, @RequestParam(value = "paramData") String paramData) {
        WebAppResult webAppResult = itemParamService.saveItemParam(cid, paramData);
        return webAppResult;
    }
}
