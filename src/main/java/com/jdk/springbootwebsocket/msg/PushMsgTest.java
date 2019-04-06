package com.jdk.springbootwebsocket.msg;

import com.alibaba.fastjson.JSON;
import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PushMsgTest {

    String SubscribeKey = "BS-129088b9da1742bfbb93897f366d7fe8"; //Subscribe only
    String CommonKey = "BC-832fdea8079b4238bcbed64e82bf0f93"; //Available for publish and subscribe

    @Test
    public void testPushMsg(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","Hello GoEasy!");
        String s = JSON.toJSONString(map);

        GoEasy goEasy = new GoEasy( "http://goeasy.io/goeasy/publish", CommonKey);
        goEasy.publish("my_channel", s,new PublishListener(){
            @Override
            public void onSuccess() {
                System.out.println("消息发送成功");
            }

            @Override
            public void onFailed(GoEasyError error) {
                System.out.println("消息发送失败:" + error);
            }
        });
    }

}
