package me.alent.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Alent on 2017/2/21.
 */
@Controller
public class TestController{
    @RequestMapping(value = "/test/springmvc.do", method = RequestMethod.POST)
    public String testMethod(String name, Date birthday) {
        System.out.println(name);
        return "";
    }
}
