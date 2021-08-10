package com.myx.bank.dao;

import com.myx.bank.pojo.User;

import java.util.List;

/**
 * description: UserDao <br>
 * date: 2021/8/10 16:36 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public interface UserDao {
    List<User> getUserList();
}
