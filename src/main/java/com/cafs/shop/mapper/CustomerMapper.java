package com.cafs.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cafs.shop.domain.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 查询用户
     * @param phone
     * @return
     */
    Customer getByPhone(String phone);

    Customer getByUsername(String username);

    List<Customer> page(Map<String,Object> params);

    void deleteMulti(Integer[] ids);

    int getUserCount();
}