package com.example.concurrentdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭文文
 * @version 1.0
 * @date 2020/11/9 10:32
 */
@RestController
@RequestMapping("/test")
public class Test {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
