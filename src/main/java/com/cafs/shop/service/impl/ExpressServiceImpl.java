package com.cafs.shop.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafs.shop.domain.Express;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.mapper.ExpressMapper;
import com.cafs.shop.service.ExpressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpressServiceImpl extends ServiceImpl<ExpressMapper, Express> implements ExpressService {

    @Resource
    private ExpressMapper expressMapper;

    @Override
    public PageInfo<Express> page(int draw, int start, int length, Express express) {
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("Express",express);

        int count = Math.toIntExact(expressMapper.selectCount(Wrappers.lambdaQuery(express)));
        PageInfo<Express> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(expressMapper.expressPage(params));

        return pageInfo;
    }

    /**
     * 保存快递信息
     * @param express
     */
    @Override
    public void saveExpress(Express express) {
        if (express.getId() == null){
            expressMapper.insert(express);
        }
        else {
            expressMapper.updateById(express);
        }
    }

    @Override
    public Express getById(int id) {
        Express express = expressMapper.selectById(id);
        return express;
    }

    @Override
    public void deleteOne(int id) {
        expressMapper.deleteById(id);
    }

    @Override
    public List<Express> getAll() {
        return expressMapper.selectList(Wrappers.lambdaQuery());
    }

    @Override
    public void delSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            expressMapper.deleteById(id);
        }
    }
}
