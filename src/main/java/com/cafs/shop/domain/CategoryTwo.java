package com.cafs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName category_two
 */
@TableName(value ="category_two")
@Data
public class CategoryTwo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long categoryId;

    /**
     * 
     */
    private String twoName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}