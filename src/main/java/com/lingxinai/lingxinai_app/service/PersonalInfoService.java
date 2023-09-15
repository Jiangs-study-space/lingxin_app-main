package com.lingxinai.lingxinai_app.service;

import com.lingxinai.lingxinai_app.dao.PersonalInfoDao;
import com.lingxinai.lingxinai_app.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: PersonalInfoService
 * Package: com.lingxinai.lingxinai_app.service
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/12 21:46
 * @Version 1.0
 */
@Component
public class PersonalInfoService {
    @Autowired
    PersonalInfoDao personalInfoDao;

    @Transactional
    public User findUserById(String user_id){
        return personalInfoDao.findUserById(user_id);
    }

    public User modifyUserInfo(Integer userId, String nickName, String birthday, String avatar, String address) {
        return personalInfoDao.modifyUserInfo(userId,nickName,birthday,avatar,address);
    }
}
