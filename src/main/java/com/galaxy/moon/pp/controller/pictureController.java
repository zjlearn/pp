package com.galaxy.moon.pp.controller;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import static org.apache.catalina.servlet4preview.http.MappingMatch.PATH;

/**
 * create by zhangjun1 on 2018/1/25
 */
@RestController
@RequestMapping("/picture")
public class pictureController {

    Logger logger = LoggerFactory.getLogger(pictureController.class);

    /**
     * 上传文件
     * fixme 解决图片文件的命名，存储和查找功能
     *
     * @param file
     * @return * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {

        String fileName = "";
        if (!file.isEmpty()) {
            BufferedOutputStream out = null;
            File fileSourcePath = new File("");
            if (!fileSourcePath.exists()) {
                fileSourcePath.mkdirs();
            }
            fileName = file.getOriginalFilename();
            logger.info("上传的文件名为：" + fileName);
            out = new BufferedOutputStream(
                    new FileOutputStream(new File(fileSourcePath, fileName)));
            out.write(file.getBytes());
            out.flush();
            System.out.println(fileName.toString());
        }
        return ResultGenerator.genSuccessResult();

    }
}
