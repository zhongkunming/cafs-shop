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
 * @TableName goods
 */
@TableName(value ="goods")
@Data
public class Goods implements Serializable {
    /**
     * 商品ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 卖家ID
     */
    private Long sellerId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 价格
     */
    private Double price;

    /**
     * 原价格
     */
    private Double originalPrice;

    /**
     * 描述
     */
    private String goodsDetail;

    /**
     * 数量
     */
    private Integer goodsNumber;

    /**
     * 热度
     */
    private Integer heat;

    /**
     * 图片1
     */
    private String picture1;

    /**
     * 图片2
     */
    private String picture2;

    /**
     * 图片3
     */
    private String picture3;

    /**
     * 图片4
     */
    private String picture4;

    /**
     * 图片5
     */
    private String picture5;

    /**
     * 精选1 白菜2
     */
    private Byte jbStatus;

    /**
     * 售出0 还有1
     */
    private Byte sellStatus;

    /**
     * 上架时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}