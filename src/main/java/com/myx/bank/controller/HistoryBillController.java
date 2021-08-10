package com.myx.bank.controller;

import com.myx.bank.pojo.HistoryBill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * description: HistoryBillController <br>
 * date: 2021/8/10 14:45 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class HistoryBillController {
    @RequestMapping("/historyBillList")
    public Collection<HistoryBill> list() {
        System.out.println("接收到返回历史账单的请求");
        Collection<HistoryBill> result = new HistoryBill().some();
        return result;
    }
}
