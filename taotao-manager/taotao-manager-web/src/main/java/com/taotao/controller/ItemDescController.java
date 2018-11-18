package com.taotao.controller;

import com.pub.utils.WebAppResult;
import com.taotao.service.ItemService;
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
 * @CreateDate 2018/11/18
 */
@Controller
public class ItemDescController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/rest/item/query/item/desc/{id}")
    @ResponseBody
    public WebAppResult queryItemDesc(@PathVariable Long id) {
        WebAppResult webAppResult = itemService.queryItemDesc(id);
        return webAppResult;
    }

    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public WebAppResult itemInstock(@RequestParam(value = "ids") String ids) {
        WebAppResult webAppResult = itemService.itemInstock(ids);
        return webAppResult;
    }


    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public WebAppResult itemReshelf(@RequestParam(value = "ids") String ids) {
        WebAppResult webAppResult = itemService.itemReshelf(ids);
        return webAppResult;
    }

}
