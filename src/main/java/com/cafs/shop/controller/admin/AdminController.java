package com.cafs.shop.controller.admin;

import com.cafs.shop.domain.Admin;
import com.cafs.shop.service.AdminService;
import com.cafs.shop.service.GoodsService;
import com.cafs.shop.service.SellerService;
import com.cafs.shop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
@Api(value = "登录", tags = "登录接口")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private SellerService sellerService;

    @Resource
    private UserService userService;

    /**
     * 后台首页
     *
     * @param model
     * @return
     */
    @ApiOperation(value = "后台首页")
    @GetMapping("home")
    public String home(Model model) {
        double totalSum = goodsService.getTotalSum();
        int goodsCount = goodsService.getGoodsCount();

        int sellerCount = sellerService.getSellerCount();
        int userCount = userService.getUserCount();

        int usCount = sellerCount + userCount;

        model.addAttribute("totalSum", totalSum);
        model.addAttribute("goodsCount", goodsCount);
        model.addAttribute("sellerCount", sellerCount);
        model.addAttribute("usCount", usCount);
        return "admin/home";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @ApiOperation(value = "登录页面")
    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    /**
     * 管理员登录
     *
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @ApiOperation(value = "管理员登录")
    @PostMapping("login")
    public String tologin(String username, String password, Model model, HttpSession session) {

        Admin admin = adminService.login(username, password);

        if (admin == null) {
            model.addAttribute("msg", "用户名与密码错误");
            return "admin/login";
        } else {
            session.setAttribute("admin", admin);
            return "redirect:home";
        }
    }
}
