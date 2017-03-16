package com.gqcp.simple.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.gqcp.common.exception.business.BusinessException;
import com.gqcp.common.utils.copy.BeanCopyTools;
import com.gqcp.common.utils.copy.BeanUtilsEx;
import com.gqcp.simple.dao.mapper.SimpleMapper;
import com.gqcp.simple.dao.model.Simple;
import com.gqcp.simple.mcontroller.res.SimpleResForm;
import com.gqcp.simple.service.SimpleService;
import com.gqcp.common.exception.Errors;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.gqcp.simple.dao.model.SimpleExample;
import com.gqcp.simple.dao.model.SimpleExample.Criteria;
import com.gqcp.simple.mcontroller.req.SimpleReqForm;

@Service
public class SimpleServiceImpl implements SimpleService {

  @Resource
  SimpleMapper simpleMapper;

  @Override
  public SimpleResForm selectSimpleById(Long id) throws Exception {
    Simple simple = simpleMapper.selectByPrimaryKey(id);
    SimpleResForm srf = new SimpleResForm();
    BeanUtilsEx.copyProperties(srf,simple);
    return srf;
  }

  @Override
  public List<Simple> selectSimpleList(SimpleReqForm reqForm) {
    PageHelper.startPage(reqForm.getPageNum(), reqForm.getPageSize());
    SimpleExample example = new SimpleExample();
    example.setOrderByClause("order by");
    Criteria criteria = example.createCriteria();
    if (StringUtils.isNotBlank(reqForm.getName())) {
      criteria.andNameEqualTo(reqForm.getName());
    }
    List<Simple> list = simpleMapper.selectByExample(example);
    return list;
  }

  @Override
  public Integer insertSimpleEntity(SimpleReqForm reqForm){
    Simple simple = new Simple();
    Date date = new Date();
    simple.setAddress("北京市海淀区中关村大厦");
    simple.setName("大北农");
    simple.setCompanyName("大北农");
    simple.setBirthday(date);
    simple.setCreateTime(date);
    simple.setEnable(true);
    simple.setAge(20);
    simple.setUpdateTime(date);
    simple.setUpdateId(10l);
    simpleMapper.insertSelective(simple);
    throw new BusinessException(Errors.SYSTEM_ERROR);
  }

  @Override
  public Integer updateSimpleEntity(SimpleReqForm reqForm) throws Exception {
    Simple simple = new Simple();
    BeanCopyTools.copyProperties(reqForm, simple);
    return simpleMapper.updateByPrimaryKeySelective(simple);
  }

  @Override
  public Integer deleteSimpleById(Long id) {
    return simpleMapper.deleteByPrimaryKey(id);
  }

}
