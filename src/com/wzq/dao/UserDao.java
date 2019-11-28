package com.wzq.dao;

import com.wzq.entity.User;
import com.wzq.param.UserReqParam;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户数据库操作
 * @created by 24745
 * @date 2019/11/25
 */

public interface UserDao {
    /**查询全部用户*/
    public List<User> getUserList() throws SQLException;

    /**条件查询用户*/
    public List<User> getUserByCondition(UserReqParam param);

    /**编辑用户信息*/
    public int updateByCondition(UserReqParam param);

}
