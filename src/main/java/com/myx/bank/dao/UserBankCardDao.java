package com.myx.bank.dao;

import com.myx.bank.pojo.BankCard;
import com.myx.bank.pojo.BankCardManage;

import java.util.Map;

/**
 * description: UserBankCardDao <br>
 * date: 2021/8/15 16:33 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public interface UserBankCardDao {
    void addBankCard(Map<String, Object> map);
    void deleteBankCard(Map<String, Object> map);
}
