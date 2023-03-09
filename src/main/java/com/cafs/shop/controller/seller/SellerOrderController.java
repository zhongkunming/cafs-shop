package com.cafs.shop.controller.seller;

import com.cafs.shop.domain.ShopOrder;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("sellerOrder")
@Api(value = "订单",tags = "订单接口")
public class SellerOrderController {

    @Resource
    private OrderService orderService;

    /**
     *订单分页
     * @param request
     * @param shopOrder
     * @return
     */
    @ApiOperation(value = "订单分页")
    @GetMapping("page")
    @ResponseBody
    public PageInfo<ShopOrder> pageInfo(HttpServletRequest request, ShopOrder shopOrder){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt(strlength);

        PageInfo<ShopOrder> pageInfo = orderService.page(draw,start,length,shopOrder);
        return pageInfo;
    }

    /**
     * 订单列表
     * @param session
     * @return
     */
    @ApiOperation(value = "订单列表")
    @GetMapping("list")
    public String toSellerOrders(HttpSession session){
        return "seller/seller_order";
    }

    /**
     * 设为发货
     * @param id
     * @return
     */
    @ApiOperation(value = "设为发货")
    @GetMapping("deliver")
    public String deliver(Long id){
        orderService.updateStatus(id);
        return "seller/seller_order";
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @ApiOperation(value = "删除订单")
    @GetMapping("delete")
    public String delete(Long id){
        orderService.delete(id);
        return "seller/seller_order";
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除选中")
    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        orderService.delSelected(sIds);
        return "seller/seller_order";
    }
}
