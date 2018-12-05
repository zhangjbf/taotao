package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pub.model.ItemCat;
import com.pub.model.Tree;
import com.pub.utils.ItemCatResult;
import com.pub.utils.MMCollectionUtil;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<Tree> getItemCatList(Integer id) {

        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(Long.valueOf(id));
        List<TbItemCat> itemCatList = tbItemCatMapper.selectByExample(example);

        List<Tree> listData = new ArrayList<>();
        if (MMCollectionUtil.isNotEmpty(itemCatList)) {
            Tree tree = null;
            //如果itemcats不为空，则构建成tree
            for (TbItemCat tbItemCat : itemCatList) {
                tree = new Tree();
                tree.setId(tbItemCat.getId() + "");
                tree.setPid(tbItemCat.getParentId() + "");
                tree.setState(tbItemCat.getIsParent() ? "closed" : "open");
                tree.setText(tbItemCat.getName());
                listData.add(tree);
            }
        }
        return listData;
    }

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
        int i = 0;
        for (TbItemCat tbItemCat : list) {
            i++;
            if (i > 14) {
                break;
            }
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
