package com.wzq.service;

import com.wzq.dao.TranFlowDao;
import com.wzq.dao.TranflowdaoImpl;
import com.wzq.entity.TranFlow;
import com.wzq.param.TranFlowParam;

import java.util.List;

/**
 * @created by 24745
 * @date 2019/11/27
 */

public class TranflowServiceImpl implements TranflowService {
    private TranFlowDao tranFlowDao = new TranflowdaoImpl();
    @Override
    public List<TranFlow> listAllTranFlow() {
        return tranFlowDao.listalltranFLow();
    }

    @Override
    public List<TranFlow> getTranFlowByCondition(TranFlowParam param) {
        return  tranFlowDao.getTranFlowByCondition(param);

    }

    @Override
    public List<TranFlow> getUserWhoEatList(Integer month) {
        return tranFlowDao.getUserWhoEatList(month);
    }
}
