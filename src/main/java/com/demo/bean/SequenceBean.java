package com.demo.bean;

import java.sql.Timestamp;

/**
 * Sequence entity. @author MyEclipse Persistence Tools
 */

public class SequenceBean implements java.io.Serializable {

    // Fields
    private Integer id;
    private String keys_;
    private String value_;
    private String description;
    private Timestamp addTime;

    // Constructors
    /**
     * default constructor
     */
    public SequenceBean() {
    }

    /**
     * minimal constructor
     */
    public SequenceBean(Integer id, String keys_, String value_) {
        this.id = id;
        this.keys_ = keys_;
        this.value_ = value_;
    }

    /**
     * full constructor
     */
    public SequenceBean(Integer id, String keys_, String value_, String description,
            Timestamp addTime) {
        this.id = id;
        this.keys_ = keys_;
        this.value_ = value_;
        this.description = description;
        this.addTime = addTime;
    }

   
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeys_() {
        return this.keys_;
    }

    public void setKeys_(String keys_) {
        this.keys_ = keys_;
    }

    public String getValue_() {
        return this.value_;
    }

    public void setValue_(String value_) {
        this.value_ = value_;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

}
