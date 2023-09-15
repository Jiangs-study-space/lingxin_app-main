package com.lingxinai.lingxinai_app.service;

import com.lingxinai.lingxinai_app.dao.UserDao;
import com.lingxinai.lingxinai_app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class LoginService {
    @Autowired
    UserDao userDao;

    @Transactional
    public List<User> findUser(String phone_number) {
        return userDao.findUser(phone_number);
    }

    public User register(String nickName, String sex, String birthday, String phoneNumber, String avatar, String address) {
        return userDao.addUser(nickName, sex, birthday, phoneNumber, avatar, address);
    }
}
