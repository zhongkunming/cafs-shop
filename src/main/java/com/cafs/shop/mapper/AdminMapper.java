package com.cafs.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafs.shop.domain.Admin;

public interface AdminMapper extends BaseMapper<Admin> {
    Admin getByUsername(String username);
}