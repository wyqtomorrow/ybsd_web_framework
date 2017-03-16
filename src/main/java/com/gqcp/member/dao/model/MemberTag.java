package com.gqcp.member.dao.model;

import java.util.Date;

public class MemberTag {
    private Long id;

    private Long boId;

    private String type;

    private Long shopId;

    private String memberRole;

    private String tagsCode;

    private String tags;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole == null ? null : memberRole.trim();
    }

    public String getTagsCode() {
        return tagsCode;
    }

    public void setTagsCode(String tagsCode) {
        this.tagsCode = tagsCode == null ? null : tagsCode.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
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