package com.wzq.dao;

import com.wzq.entity.AdminUser;

/**管理员用户表*/
public interface AdminUserDao {
    /**
     * 管理员登录
     */

    public AdminUser login(String username,String password);

    /**
     * 管理员操作新增管理员
     * @return
     */
    public int addAdminUser(String username,String password);


}
