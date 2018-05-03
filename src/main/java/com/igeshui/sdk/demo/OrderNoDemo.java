package com.igeshui.sdk.demo;

import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于orderNo查询个税信息
 * @author fanghao
 * @create 2018-01-15 10:52
 */
public class OrderNoDemo extends Common{

    public static final String queryType = "orderNo";//请求接口
    public static final String orderNo = "0101022018011915380672515";
    public static final String apiUrl = "http://localhost:8080/sdk/api/tax/findTaxInfo";

    @Test
    public void testDemo()   {
        OrderNoDemo orderNoDemo = new OrderNoDemo();
        orderNoDemo.process();
    }

    public void process(){
        System.out.println("开始获取账户信息");

        try {

            //提交受理请求对象
            List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
            reqParam.add(new BasicNameValuePair("apiKey", apiKey));
            reqParam.add(new BasicNameValuePair("orderNo", orderNo));
            reqParam.add(new BasicNameValuePair("queryType", queryType));
            reqParam.add(new BasicNameValuePair("sign", getSign(reqParam)));

            //提交受理请求
            doProcess(reqParam,apiUrl);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
