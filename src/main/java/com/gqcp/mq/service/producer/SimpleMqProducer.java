package com.gqcp.mq.service.producer;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gqcp.mq.service.SimpleMqProducerApi;
import com.gqcp.simple.mcontroller.req.SimpleReqForm;

/**
 * Created by lenovo on 2017/3/13.
 */
@Service
public class SimpleMqProducer implements SimpleMqProducerApi {
  static Logger logger = LoggerFactory.getLogger(SimpleMqProducer.class);
  @Resource
  AmqpTemplate amqpTemplate;

  @Value("${rabbit.mq.simple.routingkey}")
  String routingKey;

  @Override
  public void sendSimpleLog(SimpleReqForm reqForm) {
    try {
      amqpTemplate.convertAndSend(routingKey, reqForm);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }
}
