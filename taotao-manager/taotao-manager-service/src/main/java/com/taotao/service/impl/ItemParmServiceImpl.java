package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/19
 */
@Service
public class ItemParmServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public EUDataGridResult list(Integer page, Integer size) {
        EUDataGridResult result = new EUDataGridResult();
        if (MMValueUtils.isNotEmpty(page) && MMValueUtils.isNotEmpty(size)) {
            TbItemParamExample example = new TbItemParamExample();
            PageHelper.startPage(page, size);
            List<TbItemParam> listTbItemParam = tbItemParamMapper.selectByExampleWithBLOBs(example);
            if (MMCollectionUtil.isNotEmpty(listTbItemParam)) {
                PageInfo<TbItemParam> info = new PageInfo<>(listTbItemParam);
                result.setTotal(info.getTotal());
                result.setRows(info.getList());
            }
        }
        return result;
    }

    @Override
    public WebAppResult queryItemParamById(Long cid) {
        if (MMValueUtils.isNotEmpty(cid)) {
            TbItemParam tbItemParam = tbItemParamMapper.selectByPrimaryKey(cid);
            if (MMValueUtils.isNotEmpty(tbItemParam)) {
                return WebAppResult.ok(tbItemParam);
            }
        }
        return WebAppResult.build(400, "查询数据异常");
    }

    @Override
    public WebAppResult saveItemParam(Long cid, String paramData) {
        if (MMValueUtils.isNotEmpty(cid)) {
            TbItemParam tbItemParam = new TbItemParam();
            tbItemParam.setItemCatId(cid);
            tbItemParam.setParamData(paramData);
            tbItemParam.setCreated(new Date());
            tbItemParam.setUpdated(new Date());

            tbItemParamMapper.insert(tbItemParam);
        }
        return WebAppResult.ok();
    }
}
