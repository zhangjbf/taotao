package com.taotao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
public interface TbItemMapperWrapper {

    void itemInstock(@Param("ids") List<Long> ids);

    void itemReshelf(@Param("ids") List<Long> ids);

}
