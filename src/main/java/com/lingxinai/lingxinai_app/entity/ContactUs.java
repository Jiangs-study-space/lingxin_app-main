package com.lingxinai.lingxinai_app.entity;

import jakarta.persistence.*;

/**
 * ClassName: ContactWithLingXin
 * Package: com.lingxinai.lingxinai_app.entity
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/13 17:10
 * @Version 1.0
 */
@Entity
@Table(name="contact_us")
public class ContactUs {
    public ContactUs() {
    }

    public ContactUs(Integer id, String weiXinPublicName, String contactPhone, String contactEmail, String weiXinGroup) {
        this.id = id;
        WeiXinPublicName = weiXinPublicName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        WeiXinGroup = weiXinGroup;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="weixin_public_name")
    private String WeiXinPublicName;

    @Column(name="contact_phone")
    private String contactPhone;

    @Column(name="contact_email")
    private String contactEmail;

    @Column(name="weixin_group")
    private String WeiXinGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeiXinPublicName() {
        return WeiXinPublicName;
    }

    public void setWeiXinPublicName(String weiXinPublicName) {
        WeiXinPublicName = weiXinPublicName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getWeiXinGroup() {
        return WeiXinGroup;
    }

    public void setWeiXinGroup(String weiXinGroup) {
        WeiXinGroup = weiXinGroup;
    }
}
