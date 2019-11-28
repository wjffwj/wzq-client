package com.wzq.controller;

import com.wzq.entity.TranFlow;
import com.wzq.service.TranflowService;
import com.wzq.service.TranflowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/27
 */
@WebServlet("/tranflow/list")
public class TranflowServlet extends HttpServlet {
    TranflowService tranflowService = new TranflowServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TranFlow> tranFlows = tranflowService.listAllTranFlow();
        req.setAttribute("tranflows",tranFlows);
        req.getRequestDispatcher("/show.jsp").forward(req,resp);
    }
}
