package com.wzq.dao;

import com.wzq.entity.TranFlow;
import com.wzq.param.TranFlowParam;

import java.util.List;

/***
 * 流水记录操作
 */
public interface TranFlowDao {
    /**
     * 查询用户消费流水操作
     */
    public List<TranFlow> getTranFlowByCondition(TranFlowParam param);

    public List<TranFlow> listalltranFLow();

    List<TranFlow> getUserWhoEatList(Integer month);
}
