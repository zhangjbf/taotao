package com.taotao.service;

import com.pub.utils.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
public interface PictureService {

    PictureResult updateLoadFile(MultipartFile multipartFile);
}
