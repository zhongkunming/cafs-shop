package com.cafs.shop.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName address
 */
@TableName(value ="address")
@Data
public class Address implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String conPhone;

    /**
     * 
     */
    private String detailAddr;

    /**
     * 
     */
    private String postcode;

    /**
     * 
     */
    private Date created;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}