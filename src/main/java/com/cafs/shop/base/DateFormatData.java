package com.cafs.shop.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description 时间格式化入参
 */
@Data
@ApiModel(description= "时间格式化入参")
public class DateFormatData {

    @ApiModelProperty(value = "开始时间")
    private String startDt;

    @ApiModelProperty(value = "开始时间")
    private String endDt;

}
