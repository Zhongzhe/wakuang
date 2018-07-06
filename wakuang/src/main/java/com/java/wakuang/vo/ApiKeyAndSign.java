package com.java.wakuang.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/5.
 */
public class ApiKeyAndSign implements Serializable{

    //公钥
    private String apiKey;
    //签名
    private String sign;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    @Override
    public String toString() {
        return "apiKey="+apiKey+"&sign="+sign;
    }
}
