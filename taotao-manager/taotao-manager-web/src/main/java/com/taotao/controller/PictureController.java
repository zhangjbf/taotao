package com.taotao.controller;

import com.pub.utils.JsonUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public String picUpload(MultipartFile uploadFile) {
        return JsonUtils.objectToJson(pictureService.updateLoadFile(uploadFile));
    }
}
