package com.gqcp.area.dao.model;

import java.util.Date;

public class Area {
    private Integer areaId;

    private String areaCode;

    private String areaName;

    private String areaFullCode;

    private String areaFullName;

    private Integer rank;

    private Integer parentId;

    private Integer order;

    private String areaNameSpell;

    private String areaNameAcronym;

    private String telAreaCode;

    private String axis;

    private String longitude;

    private String latitude;

    private Byte isEnd;

    private Byte isEnabled;

    private Date effectiveStartDate;

    private Date effectiveEndDate;

    private Date creationDate;

    private Date lastUpdateDate;

    private String remarks;

    private String description;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaFullCode() {
        return areaFullCode;
    }

    public void setAreaFullCode(String areaFullCode) {
        this.areaFullCode = areaFullCode == null ? null : areaFullCode.trim();
    }

    public String getAreaFullName() {
        return areaFullName;
    }

    public void setAreaFullName(String areaFullName) {
        this.areaFullName = areaFullName == null ? null : areaFullName.trim();
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getAreaNameSpell() {
        return areaNameSpell;
    }

    public void setAreaNameSpell(String areaNameSpell) {
        this.areaNameSpell = areaNameSpell == null ? null : areaNameSpell.trim();
    }

    public String getAreaNameAcronym() {
        return areaNameAcronym;
    }

    public void setAreaNameAcronym(String areaNameAcronym) {
        this.areaNameAcronym = areaNameAcronym == null ? null : areaNameAcronym.trim();
    }

    public String getTelAreaCode() {
        return telAreaCode;
    }

    public void setTelAreaCode(String telAreaCode) {
        this.telAreaCode = telAreaCode == null ? null : telAreaCode.trim();
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis == null ? null : axis.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Byte getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Byte isEnd) {
        this.isEnd = isEnd;
    }

    public Byte getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Byte isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}