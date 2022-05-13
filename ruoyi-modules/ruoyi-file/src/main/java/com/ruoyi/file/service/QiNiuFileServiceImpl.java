package com.ruoyi.file.service;

import com.ruoyi.file.utils.QiniuUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 万一
 * @DATE 2022年04月24日10:28
 */
@Primary
@Service
public class QiNiuFileServiceImpl implements ISysFileService {

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        return QiniuUtil.saveImage(file);
    }
}
