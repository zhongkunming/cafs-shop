package com.cafs.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "customer_oper")
public class CustomerOper {
    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "good_id")
    private Long goodId;

    @TableField(value = "oper_time")
    private Date operTime;

    @TableField(value = "oper_type")
    private String operType;

    @TableField(value = "preference")
    private Double preference;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_GOOD_ID = "good_id";

    public static final String COL_OPER_TIME = "oper_time";

    public static final String COL_OPER_TYPE = "oper_type";

    public static final String COL_PREFERENCE = "preference";
}