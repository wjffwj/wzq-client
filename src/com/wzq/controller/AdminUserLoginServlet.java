package com.wzq.controller;

import com.wzq.entity.AdminUser;
import com.wzq.service.AdminService;
import com.wzq.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理管理员用户登录操作
 * @created by 24745
 * @date 2019/11/26
 */
@WebServlet("/admin/login")
public class AdminUserLoginServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String username = req.getParameter("username");
     String password = req.getParameter("password");
     AdminUser adminUser = adminService.login(username, password);
     if(adminUser!=null) {
         //登录成功
         req.getSession().setAttribute("adminUser",adminUser);
         req.setAttribute("adminUser",adminUser);
         req.setAttribute("msg","登录成功欢迎您:"+adminUser.getUsername());
         req.getRequestDispatcher("/login.jsp").forward(req,resp);
     }else {
         //登陆失败
         req.setAttribute("msg","登录失败用户名密码错误");
         req.getRequestDispatcher("/index.jsp").forward(req,resp);

     }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
