package me.alent.core.controller.admin;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import me.alent.common.web.Constants;
import me.alent.common.web.ResponseUtils;
import net.fckeditor.response.UploadResponse;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by alent on 2017/2/27.
 */
@Controller
public class UploadController {

    //使用Jersey上传图片到另一台服务器
    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(MultipartFile pic, HttpServletResponse response) throws IOException {
        // 获取图片扩展名
        String extension = FilenameUtils.getExtension(pic.getOriginalFilename());

        // 图片名称生成策略, 使用时间（毫秒级）作为名称的一部分
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = dateFormat.format(new Date());
        // 随机生成三个数
        Random random = new Random();
        for(int i=0; i<3; i++) {
            format += random.nextInt(10);
        }

        // 实例化一个Jersey
        Client client = new Client();
        // 保存到数据库
        String path = "upload/" + format + "." + extension;
        // 另一台服务器的请求路径
        String url = Constants.IMAGE_URL + path;
        WebResource resource = client.resource(url);
        resource.put(String.class, pic.getBytes());

        // 异步返回2个请求路径，使用json格式
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", url);
        jsonObject.put("path", path);
        ResponseUtils.renderJson(response, jsonObject.toString());
    }

    @RequestMapping(value = "/upload/uploadFck.do")
    public void uploadFck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultipartHttpServletRequest mhr = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = mhr.getFileMap();
//        获取多张图片
        Set<Map.Entry<String, MultipartFile>> entries = fileMap.entrySet();
        for (Map.Entry<String, MultipartFile> entry : entries) {
            MultipartFile value = entry.getValue();

            // 获取图片扩展名
            String extension = FilenameUtils.getExtension(value.getOriginalFilename());

            // 图片名称生成策略, 使用时间（毫秒级）作为名称的一部分
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String format = dateFormat.format(new Date());
            // 随机生成三个数
            Random random = new Random();
            for(int i=0; i<3; i++) {
                format += random.nextInt(10);
            }

            // 实例化一个Jersey
            Client client = new Client();
            // 保存到数据库
            String path = "upload/" + format + "." + extension;
            // 另一台服务器的请求路径
            String url = Constants.IMAGE_URL + path;
            WebResource resource = client.resource(url);
            resource.put(String.class, value.getBytes());

            UploadResponse ok = UploadResponse.getOK(url);
//            response返回对象
            response.getWriter().print(ok); //字节流
        }
    }
}
