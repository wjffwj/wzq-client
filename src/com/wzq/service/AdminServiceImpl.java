package com.wzq.service;

import com.wzq.dao.AdminUserDao;
import com.wzq.dao.AdminUserDaoImpl;
import com.wzq.entity.AdminUser;

/**
 * @created by 24745
 * @date 2019/11/26
 */

public class AdminServiceImpl implements AdminService {
    AdminUserDao dao = new AdminUserDaoImpl();


    @Override
    public AdminUser login(String username, String password) {
        AdminUser login = dao.login(username, password);
        return login;
    }

    @Override
    public int insertadmin(String username, String password) {
        return  dao.addAdminUser(username,password);
    }
}
