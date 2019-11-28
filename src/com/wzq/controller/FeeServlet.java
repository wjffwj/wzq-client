package com.wzq.controller;

import com.wzq.entity.TranFlow;
import com.wzq.param.TranFlowParam;
import com.wzq.service.TranflowService;
import com.wzq.service.TranflowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 统计公司1月份应付给食堂的费用
 * @created by 24745
 * @date 2019/11/27
 */
@WebServlet("/fee/fee")
public class FeeServlet extends HttpServlet {
    private TranflowService tranflowService = new TranflowServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer month =1;//指定月份为1
        //step-1查询指定月份的消费流水表
        TranFlowParam param = new TranFlowParam();
        param.setMonth(month);
        //流水列表
        List<TranFlow> tranFlowByCondition = tranflowService.getTranFlowByCondition(param);
        //取出列表中每一个money进行累加
         int sum=0;
        for(TranFlow t:tranFlowByCondition) {
            Integer money = t.getMoney();
            sum+=money;
        }
        req.setAttribute("sum",sum);

        //总数是sum，返回给前端
        req.getRequestDispatcher("/showsum.jsp").forward(req,resp);

    }
}
