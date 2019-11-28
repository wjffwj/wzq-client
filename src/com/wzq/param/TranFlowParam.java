package com.wzq.param;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询用户流水请求类
 * @created by 24745
 * @date 2019/11/26
 */

public class TranFlowParam implements Serializable {
    //主键
    private Integer id;
    //用户号
    private  Integer userId;
    //用户名
    private String username;
    //卡号
    private Integer cardNo;
    //消费金额
    private Integer money;
    //创建时间戳
    private Date created;
    //创建日
    private Date createDate;
    //消费月份
    private Integer month;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
