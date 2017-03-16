package com.gqcp.redis.service;

import org.redisson.core.RAtomicLong;
import org.redisson.core.RBucket;
import org.redisson.core.RCountDownLatch;
import org.redisson.core.RDeque;
import org.redisson.core.RList;
import org.redisson.core.RLock;
import org.redisson.core.RMap;
import org.redisson.core.RQueue;
import org.redisson.core.RSet;
import org.redisson.core.RSortedSet;
import org.redisson.core.RTopic;

public interface RedisService {
  /**
   * 获取字符串对象
   * 
   * @param objectName
   * @return
   */
  public <T> RBucket<T> getRBucket(String objectName);

  /**
   * 获取Map对象
   * 
   * @param objectName
   * @return
   */
  public <K, V> RMap<K, V> getRMap(String objectName);

  /**
   * 获取有序集合
   * 
   * @param objectName
   * @return
   */
  public <V> RSortedSet<V> getRSortedSet(String objectName);

  /**
   * 获取集合
   * 
   * @param objectName
   * @return
   */
  public <V> RSet<V> getRSet(String objectName);

  /**
   * 获取列表
   * 
   * @param objectName
   * @return
   */
  public <V> RList<V> getRList(String objectName);

  /**
   * 批量删除
   * @param patternName
   */
  public void deleteByPatternName(String patternName);

  /**
   * 获取队列
   * 
   * @param objectName
   * @return
   */
  public <V> RQueue<V> getRQueue(String objectName);

  /**
   * 获取双端队列
   * 
   * @param objectName
   * @return
   */
  public <V> RDeque<V> getRDeque(String objectName);

  /**
   * 获取锁
   * 
   * @param objectName
   * @return
   */
  public RLock getRLock(String objectName);

  /**
   * 获取原子数
   * 
   * @param objectName
   * @return
   */
  public RAtomicLong getRAtomicLong(String objectName);

  /**
   * 获取记数锁
   * 
   * @param objectName
   * @return
   */
  public RCountDownLatch getRCountDownLatch(String objectName);

  /**
   * 获取消息的Topic
   * 
   * @param objectName
   * @return
   */
  public <M> RTopic<M> getRTopic(String objectName);

  /**
   *
   * @Title: getMap
   * @Description: 获取map
   * @param name
   * @return RMap<K,V>
   *
   */
  public <K, V> RMap<K, V> getMap(String name);

  /**
   * 
   * @Title: getList
   * @Description: 获取List
   * @param name
   * @return RList<V>
   *
   */
  public <V> RList<V> getList(String name);


}
