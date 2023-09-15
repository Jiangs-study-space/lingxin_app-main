package com.lingxinai.lingxinai_app.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * ClassName: Feedback
 * Package: com.lingxinai.lingxinai_app.entity
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/13 16:07
 * @Version 1.0
 */
@Entity
@Table(name = "user_feedback")
public class Feedback implements Serializable {
    public Feedback() {
    }

    public Feedback(Integer bugId, Integer userId, Integer bugType, String bugDesc, String phoneNumber, String createTime) {
        this.bugId = bugId;
        this.userId = userId;
        this.bugType = bugType;
        this.bugDesc = bugDesc;
        this.phoneNumber = phoneNumber;
        this.createTime = createTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bug_id")
    private Integer bugId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "bug_type")
    private Integer bugType;

    @Column(name = "bug_desc")
    private String bugDesc;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "create_time")
    private String createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBugType() {
        return bugType;
    }

    public void setBugType(Integer bugType) {
        this.bugType = bugType;
    }

    public String getBugDesc() {
        return bugDesc;
    }

    public void setBugDesc(String bugDesc) {
        this.bugDesc = bugDesc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getBugId() {
        return bugId;
    }
}
