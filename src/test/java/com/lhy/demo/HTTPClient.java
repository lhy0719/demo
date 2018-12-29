/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 *
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2018-12-29 11:49
 */
public class HTTPClient {

    public static void main(String[] args) throws Exception {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入手机号:");
            String mobileCode = scanner.nextLine();
            if (Long.valueOf(mobileCode)>0) {
                get(mobileCode);
            }else {
                System.out.println("应用退出！");
                break;
            }
        }
    }

    private static void get(String mobileCode) throws Exception{
        URL url=new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode="+mobileCode+
                "&userID="+"");
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){ //结果码=200
            InputStream is=conn.getInputStream();
            //内存流 ，
            ByteArrayOutputStream boas=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len=-1;
            while((len=is.read(buffer))!=-1){
                boas.write(buffer, 0, len);
            }
            System.out.println("GET请求获取的数据:"+boas.toString());
            boas.close();
            is.close();
        }
    }

    //2.Post请求 ：通过Http-Client 框架来模拟实现 Http请求
    public void post(String mobileCode ,String userID) throws Exception{

        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
        // 创建参数队列
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("mobileCode", mobileCode));
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(params, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
