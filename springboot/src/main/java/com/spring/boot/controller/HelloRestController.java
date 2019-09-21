package com.spring.boot.controller;

import com.spring.boot.common.utils.I18nUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/hello")
public class HelloRestController {

    @RequestMapping("/name/{myName}")
    public String demo(@PathVariable String myName) {
        return I18nUtils.getMessage("hello.hello") + myName + "!!!";
    }
}
