package com.cn.oss.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.io.InputStream;
@Slf4j
public class FileUploadUtils {

    public static String upload(String fileName,InputStream inputStream){
        String url = null;
        try{
            //创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(ConstantPropertiesUtils.END_POINT,ConstantPropertiesUtils.KEY_ID,ConstantPropertiesUtils.KEY_SECRET);

            Long time = System.currentTimeMillis();

            fileName = time+fileName;

            String datePath = new DateTime().toString("yyyy/MM/dd");

            fileName = datePath + "/" + fileName;

            //上传文件流
            PutObjectResult result = ossClient.putObject(ConstantPropertiesUtils.BUCKET_NAME,fileName,inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            if(result != null){
                url = "https://"+ ConstantPropertiesUtils.BUCKET_NAME + "."+ConstantPropertiesUtils.END_POINT+"/"+fileName;
            }

            return url;
        }catch (Exception e){
            log.error(e.getMessage());
            return url;
        }
    }

}
