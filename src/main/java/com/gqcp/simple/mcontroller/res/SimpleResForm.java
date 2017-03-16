package com.gqcp.simple.mcontroller.res;

import java.util.Date;

public class SimpleResForm {
  private Long id;

  private String name;

  private String address;

  private Date birthday;

  private Integer age;

  private Boolean enable;

  private Boolean gender;

  private String companyName;

  private Date createTime;

  private Long createId;

  private Date updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Long getCreateId() {
    return createId;
  }

  public void setCreateId(Long createId) {
    this.createId = createId;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getUpdateId() {
    return updateId;
  }

  public void setUpdateId(Long updateId) {
    this.updateId = updateId;
  }

  private Long updateId;
  
}
