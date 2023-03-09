package com.cafs.shop.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafs.shop.domain.Goods;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.mapper.GoodsMapper;
import com.cafs.shop.service.GoodsService;
import com.cafs.shop.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>  implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private IdWorker idWorker;

    @Override
    public Goods detail(Long id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public List<Goods> showChosen() {
        List<Goods> chosen = goodsMapper.getChosen();
        return chosen;
    }

    @Override
    public List<Goods> showAll() {
        List<Goods> goodsList = goodsMapper.selectList(Wrappers.lambdaQuery());
        return goodsList;
    }

    @Override
    public List<Goods> showCheaper() {
        List<Goods> cheaper = goodsMapper.getCheaper();
        return cheaper;
    }

    @Override
    public List<Goods> showByCate(Long categoryId) {
        List<Goods> goodsByCate = goodsMapper.getByCate(categoryId);
        return goodsByCate;
    }

    @Override
    public List<Goods> getBySellerId(Long sellerId) {
//        Example example = new Example(Goods.class);
//        example.createCriteria().andEqualTo("sellerId",sellerId);
        return goodsMapper.selectList(Wrappers.<Goods>lambdaQuery().eq(Goods::getSellerId,sellerId));
    }

    @Override
    public PageInfo<Goods> page(int draw, int start, int length, Goods goods) {
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("goods",goods);

        int count = Math.toIntExact(goodsMapper.selectCount(Wrappers.lambdaQuery(goods)));
        PageInfo<Goods> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(goodsMapper.goodsPage(params));

        return pageInfo;
    }

    @Override
    public void saveGoods(Goods goods) {
        //设置更新时间
        goods.setUpdated(new Date());

        if (goods.getId() == null){
            goods.setCreated(new Date());
            goods.setId(idWorker.nextId());
            goodsMapper.insert(goods);
        }
        else {
            goodsMapper.updateById(goods);
        }
    }

    @Override
    public void updateJb(Long goodsId, int selected) {
        Goods goods = goodsMapper.selectById(goodsId);
        if (selected == 1){
            goods.setJbStatus((byte) 2);
            goodsMapper.updateById(goods);
        }else{
            goods.setJbStatus((byte) 1);
            goodsMapper.updateById(goods);
        }
    }

    @Override
    public void delete(Long id) {
        goodsMapper.deleteById(id);
    }

    @Override
    public void deleteSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            goodsMapper.deleteById(id);
        }
    }

    @Override
    public double getTotalSum() {
        return goodsMapper.getTotalSum();
    }

    @Override
    public int getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public void delSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            goodsMapper.deleteById(id);
        }
    }

    @Override
    public Map<String, Object> IndexInfoBySellerId(Long id) {
        Map<String,Object> map =new HashMap<>();

        int countBySellerId = goodsMapper.GoodsCountBySellerId(id);
        map.put("countBySellerId",countBySellerId);

//        Example example = new Example(Goods.class);
//        example.createCriteria().andEqualTo("sellerId",id).andEqualTo("sellStatus",0);
        List<Goods> goods = goodsMapper.selectList(Wrappers.<Goods>lambdaQuery().eq(Goods::getSellerId,id).eq(Goods::getSellStatus,0));
        int soldCount = goods.size();
        double soldMoney =0;
        for (Goods good : goods) {
            soldMoney += good.getPrice();
        }
        map.put("soldCount",soldCount);
        map.put("soldMoney",soldMoney);

        return map;
    }

    @Override
    public List<Goods> searchSome(String search) {
//        Example example = new Example(Goods.class);
//        example.createCriteria().andLike("goodsName","%"+search+"%");
        List<Goods> goods = goodsMapper.selectList(Wrappers.<Goods>lambdaQuery().like(Goods::getGoodsName,search));
        return goods;
    }

}
