package com.gqcp.member.dao.model;

import java.util.Date;

public class MemberLogin {
  private Long boId;

  private String loginName;

  private String loginPwd;

  private Byte loginErrorNumber;

  private Byte systemId;

  private String dataRemark;

  private Date createTime;

  private String versionRemark;

  private Date vno;

  private Byte isEnabled;

  private Member member;

  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Long getBoId() {
    return boId;
  }

  public void setBoId(Long boId) {
    this.boId = boId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName == null ? null : loginName.trim();
  }

  public String getLoginPwd() {
    return loginPwd;
  }

  public void setLoginPwd(String loginPwd) {
    this.loginPwd = loginPwd == null ? null : loginPwd.trim();
  }

  public Byte getLoginErrorNumber() {
    return loginErrorNumber;
  }

  public void setLoginErrorNumber(Byte loginErrorNumber) {
    this.loginErrorNumber = loginErrorNumber;
  }

  public Byte getSystemId() {
    return systemId;
  }

  public void setSystemId(Byte systemId) {
    this.systemId = systemId;
  }

  public String getDataRemark() {
    return dataRemark;
  }

  public void setDataRemark(String dataRemark) {
    this.dataRemark = dataRemark == null ? null : dataRemark.trim();
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getVersionRemark() {
    return versionRemark;
  }

  public void setVersionRemark(String versionRemark) {
    this.versionRemark = versionRemark == null ? null : versionRemark.trim();
  }

  public Date getVno() {
    return vno;
  }

  public void setVno(Date vno) {
    this.vno = vno;
  }

  public Byte getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(Byte isEnabled) {
    this.isEnabled = isEnabled;
  }
}
