package com.myx.bank.controller;

import com.myx.bank.dao.BankCardImpl;
import com.myx.bank.dao.HistoryBillImpl;
import com.myx.bank.dao.UserBankCardImpl;
import com.myx.bank.pojo.BankCard;
import com.myx.bank.pojo.BankCardManage;
import com.myx.bank.pojo.Bill;
import com.myx.bank.pojo.BussinessType;
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
        double number = Integer.parseInt(httpServletRequest.getParameter("number"));
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", number);
        new BankCardImpl().changeRemainingBalance(map);

        Bill bill = new Bill();
        bill.setpayee(userId);
        bill.settype(BussinessType.存款.toString());
        bill.setvalue(number);
        new HistoryBillImpl().insertHistoryDepositBill(bill);
        return "存款成功";
    }

    @RequestMapping("/withdrawNumber")
    public String withdrawNumber(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到取款请求,ID为：" + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        double number = -Integer.parseInt(httpServletRequest.getParameter("number"));
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", number);
        new BankCardImpl().changeRemainingBalance(map);

        Bill bill = new Bill();
        bill.setsender(userId);
        bill.setvalue(number);
        bill.settype(BussinessType.取款.toString());
        new HistoryBillImpl().insertHistoryWithdrawBill(bill);
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
        new HistoryBillImpl().insertHistoryBill(new Bill(Integer.parseInt(sender), Integer.parseInt(payee), Double.parseDouble(money), BussinessType.转账.toString()));
        return "转账成功";
    }

    @RequestMapping("/addBankCard")
    public String addBankCard(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到转账请求,ID为：" + userId);
        String newPassword = httpServletRequest.getParameter("newPassword");
        String addBankCardNumber = httpServletRequest.getParameter("addBankCardNumber");
        String bank = httpServletRequest.getParameter("bank");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", userId);
        map.put("bankcardnumber", addBankCardNumber);
        new UserBankCardImpl().addBankCard(map);
        new BankCardImpl().addBankCard(new BankCard(Integer.parseInt(addBankCardNumber), newPassword, 0, bank));
        return "添加银行卡成功";
    }

    @RequestMapping("/getLoanMoney")
    public String getLoanMoney(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        String money = httpServletRequest.getParameter("money");
        System.out.println("接受到贷款请求,ID为：" + userId + " 卡号为：" + bankcardNumber + " 金额为: " + money);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", Double.parseDouble(money));
        new BankCardImpl().changeRemainingBalance(map);
        Bill bill = new Bill();
        bill.setpayee(userId);
        bill.settype(BussinessType.贷款.toString());
        bill.setvalue(Double.parseDouble(money));
        new HistoryBillImpl().insertHistoryDepositBill(bill);
        return "贷款成功";
    }
}
