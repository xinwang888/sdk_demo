package com.igeshui.sdk.demo;

import com.igeshui.sdk.common.HttpClient;
import com.igeshui.sdk.common.MD5Utils;
import com.igeshui.sdk.common.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

/**
 * @author fanghao
 * @create 2018-01-15 10:59
 */
public class Common {

    public static HttpClient httpClient = new HttpClient();
    public static final String apiKey = "XW0101020000007623";
    public static final String apiSecret = "465d6bf1862842dbbc7e154667b66b27";


    /**
     * 共同处理流程
     *
     * @param reqParam
     * @throws Exception
     */
    public void doProcess(List<BasicNameValuePair> reqParam, String apiUrl) throws Exception {

        //提交受理请求
        String json = httpClient.doPost(apiUrl, reqParam);
        if (StringUtils.isBlank(json)) {
            System.out.println("查询失败");
        } else {
            System.out.println("json=" + json);

        }

    }

    /**
     * 签名转化
     *
     * @param reqParam
     * @return
     */
    public String getSign(List<BasicNameValuePair> reqParam) {

        StringBuffer sbb = new StringBuffer();
        int index = 1;
        for (BasicNameValuePair nameValuePair : reqParam) {
            sbb.append(nameValuePair.getName() + "=" + nameValuePair.getValue());
            if (reqParam.size() != index) {
                sbb.append("&");
            }
            index++;
        }
        String sign = sbb.toString();

        Map<String, String> paramMap = new HashMap<String, String>();
        String ret = "";
        if (!StringUtils.isEmpty(sign)) {
            String[] arr = sign.split("&");
            for (int i = 0; i < arr.length; i++) {
                String tmp = arr[i];
                if (-1 != tmp.indexOf("=")) {
                    paramMap.put(tmp.substring(0, tmp.indexOf("=")), tmp.substring(tmp.indexOf("=") + 1, tmp.length()));
                }

            }
        }
        List<Map.Entry<String, String>> list = new ArrayList<>(paramMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                int ret = 0;
                ret = o1.getKey().compareTo(o2.getKey());
                if (ret > 0) {
                    ret = 1;
                } else {
                    ret = -1;
                }
                return ret;
            }
        });

        StringBuilder sbTmp = new StringBuilder();
        for (Map.Entry<String, String> mapping : list) {
            if (!"sign".equals(mapping.getKey())) {
                sbTmp.append(mapping.getKey()).append("=").append(mapping.getValue()).append("&");
            }
        }
        sbTmp.setLength(sbTmp.lastIndexOf("&"));
        sbTmp.append(apiSecret);
        ret = MD5Utils.MD5(sbTmp.toString());

        //System.out.println(sb.toString());
        return ret;
    }

}

