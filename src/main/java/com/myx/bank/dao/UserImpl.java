package com.myx.bank.dao;

import com.myx.bank.pojo.User;
import com.myx.bank.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * description: UserImpl <br>
 * date: 2021/8/10 22:01 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class UserImpl implements UserDao {

    public List<User> getUserList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            return sqlSession.selectList("com.myx.bank.dao.UserDao.getUserList");
        } finally {
            Objects.requireNonNull(sqlSession).close();
        }

    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            sqlSession.insert("com.myx.bank.dao.UserDao.addUser", user);
        } finally {
            if (sqlSession != null) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.deleteUser(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public User getUserById(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            return userDao.getUserById(id);
        } finally {
            Objects.requireNonNull(sqlSession).close();
        }
    }

    @Override
    public String getUserNameById(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            String result = userDao.getUserNameById(id);
            return result;


        } finally {
            if (sqlSession != null) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }

    @Override
    public void changePassword(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.changePassword(map);
            sqlSession.commit();

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public void changeInformation(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.changeInformation(user);
            sqlSession.commit();

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public void changeName(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.changeName(map);
            sqlSession.commit();
        } finally {
            if (sqlSession != null) {

                sqlSession.close();
            }
        }
    }

    @Override
    public void changeAddress(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.changeAddress(map);
            sqlSession.commit();

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public void changePhoneNumber(Map<String, Object> map) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.changePhoneNumber(map);
            sqlSession.commit();

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
