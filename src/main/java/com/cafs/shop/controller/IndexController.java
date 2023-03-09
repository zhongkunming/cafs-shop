package com.cafs.shop.controller;

import com.cafs.shop.domain.Banner;
import com.cafs.shop.domain.Cart;
import com.cafs.shop.domain.Category;
import com.cafs.shop.domain.CategoryTwo;
import com.cafs.shop.domain.Goods;
import com.cafs.shop.domain.Customer;
import com.cafs.shop.service.BannerService;
import com.cafs.shop.service.CartService;
import com.cafs.shop.service.CategoryService;
import com.cafs.shop.service.CategoryTwoService;
import com.cafs.shop.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class IndexController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private CartService cartService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryTwoService categoryTwoService;

    @Resource
    private BannerService bannerService;


    /**
     * 跳转到首页
     * @return
     */
    @GetMapping(value = {"/","/index"})
    public String index(Model model,HttpSession session){
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

        //轮播图
        List<Banner> banners = bannerService.showBanner();

        //白菜
        List<Goods> cheaper = goodsService.showCheaper();

        // 精选
        List<Goods> chosen = goodsService.showChosen();

        //所有商品
        List<Goods> goodsAll = goodsService.showAll();

        model.addAttribute("user",user);
        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("banners",banners);
        model.addAttribute("cheaper",cheaper);
        model.addAttribute("goodsAll",goodsAll);
        model.addAttribute("chosen",chosen);
        return "index";
    }

    @GetMapping("search")
    public String searchResult(String search,Model model,HttpSession session){
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


        List<Goods> list = goodsService.searchSome(search);
        int size = list.size();

        model.addAttribute("user",user);
        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("search",list);
        model.addAttribute("sName",search);
        model.addAttribute("size",size);
        return "search";
    }

    @GetMapping("buttonSearch")
    public String buttonSearch(String buttonSearch,Model model,HttpSession session){
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


        List<Goods> list = goodsService.searchSome(buttonSearch);
        int size = list.size();

        model.addAttribute("user",user);
        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("search",list);
        model.addAttribute("buttonSearch",buttonSearch);
        model.addAttribute("size",size);
        return "buttonSearch";
    }
}
