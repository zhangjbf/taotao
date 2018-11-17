package com.taotao.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/17
 */
public class TestPageHelper {

    @Test
    public void testPageHelper() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);

        TbItemExample example = new TbItemExample();

        PageHelper.startPage(1, 50);

        List<TbItem> list = itemMapper.selectByExample(example);

        for (TbItem tbItem : list) {
            System.out.println(tbItem.getTitle());
        }

        PageInfo<TbItem> info = new PageInfo<>(list);
        System.out.println(info.getTotal());


    }
}
