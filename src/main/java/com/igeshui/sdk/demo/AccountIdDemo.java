package com.igeshui.sdk.demo;

import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于accountId查询个税信息
 * @author fanghao
 * @create 2018-01-15 10:52
 */
public class AccountIdDemo extends Common{

    public static final String queryType = "accountId";
    public static final String accountId = "c543fe474f544212a334bf42813f4a21";
    public static final String apiUrl = "http://localhost:8080/sdk/api/tax/findTaxInfo";

    @Test
    public  void testDemo()   {
        AccountIdDemo accountIdDemo = new AccountIdDemo();
        accountIdDemo.process();
    }

    public void process(){
        System.out.println(".......");

        try {

            //提交受理请求对象
            List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
            reqParam.add(new BasicNameValuePair("apiKey", apiKey));
            reqParam.add(new BasicNameValuePair("accountId", accountId));
            reqParam.add(new BasicNameValuePair("queryType", queryType));
            reqParam.add(new BasicNameValuePair("sign", getSign(reqParam)));

            //提交受理请求
            doProcess(reqParam,apiUrl);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
