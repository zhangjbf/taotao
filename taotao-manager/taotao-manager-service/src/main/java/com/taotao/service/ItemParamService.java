package com.taotao.service;

import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/19
 */
public interface ItemParamService {

    EUDataGridResult list(Integer page, Integer size);

    WebAppResult queryItemParamById(Long cid);

    WebAppResult saveItemParam(Long cid, String paramData);

}
