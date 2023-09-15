package com.lingxinai.lingxinai_app.dao;

import com.lingxinai.lingxinai_app.entity.User;
import com.lingxinai.lingxinai_app.entity.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: PersonalInfoDao
 * Package: com.lingxinai.lingxinai_app.dao
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/12 21:47
 * @Version 1.0
 */
@Component
public class PersonalInfoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public User findUserById(String user_id){
        List<User> userList = jdbcTemplate.query("select * from user where user_id=?",new UserMapper(),user_id);
        if (userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }

    public User modifyUserInfo(Integer userId, String nickName, String birthday, String avatar, String address) {
        int row_num = jdbcTemplate.update("update user set  nick_name = ?, birthday = ?, avatar = ?, address = ? where user_id = ?",
                nickName, birthday, avatar, address, userId);
        if (row_num == 1){
            User user = findUserById(String.valueOf(userId));
            if (user != null){
                return user;
            }
        }
        return null;
    }
}
