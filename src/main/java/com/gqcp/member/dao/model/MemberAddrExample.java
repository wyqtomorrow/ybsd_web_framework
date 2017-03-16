package com.gqcp.member.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberAddrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberAddrExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBoIdIsNull() {
            addCriterion("bo_id is null");
            return (Criteria) this;
        }

        public Criteria andBoIdIsNotNull() {
            addCriterion("bo_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoIdEqualTo(Long value) {
            addCriterion("bo_id =", value, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdNotEqualTo(Long value) {
            addCriterion("bo_id <>", value, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdGreaterThan(Long value) {
            addCriterion("bo_id >", value, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bo_id >=", value, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdLessThan(Long value) {
            addCriterion("bo_id <", value, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdLessThanOrEqualTo(Long value) {
            addCriterion("bo_id <=", value, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdIn(List<Long> values) {
            addCriterion("bo_id in", values, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdNotIn(List<Long> values) {
            addCriterion("bo_id not in", values, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdBetween(Long value1, Long value2) {
            addCriterion("bo_id between", value1, value2, "boId");
            return (Criteria) this;
        }

        public Criteria andBoIdNotBetween(Long value1, Long value2) {
            addCriterion("bo_id not between", value1, value2, "boId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaAxisIsNull() {
            addCriterion("area_axis is null");
            return (Criteria) this;
        }

        public Criteria andAreaAxisIsNotNull() {
            addCriterion("area_axis is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAxisEqualTo(String value) {
            addCriterion("area_axis =", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisNotEqualTo(String value) {
            addCriterion("area_axis <>", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisGreaterThan(String value) {
            addCriterion("area_axis >", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisGreaterThanOrEqualTo(String value) {
            addCriterion("area_axis >=", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisLessThan(String value) {
            addCriterion("area_axis <", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisLessThanOrEqualTo(String value) {
            addCriterion("area_axis <=", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisLike(String value) {
            addCriterion("area_axis like", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisNotLike(String value) {
            addCriterion("area_axis not like", value, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisIn(List<String> values) {
            addCriterion("area_axis in", values, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisNotIn(List<String> values) {
            addCriterion("area_axis not in", values, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisBetween(String value1, String value2) {
            addCriterion("area_axis between", value1, value2, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaAxisNotBetween(String value1, String value2) {
            addCriterion("area_axis not between", value1, value2, "areaAxis");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameIsNull() {
            addCriterion("area_display_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameIsNotNull() {
            addCriterion("area_display_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameEqualTo(String value) {
            addCriterion("area_display_name =", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameNotEqualTo(String value) {
            addCriterion("area_display_name <>", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameGreaterThan(String value) {
            addCriterion("area_display_name >", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_display_name >=", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameLessThan(String value) {
            addCriterion("area_display_name <", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("area_display_name <=", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameLike(String value) {
            addCriterion("area_display_name like", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameNotLike(String value) {
            addCriterion("area_display_name not like", value, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameIn(List<String> values) {
            addCriterion("area_display_name in", values, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameNotIn(List<String> values) {
            addCriterion("area_display_name not in", values, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameBetween(String value1, String value2) {
            addCriterion("area_display_name between", value1, value2, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAreaDisplayNameNotBetween(String value1, String value2) {
            addCriterion("area_display_name not between", value1, value2, "areaDisplayName");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Byte value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Byte value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Byte value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Byte value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Byte value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Byte> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Byte> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Byte value1, Byte value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Byte value1, Byte value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(Byte value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(Byte value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(Byte value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(Byte value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(Byte value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<Byte> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<Byte> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(Byte value1, Byte value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(Byte value1, Byte value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andDataRemarkIsNull() {
            addCriterion("data_remark is null");
            return (Criteria) this;
        }

        public Criteria andDataRemarkIsNotNull() {
            addCriterion("data_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDataRemarkEqualTo(String value) {
            addCriterion("data_remark =", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkNotEqualTo(String value) {
            addCriterion("data_remark <>", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkGreaterThan(String value) {
            addCriterion("data_remark >", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("data_remark >=", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkLessThan(String value) {
            addCriterion("data_remark <", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkLessThanOrEqualTo(String value) {
            addCriterion("data_remark <=", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkLike(String value) {
            addCriterion("data_remark like", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkNotLike(String value) {
            addCriterion("data_remark not like", value, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkIn(List<String> values) {
            addCriterion("data_remark in", values, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkNotIn(List<String> values) {
            addCriterion("data_remark not in", values, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkBetween(String value1, String value2) {
            addCriterion("data_remark between", value1, value2, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andDataRemarkNotBetween(String value1, String value2) {
            addCriterion("data_remark not between", value1, value2, "dataRemark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkIsNull() {
            addCriterion("version_remark is null");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkIsNotNull() {
            addCriterion("version_remark is not null");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkEqualTo(String value) {
            addCriterion("version_remark =", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkNotEqualTo(String value) {
            addCriterion("version_remark <>", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkGreaterThan(String value) {
            addCriterion("version_remark >", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("version_remark >=", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkLessThan(String value) {
            addCriterion("version_remark <", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkLessThanOrEqualTo(String value) {
            addCriterion("version_remark <=", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkLike(String value) {
            addCriterion("version_remark like", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkNotLike(String value) {
            addCriterion("version_remark not like", value, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkIn(List<String> values) {
            addCriterion("version_remark in", values, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkNotIn(List<String> values) {
            addCriterion("version_remark not in", values, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkBetween(String value1, String value2) {
            addCriterion("version_remark between", value1, value2, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVersionRemarkNotBetween(String value1, String value2) {
            addCriterion("version_remark not between", value1, value2, "versionRemark");
            return (Criteria) this;
        }

        public Criteria andVnoIsNull() {
            addCriterion("vno is null");
            return (Criteria) this;
        }

        public Criteria andVnoIsNotNull() {
            addCriterion("vno is not null");
            return (Criteria) this;
        }

        public Criteria andVnoEqualTo(Date value) {
            addCriterion("vno =", value, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoNotEqualTo(Date value) {
            addCriterion("vno <>", value, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoGreaterThan(Date value) {
            addCriterion("vno >", value, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoGreaterThanOrEqualTo(Date value) {
            addCriterion("vno >=", value, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoLessThan(Date value) {
            addCriterion("vno <", value, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoLessThanOrEqualTo(Date value) {
            addCriterion("vno <=", value, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoIn(List<Date> values) {
            addCriterion("vno in", values, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoNotIn(List<Date> values) {
            addCriterion("vno not in", values, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoBetween(Date value1, Date value2) {
            addCriterion("vno between", value1, value2, "vno");
            return (Criteria) this;
        }

        public Criteria andVnoNotBetween(Date value1, Date value2) {
            addCriterion("vno not between", value1, value2, "vno");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Byte value) {
            addCriterion("is_enabled =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Byte value) {
            addCriterion("is_enabled <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Byte value) {
            addCriterion("is_enabled >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_enabled >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Byte value) {
            addCriterion("is_enabled <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("is_enabled <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Byte> values) {
            addCriterion("is_enabled in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Byte> values) {
            addCriterion("is_enabled not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Byte value1, Byte value2) {
            addCriterion("is_enabled between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("is_enabled not between", value1, value2, "isEnabled");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}