/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2018-12-29 11:17
 */
public class SocketServer {
    private static Logger logger = LoggerFactory.getLogger(SocketServer.class);
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6666);
        try {

            while (true) {
                //接收客户端的请求
                System.out.println("监听客户端的数据:");
                Socket sc = ss.accept();
                InputStream is = sc.getInputStream();
                byte[] buffer = new byte[1024];
                int len = is.read(buffer);
                String getData = new String(buffer, 0, len);
                System.out.println("从客户端获取的数据:" + getData);
                //业务处理 大小写转化
                String outPutData = getData.toUpperCase();

                //向客户端写数据
                OutputStream os = sc.getOutputStream();
                os.write(outPutData.getBytes(StandardCharsets.UTF_8));

                //释放资源
                os.close();
                is.close();
                sc.close();
            }
        }catch (Exception e) {
            logger.error("启动Socket异常：",e);
            ss.close();
        }
    }

}
