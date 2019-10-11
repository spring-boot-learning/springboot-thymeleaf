package com.spring.boot.controller;

import com.spring.boot.common.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("welcome")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("hello");
//        mv.addObject("messageKey","hello.welcome");
        mv.addObject("message", MessageUtils.getMessage("hello.welcome"));
        System.out.println("-----> go to welcome page...");
        return mv;
    }

    @RequestMapping("/name/{myName}")
    @ResponseBody
    public String demo(@PathVariable String myName) {
        return MessageUtils.getMessage("hello.hello") + myName + "!!!";
    }
}
