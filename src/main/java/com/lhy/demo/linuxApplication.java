package com.lhy.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class linuxApplication {

    private static Logger logger = LoggerFactory.getLogger(linuxApplication.class);
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public static void execCmd(String cmd,File file){
        try{
            Runtime rt = Runtime.getRuntime();
            //执行命令, 最后一个参数，可以使用new File("path")指定运行的命令的位置
            Process proc = rt.exec(cmd,null,null);
            InputStream stderr =  proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr,"GBK");
            BufferedReader br = new BufferedReader(isr);
            String line="";
            // 打印出命令执行的结果
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        logger.info("=======================================================");
        //命令的前面必须要有/bin/sh -c
        String cmd="/bin/sh -c mvn complie";
		    String path="";
		    File file=new File(path);
        execCmd(cmd,file);
        logger.info("=======================================================");
    }
}
