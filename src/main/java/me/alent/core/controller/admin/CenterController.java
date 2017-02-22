package me.alent.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alent on 2017/2/21.
 */
@Controller
@RequestMapping(value = "/control")
public class CenterController {
    //跳转到首页
    @RequestMapping(value = "/index.do")
    public String index() {
        return "index";
    }

    //跳转头页面
    @RequestMapping(value = "/top.do")
    public String top() {
        return "top";
    }

    //跳转身体页面
    @RequestMapping(value = "/main.do")
    public String main() {
        return "main";
    }
    //身体页面左
    @RequestMapping(value = "/left.do")
    public String left() {
        return "left";
    }

    @RequestMapping(value = "/right.do")
    public String right() {
        return "right";
    }
}
