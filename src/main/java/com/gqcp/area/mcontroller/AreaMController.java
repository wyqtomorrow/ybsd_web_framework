package com.gqcp.area.mcontroller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.gqcp.area.mcontroller.res.AreaResponseForm;
import com.gqcp.area.service.AreaService;
import com.gqcp.common.page.ResponseEntity;
import com.gqcp.common.page.ResponseEntityUtil;
import com.gqcp.common.web.BaseController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/area/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AreaMController extends BaseController {
  @Resource
  AreaService areaService;

  @RequestMapping(value = "/init", method = RequestMethod.GET)
  public ResponseEntity<?> init(HttpServletRequest request) throws Exception {
    areaService.initArea();
    return ResponseEntityUtil.success();
  }

  @RequestMapping(value = "/getAllProvinces", method = RequestMethod.GET)
  public ResponseEntity<?> getAllProvinces(HttpServletRequest request) throws Exception {
    List<Map<Long, Object>> list = areaService.getAllProvinces();
    return ResponseEntityUtil.success(list);
  }

  @RequestMapping(value = "/getAllCitysByProvinceId/{areaId}", method = RequestMethod.GET)
  public ResponseEntity<?> getAllCitysByProvinceId(@PathVariable("areaId") Long areaId,
      HttpServletRequest request) throws Exception {
    List<Map<Long, Object>> list = areaService.getAllCitysByProvinceId(areaId);
    return ResponseEntityUtil.success(list);
  }

  @RequestMapping(value = "/getAreaById/{areaId}", method = RequestMethod.GET)
  public ResponseEntity<?> getAllProvinces(@PathVariable("areaId") Long areaId,
      HttpServletRequest request) throws Exception {
    AreaResponseForm area = areaService.getAreaById(areaId);
    return ResponseEntityUtil.success(area);
  }
}
