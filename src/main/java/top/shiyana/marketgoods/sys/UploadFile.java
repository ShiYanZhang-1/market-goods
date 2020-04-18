package top.shiyana.marketgoods.sys;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @ProjectName: market-goods
 * @Package: top.shiyana.marketgoods.sys
 * @ClassName: UploadFile
 * @Author: dangerous
 * @Description:
 * @Date: 2020/4/17 16:56
 * @Version: 1.0
 */
@Component
@Slf4j
public class UploadFile {

    public String uploadFile(MultipartFile file) throws Exception {
        // 首先校验图片格式
        List<String> imageType =  Arrays.asList("jpg", "jpeg", "png", "bmp", "gif");
        // 获取文件名，带后缀
        String originalFilename = file.getOriginalFilename();
        // 获取文件的后缀格式
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        if (imageType.contains(fileSuffix)) {
            // 只有当满足图片格式时才进来，重新赋图片名，防止出现名称重复的情况
            String newFileName = UUID.randomUUID().toString() + originalFilename;
            // 该方法返回的为当前项目的工作目录，即在哪个地方启动的java线程
            String dirPath = System.getProperty("user.dir");
//            String dirPath =  "/Users/dangerous/Desktop/pic";
            String path = File.separator + "uploadImg" + File.separator + newFileName;
            File destFile = new File(dirPath +"/src/main/view/static/images"+ path);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            try {
                file.transferTo(destFile);
                // 将相对路径返回给前端
                return path;
            } catch (IOException e) {
                log.error("upload pic error");
                return null;
            }
        } else {
            // 非法文件
            log.error("the picture's suffix is illegal");
            throw new Exception(SysConstant.FILE_UPLOAD_ERROR);
        }
    }
}
