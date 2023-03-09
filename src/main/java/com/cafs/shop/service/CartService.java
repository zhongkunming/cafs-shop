package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {

    /**
     * 新增购物车
     * @param userId
     * @param sellerId
     * @param goodsId
     * @return
     */
    List<Cart> add(Long userId, Long sellerId, Long goodsId);

    /**
     * 删除
     * @param userId
     * @param goodsId
     * @return
     */
    List<Cart> delete(Long userId, Long goodsId);

    /**
     *
     * @param userId
     * @return
     */
    List<Cart> getByUserId(Long userId);

    /**
     * 根据用户ID删除购物车
     * @param userId
     */
    void  deleteByUserId(Long userId);
}
