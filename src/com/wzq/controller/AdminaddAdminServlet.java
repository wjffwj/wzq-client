package com.wzq.controller;

import com.mysql.jdbc.StringUtils;
import com.wzq.service.AdminService;
import com.wzq.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员用户添加管理员
 * @created by 24745
 * @date 2019/11/27
 */
@WebServlet("/add/addadmin")
public class AdminaddAdminServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(1==this.check(username,password)) {
            req.setAttribute("msg","用户名或密码必输");
            req.getRequestDispatcher("/addadminRes.jsp").forward(req,resp);
        }else {
            int insertadmin = adminService.insertadmin(username, password);
            if(insertadmin>0) {
                req.setAttribute("msg","注册成功");
                req.getRequestDispatcher("/addadminRes.jsp").forward(req,resp);
            }else{
                req.setAttribute("msg","注册失败");
                req.getRequestDispatcher("/addadminRes.jsp").forward(req,resp);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    public int check(String username,String password) {
        if(StringUtils.isNullOrEmpty(username) ||StringUtils.isNullOrEmpty(password)) {
            return  1;
        }
        return 0;
    }
}
