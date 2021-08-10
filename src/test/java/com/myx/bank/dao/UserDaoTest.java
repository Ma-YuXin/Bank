package com.myx.bank.dao;

import com.myx.bank.pojo.HistoryBill;
import com.myx.bank.pojo.User;
import com.myx.bank.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * description: UserDaoTest <br>
 * date: 2021/8/10 16:19 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class UserDaoTest {
    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        List<User>userList=userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
