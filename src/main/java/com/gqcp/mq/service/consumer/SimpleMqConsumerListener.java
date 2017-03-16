package com.gqcp.mq.service.consumer;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.alibaba.fastjson.JSON;
import com.gqcp.simple.mcontroller.res.SimpleResForm;
import org.springframework.stereotype.Service;

/**
 * Created by hh on 2017/1/19.
 */
public class SimpleMqConsumerListener implements MessageListener {

  @Override
  public void onMessage(Message message) {
    String json;
    try {
      json = new String(message.getBody(), "UTF-8");
      SimpleResForm resForm = JSON.parseObject(json, SimpleResForm.class);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
