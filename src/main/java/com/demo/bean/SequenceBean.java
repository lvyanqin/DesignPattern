package com.demo.bean;

import java.sql.Timestamp;

/**
 * Sequence entity. @author MyEclipse Persistence Tools
 */

public class SequenceBean implements java.io.Serializable {

    // Fields
    private Integer id;
    private String keys;
    private String value;
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
    public SequenceBean(Integer id, String keys, String value) {
        this.id = id;
        this.keys = keys;
        this.value = value;
    }

    /**
     * full constructor
     */
    public SequenceBean(Integer id, String keys, String value, String description,
            Timestamp addTime) {
        this.id = id;
        this.keys = keys;
        this.value = value;
        this.description = description;
        this.addTime = addTime;
    }

   
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeys() {
        return this.keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
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
