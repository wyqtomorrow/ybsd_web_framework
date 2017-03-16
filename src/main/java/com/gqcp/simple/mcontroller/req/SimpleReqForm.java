package com.gqcp.simple.mcontroller.req;

import java.util.Date;

import com.gqcp.common.web.BasePageForm;


public class SimpleReqForm extends BasePageForm {
  /**  
  * @Fields serialVersionUID : TODO
  */  
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private String address;

  private Date birthday;

  private Integer age;

  private Boolean enable;

  private Boolean gender;

  private String companyName;

  private Date createTime;

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

}
