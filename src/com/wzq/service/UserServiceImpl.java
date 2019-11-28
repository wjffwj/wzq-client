package com.wzq.service;

import com.wzq.dao.UserDao;
import com.wzq.dao.UserDaoImpl;
import com.wzq.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/27
 */

public class UserServiceImpl implements UserService {
    UserDao userDao =new UserDaoImpl();
    @Override
    public List<User> getAll() {
        try {
            return userDao.getUserList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
