package com.cafs.shop.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafs.shop.domain.Banner;
import com.cafs.shop.mapper.BannerMapper;
import com.cafs.shop.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> showBanner() {
        List<Banner> banners = bannerMapper.selectList(Wrappers.lambdaQuery());
        return banners;
    }
}
