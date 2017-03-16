package com.gqcp.common.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.core.*;

import io.netty.util.concurrent.Future;

public class RedissonTemplate implements RedissonClient {


  private RedissonClient redisson;

  @Override
  public <V> RGeo<V> getGeo(String s) {
    return redisson.getGeo(s);
  }

  @Override
  public <V> RGeo<V> getGeo(String s, Codec codec) {
    return redisson.getGeo(s, codec);
  }

  @Override
  public <V> RSetCache<V> getSetCache(String s) {
    return redisson.getSetCache(s);
  }

  @Override
  public <V> RSetCache<V> getSetCache(String s, Codec codec) {
    return redisson.getSetCache(s, codec);
  }

  @Override
  public <K, V> RMapCache<K, V> getMapCache(String s, Codec codec) {
    return redisson.getMapCache(s, codec);
  }

  @Override
  public <K, V> RMapCache<K, V> getMapCache(String s) {
    return redisson.getMapCache(s);
  }

  @Override
  public <V> RBucket<V> getBucket(String s) {
    return redisson.getBucket(s);
  }

  @Override
  public <V> RBucket<V> getBucket(String s, Codec codec) {
    return redisson.getBucket(s, codec);
  }

  @Override
  public RBuckets getBuckets() {
    return redisson.getBuckets();
  }

  @Override
  public RBuckets getBuckets(Codec codec) {
    return redisson.getBuckets(codec);
  }

  @Override
  public <V> List<RBucket<V>> findBuckets(String s) {
    return redisson.findBuckets(s);
  }

  @Override
  public <V> Map<String, V> loadBucketValues(Collection<String> collection) {
    return redisson.loadBucketValues(collection);
  }

  @Override
  public <V> Map<String, V> loadBucketValues(String... strings) {
    return redisson.loadBucketValues(strings);
  }

  @Override
  public void saveBuckets(Map<String, ?> map) {
    redisson.saveBuckets(map);
  }

  @Override
  public <V> RHyperLogLog<V> getHyperLogLog(String s) {
    return redisson.getHyperLogLog(s);
  }

  @Override
  public <V> RHyperLogLog<V> getHyperLogLog(String s, Codec codec) {
    return redisson.getHyperLogLog(s, codec);
  }

  @Override
  public <V> RList<V> getList(String s) {
    return redisson.getList(s);
  }

  @Override
  public <V> RList<V> getList(String s, Codec codec) {
    return redisson.getList(s, codec);
  }

  @Override
  public <K, V> RListMultimap<K, V> getListMultimap(String s) {
    return redisson.getListMultimap(s);
  }

  @Override
  public <K, V> RListMultimap<K, V> getListMultimap(String s, Codec codec) {
    return redisson.getListMultimap(s, codec);
  }

  @Override
  public <K, V> RListMultimapCache<K, V> getListMultimapCache(String s) {
    return redisson.getListMultimapCache(s);
  }

  @Override
  public <K, V> RListMultimapCache<K, V> getListMultimapCache(String s, Codec codec) {
    return redisson.getListMultimapCache(s, codec);
  }

  @Override
  public <K, V> RMap<K, V> getMap(String s) {
    return redisson.getMap(s);
  }

  @Override
  public <K, V> RMap<K, V> getMap(String s, Codec codec) {
    return redisson.getMap(s, codec);
  }

  @Override
  public <K, V> RSetMultimap<K, V> getSetMultimap(String s) {
    return redisson.getSetMultimap(s);
  }

  @Override
  public <K, V> RSetMultimap<K, V> getSetMultimap(String s, Codec codec) {
    return redisson.getSetMultimap(s, codec);
  }

  @Override
  public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String s) {
    return redisson.getSetMultimapCache(s);
  }

  @Override
  public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String s, Codec codec) {
    return redisson.getSetMultimapCache(s, codec);
  }

  @Override
  public RSemaphore getSemaphore(String s) {
    return redisson.getSemaphore(s);
  }

  @Override
  public RLock getLock(String s) {
    return redisson.getLock(s);
  }

  @Override
  public RLock getFairLock(String s) {
    return redisson.getFairLock(s);
  }

  @Override
  public RReadWriteLock getReadWriteLock(String s) {
    return redisson.getReadWriteLock(s);
  }

  @Override
  public <V> RSet<V> getSet(String s) {
    return redisson.getSet(s);
  }

  @Override
  public <V> RSet<V> getSet(String s, Codec codec) {
    return redisson.getSet(s, codec);
  }

  @Override
  public <V> RSortedSet<V> getSortedSet(String s) {
    return redisson.getSortedSet(s);
  }

  @Override
  public <V> RSortedSet<V> getSortedSet(String s, Codec codec) {
    return redisson.getSortedSet(s, codec);
  }

  @Override
  public <V> RScoredSortedSet<V> getScoredSortedSet(String s) {
    return redisson.getScoredSortedSet(s);
  }

  @Override
  public <V> RScoredSortedSet<V> getScoredSortedSet(String s, Codec codec) {
    return redisson.getScoredSortedSet(s, codec);
  }

  @Override
  public RLexSortedSet getLexSortedSet(String s) {
    return redisson.getLexSortedSet(s);
  }

  @Override
  public <M> RTopic<M> getTopic(String s) {
    return redisson.getTopic(s);
  }

  @Override
  public <M> RTopic<M> getTopic(String s, Codec codec) {
    return redisson.getTopic(s, codec);
  }

  @Override
  public <M> RPatternTopic<M> getPatternTopic(String s) {
    return redisson.getPatternTopic(s);
  }

  @Override
  public <M> RPatternTopic<M> getPatternTopic(String s, Codec codec) {
    return redisson.getPatternTopic(s, codec);
  }

  @Override
  public <V> RQueue<V> getQueue(String s) {
    return redisson.getQueue(s);
  }

  @Override
  public <V> RQueue<V> getQueue(String s, Codec codec) {
    return redisson.getQueue(s, codec);
  }

  @Override
  public <V> RBlockingQueue<V> getBlockingQueue(String s) {
    return redisson.getBlockingQueue(s);
  }

  @Override
  public <V> RBlockingQueue<V> getBlockingQueue(String s, Codec codec) {
    return redisson.getBlockingQueue(s, codec);
  }

  @Override
  public <V> RDeque<V> getDeque(String s) {
    return redisson.getDeque(s);
  }

  @Override
  public <V> RDeque<V> getDeque(String s, Codec codec) {
    return redisson.getDeque(s, codec);
  }

  @Override
  public <V> RBlockingDeque<V> getBlockingDeque(String s) {
    return redisson.getBlockingDeque(s);
  }

  @Override
  public <V> RBlockingDeque<V> getBlockingDeque(String s, Codec codec) {
    return redisson.getBlockingDeque(s, codec);
  }

  @Override
  public RAtomicLong getAtomicLong(String s) {
    return redisson.getAtomicLong(s);
  }

  @Override
  public RAtomicDouble getAtomicDouble(String s) {
    return redisson.getAtomicDouble(s);
  }

  @Override
  public RCountDownLatch getCountDownLatch(String s) {
    return redisson.getCountDownLatch(s);
  }

  @Override
  public RBitSet getBitSet(String s) {
    return redisson.getBitSet(s);
  }

  @Override
  public <V> RBloomFilter<V> getBloomFilter(String s) {
    return redisson.getBloomFilter(s);
  }

  @Override
  public <V> RBloomFilter<V> getBloomFilter(String s, Codec codec) {
    return redisson.getBloomFilter(s, codec);
  }

  @Override
  public RScript getScript() {
    return redisson.getScript();
  }

  @Override
  public RRemoteService getRemoteSerivce() {
    return redisson.getRemoteSerivce();
  }

  @Override
  public RRemoteService getRemoteSerivce(Codec codec) {
    return redisson.getRemoteSerivce(codec);
  }

  @Override
  public RRemoteService getRemoteSerivce(String s) {
    return redisson.getRemoteSerivce(s);
  }

  @Override
  public RRemoteService getRemoteSerivce(String s, Codec codec) {
    return redisson.getRemoteSerivce(s, codec);
  }

  @Override
  public RBatch createBatch() {
    return redisson.createBatch();
  }

  @Override
  public RKeys getKeys() {
    return redisson.getKeys();
  }

  @Override
  public void shutdown() {
    redisson.shutdown();
  }

  @Override
  public void shutdown(long l, long l1, TimeUnit timeUnit) {
    redisson.shutdown(l, l1, timeUnit);
  }

  @Override
  public Config getConfig() {
    return redisson.getConfig();
  }

  @Override
  public NodesGroup<Node> getNodesGroup() {
    return redisson.getNodesGroup();
  }

  @Override
  public ClusterNodesGroup getClusterNodesGroup() {
    return redisson.getClusterNodesGroup();
  }

  @Override
  public boolean isShutdown() {
    return false;
  }

  @Override
  public boolean isShuttingDown() {
    return false;
  }

  public void setRedisson(RedissonClient redisson) {
    this.redisson = redisson;
  }


}
