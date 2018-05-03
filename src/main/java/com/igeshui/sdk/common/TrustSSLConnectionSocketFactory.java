package com.igeshui.sdk.common;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;

/**
 * Created by lewis on 2016/7/2.
 */
public class TrustSSLConnectionSocketFactory {

    /**
     * 创建SSL安全连接
     *
     * @return
     */
    public static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory connectionSocketFactory=null;
        try{
            SSLContext sslcontext = SSLContexts.custom()
                    //忽略掉对服务器端证书的校验
                    .loadTrustMaterial((TrustStrategy) (chain, authType) -> true).build();
            connectionSocketFactory = new SSLConnectionSocketFactory(sslcontext, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
       return connectionSocketFactory;
    }
}
