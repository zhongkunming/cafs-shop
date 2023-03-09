package com.cafs.shop.controller.seller;

import com.cafs.shop.domain.Seller;
import com.cafs.shop.service.SellerService;
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
@RequestMapping("sellerLogin")
@Api(value = "卖家登录",tags = "卖家登录接口")
public class SellerLoginController {

    @Resource
    private SellerService sellerService;

    /**
     * 登录页面
     * @return
     */
    @ApiOperation(value = "登录页面")
    @GetMapping("login")
    public String login(){
        return "seller/login";
    }

    /**
     * 卖家登录
     * @param phone
     * @param password
     * @param model
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping("login")
    public String loginByPassword(String phone, String password, Model model, HttpSession session){
        Seller seller = sellerService.login(phone, password);

        if (seller != null){
            session.setAttribute("seller",seller);
            return "redirect:/sellerCentre/index";
        }
        else {
            model.addAttribute("message","用户名或密码错误");
            return "seller/login";
        }
    }

    /**
     * 卖家注册
     * @return
     */
    @ApiOperation(value = "卖家注册页面")
    @GetMapping("register")
    public String toRegister(){
        return "seller/register";
    }

    /**
     * 注册
     * @param realname
     * @param phone
     * @param city
     * @param password
     * @param repassword
     * @return
     */
    @ApiOperation(value = "卖家注册")
    @PostMapping("register")
    public String register(String realname, String phone, String city, String password, String repassword){
        if(!password.equals(repassword)){
            return "redirect:/sellerLogin/register";
        }
        sellerService.register(realname, phone, city, password);
        return "redirect:/sellerLogin/login";
    }

}
