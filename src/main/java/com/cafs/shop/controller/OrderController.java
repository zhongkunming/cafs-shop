package com.cafs.shop.controller;

import com.cafs.shop.domain.Customer;
import com.cafs.shop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 生成订单
     */
    @PostMapping("create")
    @ResponseBody
    public Long create(Long expressId, HttpSession session) {
        // 从 session 中获取会员信息
        Customer user = (Customer) session.getAttribute("user");

        // 创建订单
        Long orderId = orderService.create(user.getId(), expressId);

        return orderId;
    }
}
