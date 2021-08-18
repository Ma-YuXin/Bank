package com.myx.bank.dao;

import com.myx.bank.pojo.BankCard;
import com.myx.bank.pojo.BankCardManage;
import com.myx.bank.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * description: BankCardImpl <br>
 * date: 2021/8/15 15:57 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class BankCardImpl implements BankCardDao {
    @Override
    public List<BankCardManage> getUserBankCard() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            BankCardDao bankCardDao = sqlSession.getMapper(BankCardDao.class);
            return bankCardDao.getUserBankCard();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<BankCardManage> getBankCardById(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            BankCardDao bankCardDao = sqlSession.getMapper(BankCardDao.class);
            return bankCardDao.getBankCardById(id);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void addBankCard(BankCard bankCard) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            BankCardDao bankCardDao = sqlSession.getMapper(BankCardDao.class);
            bankCardDao.addBankCard(bankCard);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public void deleteBankCard(int bankcardnumber) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            BankCardDao bankCardDao = sqlSession.getMapper(BankCardDao.class);
            bankCardDao.deleteBankCard(bankcardnumber);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public void changeInformation(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            BankCardDao bankCardDao = sqlSession.getMapper(BankCardDao.class);
            bankCardDao.changeInformation(map);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public void changeRemainingBalance(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            BankCardDao bankCardDao = sqlSession.getMapper(BankCardDao.class);
            bankCardDao.changeRemainingBalance(map);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
