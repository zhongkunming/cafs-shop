package com.cafs.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafs.shop.domain.Admin;
import com.cafs.shop.mapper.AdminMapper;
import com.cafs.shop.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminMapper.getByUsername(username);

        if(admin != null){
            if (admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }
}
