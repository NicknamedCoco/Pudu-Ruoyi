package world.keyi.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import world.keyi.config.QiniuProperties;

import java.io.IOException;
import java.util.UUID;


@Component
public class QiniuUtil {

    @Autowired
    private QiniuProperties properties;

    //构造一个带指定Region对象的配置类
    private Configuration cfg = new Configuration(Region.region2());

    //上传资源使用
    //private UploadManager uploadManager= new UploadManager(cfg);

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
}
