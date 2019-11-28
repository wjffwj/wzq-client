package com.wzq.entity;

import java.io.Serializable;

/**
 * 用户信息表
 * @created by 24745
 * @date 2019/11/25
 */

public class User implements Serializable {
    //用户id
    private Integer id;
    //用户名
    private String username;
    //性别
    private String sex;
    //职位
    private String post;
    //部门
    private String bumen;
    //电话
    private String tel;
    //用餐次数
    private Integer time;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
