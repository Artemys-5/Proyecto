package com.example.demo.entity;

import java.util.Date;

public class Profile {
    @id
    private String id;
    private String image;
    private String phone;
    private User user;
    private Date updateAt;
    private Date createdAt;

    public Profile(String id, String image, String phone, User user, Date updateAt, Date createdAt){
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.user = user;
        this.updateAt = updateAt;
        this.createdAt = createdAt;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
