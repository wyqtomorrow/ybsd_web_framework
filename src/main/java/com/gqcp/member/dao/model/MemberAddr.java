package com.gqcp.member.dao.model;

import java.util.Date;

public class MemberAddr {
    private Long id;

    private Long boId;

    private String name;

    private String tel;

    private Integer areaId;

    private String areaAxis;

    private String areaDisplayName;

    private String addr;

    private Byte isDefault;

    private String type;

    private Byte systemId;

    private String dataRemark;

    private Date createTime;

    private String versionRemark;

    private Date vno;

    private Byte isEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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
        this.areaAxis = areaAxis == null ? null : areaAxis.trim();
    }

    public String getAreaDisplayName() {
        return areaDisplayName;
    }

    public void setAreaDisplayName(String areaDisplayName) {
        this.areaDisplayName = areaDisplayName == null ? null : areaDisplayName.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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