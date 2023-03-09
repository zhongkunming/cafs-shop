package com.cafs.shop.controller.admin;

import com.cafs.shop.domain.Express;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.service.ExpressService;
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
@RequestMapping("admin/express")
@Api(value = "快递", tags = "快递接口")
public class AdminExpressController {

    @Resource
    private ExpressService expressService;

    /**
     * 遍历快递信息
     *
     * @param request
     * @param express
     * @return
     */
    @ApiOperation(value = "遍历快递信息")
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Express> pageInfo(HttpServletRequest request, Express express) {
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 10 : Integer.parseInt(strlength);

        PageInfo<Express> pageInfo = expressService.page(draw, start, length, express);
        return pageInfo;
    }

    /**
     * 页面
     *
     * @return
     */
    @ApiOperation(value = "页面")
    @GetMapping("list")
    public String list() {
        return "admin/express_manager";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @ApiOperation(value = "添加页面")
    @GetMapping("add")
    public String add() {
        return "admin/express_add";
    }

    /**
     * 保存
     *
     * @param express
     * @return
     */
    @ApiOperation(value = "保存")
    @PostMapping("save")
    public String save(Express express) {
        expressService.saveExpress(express);
        return "admin/express_manager";
    }

    /**
     * 更新
     *
     * @param id
     * @param model
     * @return
     */
    @ApiOperation(value = "更新")
    @GetMapping("update")
    public String update(int id, Model model) {
        Express express = expressService.getById(id);
        model.addAttribute("express", express);
        return "admin/express_update";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除")
    @GetMapping("delete")
    public String deleteOne(int id) {
        expressService.deleteOne(id);
        return "admin/express_manager";
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
        expressService.delSelected(sIds);
        return "admin/express_manager";
    }
}
