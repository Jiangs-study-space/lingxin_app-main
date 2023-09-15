package com.lingxinai.lingxinai_app.entity;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: BugTypeMapper
 * Package: com.lingxinai.lingxinai_app.entity
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/14 20:13
 * @Version 1.0
 */
public class BugTypeMapper implements RowMapper<BugType> {
    @Override
    public BugType mapRow(ResultSet resultSet, int i) throws SQLException {
        int bugTypeId = resultSet.getInt("bug_type_id");
        String bugTypeName = resultSet.getString("bug_type_name");
        String bugTypeDesc = resultSet.getString("bug_type_desc");
        int bugTypeOrder = resultSet.getInt("bug_type_order");
        return new BugType(bugTypeId,bugTypeName,bugTypeDesc,bugTypeOrder);
    }
}
