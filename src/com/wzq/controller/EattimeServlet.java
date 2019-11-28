package com.wzq.controller;

import com.wzq.entity.User;
import com.wzq.param.TranFlowParam;
import com.wzq.service.TranflowService;
import com.wzq.service.TranflowServiceImpl;
import com.wzq.service.UserService;
import com.wzq.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/28
 */
@WebServlet("/ccgc/tongji")
public class EattimeServlet extends HttpServlet {
    UserService userService =new UserServiceImpl();
    TranflowService tranflowService  = new TranflowServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int month = 1;
        List<User> all = userService.getAll();
        for(User u:all) {
            Integer id = u.getId();
            TranFlowParam param = new TranFlowParam();
            param.setUserId(id);
            param.setMonth(month);
            int time =  tranflowService.getTranFlowByCondition(param).size();
            u.setTime(time);
        }
        req.setAttribute("users",all);
        req.getRequestDispatcher("/showusereat.jsp").forward(req,resp);
    }
}
