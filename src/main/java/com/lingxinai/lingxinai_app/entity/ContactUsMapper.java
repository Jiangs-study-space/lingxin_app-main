package com.lingxinai.lingxinai_app.entity;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: ContactUsMapper
 * Package: com.lingxinai.lingxinai_app.entity
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/13 18:25
 * @Version 1.0
 */
public class ContactUsMapper implements RowMapper<ContactUs> {

    @Override
    public ContactUs mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String WeiXinPublicName = resultSet.getString("weixin_public_name");
        String contactPhone = resultSet.getString("contact_phone");
        String contactEmail = resultSet.getString("contact_email");
        String WeiXinGroup = resultSet.getString("weixin_group");
        return new ContactUs(id,WeiXinPublicName,contactPhone,contactEmail,WeiXinGroup);
    }
}
