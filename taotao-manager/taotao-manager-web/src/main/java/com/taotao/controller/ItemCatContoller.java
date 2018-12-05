package com.taotao.controller;

import java.util.List;

import com.pub.model.Tree;
import com.pub.utils.ItemCatResult;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
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
public class ItemCatContoller {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<Tree> getItemCartList(@RequestParam(defaultValue = "0") Integer id) {
        List<Tree> itemCatList = itemCatService.getItemCatList(id);
        return itemCatList;
    }

    @RequestMapping("/rest/itemcat/all")
    @ResponseBody
    public MappingJacksonValue getAllItemCat(String callback) {
        ItemCatResult allItemCat = itemCatService.getAllItemCat();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(allItemCat);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

}
