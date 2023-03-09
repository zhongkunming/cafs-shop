package com.cafs.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafs.shop.domain.Seller;

import java.util.List;
import java.util.Map;

public interface SellerMapper extends BaseMapper<Seller> {
    /**
     * 卖家分页
     * @param params
     * @return
     */
    List<Seller> sellerPage(Map<String,Object> params);

    /**
     * 卖家总数
     * @return
     */
    int getSellerCount();
}