package com.lingxinai.lingxinai_app.entity;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: FeedbackMapper
 * Package: com.lingxinai.lingxinai_app.entity
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/13 16:22
 * @Version 1.0
 */
public class FeedbackMapper implements RowMapper<Feedback> {
    @Override
    public Feedback mapRow(ResultSet resultSet, int i) throws SQLException {
        int bugId = resultSet.getInt("bug_id");
        int userId = resultSet.getInt("user_id");
        int bugType = resultSet.getInt("bug_type");
        String bugDesc = resultSet.getString("bug_desc");
        String phoneNumber = resultSet.getString("phone_number");
        String createTime = resultSet.getString("create_time");
        return new Feedback(bugId,userId,bugType,bugDesc,phoneNumber,createTime);
    }
}
