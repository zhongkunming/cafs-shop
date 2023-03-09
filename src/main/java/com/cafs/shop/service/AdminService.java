package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Admin;

public interface AdminService extends IService<Admin> {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Admin login(String username, String password);

}
