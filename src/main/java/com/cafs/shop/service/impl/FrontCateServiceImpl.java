package com.cafs.shop.service.impl;

import com.cafs.shop.domain.Goods;
import com.cafs.shop.dto.PageResult;
import com.cafs.shop.mapper.GoodsMapper;
import com.cafs.shop.service.FrontCateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FrontCateServiceImpl implements FrontCateService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public PageResult<Goods> goodsPage(int pageNum, Long categoryId) {
        //一页的数量
        int pageSize = 6;
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsMapper.getByCate(categoryId);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);

        //获取分页结果
        List<Goods> goods = goodsPageInfo.getList();
        //创建一个分页对象
        PageResult<Goods> pageResult = new PageResult<>();
        //第几页
        pageResult.setPageNum(pageNum);
        //分页数据
        pageResult.setList(goods);
        //数据总条数
        Long total = goodsPageInfo.getTotal();
        pageResult.setTotal(total.intValue());
        //总页数
        int pageTotal = (total.intValue() + pageSize ) / pageSize;
        pageResult.setPageTotal(pageTotal);

        return pageResult;
    }
}
