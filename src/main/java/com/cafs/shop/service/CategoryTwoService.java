package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.CategoryTwo;

import java.util.List;

public interface CategoryTwoService extends IService<CategoryTwo> {
    /**
     * 查询所有子分类
     *
     * @return
     */
    List<CategoryTwo> getAll();
}
