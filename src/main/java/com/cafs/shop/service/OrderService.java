package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.ShopOrder;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.vo.OrderVO;

public interface OrderService extends IService<ShopOrder> {
    PageInfo<ShopOrder> page(int draw, int start, int length, ShopOrder order);

//    ComResult addOrder(ShopOrder order);
//
//    ComResult checkOrder(ShopOrder order);

    /**
     * 创建订单
     *
     * @param userId 会员 ID
     * @param  expressId  快递 ID
     * @return 订单 ID
     */
    Long create(Long userId, Long expressId);

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    OrderVO getById(Long orderId);

    /**
     * 更新订单
     * @param order
     */
    void updateOrder(ShopOrder order);

    /**
     * 获取用户ID
     * @param orderId
     * @return
     */
    Long getUserId(Long orderId);

    /**
     * 详情
     * @param userId
     * @return
     */
    OrderVO getOrderId(Long userId);

    /**
     * 更新状态
     * @param id
     */
    void updateStatus(Long id);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 批量删除
     * @param sIds
     */
    void delSelected(String[] sIds);
}
