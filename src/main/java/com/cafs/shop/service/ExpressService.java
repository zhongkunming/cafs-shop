package com.cafs.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cafs.shop.domain.Express;
import com.cafs.shop.dto.PageInfo;

import java.util.List;

public interface ExpressService extends IService<Express> {
    /**
     * 分页
     * @param draw
     * @param start
     * @param length
     * @param express
     * @return
     */
    PageInfo<Express> page(int draw, int start, int length, Express express);

    /**
     * 保存或更新
     * @param express
     */
    void saveExpress(Express express);

    /**
     * 详情
     * @param id
     * @return
     */
    Express getById(int id);

    /**
     * 删除
     * @param id
     */
    void deleteOne(int id);

    /**
     * 列表
     * @return
     */
    List<Express> getAll();

    /**
     * 批量删除
     * @param sIds
     */
    void delSelected(String[] sIds);
}
