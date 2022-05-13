package com.ruoyi.file.utils;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.file.config.QiniuProperties;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@Slf4j
@Component
public class QiniuUtil {

    @Autowired
    private static QiniuProperties properties;

    //构造一个带指定Region对象的配置类
    private static Configuration cfg = new Configuration(Region.region2());

    //提供有参构造函数，才能让properties有数据
    public QiniuUtil(QiniuProperties properties) {
        this.properties = properties;
    }


    //获取图片路径
    public String getImageList(String prefix) {
        Auth auth = Auth.create(properties.getAccessKey(), properties.getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, cfg);

        //文件名前缀由参数传递过来

        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀(模拟列出目录效果)。缺省值为空字符串
        String delimiter = "";

        try {
            FileListing jianjie = bucketManager.listFiles(properties.getBucket(), prefix, "", 1000, delimiter);
            for (FileInfo item : jianjie.items) {
                System.out.println(item.key);
            }
        } catch (QiniuException e) {
            e.printStackTrace();
        }

        //列举空间文件列表(方式2)
        /*BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(properties.getBucket(), prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                System.out.println(item.key);
                System.out.println(item.hash);
                System.out.println(item.fsize);
                System.out.println(item.mimeType);
                System.out.println(item.putTime);
                System.out.println(item.endUser);
            }
        }*/
        return "error";
    }

    public static String saveImage(MultipartFile file)  {
        try {
            UploadManager uploadManager= new UploadManager(cfg);
            int dotPos = file.getOriginalFilename().lastIndexOf(".");
            if (dotPos < 0) {
                return null;
            }
//            String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
            String fileExt = FileUploadUtils.getExtension(file);
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
            // 调用put方法上传
            //获取token
            String token = Auth.create(properties.getAccessKey(), properties.getSecretKey()).uploadToken(properties.getBucket());
            Response res = uploadManager.put(file.getBytes(), "keshi/"+fileName, token);
            // 打印返回的信息
            if (res.isOK() && res.isJson()) {
                // 返回这张存储照片的地址
                return "http://"+properties.getDomain()+"/"+ JSONObject.parseObject(res.bodyString()).getString("key");
            } else {
                log.error("七牛异常:" + res.bodyString());
                return null;
            }
        } catch (QiniuException e) {
            // 请求失败时打印的异常的信息
            log.error("七牛异常:" + e.getMessage());
            return null;
        } catch (Exception e) {
            log.error("七牛异常:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //删除文件
    public static void deleteFileFromQiniu(String fileName){
        Auth auth = Auth.create(properties.getAccessKey(), properties.getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(properties.getBucket(), fileName);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }
}
