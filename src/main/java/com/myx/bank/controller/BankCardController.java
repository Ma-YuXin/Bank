package com.myx.bank.controller;

import com.myx.bank.pojo.BankCardManage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

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
    public Collection<BankCardManage> bankCardList(){
        System.out.println("接受到返回银行卡列表请求");
        Collection<BankCardManage> bds= new BankCardManage().some();
        return bds;
    }
}
