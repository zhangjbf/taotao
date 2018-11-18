package com.taotao.controller;

import com.pub.model.Tree;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatContoller {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Tree> getItemCartList(@RequestParam(defaultValue = "0") Integer id) {
        List<Tree> itemCatList = itemCatService.getItemCatList(id);
        return itemCatList;
    }
}
