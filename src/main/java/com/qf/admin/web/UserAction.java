package com.qf.admin.web;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class UserAction {
    @GetMapping("/toupdate")
    public String toUpLoad() {
        return "update";
    }

    @PostMapping("/update")
    public String upLoad(HttpServletRequest request, MultipartFile file) {
        //如果数据不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String realPath = request.getServletContext().getRealPath("/imgge/");
            //获得上传文件名
            String filename = file.getOriginalFilename();
            //获得file对象
            File filepath = new File(realPath, filename);
            //判断路径是否存在，如果不存在则创建
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件上传到一个目录文件中
            try {
                file.transferTo(new File(realPath + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "update";
        } else {
            return "update";
        }
    }
    @GetMapping("/downLoad")
    public ResponseEntity<byte[]> downLoad(HttpServletRequest request,String filename){
        //1.文件下载路径
        String path = request.getServletContext().getRealPath("/imgge/");
        //2.拼接出要下载的文件
        File file = new File(path + File.separator + filename);
        //3.设置请求头
        HttpHeaders headers = new HttpHeaders();
        //4.设置编码
        String downLoadFileName = null;
        try {
            downLoadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //5.设置格式
        headers.setContentDispositionFormData("attachment",downLoadFileName);
        //6.设置内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
