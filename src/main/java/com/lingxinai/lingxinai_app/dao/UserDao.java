package com.lingxinai.lingxinai_app.dao;

import com.lingxinai.lingxinai_app.entity.User;
import com.lingxinai.lingxinai_app.entity.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public List<User> findUser(String phone_number) {
        List<User> users = jdbcTemplate.query("select * from user where phone_number=?", new UserMapper(), phone_number);
        return users;
    }

    public User addUser(String nickName, String sex, String birthday, String phone_number, String avatar, String address) {
        int row_num = jdbcTemplate.update("insert into user (nick_name, sex, birthday, phone_number, avatar, address) values (?,?,?,?,?,?)",
                nickName, sex, birthday, phone_number, avatar, address);
        if (row_num == 1) {
            List<User> users = findUser(phone_number);
            if (users.size() > 0) {
                return users.get(0);
            }
        }
        return null;
    }
}
