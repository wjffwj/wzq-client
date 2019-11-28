package com.wzq.entity;

/**
 * 管理员
 * @created by 24745
 * @date 2019/11/25
 */

public class AdminUser {
    //主键管理员号
    private  Integer id;
    //管理员用户名
    private String username;
    //管理员密码
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
