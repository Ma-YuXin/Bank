package com.myx.bank.dao;

import com.myx.bank.pojo.Loan;
import com.myx.bank.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * description: LoanImpl <br>
 * date: 2021/8/15 23:35 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class LoanImpl implements LoanDao {
    @Override
    public List<Loan> getLoan() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            LoanDao loanDao = sqlSession.getMapper(LoanDao.class);
            return loanDao.getLoan();
        }finally {
            sqlSession.close();
        }
    }
}
