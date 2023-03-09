package com.cafs.shop.vo;

import com.cafs.shop.domain.Express;
import com.cafs.shop.domain.OrderDetail;
import com.cafs.shop.domain.Customer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderVO implements Serializable {
    /**
     * 订单ID
     */
    private Long id;

    /**
     * 快递
     */
    private Express express;

    /**
     * 订单项集合
     */
    private List<OrderDetail> orderDetails;

    /**
     *订单总额
     */
    private Double total;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单状态
     */
    private Byte status;

    /**
     * 会员信息
     */
    private Customer user;

}
