package com.cafs.shop.controller.admin;

import com.cafs.shop.domain.Seller;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.service.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/seller")
@Api(value = "卖家", tags = "卖家接口")
public class AdminSellerController {
    @Resource
    private SellerService sellerService;

    /**
     * 遍历商家信息
     *
     * @param request
     * @param seller
     * @return
     */
    @ApiOperation(value = "遍历商家信息")
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Seller> pageInfo(HttpServletRequest request, Seller seller) {
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 10 : Integer.parseInt(strlength);

        PageInfo<Seller> pageInfo = sellerService.page(draw, start, length, seller);
        return pageInfo;
    }

    /**
     * 信息页面
     *
     * @return
     */
    @ApiOperation(value = "信息页面")
    @GetMapping("list")
    public String list() {
        return "admin/seller_manager";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @ApiOperation(value = "添加页面")
    @GetMapping("add")
    public String add() {
        return "admin/seller_add";
    }

    /**
     * 保存卖家信息
     *
     * @param seller
     * @return
     */
    @ApiOperation(value = "保存卖家信息")
    @PostMapping("save")
    public String save(Seller seller) {
        sellerService.saveSeller(seller);
        return "admin/seller_manager";
    }

    /**
     * 修改信息
     *
     * @param id
     * @param model
     * @return
     */
    @ApiOperation(value = "修改信息")
    @GetMapping("update")
    public String update(Long id, Model model) {
        Seller seller = sellerService.getById(id);
        model.addAttribute("seller", seller);
        return "admin/seller_update";
    }

    /**
     * 删除商家
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除商家")
    @GetMapping("delete")
    public String deleteOne(Long id) {
        sellerService.delete(id);
        return "admin/seller_manager";
    }

    /**
     * 删除选中
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除选中")
    @GetMapping("delSelected")
    public String delSelected(String ids) {
        String sIds[] = ids.split(",");
        sellerService.delSelected(sIds);
        return "admin/seller_manager";
    }

}
