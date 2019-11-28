package com.wzq.service;

import com.wzq.entity.AdminUser;

/**
 * @created by 24745
 * @date 2019/11/26
 */

public interface AdminService {
    //管理员登录
    public AdminUser login(String username,String password);

    //管理员添加管理员
    public int insertadmin(String username , String password);
}
