package com.taotao.service.impl;

import com.pub.model.Tree;
import com.pub.utils.MMCollectionUtil;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
