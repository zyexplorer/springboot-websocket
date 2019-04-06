package com.jdk.springbootwebsocket.controller;

import com.jdk.springbootwebsocket.entity.RequestMessage;
import com.jdk.springbootwebsocket.entity.ResponseMessage;
import com.jdk.springbootwebsocket.entity.WidelyMessage;
import com.jdk.springbootwebsocket.entity.WidelyResponse;
import com.jdk.springbootwebsocket.service.WsService;
import com.jdk.springbootwebsocket.websocketconfig.WsConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.thymeleaf.expression.Lists;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WsController {

//    @MessageMapping("/welcome")
//    @SendTo("/topic/getResponse")
//    public ResponseMessage say(RequestMessage message) {
//        System.out.println(message.getName());
//        return new ResponseMessage("welcome," + message.getName() + "!");
//    }


    @Autowired
    WsService webSocketService;

    @MessageMapping(WsConstant.FORETOSERVERPATH)//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @SendTo(WsConstant.PRODUCERPATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public WidelyResponse say(WidelyMessage message) throws Exception {
//        List<String> users = Lists.newArrayList();
        List<String> users = new ArrayList<>();
        users.add("d892bf12bf7d11e793b69c5c8e6f60fb");//此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
        webSocketService.send2Users(users, new WidelyResponse("admin hello"));

        return new WidelyResponse("Welcome, " + message.getName() + "!");
    }
}
