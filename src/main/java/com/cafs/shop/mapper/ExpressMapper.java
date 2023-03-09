package com.cafs.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafs.shop.domain.Express;

import java.util.List;
import java.util.Map;

public interface ExpressMapper extends BaseMapper<Express> {
    List<Express>  expressPage(Map<String,Object> params);
}