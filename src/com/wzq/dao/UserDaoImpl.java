package com.wzq.dao;

import com.wzq.entity.User;
import com.wzq.param.UserReqParam;
import com.wzq.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/27
 */

public class UserDaoImpl implements UserDao {
    private Connection connection = ConnectionUtil.getConnection();
    @Override
    public List<User> getUserList() throws SQLException {
        List<User> list= new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("select * from user");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setSex(rs.getString("sex"));
            u.setBumen(rs.getString("bumen"));
            u.setPost(rs.getString("post"));
            u.setTel(rs.getString("tel"));
            list.add(u);
        }
        return list;
    }

    @Override
    public List<User> getUserByCondition(UserReqParam param) {
        return null;
    }

    @Override
    public int updateByCondition(UserReqParam param) {
        return 0;
    }
}
