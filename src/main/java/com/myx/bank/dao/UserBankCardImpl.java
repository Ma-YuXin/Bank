package com.myx.bank.dao;

import com.myx.bank.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

/**
 * description: UserBankCardImpl <br>
 * date: 2021/8/15 16:33 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class UserBankCardImpl implements UserBankCardDao {

    @Override
    public void addBankCard(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserBankCardDao userBankCardDao = sqlSession.getMapper(UserBankCardDao.class);
            userBankCardDao.addBankCard(map);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public void deleteBankCard(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserBankCardDao userBankCardDao = sqlSession.getMapper(UserBankCardDao.class);
            userBankCardDao.deleteBankCard(map);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
