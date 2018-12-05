package com.taotao.service;

import java.util.List;

import com.pub.model.Tree;
import com.pub.utils.ItemCatResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
public interface ItemCatService {

    List<Tree> getItemCatList(Integer id);

    ItemCatResult getAllItemCat();
}
