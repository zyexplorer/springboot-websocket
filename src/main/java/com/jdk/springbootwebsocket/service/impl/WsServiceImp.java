package com.jdk.springbootwebsocket.service.impl;

import com.jdk.springbootwebsocket.entity.WidelyResponse;
import com.jdk.springbootwebsocket.service.WsService;
import com.jdk.springbootwebsocket.websocketconfig.WsConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WsServiceImp implements WsService {

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 广播
     * 发给所有在线用户
     *
     * @param msg
     */
    public void sendMsg(WidelyResponse msg) {
        template.convertAndSend(WsConstant.PRODUCERPATH, msg);
    }

    /**
     * 发送给指定用户
     * @param users
     * @param msg
     */
    public void send2Users(List<String> users, WidelyResponse msg) {
        users.forEach(userName -> {
            template.convertAndSendToUser(userName, WsConstant.P2PPUSHPATH, msg);
        });
    }

}
