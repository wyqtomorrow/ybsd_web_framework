package com.gqcp.redis.service.impl;

import javax.annotation.Resource;

import com.gqcp.common.cache.RedissonTemplate;
import org.redisson.core.*;
import org.springframework.stereotype.Service;

import com.gqcp.redis.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

  @Resource
  RedissonTemplate redissonTemplate;



  /**
   * 获取字符串对象
   * 
   * @param objectName
   * @return
   */
  public <T> RBucket<T> getRBucket(String objectName) {
    RBucket<T> bucket = redissonTemplate.getBucket(objectName);
    return bucket;
  }

  /**
   * 批量删除
   * @param patternName
   */
  public void deleteByPatternName(String patternName) {
    RKeys rKeys = redissonTemplate.getKeys();
    rKeys.deleteByPattern(patternName);
  }

  /**
   * 获取Map对象
   * 
   * @param objectName
   * @return
   */
  public <K, V> RMap<K, V> getRMap(String objectName) {
    RMap<K, V> map = redissonTemplate.getMap(objectName);
    return map;
  }

  /**
   * 获取有序集合
   * 
   * @param objectName
   * @return
   */
  public <V> RSortedSet<V> getRSortedSet(String objectName) {
    RSortedSet<V> sortedSet = redissonTemplate.getSortedSet(objectName);
    return sortedSet;
  }

  /**
   * 获取集合
   * 
   * @param objectName
   * @return
   */
  public <V> RSet<V> getRSet(String objectName) {
    RSet<V> rSet = redissonTemplate.getSet(objectName);
    return rSet;
  }

  /**
   * 获取列表
   * 
   * @param objectName
   * @return
   */
  public <V> RList<V> getRList(String objectName) {
    RList<V> rList = redissonTemplate.getList(objectName);
    return rList;
  }

  /**
   * 获取队列
   * 
   * @param objectName
   * @return
   */
  public <V> RQueue<V> getRQueue(String objectName) {
    RQueue<V> rQueue = redissonTemplate.getQueue(objectName);
    return rQueue;
  }

  /**
   * 获取双端队列
   * 
   * @param objectName
   * @return
   */
  public <V> RDeque<V> getRDeque(String objectName) {
    RDeque<V> rDeque = redissonTemplate.getDeque(objectName);
    return rDeque;
  }

  /**
   * 获取锁
   * 
   * @param objectName
   * @return
   */
  public RLock getRLock(String objectName) {
    RLock rLock = redissonTemplate.getLock(objectName);
    return rLock;
  }

  /**
   * 获取原子数
   * 
   * @param objectName
   * @return
   */
  public RAtomicLong getRAtomicLong(String objectName) {
    RAtomicLong rAtomicLong = redissonTemplate.getAtomicLong(objectName);
    return rAtomicLong;
  }

  /**
   * 获取记数锁
   * 
   * @param objectName
   * @return
   */
  public RCountDownLatch getRCountDownLatch(String objectName) {
    RCountDownLatch rCountDownLatch = redissonTemplate.getCountDownLatch(objectName);
    return rCountDownLatch;
  }

  /**
   * 获取消息的Topic
   * 
   * @param objectName
   * @return
   */
  public <M> RTopic<M> getRTopic(String objectName) {
    RTopic<M> rTopic = redissonTemplate.getTopic(objectName);
    return rTopic;
  }

  /**
   * 关闭Redisson客户端连接
   */
  public void closeRedisson(){
    redissonTemplate.shutdown();
  }


  @Override
  public <K, V> RMap<K, V> getMap(String name) {
    return redissonTemplate.getMap(name);
  }

  @Override
  public <V> RList<V> getList(String name) {
    return redissonTemplate.getList(name);
  }



}
