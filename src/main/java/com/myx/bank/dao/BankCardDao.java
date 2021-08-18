package com.myx.bank.dao;

import com.myx.bank.pojo.BankCard;
import com.myx.bank.pojo.BankCardManage;

import java.util.List;
import java.util.Map;

/**
 * description: BankCarkDao <br>
 * date: 2021/8/15 15:57 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public interface BankCardDao {
    List<BankCardManage> getUserBankCard();

    List<BankCardManage> getBankCardById(int id);

    void addBankCard(BankCard bankCard);

    void deleteBankCard(int bankcardnumber);

    void changeInformation(Map<String, Object> map);

    void changeRemainingBalance(Map<String, Object> map);
}
