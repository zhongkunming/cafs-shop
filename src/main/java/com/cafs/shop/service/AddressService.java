package com.cafs.shop.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Address;

public interface AddressService extends IService<Address> {

    /**
     * 地址详情
     * @param userId
     * @return
     */
    Address getByUserId(Long userId);

}
