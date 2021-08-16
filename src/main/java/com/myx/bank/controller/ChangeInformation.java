package com.myx.bank.controller;

import com.myx.bank.dao.UserImpl;
import com.myx.bank.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * description: ChangeInformation <br>
 * date: 2021/8/16 20:50 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class ChangeInformation {
    UserImpl userImpl = new UserImpl();

    @RequestMapping("/changeMultiple")
    public String changeMultiple(HttpServletRequest httpServletRequest) {
        Integer userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        User user = new User();
        user.setID(userId);
        user.setAddress(httpServletRequest.getParameter("newAddressMultiple"));
        user.setName(httpServletRequest.getParameter("newNameMultiple"));
        user.setPhoneNumber(httpServletRequest.getParameter("newTelephoneNumberMultiple"));
        System.out.println("用户将会被修改为：" + user);
        userImpl.changeInformation(user);
        System.out.println("接受修改多项用户信息请求请求,ID为：" + userId);
        return "修改成功";
    }

    @RequestMapping("/changeNameSingle")
    public String changeNameSingle(HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("name", httpServletRequest.getParameter("changeNameSingle"));
        userImpl.changeName(map);
        System.out.println("接受到修改用户姓名请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId"));
        return "修改成功";
    }

    @RequestMapping("/changeAddressSingle")
    public String changeAddressSingle(HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("address", httpServletRequest.getParameter("changeAddressSingle"));
        userImpl.changeAddress(map);
        System.out.println("接受到修改用户地址请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId"));
        return "修改成功";
    }

    @RequestMapping("/changeTelephoneNumberSingle")
    public String changeTelephoneNumberSingle(HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("phoneNumber", httpServletRequest.getParameter("changeTelephoneNumberSingle"));
        userImpl.changePhoneNumber(map);
        System.out.println("接受到修改用户电话请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId"));
        return "修改成功";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpServletRequest httpServletRequest) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("password", httpServletRequest.getSession().getAttribute("newPassword"));
        userImpl.changePassword(map);
        System.out.println("接受到修改用户密码请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId"));
        return "修改成功";
    }
}
