package com.jdk.springbootwebsocket.entity;

import lombok.Data;

/*
    后台发送消息实体类
 */
@Data
public class WidelyResponse {

    private String responseMessage;

    public WidelyResponse(){}

    public WidelyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
