package com.cafs.shop.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description 时间格式化入参
 * @author jzh
 * @date 2021/4/22 15:27
 */
@Data
@ApiModel(description= "时间格式化入参")
public class DateFormatData {

    @ApiModelProperty(value = "开始时间")
    private String startDt;

    @ApiModelProperty(value = "开始时间")
    private String endDt;

}
