package com.cafs.shop.controller.seller;


import com.cafs.shop.domain.Goods;
import com.cafs.shop.domain.Seller;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("sellerGoods")
@Api(value = "卖家商品", tags = "卖家商品接口")
public class SellerGoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 遍历商品信息
     *
     * @param request
     * @param goods
     * @return
     */
    @ApiOperation(value = "遍历商品信息")
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Goods> pageInfo(HttpServletRequest request, Goods goods) {
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 10 : Integer.parseInt(strlength);

        PageInfo<Goods> pageInfo = goodsService.page(draw, start, length, goods);
        return pageInfo;
    }

    /**
     * 商品列表
     * @param session
     * @return
     */
    @ApiOperation(value = "商品列表")
    @GetMapping("list")
    public String toSellerGoods(HttpSession session) {
        return "seller/seller_goods";
    }

    /**
     * 保存商品信息
     *
     * @param goods
     * @param session
     * @return
     */
    @ApiOperation(value = "保存商品信息")
    @Transactional
    @PostMapping("save")
    public String addGoods(Goods goods, HttpSession session) {
        Seller seller = (Seller) session.getAttribute("seller");
        goods.setSellerId(seller.getId());
        goodsService.saveGoods(goods);
        return "seller/seller_goods";
    }

    /**
     * 在修改商品信息时将商品原本信息传入
     *
     * @param model
     * @param session
     * @return
     */
    @ApiOperation(value = "在修改商品信息时将商品原本信息传入")
    @GetMapping("add")
    public String toAdd(Model model, HttpSession session) {
        Seller seller = (Seller) session.getAttribute("seller");
        model.addAttribute("seller", seller);
        return "seller/goods_from";
    }

    /**
     * 更新商品
     *
     * @param id
     * @param model
     * @return
     */
    @ApiOperation(value = "更新商品")
    @GetMapping("update")
    public String update(Long id, Model model) {
        Goods goods = goodsService.detail(id);
        model.addAttribute("goods", goods);
        return "seller/goods_update";
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除商品")
    @GetMapping("delete")
    public String delete(Long id) {
        goodsService.delete(id);
        return "seller/seller_goods";
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除选中")
    @GetMapping("delSelected")
    public String delSelected(String ids) {
        String sIds[] = ids.split(",");
        goodsService.delSelected(sIds);
        return "seller/seller_goods";
    }
}
