package com.myx.bank.dao;

import com.myx.bank.pojo.User;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * description: UserDaoTest <br>
 * date: 2021/8/10 16:19 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class UserDaoTest {
    UserImpl userImpl = new UserImpl();

    @Test
    public void getUserList() {
        Collection<User> userList = userImpl.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserById() {
        System.out.println(userImpl.getUserById(100));
    }

    @Test
    public void changePassword() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",100);
        map.put("password","101");
        userImpl.changePassword(map);
    }

    @Test
    public void changeInformation() {
        userImpl.changeInformation(new User(100, "10086", "李白", "102", "山西太原"));
    }

    @Test
    public void changeName() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id","100");
        map.put("name","白居易");
        userImpl.changeName(map);
    }

    @Test
    public void changeAddress() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id","100");
        map.put("address","北京");
        userImpl.changeAddress(map);
    }

    @Test
    public void changePhoneNumber() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id","100");
        map.put("phoneNumber","12345");
        userImpl.changePhoneNumber(map);
    }
}
