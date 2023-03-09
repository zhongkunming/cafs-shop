package com.cafs.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafs.shop.domain.OrderDetail;

import java.util.List;

public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    /**
     *获取订单项
     * @param orderId
     * @return
     */
    List<OrderDetail> getByOrderId(Long orderId);
}