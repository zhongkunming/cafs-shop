package com.cafs.shop.controller;

import com.cafs.shop.domain.Cart;
import com.cafs.shop.domain.Category;
import com.cafs.shop.domain.CategoryTwo;
import com.cafs.shop.domain.Goods;
import com.cafs.shop.domain.Seller;
import com.cafs.shop.domain.Customer;
import com.cafs.shop.service.CartService;
import com.cafs.shop.service.CategoryService;
import com.cafs.shop.service.CategoryTwoService;
import com.cafs.shop.service.GoodsService;
import com.cafs.shop.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("sellerInfo")
public class SellerInfoController {
    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryTwoService categoryTwoService;

    @Resource
    private CartService cartService;

    @Resource
    private SellerService sellerService;

    @Resource
    private GoodsService goodsService;

    /**
     * 卖家信息页
     * @param id
     * @param model
     * @param session
     * @return
     */
    @GetMapping("detail/{id}")
    public String toSellerInfo(@PathVariable Long id, Model model, HttpSession session){
        // 获取用户 ID
        Customer user = (Customer) session.getAttribute("user");

        // 购物车
        List<Cart> cartGoods = new ArrayList<>();
        if (user != null){
            cartGoods = cartService.getByUserId(user.getId());
        }
        Double total = 0.0;
        int goodsCount = cartGoods.size();
        if (cartGoods.size() >0){
            for (int i = 0; i< cartGoods.size(); i++){
                total += cartGoods.get(i).getBuyCount() * cartGoods.get(i).getGoodsPrice();
            }
        }
        // 父分类
        List<Category> categories = categoryService.categoryList();

        // 查询所有子分类
        List<CategoryTwo> categoryTwos = categoryTwoService.getAll();

        //查询卖家信息
        Seller seller = sellerService.getById(id);

        //查询该卖家的商品
        List<Goods> goods = goodsService.getBySellerId(id);


        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("seller",seller);
        model.addAttribute("goods",goods);
        return "sellerInfo";
    }
}
