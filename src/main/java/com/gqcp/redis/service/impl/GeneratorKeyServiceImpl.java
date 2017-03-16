package com.gqcp.redis.service.impl;

import com.gqcp.common.utils.date.DateFormatUtils;
import com.gqcp.redis.service.GeneratorKeyService;
import com.gqcp.redis.service.RedisService;
import org.redisson.core.RLock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author wyq
 * @ClassName: GeneratorKeyServiceImpl
 * @Description: 实现(这里用一句话描述这个类的作用)
 * @date 2016/12/5 21:17
 */
@Service
public class GeneratorKeyServiceImpl implements GeneratorKeyService {

  @Resource
  RedisService redisService;

  @Override
  public Long generatorGoodsKey() {
    // 商品ID：年月日时分+4位顺序号+01系统ID，1612052359123401,16位
    String time = DateFormatUtils.formatDate(new Date(), "yyMMddHHmm");
    // 1、判断当前分钟内缓存是否存在数据
    // (1)、如果存在则获取序列号
    // (2)、如果不存在则生成0001
    RLock lock = redisService.getRLock(time);
    lock.lock();
    Long number = 0l;
    Object obj = redisService.getRBucket("GOODSID:" + time).get();
    if (obj != null) {
      String sequence = (String) obj;
      Integer increment = Integer.parseInt(sequence) + 1;
      String newSeq = String.format("%04d", increment);
      redisService.getRBucket("GOODSID:" + time).set(newSeq);
      number = Long.parseLong(time + newSeq + "01");
    } else {
      redisService.getRBucket("GOODSID:" + time).set("0001");
      number = Long.parseLong(time + "0001" + "01");
    }
    lock.unlock();
    return number;
  }

  @Override
  public Long generatorOrderKey() {
    // 订单ID：年月日时分秒+3位顺序号+01系统ID，16120523595912301,17位
    String time = DateFormatUtils.formatDate(new Date(), "yyMMddHHmmss");
    // 1、判断当前分钟内缓存是否存在数据
    // (1)、如果存在则获取序列号
    // (2)、如果不存在则生成0001
    RLock lock = redisService.getRLock(time);
    lock.lock();
    Long number = 0l;
    Object obj = redisService.getRBucket("ORDER:" + time).get();
    if (obj != null) {
      String sequence = (String) obj;
      Integer increment = Integer.parseInt(sequence) + 1;
      String newSeq = String.format("%03d", increment);
      redisService.getRBucket("ORDER:" + time).set(newSeq);
      number = Long.parseLong(time + newSeq + "01");
    } else {
      redisService.getRBucket("ORDER:" + time).set("001");
      number = Long.parseLong(time + "001" + "01");
    }
    lock.unlock();
    return number;
  }

  @Override
  public Long generatorBoId() {
    // 用户ID：年月日时分+4位顺序号，16120523591234,14位
    String time = DateFormatUtils.formatDate(new Date(), "yyMMddHHmm");
    // 1、判断当前分钟内缓存是否存在数据
    // (1)、如果存在则获取序列号
    // (2)、如果不存在则生成0001
    RLock lock = redisService.getRLock(time);
    lock.lock();
    Long number = 0l;
    Object obj = redisService.getRBucket("BOID:" + time).get();
    if (obj != null) {
      String sequence = (String) obj;
      Integer increment = Integer.parseInt(sequence) + 1;
      String newSeq = String.format("%04d", increment);
      redisService.getRBucket("BOID:" + time).set(newSeq);
      number = Long.parseLong(time + newSeq);
    } else {
      redisService.getRBucket("BOID:" + time).set("00001");
      number = Long.parseLong(time + "0001");
    }
    lock.unlock();
    return number;
  }
}
