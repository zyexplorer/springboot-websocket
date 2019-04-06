package com.jdk.springbootwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex(){
        return "ws";
    }

    @RequestMapping("/toGoEasyTest")
    public String toGoEasyTest(){
        return "goEasyTest";
    }

    @RequestMapping("/toNewWs1")
    public String toNewWs1(){
        return "newWs1";
    }

    @RequestMapping("/toNewWs2")
    public String toNewWs2(){
        return "newWs2";
    }
}
