package com.cafs.shop.service;

import com.cafs.shop.domain.Goods;
import com.cafs.shop.dto.PageResult;

public interface FrontCateService {
    /**
     * 分页
     * @param pageNum
     * @param categoryId
     * @return
     */
    PageResult<Goods> goodsPage(int pageNum, Long categoryId);
}
