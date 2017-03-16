package com.gqcp.redis.service;

/**
 * @author wyq
 * @ClassName: GeneratorKeyService
 * @Description: 生成系统key(这里用一句话描述这个类的作用)
 * @date 2016/12/5 21:17
 */
public interface GeneratorKeyService {
  /**
   * 生成商品主键
   * 
   * @return
   */
  Long generatorGoodsKey();

  /**
   * 生成订单主键
   * 
   * @return
   */
  Long generatorOrderKey();

  /**
   * 生成用户主键
   * 
   * @return
   */
  Long generatorBoId();
}
