package com.lingxinai.lingxinai_app.service;

import com.lingxinai.lingxinai_app.dao.FeedbackDao;
import com.lingxinai.lingxinai_app.entity.BugType;
import com.lingxinai.lingxinai_app.entity.ContactUs;
import com.lingxinai.lingxinai_app.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: FeedbackService
 * Package: com.lingxinai.lingxinai_app.service
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/13 11:42
 * @Version 1.0
 */
@Component
public class FeedbackService {
    @Autowired
    FeedbackDao feedbackDao;

    public Feedback addFeedback(String userId, String bugType, String bugDesc, String phoneNumber, String createTime) {
        return feedbackDao.addFeedback(userId,bugType,bugDesc,phoneNumber,createTime);
    }

    public List<ContactUs> contactUs() {
        return feedbackDao.contactUs();
    }

    public List<BugType> getBugType() {
        return feedbackDao.getBugType();
    }
}
