package com.lingxinai.lingxinai_app.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;

/**
 * ClassName: BugType
 * Package: com.lingxinai.lingxinai_app.entity
 * Description:
 *
 * @Author Chilly
 * @Create 2023/9/14 20:07
 * @Version 1.0
 */
@Entity
@Table(name="bug_type")
public class BugType implements Serializable {
    public BugType() {
    }

    public BugType(Integer bugTypeId, String bugTypeName, String bugTypeDesc, Integer bugTypeOrder) {
        this.bugTypeId = bugTypeId;
        this.bugTypeName = bugTypeName;
        this.bugTypeDesc = bugTypeDesc;
        this.bugTypeOrder = bugTypeOrder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bug_type_id")
    private Integer bugTypeId;

    @Column(name = "bug_type_name")
    private String bugTypeName;

    @Column(name = "bug_type_desc")
    private String bugTypeDesc;

    @Column(name = "bug_type_order")
    private Integer bugTypeOrder;

    public Integer getBugTypeId() {
        return bugTypeId;
    }

    public void setBugTypeId(Integer bugTypeId) {
        this.bugTypeId = bugTypeId;
    }

    public String getBugTypeName() {
        return bugTypeName;
    }

    public void setBugTypeName(String bugTypeName) {
        this.bugTypeName = bugTypeName;
    }

    public String getBugTypeDesc() {
        return bugTypeDesc;
    }

    public void setBugTypeDesc(String bugTypeDesc) {
        this.bugTypeDesc = bugTypeDesc;
    }

    public Integer getBugTypeOrder() {
        return bugTypeOrder;
    }

    public void setBugTypeOrder(Integer bugTypeOrder) {
        this.bugTypeOrder = bugTypeOrder;
    }
}
