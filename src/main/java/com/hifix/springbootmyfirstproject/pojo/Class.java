package com.hifix.springbootmyfirstproject.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class Class {
    private Integer id;

    private String classname;

    private Long classimage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Long getClassimage() {
        return classimage;
    }

    public void setClassimage(Long classimage) {
        this.classimage = classimage;
    }
}