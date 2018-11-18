package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.utils.*;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemMapperWrapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Autowired
    private TbItemMapperWrapper tbItemMapperWrapper;

    @Override
    public EUDataGridResult getListItems(Integer page, Integer size) {

        TbItemExample example = new TbItemExample();

        PageHelper.startPage(page, size);

        List<TbItem> listItems = tbItemMapper.selectByExample(example);

        EUDataGridResult result = new EUDataGridResult();

        if (MMCollectionUtil.isNotEmpty(listItems)) {
            PageInfo<TbItem> info = new PageInfo(listItems);
            result.setRows(info.getList());
            result.setTotal(info.getTotal());
        }
        return result;
    }


    @Override
    public WebAppResult saveItem(TbItem tbItem, String desc) {
        Long id = IDUtils.genLongId();
        tbItem.setId(id);
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItemMapper.insert(tbItem);


        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());

        tbItemDescMapper.insert(tbItemDesc);

        return WebAppResult.ok();
    }

    @Override
    public WebAppResult queryItemDesc(Long id) {
        if (MMValueUtils.isNotEmpty(id)) {
            TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(id);
            if (MMValueUtils.isNotEmpty(tbItemDesc)) {
                return WebAppResult.ok(tbItemDesc);
            }
        }
        return WebAppResult.build(400, "查询失败");
    }

    /**
     * @returns
     * @Param
     * @author jiabin.zhang 张佳宾
     */
    @Override
    public WebAppResult itemInstock(String ids) {
        if (MMStringUtil.isNotEmpty(ids)) {
            String[] idArray = ids.split(",");
            List<Long> listIds = new ArrayList<>();
            if (MMArrayUtil.isNotEmpty(idArray)) {
                for (String id : idArray) {
                    listIds.add(Long.valueOf(id));
                }
                tbItemMapperWrapper.itemInstock(listIds);
                return WebAppResult.ok();

            }
        }
        return WebAppResult.build(400, "下架异常");
    }

    @Override
    public WebAppResult itemReshelf(String ids) {
        if (MMStringUtil.isNotEmpty(ids)) {
            String[] idArray = ids.split(",");
            List<Long> listIds = new ArrayList<>();
            if (MMArrayUtil.isNotEmpty(idArray)) {
                for (String id : idArray) {
                    listIds.add(Long.valueOf(id));
                }
                tbItemMapperWrapper.itemReshelf(listIds);
                return WebAppResult.ok();

            }
        }
        return WebAppResult.build(400, "上架异常");
    }
}
