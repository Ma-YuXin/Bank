package com.myx.bank.controller;

import com.myx.bank.dao.UserImpl;
import com.myx.bank.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String changeMultiple(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Integer userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受修改多项用户信息请求请求,ID为：" + userId);
        User user = new User();
        user.setID(userId);
        user.setAddress(httpServletRequest.getParameter("newAddressMultiple"));
        user.setName(httpServletRequest.getParameter("newNameMultiple"));
        user.setPhoneNumber(httpServletRequest.getParameter("newTelephoneNumberMultiple"));
        httpSession.setAttribute("loginUserName", user.getName());
        httpSession.setAttribute("loginUserPhoneNumber", user.getPhoneNumber());
        httpSession.setAttribute("loginUserAddress", user.getAddress());
        System.out.println("用户将会被修改为：" + user);
        userImpl.changeInformation(user);
        return "修改成功";
    }

    @RequestMapping("/changeNameSingle")
    public String changeNameSingle(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String newName = httpServletRequest.getParameter("newNameSingle");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("name", newName);
        userImpl.changeName(map);
        httpSession.setAttribute("loginUserName", newName);
        System.out.println("接受到修改用户姓名请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId") + " 姓名将改为：" + newName);
        return "修改成功";
    }

    @RequestMapping("/changeAddressSingle")
    public String changeAddressSingle(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String newAddress = httpServletRequest.getParameter("newAddressSingle");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("address", newAddress);
        userImpl.changeAddress(map);
        httpSession.setAttribute("loginUserAddress", newAddress);
        System.out.println("接受到修改用户地址请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId") + " 新地址将改为：" + newAddress);
        return "修改成功";
    }

    @RequestMapping("/changeTelephoneNumberSingle")
    public String changeTelephoneNumberSingle(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String telephoneNumber = httpServletRequest.getParameter("newTelephoneNumberSingle");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("phoneNumber", telephoneNumber);
        userImpl.changePhoneNumber(map);
        httpSession.setAttribute("loginUserPhoneNumber", telephoneNumber);
        System.out.println("接受到修改用户电话请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId") + " 新电话将改为： " + telephoneNumber);
        return "修改成功";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String newPassword = httpServletRequest.getParameter("newPassword");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("password", newPassword);
        userImpl.changePassword(map);
        System.out.println("接受到修改用户密码请求,ID为：" + httpServletRequest.getSession().getAttribute("loginUserId") + " 密码将改为： " + newPassword);
        httpSession.setAttribute("loginUserPassword", newPassword);

        return "修改成功";
    }
}
