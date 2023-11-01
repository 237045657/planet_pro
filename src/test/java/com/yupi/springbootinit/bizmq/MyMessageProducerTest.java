package com.yupi.springbootinit.bizmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyMessageProducerTest {
    @Resource
    MyMessageProducer myMessageProducer;

    @Test
    void senMessage() {
        myMessageProducer.senMessage("code_exchange", "my_routingKey", "帅逼你谁");
    }
}