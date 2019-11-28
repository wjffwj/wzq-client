package com.wzq.service;

import com.wzq.entity.TranFlow;
import com.wzq.param.TranFlowParam;

import java.util.List;

/**
 * tran flow service
 * @created by 24745
 * @date 2019/11/27
 */

public interface TranflowService {
    List<TranFlow> listAllTranFlow();

    List<TranFlow> getTranFlowByCondition(TranFlowParam param);

    List<TranFlow> getUserWhoEatList(Integer month);
}
