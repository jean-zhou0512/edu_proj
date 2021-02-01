package com.cn.oss.service.impl;

import com.cn.oss.service.OssService;
import com.cn.oss.utils.ConstantPropertiesUtils;
import com.cn.oss.utils.FileUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class OssServiceImpl implements OssService {

    public String uploadAvatar(MultipartFile file){
        try{
            String url = FileUploadUtils.upload(file.getOriginalFilename(),file.getInputStream());
//            String url = "https://"+ ConstantPropertiesUtils.BUCKET_NAME + "."+ConstantPropertiesUtils.END_POINT+"/"+file.getOriginalFilename();
            return url;
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }

    };
}
