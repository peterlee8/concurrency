package com.imooc.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * @Author peterLee
 * @Date 2018/9/5 下午3:40
 * @Describtion :
 */
@RestController
@Slf4j
public class FileController {

    private static final String UPLOAD_PATH ="/Users/ligang/IdeaProjects/thread-note/concurrency/src/main/resources/update/";

    /**
     * 单个文件上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 设置文件存储路径
            String filePath = UPLOAD_PATH;
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);
            // 文件写入
            return "上传成功："+fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    /**
     * 批量上传
     * @param request
     * @return
     */
    @PostMapping("/batch")
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String filePath = UPLOAD_PATH;
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(filePath + file.getOriginalFilename())));//设置文件路径及名字                     stream.write(bytes);// 写入
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "第 " + i + " 个文件上传失败 ==> " + e.getMessage();
                }
            } else {
                return "第 " + i+ " 个文件上传失败因为文件为空";
            }
        }
        return "上传成功";
    }
    /*@GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "dalaoyang.jpeg";// 文件名
         if (fileName != null) {
         //设置文件路径
         File file = new File("/Users/dalaoyang/Documents/dalaoyang.jpeg");
         File file = new File(realPath , fileName);
         if (file.exists()) {
               response.setContentType("application/force-download");// 设置强制下载不打开
               response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
               byte[] buffer = new byte[1024];
               FileInputStream fis = null;
               BufferedInputStream bis = null;
               try {
                     fis = new FileInputStream(file);
                     bis = new BufferedInputStream(fis);
                     OutputStream os = response.getOutputStream();
                     int i = bis.read(buffer);
                     while (i != -1) {
                     os.write(buffer, 0, i);
                     i = bis.read(buffer);
         }
              return "下载成功";
         } catch (Exception e) {
                    e.printStackTrace();
            } finally {
                 if (bis != null) {
                   try {
                     bis.close();
                  } catch (IOException e) {
                              e.printStackTrace();
                         }
                }
                 if (fis != null) {
                     try {
                      fis.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                  }
                }
               }
             }
            return "下载失败";
            }
         }*/

}
