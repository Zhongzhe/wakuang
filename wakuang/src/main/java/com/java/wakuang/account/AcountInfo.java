package com.java.wakuang.account;


import com.java.wakuang.util.MyHttpUtils;
import com.java.wakuang.vo.FeeInfo;
import com.java.wakuang.vo.ResultHttpRequest;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * Created by Administrator on 2018/7/5.
 */
@Component
public class AcountInfo {
    //www.coinbig.com/api/publics/websocket
    private String domain = "www.coinbig.com";
    private String url= "/api/publics/v1/order_fee";

    /**
     * 查询用户手续费
     * @param apikey
     * @param sign
     * @param symbol
     * @param order_id
     * @return
     */
    public String getOrderFee(String apikey,String sign, String symbol,Long order_id){
        StringBuilder sb = new StringBuilder("");
        sb.append("apikey="+apikey);
        sb.append("&sign="+sign);
        sb.append("&symbol="+symbol);
        sb.append("&order_id="+order_id);
        try {
            ResultHttpRequest resultHttpRequest = MyHttpUtils.doPost(domain+url,sb.toString());
            if(200==resultHttpRequest.getStatusCode()){
                FeeInfo fee = JSON.parseObject(resultHttpRequest.getResponseBody(),FeeInfo.class);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取用户提现/充值记录
     * @param apikey
     * @param sign
     * @param shortName
     * @param recordType
     * @param status
     * @return
     */
    public String getAccountRecords(String apikey,String sign, String shortName,Integer recordType,Integer status){

        return "";
//        shortName: 币种名称 usdt:比特币
//        type: 0全部,1充值,2提现
//        status: 状态１:等待提现 2. 锁定，正在处理 3.提现成功  4.用户撤销
    }



}
