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
 * @TableName seller
 */
@TableName(value ="seller")
@Data
public class Seller implements Serializable {
    /**
     * 卖家ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 卖家名
     */
    private String sellerName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 信誉程度
     */
    private String reputation;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}