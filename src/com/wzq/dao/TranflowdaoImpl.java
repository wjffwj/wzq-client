package com.wzq.dao;

import com.wzq.entity.TranFlow;
import com.wzq.param.TranFlowParam;
import com.wzq.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/27
 */

public class TranflowdaoImpl implements TranFlowDao {
    private Connection connection;


    @Override
    public List<TranFlow> getTranFlowByCondition(TranFlowParam param) {
        List<TranFlow> list = new ArrayList<>();
        connection = ConnectionUtil.getConnection();
        StringBuilder sql = new StringBuilder("select * from tran_flow where 1=1 ");

        if(param.getCardNo()!=null) {
            sql.append("and card_no=? ");
        }
        if(param.getId()!=null) {
            sql.append("and id=? ");
        }
        if(param.getUserId()!=null){
            sql.append("and userid=? ");

        }
        if(param.getCreateDate()!=null){
            sql.append("and create_date=?");
        }
        if(param.getMonth()!=null){
            sql.append( "and month = ?");
        }
        try {
            int index = 1;
            PreparedStatement ps = connection.prepareStatement(sql.toString());
            if(param.getCardNo()!=null) {
                ps.setInt(index++,param.getCardNo());
            }
            if(param.getId()!=null) {
                ps.setInt(index++,param.getId());
            }
            if(param.getUserId()!=null){
                ps.setInt(index++,param.getUserId());

            }
            if(param.getCreateDate()!=null){
                ps.setDate(index++, new Date(param.getCreateDate().getTime()));
            }
            if(param.getMonth()!=null){
                ps.setInt( index++,param.getMonth());
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TranFlow tranFlow = new TranFlow();
                tranFlow.setId(rs.getInt("id"));
                tranFlow.setUserId(rs.getInt("userid"));
                tranFlow.setUsername(rs.getString("username"));
                tranFlow.setCardNo(rs.getInt("card_no"));
                tranFlow.setMoney(rs.getInt("money"));
                tranFlow.setCreated(rs.getTimestamp("created"));
                tranFlow.setCreateDate(rs.getDate("create_date"));
                tranFlow.setMonth(rs.getInt("month"));
                list.add(tranFlow);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public List<TranFlow> listalltranFLow() {
        List<TranFlow> list = new ArrayList<>();
        connection = ConnectionUtil.getConnection();
        try {

            PreparedStatement ps = connection.prepareStatement("select * from tran_flow");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TranFlow tranFlow = new TranFlow();
                tranFlow.setId(rs.getInt("id"));
                tranFlow.setUserId(rs.getInt("userid"));
                tranFlow.setUsername(rs.getString("username"));
                tranFlow.setCardNo(rs.getInt("card_no"));
                tranFlow.setMoney(rs.getInt("money"));
                tranFlow.setCreated(rs.getTimestamp("created"));
                tranFlow.setCreateDate(rs.getDate("create_date"));
                tranFlow.setMonth(rs.getInt("month"));
                list.add(tranFlow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TranFlow> getUserWhoEatList(Integer month) {
        List<TranFlow> list= new ArrayList<>();
        String sql ="select userid,username from tran_flow where month=? group by userId ";
        connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,month);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int userid = rs.getInt("userid");
                String username = rs.getString("username");
                TranFlow tranFlow =new TranFlow();
                tranFlow.setUsername(username);
                tranFlow.setUserId(userid);
                list.add(tranFlow);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
