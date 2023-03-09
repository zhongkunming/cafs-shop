package com.cafs.shop.controller.admin;

import com.cafs.shop.domain.Customer;
import com.cafs.shop.dto.ComResult;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.service.UserService;
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
@RequestMapping("user")
@Api(value = "用户", tags = "用户接口")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 遍历用户信息
     *
     * @param request
     * @param user
     * @return
     */
    @ApiOperation(value = "遍历用户信息")
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Customer> pageInfo(HttpServletRequest request, Customer user) {
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 10 : Integer.parseInt(strlength);

        PageInfo<Customer> pageInfo = userService.page(draw, start, length, user);
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
        return "admin/user_manager";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户")
    @GetMapping("delete")
    public String deleteOne(Long id) {
        userService.delete(id);
        return "admin/user_manager";
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("deleteMulti")
    @ResponseBody
    public ComResult delete(Integer[] ids) {
        ComResult comResult = null;
        if (ids != null) {
            comResult = ComResult.success("删除用户成功");
            userService.deleteMulti(ids);
        } else {
            comResult = ComResult.fail("删除用户失败");
        }
        return comResult;
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
        userService.deleteSelected(sIds);
        return "admin/user_manager";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @ApiOperation(value = "添加页面")
    @GetMapping("add")
    public String add() {
        return "admin/user_add";
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "保存用户信息")
    @PostMapping("save")
    public String save(Customer user) {
        userService.saveUser(user);
        return "admin/user_manager";
    }

    /**
     * 修改用户信息
     */
    @ApiOperation(value = "修改用户信息")
    @GetMapping("update")
    public String update(Long id, Model model) {
        Customer user = userService.getById(id);
        model.addAttribute("user", user);
        return "admin/user_update";
    }


}
