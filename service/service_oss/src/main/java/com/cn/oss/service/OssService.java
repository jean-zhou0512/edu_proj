package com.cn.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    public String uploadAvatar(MultipartFile file);
}
