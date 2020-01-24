package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
public class Task {
    @Id
    private String id;
    @Value("${task.name}")
    private String name;
    private String email;
    private String pwd;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}