package com.cafs.shop.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName banner
 */
@TableName(value ="banner")
@Data
public class Banner implements Serializable {
    /**
     * 
     */
    @TableId
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
     * 名称
     */
    private String bannerName;

    /**
     * 价格
     */
    private Double bannerPrice;

    /**
     * 详情
     */
    private String bannerDetail;

    /**
     * 库存
     */
    private Integer bannerNumber;

    /**
     * 
     */
    private String img1;

    /**
     * 
     */
    private String img2;

    /**
     * 
     */
    private String img3;

    /**
     * 是否卖出
     */
    private Byte sellStatus;

    /**
     * 
     */
    private Date created;

    /**
     * 
     */
    private Date updated;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}