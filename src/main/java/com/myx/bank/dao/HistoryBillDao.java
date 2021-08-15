package com.myx.bank.dao;

import com.myx.bank.pojo.Bill;
import com.myx.bank.pojo.HistoryBill;

import java.util.List;

/**
 * description: HistoryBillDao <br>
 * date: 2021/8/10 16:09 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public interface HistoryBillDao {
    List<HistoryBill> getHistoryBillList();
    List<HistoryBill>getHistoryBillListById(int id);
    void insertHistoryBill(Bill bill);
    void insertHistoryWithdrawBill(Bill bill);
    void insertHistoryDepositBill(Bill bill);
    void deleteHistoryBill(Bill bill);
}
