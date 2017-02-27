package me.alent.common.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异步返回各种格式，json，xml，text
 * Created by alent on 2017/2/27.
 */
public class ResponseUtils {

    // 发送内容
    public static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 发送json格式
    public static void renderJson(HttpServletResponse response, String text) {
        render(response, "application/json; charset=UTF-8", text);
    }

    // 发送json格式
    public static void renderXml(HttpServletResponse response, String text) {
        render(response, "text/xml; charset=UTF-8", text);
    }

    // 发送json格式
    public static void renderText(HttpServletResponse response, String text) {
        render(response, "application/plain; charset=UTF-8", text);
    }
}
