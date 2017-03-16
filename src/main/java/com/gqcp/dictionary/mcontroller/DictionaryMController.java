package com.gqcp.dictionary.mcontroller;

import com.gqcp.common.page.ResponseEntity;
import com.gqcp.common.page.ResponseEntityUtil;
import com.gqcp.common.web.BaseController;
import com.gqcp.dictionary.service.DictionaryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hh on 2016/12/2.
 */
@RestController
@RequestMapping(value = "/mob/dictionary", produces = MediaType.APPLICATION_JSON_VALUE)
public class DictionaryMController extends BaseController {
  @Resource
  DictionaryService dictionaryService;

  @RequestMapping(value = "/getDictParams", method = RequestMethod.GET)
  public ResponseEntity getDictParams(HttpServletRequest request, String dictParams, String sysId) {
    ResponseEntity responseEntity = dictionaryService.selectDictParamsByParams(dictParams, sysId);
    return responseEntity;
  }

  @RequestMapping(value = "/initDictionaryRedis", method = RequestMethod.GET)
  public ResponseEntity<Void> initDictionaryRedis(HttpServletRequest request) {
    dictionaryService.initSystemDictionaryCache();
    return ResponseEntityUtil.success();
  }

}
