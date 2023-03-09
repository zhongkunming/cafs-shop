package com.cafs.shop.controller.seller;

import com.cafs.shop.domain.Seller;
import com.cafs.shop.service.GoodsService;
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
import java.util.Map;

@Controller
@RequestMapping("sellerCentre")
@Api(value = "卖家中心",tags = "卖家中心接口")
public class SellerCentreController {

    @Resource
    private SellerService sellerService;

    @Resource
    private GoodsService goodsService;

    @ApiOperation(value = "首页")
    @GetMapping("index")
    public String centre(Model model,HttpSession session){
        Seller seller = (Seller) session.getAttribute("seller");

        Map<String, Object> map = goodsService.IndexInfoBySellerId(seller.getId());

        String reputation = sellerService.getReputation(seller.getId());

        model.addAttribute("countBySellerId",map.get("countBySellerId"));
        model.addAttribute("soldCount",map.get("soldCount"));
        model.addAttribute("soldMoney",map.get("soldMoney"));
        model.addAttribute("reputation",reputation);
        return "seller/index";
    }

    @ApiOperation(value = "列表")
    @GetMapping("list")
    public String list(HttpSession session, Model model){
        Seller seller = (Seller) session.getAttribute("seller");

        model.addAttribute("seller",seller);
        return "seller/seller_info";
    }

    /**
     * 保存卖家信息
     * @param seller
     * @return
     */
    @ApiOperation(value = "保存卖家信息")
    @PostMapping("save")
    public String save(Seller seller){
        sellerService.saveSeller(seller);
        return "seller/seller_info";
    }

    /**
     * 修改卖家信息
     * @param session
     * @param model
     * @return
     */
    @ApiOperation(value = "修改卖家信息")
    @GetMapping("update")
    public String toUpdate(HttpSession session, Model model){
        Seller seller = (Seller) session.getAttribute("seller");

        model.addAttribute("seller",seller);
        return "seller/info_update";
    }

}
