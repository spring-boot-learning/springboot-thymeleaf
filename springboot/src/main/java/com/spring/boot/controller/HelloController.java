package com.spring.boot.controller;

import com.spring.boot.common.utils.I18nUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("welcome")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("hello");
//        mv.addObject("messageKey","hello.welcome");
        mv.addObject("message", I18nUtils.getMessage("hello.welcome"));
        System.out.println("-----> go to welcome page...");
        return mv;
    }
}
