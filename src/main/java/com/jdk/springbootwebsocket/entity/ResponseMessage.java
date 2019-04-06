package com.jdk.springbootwebsocket.entity;

import lombok.Data;

@Data
public class ResponseMessage {

    private String responseMsg;

    public ResponseMessage(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseMsg(){
        return responseMsg;
    }
}
