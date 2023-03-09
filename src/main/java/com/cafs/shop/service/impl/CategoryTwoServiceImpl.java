package com.cafs.shop.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafs.shop.domain.CategoryTwo;
import com.cafs.shop.mapper.CategoryTwoMapper;
import com.cafs.shop.service.CategoryTwoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryTwoServiceImpl extends ServiceImpl<CategoryTwoMapper, CategoryTwo> implements CategoryTwoService {
    @Resource
    private CategoryTwoMapper categoryTwoMapper;

    @Override
    public List<CategoryTwo> getAll() {
        return categoryTwoMapper.selectList(Wrappers.lambdaQuery());
    }
}
