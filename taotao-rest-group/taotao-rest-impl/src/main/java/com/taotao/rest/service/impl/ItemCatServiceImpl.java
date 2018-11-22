package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pub.model.ItemCat;
import com.pub.utils.ItemCatResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/22
 */
@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;


    @Override
    public ItemCatResult getAllItemCat() {
        ItemCatResult r = new ItemCatResult();
        r.setData(getItemCatList(0L));
        return r;
    }

    private List<?> getItemCatList(Long parentid) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        //查询parentid为0的分类信息
        criteria.andParentIdEqualTo(parentid);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        List dataList = new ArrayList();
        for (TbItemCat tbItemCat : list) {
            //判断是否为父节点
            if (tbItemCat.getIsParent()) {
                ItemCat itemCat = new ItemCat();
                itemCat.setUrl("/category/" + tbItemCat.getId() + ".html");
                itemCat.setName(tbItemCat.getName());
                //递归调用
                itemCat.setItem(getItemCatList(tbItemCat.getId()));
                //添加到列表
                dataList.add(itemCat);
            } else {
                String catItem = "/item/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
                dataList.add(catItem);
            }
        }
        return dataList;
    }


}
