package com.wzq.controller;

import com.wzq.entity.TranFlow;
import com.wzq.entity.User;
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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 统计1月份未用过餐的员工
 *
 * @created by 24745
 * @date 2019/11/27
 */
@WebServlet("/search/noeat")
public class NoEatServlet extends HttpServlet {
    TranflowService service = new TranflowServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer month = 1;//想查几月份就换成几月份
        // step1-查询出消费过的用户
        List<TranFlow> tranFlowList = service.getUserWhoEatList(month);
        //step2 - 查询全部用户列表
        List<User> userList = userService.getAll();

        //取出tranflowList中的userId集合
        List<Integer> collect = tranFlowList.stream().map(TranFlow::getUserId).collect(Collectors.toList());
        Iterator<User> iterator = userList.iterator();
        for (Integer i : collect) {
            while (iterator.hasNext()) {
                User next = iterator.next();
                if(next.getId().equals(i)){
                    iterator.remove();
                    break;
                }

            }
        }
        req.setAttribute("users",userList);
        req.getRequestDispatcher("/showuser.jsp").forward(req,resp);
    }
}
