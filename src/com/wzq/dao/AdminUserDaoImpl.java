package com.wzq.dao;

import com.wzq.entity.AdminUser;
import com.wzq.entity.User;
import com.wzq.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/26
 */

public class AdminUserDaoImpl implements AdminUserDao {
    private static Connection con;
    public AdminUserDaoImpl() {
        con = ConnectionUtil.getConnection();
    }


    @Override
    public AdminUser login(String username, String password) {
        List<AdminUser> list = new ArrayList<>();
        try {
            int index =1;
            PreparedStatement ps = con.prepareStatement("select * from admin_user where username=? and password=?");
            ps.setString(index++,username);
            ps.setString(index++,password);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                AdminUser adminUser = new AdminUser();
                adminUser.setUsername(rs.getString("username"));
                adminUser.setPassword(rs.getString("password"));
                list.add(adminUser);
            }

        } catch (SQLException e) {}
        if(list.size()==1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int addAdminUser(String username, String password) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into admin_user(username,password) values (?,?)");
            int index =1;
            ps.setString(index++,username);
            ps.setString(index++,password);
            boolean execute = ps.execute();
            if(!execute) {
                return  1;
            }
        } catch (SQLException e) {

        }
        return 0;
    }


}
