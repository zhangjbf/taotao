package com.taotao.service.impl;

import com.pub.utils.FtpUtil;
import com.pub.utils.IDUtils;
import com.pub.utils.PictureResult;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2018/11/18
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FILE_UPLOAD_PATH}")
    private String FILE_UPLOAD_PATH;

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Value("${FTP_SERVER_IP}")
    private String FTP_SERVER_IP;

    @Value("${FTP_SERVER_PORT}")
    private int FTP_SERVER_PORT;

    @Value("${FTP_SERVER_USERNAME}")
    private String FTP_SERVER_USERNAME;

    @Value("${FTP_SERVER_PASSWORD}")
    private String FTP_SERVER_PASSWORD;


    @Override
    public PictureResult updateLoadFile(MultipartFile multipartFile) {

        PictureResult result = new PictureResult();
        String url = this.savePicture(multipartFile);

        result.setUrl(IMAGE_BASE_URL + url);
        result.setError(0);
        return result;
    }

    private String savePicture(MultipartFile uploadFile) {
        String result = null;
        try {
            // 上传文件功能实现
            // 判断文件是否为空
            if (uploadFile.isEmpty())
                return null;
            // 上传文件以日期为单位分开存放，可以提高图片的查询速度
            String filePath = "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
                    + new SimpleDateFormat("MM").format(new Date()) + "/"
                    + new SimpleDateFormat("dd").format(new Date());

            // 取原始文件名
            String originalFilename = uploadFile.getOriginalFilename();
            // 新文件名
            String newFileName = IDUtils.genImageName() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 转存文件，上传到ftp服务器
            FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME, FTP_SERVER_PASSWORD,
                    FILE_UPLOAD_PATH, filePath, newFileName, uploadFile.getInputStream());
            result = filePath + "/" + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}