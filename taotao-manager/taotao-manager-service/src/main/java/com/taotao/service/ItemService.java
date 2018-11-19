package com.taotao.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;
import com.taotao.pojo.TbItem;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
public interface ItemService {

    EUDataGridResult getListItems(Integer page, Integer size);

    WebAppResult saveItem(TbItem tbItem, String desc, String itemParams);

    WebAppResult queryItemDesc(Long id);

    WebAppResult itemInstock(String ids);

    WebAppResult itemReshelf(String ids);

}
