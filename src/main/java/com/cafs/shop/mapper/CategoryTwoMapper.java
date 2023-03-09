package com.cafs.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafs.shop.domain.CategoryTwo;

import java.util.List;

public interface CategoryTwoMapper extends BaseMapper<CategoryTwo> {
    List<CategoryTwo> getByCategoryId(Long categoryId);
}