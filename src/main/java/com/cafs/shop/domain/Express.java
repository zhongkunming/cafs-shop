package com.cafs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName express
 */
@TableName(value ="express")
@Data
public class Express implements Serializable {
    /**
     * 快递ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 快递名称
     */
    private String expressName;

    /**
     * 快递价格
     */
    private Double expressPrice;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}