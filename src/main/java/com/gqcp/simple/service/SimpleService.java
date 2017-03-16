package com.gqcp.simple.service;

import java.util.List;

import com.gqcp.simple.dao.model.Simple;
import com.gqcp.simple.mcontroller.req.SimpleReqForm;
import com.gqcp.simple.mcontroller.res.SimpleResForm;

/**
 * 
 * @ClassName: SimpleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wyq
 * @date 2016年11月26日 上午10:42:32
 *
 */
public interface SimpleService {

  /**
   * 
   * @Title: selectSimpleById
   * @Description: 按主键查询实体
   * @param id
   * @return SimpleResForm
   *
   */
  SimpleResForm selectSimpleById(Long id) throws Exception;

  /**
   * 
   * @Title: selectSimpleList
   * @Description: 按条件查询列表(含分页)
   * @param reqForm
   * @return List<SimpleResForm>
   *
   */
  List<Simple> selectSimpleList(SimpleReqForm reqForm);

  /**
   * 
   * @Title: insertSimpleEntity
   * @Description: 插入实体
   * @param reqForm
   * @return Integer
   *
   */
  Integer insertSimpleEntity(SimpleReqForm reqForm);

  /**
   * 
   * @Title: updateSimpleEntity
   * @Description: 更新实体
   * @param reqForm
   * @return Integer
   *
   */
  Integer updateSimpleEntity(SimpleReqForm reqForm) throws Exception;

  /**
   * 
   * @Title: deleteSimpleById
   * @Description: 根据主键删除实体
   * @param id
   * @return Integer
   *
   */
  Integer deleteSimpleById(Long id);
}
