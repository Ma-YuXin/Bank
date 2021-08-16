package com.myx.bank.dao;

import com.myx.bank.pojo.Bank;
import com.myx.bank.pojo.BankCard;
import com.myx.bank.pojo.BankCardManage;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * description: BankCardDaoTest <br>
 * date: 2021/8/15 16:21 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class BankCardDaoTest {
    BankCardImpl bankCardImpl = new BankCardImpl();

    @Test
    public void getUserBankCard() {
        List<BankCardManage> list = bankCardImpl.getUserBankCard();
        for (BankCardManage bankCardManage : list) {
            System.out.println(bankCardManage);
        }
    }


    @Test
    public void test() {

    }

    @Test
    public void getBankCardByIdTest() {
        List<BankCardManage> list = bankCardImpl.getBankCardById(100);
        for (BankCardManage bankCardManage : list) {
            System.out.println(bankCardManage);
        }
    }

    @Test
    public void addBankCardTest() {
        bankCardImpl.addBankCard(new BankCard(1234567,"12341",134.234, Bank.建设银行.toString()));
    }

    @Test
    public void deleteBankCardTest() {
        bankCardImpl.deleteBankCard(1234567);
    }
}
