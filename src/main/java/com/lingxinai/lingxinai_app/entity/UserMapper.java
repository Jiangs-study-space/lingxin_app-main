package com.lingxinai.lingxinai_app.entity;

import com.lingxinai.lingxinai_app.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        int user_id = resultSet.getInt("user_id");
        String nickName = resultSet.getString("nick_name");
        String sex = resultSet.getString("sex");
        String birthday = resultSet.getString("birthday");
        String phoneNumber = resultSet.getString("phone_number");
        String avatar = resultSet.getString("avatar");
        String address = resultSet.getString("address");
        return new User(user_id, nickName, sex, birthday, phoneNumber, avatar, address);
    }

}
