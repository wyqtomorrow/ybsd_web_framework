package com.gqcp.member.mcontroller.res;

import java.util.Date;

/**
 * @author wyq
 * @ClassName: MemberResForm
 * @Description: 存储到redis缓存中(这里用一句话描述这个类的作用)
 * @date 2016/12/7 15:57
 */
public class MemberResForm {
  private Long boId;

  private Long operatorBoId;

  private String userType;

  private String orgBoId;

  private String userName;

  private String realName;

  private String mobilePhone;

  private String email;

  private String companyName;

  private String headIcon;

  private Integer areaId;

  private String areaAxis;

  private String addr;

  private String memberRole;

  private Byte agreeContract;

  private Byte isCa;

  private String authSign;

  private Byte isCredit;

  private String auditStatus;

  private Date auditTime;

  private Long auditBoId;

  private Byte systemId;

  private String dataRemark;

  private Date createTime;

  private String versionRemark;

  private Date vno;

  private Byte isEnabled;

  // token
  private String token;

  private Date upTokenTime;

  public Date getUpTokenTime() {
    return upTokenTime;
  }

  public void setUpTokenTime(Date upTokenTime) {
    this.upTokenTime = upTokenTime;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Long getBoId() {
    return boId;
  }

  public void setBoId(Long boId) {
    this.boId = boId;
  }

  public Long getOperatorBoId() {
    return operatorBoId;
  }

  public void setOperatorBoId(Long operatorBoId) {
    this.operatorBoId = operatorBoId;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getOrgBoId() {
    return orgBoId;
  }

  public void setOrgBoId(String orgBoId) {
    this.orgBoId = orgBoId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getHeadIcon() {
    return headIcon;
  }

  public void setHeadIcon(String headIcon) {
    this.headIcon = headIcon;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public String getAreaAxis() {
    return areaAxis;
  }

  public void setAreaAxis(String areaAxis) {
    this.areaAxis = areaAxis;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getMemberRole() {
    return memberRole;
  }

  public void setMemberRole(String memberRole) {
    this.memberRole = memberRole;
  }

  public Byte getAgreeContract() {
    return agreeContract;
  }

  public void setAgreeContract(Byte agreeContract) {
    this.agreeContract = agreeContract;
  }

  public Byte getIsCa() {
    return isCa;
  }

  public void setIsCa(Byte isCa) {
    this.isCa = isCa;
  }

  public String getAuthSign() {
    return authSign;
  }

  public void setAuthSign(String authSign) {
    this.authSign = authSign;
  }

  public Byte getIsCredit() {
    return isCredit;
  }

  public void setIsCredit(Byte isCredit) {
    this.isCredit = isCredit;
  }

  public String getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(String auditStatus) {
    this.auditStatus = auditStatus;
  }

  public Date getAuditTime() {
    return auditTime;
  }

  public void setAuditTime(Date auditTime) {
    this.auditTime = auditTime;
  }

  public Long getAuditBoId() {
    return auditBoId;
  }

  public void setAuditBoId(Long auditBoId) {
    this.auditBoId = auditBoId;
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
    this.dataRemark = dataRemark;
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
    this.versionRemark = versionRemark;
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
