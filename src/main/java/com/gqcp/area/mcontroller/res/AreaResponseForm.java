package com.gqcp.area.mcontroller.res;

public class AreaResponseForm {
  private Integer areaId;

  private String areaName;

  private String areaFullName;

  private Integer rank;

  private Integer parentId;

  private String axis;

  private String longitude;

  private String latitude;

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public String getAreaFullName() {
    return areaFullName;
  }

  public void setAreaFullName(String areaFullName) {
    this.areaFullName = areaFullName;
  }

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public String getAxis() {
    return axis;
  }

  public void setAxis(String axis) {
    this.axis = axis;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
}
