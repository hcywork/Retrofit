package com.example.databinding.bean;

/**
 * Created by hecaiyang on 17/2/27.
 */

public class User {
    private String name;
    private String bind_name;

    public User(String name, String bind_name, String email) {
        this.name = name;
        this.bind_name = bind_name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBind_name() {
        return bind_name;
    }

    public void setBind_name(String bind_name) {
        this.bind_name = bind_name;
    }

    private String email;

}
