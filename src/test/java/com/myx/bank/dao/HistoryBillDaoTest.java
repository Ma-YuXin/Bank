package com.myx.bank.dao;

import com.myx.bank.pojo.HistoryBill;
import com.myx.bank.pojo.User;
import com.myx.bank.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * description: HistoryBillDaoTest <br>
 * date: 2021/8/10 16:40 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class HistoryBillDaoTest {
    @Test
    public void getHistoryBillTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        HistoryBillDao historyBillDao = sqlSession.getMapper(HistoryBillDao.class);
        List<HistoryBill> historyBillList = historyBillDao.getHistoryBillList();
        for (HistoryBill historyBill : historyBillList) {
            System.out.println(historyBill);
        }
        sqlSession.close();
    }

}
