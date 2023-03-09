package com.cafs.shop.controller;

import com.cafs.shop.domain.Cart;
import com.cafs.shop.domain.Category;
import com.cafs.shop.domain.CategoryTwo;
import com.cafs.shop.domain.Customer;
import com.cafs.shop.dto.ComResult;
import com.cafs.shop.service.CartService;
import com.cafs.shop.service.CategoryService;
import com.cafs.shop.service.CategoryTwoService;
import com.cafs.shop.service.OrderService;
import com.cafs.shop.service.UserService;
import com.cafs.shop.vo.OrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("personInfo")
public class PersonInfoController {
    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryTwoService categoryTwoService;

    @Resource
    private CartService cartService;

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;

    /**
     * 用户信息页
     * @param id
     * @param model
     * @param session
     * @return
     */
    @GetMapping("detail/{id}")
    public String toPersonInfo(@PathVariable Long id, Model model, HttpSession session){
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

        //查询用户信息
        Customer customer = userService.getById(id);

        //查询该用户的订单
        OrderVO orderVO = orderService.getOrderId(user.getId());

        model.addAttribute("user", customer);
        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("orderVO",orderVO);
        return "personInfo";
    }

    /**
     * 更新用户信息
     * @param customer
     * @return
     */
    @PostMapping("save")
    @ResponseBody
    public ComResult save(Customer customer, HttpSession session){
        session.removeAttribute("user");
        session.setAttribute("user", customer);
        ComResult comResult = userService.updateInfo(customer);
        return comResult;
    }

}
