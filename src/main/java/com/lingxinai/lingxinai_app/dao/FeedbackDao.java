package com.lingxinai.lingxinai_app.dao;

import com.lingxinai.lingxinai_app.controller.FeedbackController;
import com.lingxinai.lingxinai_app.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: FeedbackDao
 * Package: com.lingxinai.lingxinai_app.dao
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/13 11:43
 * @Version 1.0
 */
@Component
public class FeedbackDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Transactional
    private List<Feedback> findFeedback(String userId, String createTime) {
        List<Feedback> feedbacks = jdbcTemplate.query("select * from user_feedback where user_id =? and create_time = ?",
                new FeedbackMapper(),userId,createTime);
        return feedbacks;
    }
    public Feedback addFeedback(String userId, String bugType, String bugDesc, String phoneNumber ,String createTime) {
        int row_num = jdbcTemplate.update("insert into user_feedback(user_id,bug_type,bug_desc,phone_number,create_time) values (?,?,?,?,?)",
                userId, bugType, bugDesc, phoneNumber,createTime);
        if (row_num == 1){
            List<Feedback> feedbacks = findFeedback(userId,createTime);
            if (feedbacks.size() > 0){
                return feedbacks.get(0);
            }
        }
        return null;

    }

    public List<ContactUs> contactUs() {
        List<ContactUs> contactUses = jdbcTemplate.query("select * from contact_us",new ContactUsMapper());
        return contactUses;
    }

    public List<BugType> getBugType() {
        List<BugType> bugTypes = jdbcTemplate.query("select * from bug_type",new BugTypeMapper());
        return bugTypes;
    }
}
