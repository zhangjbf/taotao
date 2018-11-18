package com.taotao.service;

import com.pub.model.Tree;

import java.util.List;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
public interface ItemCatService {

    List<Tree> getItemCatList(Integer id);
}
