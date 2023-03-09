package com.cafs.shop.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Customer;
import com.cafs.shop.dto.ComResult;
import com.cafs.shop.dto.PageInfo;

public interface UserService extends IService<Customer> {
    Customer login(String phone, String password);

    void register(String realname,String phone,String username,String password);

    boolean verPhone(String phone);

    PageInfo<Customer> page(int draw, int start, int length, Customer user);

    void delete(Long id);

    void saveUser(Customer user);

    Customer getById(Long id);

    void deleteMulti(Integer[] ids);

    ComResult updateInfo(Customer customer);

    ComResult checkXxUser(Customer customer);

    void deleteSelected(String[] sIds);

    int getUserCount();
}
