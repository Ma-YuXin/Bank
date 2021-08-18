package com.myx.bank.controller;

import com.myx.bank.dao.BankCardImpl;
import com.myx.bank.dao.UserBankCardImpl;
import com.myx.bank.pojo.BankCardManage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * description: bankCardManageController <br>
 * date: 2021/8/9 13:41 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class BankCardController {
    @RequestMapping("/bankCardList")
    public Collection<BankCardManage> bankCardList(HttpServletRequest httpServletRequest) {

        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到返回银行卡列表请求,ID为：" + userId);
        return new BankCardImpl().getBankCardById(userId);
    }

    @RequestMapping("/changeBankcardPassword")
    public String changeBankcardPassword(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到修改银行卡密码请求,ID为：" + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password", httpServletRequest.getParameter("newPassword"));
        map.put("bankcardNumber", httpServletRequest.getParameter("bankcardNumber"));
        new BankCardImpl().changeInformation(map);
        return "修改银行卡密码成功";
    }

    @RequestMapping("/deleteBankcard")
    public String deleteBankcard(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到删除银行卡请求,ID为：" + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        map.put("userid", userId);
        map.put("bankcardnumber", Integer.parseInt(bankcardNumber));
        new BankCardImpl().deleteBankCard(Integer.parseInt(bankcardNumber));
        new UserBankCardImpl().deleteBankCard(map);
        return "删除银行卡成功";
    }

    @RequestMapping("/depositMoney")
    public String depositMoney(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到存款请求,ID为：" + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        String number = httpServletRequest.getParameter("number");
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", Integer.parseInt(number));
        new BankCardImpl().changeRemainingBalance(map);
        return "存款成功";
    }

    @RequestMapping("/withdrawNumber")
    public String withdrawNumber(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到取款请求,ID为：" + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        String number = httpServletRequest.getParameter("number");
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", -Integer.parseInt(number));
        new BankCardImpl().changeRemainingBalance(map);
        return "取款成功";
    }

    @RequestMapping("/transferMoney")
    public String transferMoney(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到转账请求,ID为：" + userId);
        BankCardImpl bankCard = new BankCardImpl();
        String sender = httpServletRequest.getParameter("sender");
        String money = httpServletRequest.getParameter("money");
        String payee = httpServletRequest.getParameter("payee");
        Map<String, Object> mapSender = new HashMap<String, Object>();
        mapSender.put("bankcardNumber", sender);
        mapSender.put("number", -Integer.parseInt(money));
        Map<String, Object> mapPayee = new HashMap<String, Object>();
        mapPayee.put("bankcardNumber", payee);
        mapPayee.put("number", Integer.parseInt(money));
        bankCard.changeRemainingBalance(mapPayee);
        bankCard.changeRemainingBalance(mapSender);
        return "转账成功";
    }

}
