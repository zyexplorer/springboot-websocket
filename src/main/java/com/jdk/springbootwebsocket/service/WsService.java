package com.jdk.springbootwebsocket.service;

import com.jdk.springbootwebsocket.entity.WidelyResponse;

import java.util.List;

public interface WsService {

    public void sendMsg(WidelyResponse msg);

    public void send2Users(List<String> users, WidelyResponse msg);
}
