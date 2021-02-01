package com.cn.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean { // InitializingBean初始化constantPropertiesUtils后执行afterPropertiesSet方法

    @Value("${aliyun.oss.file.endpoint}")
    private String endiPoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keySecret}")
    private String keySecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT=endiPoint;
        KEY_ID=keyId;
        KEY_SECRET=keySecret;
        BUCKET_NAME=bucketName;
    }
}
