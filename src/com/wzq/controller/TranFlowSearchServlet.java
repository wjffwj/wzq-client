package com.wzq.controller;

import com.wzq.entity.TranFlow;
import com.wzq.param.TranFlowParam;
import com.wzq.service.TranflowService;
import com.wzq.service.TranflowServiceImpl;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/27
 */
@WebServlet("/tranflow/search")
public class TranFlowSearchServlet extends HttpServlet {
    TranflowService tranflowService = new TranflowServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TranFlowParam param = new TranFlowParam();
        String month = req.getParameter("month");
        String id = req.getParameter("tranflowId");
        String cardNo = req.getParameter("cardNo");
        String createDate = req.getParameter("createDate");

        if(!"".equals(month)) {
            param.setMonth(Integer.valueOf(month));
        }
        if(!"".equals(id)){
            param.setId(Integer.valueOf(id));
        }
        if(!"".equals(cardNo)) {
            param.setCardNo(Integer.valueOf(cardNo));
        }
        Date createDates = null;
        if(!"".equals(createDate)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                createDates = sdf.parse(createDate);
                param.setCreateDate(createDates);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<TranFlow> tranFlowList = tranflowService.getTranFlowByCondition(param);
        req.setAttribute("tranflows",tranFlowList);
        req.getRequestDispatcher("/show.jsp").forward(req,resp);
    }
}
