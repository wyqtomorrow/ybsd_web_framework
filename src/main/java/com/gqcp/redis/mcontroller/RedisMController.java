package com.gqcp.redis.mcontroller;

import com.gqcp.common.page.ResponseEntity;
import com.gqcp.common.page.ResponseEntityUtil;
import com.gqcp.redis.service.RedisService;
import org.redisson.core.RLock;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wyq
 * @ClassName: RedisMController
 * @Description: 测试redis(这里用一句话描述这个类的作用)
 * @date 2016/12/9 14:40
 */
@RestController
@RequestMapping("/redis")
public class RedisMController {
  @Resource
  RedisService redisService;

  @RequestMapping("/getLock")
  public ResponseEntity<Void> getLock() {
    RLock lock = redisService.getRLock("1122334455");
    lock.lock();
    try {
      Thread.sleep(1 * 60 * 1000l);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    lock.unlock();
    return ResponseEntityUtil.success();
  }
}
