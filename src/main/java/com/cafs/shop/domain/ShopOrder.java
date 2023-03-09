package com.cafs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName shop_order
 */
@TableName(value ="shop_order")
@Data
public class ShopOrder implements Serializable {
    /**
     * 订单ID
     */
    @TableId(type = IdType.INPUT)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 快递ID
     */
    private Long expressId;

    /**
     * 订单价格
     */
    private Double orderPrice;

    /**
     * 订单备注
     */
    private String orderRemarks;

    /**
     * 1完成  2未完成
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 完成时间
     */
    private Date overTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}