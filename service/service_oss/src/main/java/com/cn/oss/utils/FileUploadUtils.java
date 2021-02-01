package com.cn.oss.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
@Slf4j
public class FileUploadUtils {

    public static int upload(String fileName,InputStream inputStream){
        try{
            //创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(ConstantPropertiesUtils.END_POINT,ConstantPropertiesUtils.KEY_ID,ConstantPropertiesUtils.KEY_SECRET);

            //上传文件流
            PutObjectResult result = ossClient.putObject(ConstantPropertiesUtils.BUCKET_NAME,fileName,inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();
            if(result == null){
                return -1;
            }
            return 1;
        }catch (Exception e){
            log.error(e.getMessage());
            return -1;
        }
    }

}
