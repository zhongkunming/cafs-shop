package com.cafs.shop.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cafs.shop.domain.Customer;
import com.cafs.shop.dto.ComResult;
import com.cafs.shop.dto.PageInfo;
import com.cafs.shop.mapper.CustomerMapper;
import com.cafs.shop.service.UserService;
import com.cafs.shop.utils.RegexUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements UserService {

    @Resource
    private CustomerMapper userMapper;


    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    @Override
    public Customer login(String phone, String password) {
//        String key = "user_"+phone;
//        ValueOperations<String,XxUser> operations = redisTemplate.opsForValue();
//
//        boolean haskey = redisTemplate.hasKey(key);
//
//            if (haskey){
//                XxUser user = operations.get(key);
//                return user;
//            }
//            else {
//                XxUser user = userMapper.getByPhone(phone);
//                if (user != null){
//                    if(user.getPassword().equals(password)){
//                        operations.set(key,user);
//                        return user;
//                    }
//                }
//        }
        Customer user = userMapper.getByPhone(phone);
        if (user != null){
            if (user.getPassword().equals(password)){
                return user;
            }
        }
        return  null;
    }

    /**
     * 注册
     * @return
     */
    @Override
    public void register(String realname,String phone,String username,String password) {
        if (!StringUtils.isEmpty(phone) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(realname) && !StringUtils.isEmpty(username)){
            Customer user = new Customer();
            user.setRealname(realname);
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setCreated(new Date());
            user.setUpdated(new Date());
            userMapper.insert(user);
        }
    }

    /**
     * 验证手机号码
     * @param phone
     * @return
     */
    @Override
    public boolean verPhone(String phone) {
//        Example example = new Example(XxUser.class);
//        example.createCriteria().andEqualTo("phone",phone);
        Customer user = userMapper.selectOne(Wrappers.<Customer>lambdaQuery().eq(Customer::getPhone,phone));
        if (user == null){
            return false;
        }
        return true;
    }

    /**
     * 分页
     * @param start
     * @param length
     * @param draw
     * @param user
     * @return
     */
    @Override
    public PageInfo<Customer> page(int draw, int start, int length, Customer user) {
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("User",user);

        int count = Math.toIntExact(userMapper.selectCount(Wrappers.lambdaQuery(user)));
        PageInfo<Customer> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(userMapper.page(params));

        return pageInfo;
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    /**
     * 保存用户信息
     * @param user
     */
    @Override
    public void saveUser(Customer user) {
        user.setUpdated(new Date());
        if (user.getId() == null){
            user.setCreated(new Date());
            userMapper.insert(user);
        }
        else{
            userMapper.updateById(user);
        }
    }

    @Override
    public Customer getById(Long id) {
        return userMapper.selectById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteMulti(Integer[] ids) {
        userMapper.deleteMulti(ids);
    }

    /**
     * 前台修改个人信息
     */
    @Override
    public ComResult updateInfo(Customer customer) {
        ComResult comResult = checkXxUser(customer);
        //通过验证
        if (comResult.getStatus() == ComResult.STATUS_SUCCESS){
            customer.setUpdated(new Date());
            userMapper.updateById(customer);
            comResult.setMessage("用户信息保存成功");
        }
        return comResult;
    }

    /**
     * 用户信息的有效性验证
     * @param customer
     * @return
     */
    @Override
    public ComResult checkXxUser(Customer customer) {
        ComResult comResult = ComResult.success();
        if (org.apache.commons.lang3.StringUtils.isBlank(customer.getEmail())){
            comResult = ComResult.fail("邮箱不能为空");
        }
        else if(!RegexUtils.checkEmail(customer.getEmail())){
            comResult = ComResult.fail("邮箱格式不正确");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(customer.getPassword())){
            comResult = ComResult.fail("密码不能为空");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(customer.getUsername())){
            comResult = ComResult.fail("姓名不能为空");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(customer.getPhone())){
            comResult = ComResult.fail("手机号码不能为空");
        }
        else if(!RegexUtils.checkMobile(customer.getPhone())){
            comResult = ComResult.fail("手机号码格式不正确");
        }
        else if(org.apache.commons.lang3.StringUtils.isBlank(customer.getAddress())){
            comResult = ComResult.fail("地址不能为空");
        }
        return comResult;
    }

    @Override
    public void deleteSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            userMapper.deleteById(id);
        }
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

}
