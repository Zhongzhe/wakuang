package com.java.wakuang.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/5.
 */
public class FeeInfo implements Serializable{

    //        leftfees: 实际收取费用
//        fees: 应收的手续费
//        status: 状态:1未完成,2部分成交,3完全成交,4用户撤销

    private Double leftfees;

    private Double fees;

    private Integer status;

    public Double getLeftfees() {
        return leftfees;
    }

    public void setLeftfees(Double leftfees) {
        this.leftfees = leftfees;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
