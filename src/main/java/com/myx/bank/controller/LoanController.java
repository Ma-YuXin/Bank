package com.myx.bank.controller;

import com.myx.bank.dao.LoanImpl;
import com.myx.bank.pojo.Loan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * description: LoanController <br>
 * date: 2021/8/18 16:13 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class LoanController {
    @RequestMapping("/getLoan")
    public Collection<Loan> getLoan(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("接受到返回贷款列表请求,ID为：" + userId);
        return new LoanImpl().getLoan();
    }
}
