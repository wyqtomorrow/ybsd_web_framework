package com.gqcp.mq.service;

import com.gqcp.simple.mcontroller.req.SimpleReqForm;

/**
 * Created by lenovo on 2017/3/13.
 */
public interface SimpleMqProducerApi {
  /**
   * 发送简单消息
   * 
   * @param reqForm
   */
  void sendSimpleLog(SimpleReqForm reqForm);
}
