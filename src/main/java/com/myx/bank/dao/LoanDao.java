package com.myx.bank.dao;

import com.myx.bank.pojo.Loan;

import java.util.List;

/**
 * description: LoanDao <br>
 * date: 2021/8/15 23:35 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public interface LoanDao {
    List<Loan> getLoan();
}
