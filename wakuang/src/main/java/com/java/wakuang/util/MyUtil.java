package com.java.wakuang.util;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * Created by Administrator on 2018/7/5.
 */
public class MyUtil implements Serializable{

    /**
     *  生成待签名的字符串
     * @param params
     * @return
     */
    public static String getStrForSign(String... params){
        if(StringUtils.isEmpty(params)){
            return "";
        }
        String[] afterSort = StringUtils.sortStringArray(params);
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<afterSort.length;i++){
            if(!StringUtils.isEmpty(afterSort[i])){
                sb.append(afterSort[i]);
                if(i<afterSort.length - 1){
                    sb.append("&");
                }
            }
        }
        //添加私钥参数
        sb.append("&secret_key=secretKey");
        return sb.toString();
    }

    /**
     * 签名
     * @param apiKey
     * @return
     */
    public static String getSign(String apiKey){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(apiKey.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5).toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }

    public static String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }

    public static void main(String[] args) {
        String[] parameters={
                "apikey=c821db84-6fbd-11e4-a9e3-c86000d26d7c",
                "symbol=btc_cny",
                "type=buy",
                "price=680",
                "amount=1.0"};
        String str = getStrForSign(parameters);
        System.out.println(str);
        System.out.println(getSign(str));
    }
}
