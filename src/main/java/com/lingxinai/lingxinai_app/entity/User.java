package com.lingxinai.lingxinai_app.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Calendar;

/*
    新增：
        @Column(name="address")
        private String address;

 */
@Entity
@Table(name="user")
public class User implements Serializable {

    public User() {

    }
    public User(Integer userId, String nickName, String sex, String birthday, String phoneNumber, String avatar ,String address) {
        this.userId = userId;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Integer userId;

    @Column(name="nick_name")
    private String nickName;

    @Column(name="sex")
    private String sex;

    @Column(name="birthday")
    private String birthday;

    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="avatar")
    private String avatar;

    @Column(name="address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        String birth_year = birthday.substring(0,4);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int age = year - Integer.valueOf(birth_year);
        return age;
    }
}
