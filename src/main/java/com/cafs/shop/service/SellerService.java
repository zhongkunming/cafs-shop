package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Seller;
import com.cafs.shop.dto.PageInfo;

public interface SellerService extends IService<Seller> {

    /**
     * 卖家详情
     * @param id
     * @return
     */
    Seller seller(Long id);

    /**
     * 分页
     * @param draw
     * @param start
     * @param length
     * @param seller
     * @return
     */
    PageInfo<Seller> page(int draw, int start, int length, Seller seller);

    void saveSeller(Seller seller);

    Seller getById(Long id);

    Seller login(String phone, String password);

    void register(String realname,String phone,String city,String password);

    void delete(Long id);

    void delSelected(String[] sIds);

    int getSellerCount();

    String getReputation(Long id);
}
