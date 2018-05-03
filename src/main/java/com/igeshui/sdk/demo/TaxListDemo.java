package com.igeshui.sdk.demo;

import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 查询用户列表
 * @author fanghao
 * @create 2018-01-15 10:52
 */
public class TaxListDemo extends Common{
    public static final String apiUrl = "http://localhost:8080/sdk/api/tax/findTaxAccountList";//
    public static final Date startTime = new Date();//请求接口
    public static final Date endTime = new Date();//请求接口
    public static final Integer pageNo = 1;//请求接口

    @Test
    public  void testDemo()   {
        TaxListDemo orderNoDemo = new TaxListDemo();
        orderNoDemo.process();
    }

    public void process(){
        System.out.println("开始获取账户信息");

        try {

            //提交受理请求对象
            List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
            reqParam.add(new BasicNameValuePair("apiKey", apiKey));
            reqParam.add(new BasicNameValuePair("startTime", (endTime.getTime()-6*24*60*60*1000)+"" ));
            reqParam.add(new BasicNameValuePair("endTime", startTime.getTime()+""));
            reqParam.add(new BasicNameValuePair("pageNo", 1+""));
//            reqParam.add(new BasicNameValuePair(null, 2+""));
            reqParam.add(new BasicNameValuePair("sign", getSign(reqParam)));

//            提交受理请求
            doProcess(reqParam,apiUrl);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
