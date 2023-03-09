package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Banner;

import java.util.List;

public interface BannerService extends IService<Banner> {

    /**
     * 广告列表
     * @return
     */
    List<Banner> showBanner();
}
