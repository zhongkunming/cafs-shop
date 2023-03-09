package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Category;
import com.cafs.shop.dto.PageInfo;

import java.util.List;

public interface CategoryService extends IService<Category> {
    /**
     * 详情
     * @param id
     * @return
     */
    Category showCategory(Long id);

    /**
     * 分页
     * @param draw
     * @param start
     * @param length
     * @param category
     * @return
     */
    PageInfo<Category> page(int draw, int start, int length, Category category);

    /**
     * 保存分类
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 详情
     * @param id
     * @return
     */
    Category getById(Long id);

    /**
     * 删除
     * @param id
     */
    void deleteOne(int id);

    /**
     * 列表
     * @return
     */
    List<Category> categoryList();

    /**
     * 批量删除
     * @param sIds
     */
    void deleteSelected(String[] sIds);

}