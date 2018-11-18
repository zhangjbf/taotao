package com.taotao.controller;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("list")
    @ResponseBody
    public EUDataGridResult getListItems(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows) {
        EUDataGridResult result = itemService.getListItems(page, rows);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public WebAppResult saveItem(TbItem item, String desc) {
        WebAppResult webAppResult = itemService.saveItem(item, desc);
        return webAppResult;
    }


}
