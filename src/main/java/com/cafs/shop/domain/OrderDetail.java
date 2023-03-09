package com.cafs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName order_detail
 */
@TableName(value ="order_detail")
@Data
public class OrderDetail implements Serializable {
    /**
     * 订单详情ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 卖家ID
     */
    private Long sellerId;

    /**
     * 快递ID
     */
    private Long expressId;

    /**
     * 快递名称
     */
    private String expressName;

    /**
     * 快递价格
     */
    private Double expressPrice;

    /**
     * 商品图片
     */
    private String goodsImg;

    /**
     * 商品数量
     */
    private Integer buyCount;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 商品名称
     */
    private String goodsName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}