package com.gqcp.member.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberTagExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIsNull() {
            addCriterion("member_role is null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIsNotNull() {
            addCriterion("member_role is not null");
            return (Criteria) this;
        }

        public Criteria andMemberRoleEqualTo(String value) {
            addCriterion("member_role =", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotEqualTo(String value) {
            addCriterion("member_role <>", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleGreaterThan(String value) {
            addCriterion("member_role >", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleGreaterThanOrEqualTo(String value) {
            addCriterion("member_role >=", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleLessThan(String value) {
            addCriterion("member_role <", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleLessThanOrEqualTo(String value) {
            addCriterion("member_role <=", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleLike(String value) {
            addCriterion("member_role like", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotLike(String value) {
            addCriterion("member_role not like", value, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleIn(List<String> values) {
            addCriterion("member_role in", values, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotIn(List<String> values) {
            addCriterion("member_role not in", values, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleBetween(String value1, String value2) {
            addCriterion("member_role between", value1, value2, "memberRole");
            return (Criteria) this;
        }

        public Criteria andMemberRoleNotBetween(String value1, String value2) {
            addCriterion("member_role not between", value1, value2, "memberRole");
            return (Criteria) this;
        }

        public Criteria andTagsCodeIsNull() {
            addCriterion("tags_code is null");
            return (Criteria) this;
        }

        public Criteria andTagsCodeIsNotNull() {
            addCriterion("tags_code is not null");
            return (Criteria) this;
        }

        public Criteria andTagsCodeEqualTo(String value) {
            addCriterion("tags_code =", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeNotEqualTo(String value) {
            addCriterion("tags_code <>", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeGreaterThan(String value) {
            addCriterion("tags_code >", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tags_code >=", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeLessThan(String value) {
            addCriterion("tags_code <", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeLessThanOrEqualTo(String value) {
            addCriterion("tags_code <=", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeLike(String value) {
            addCriterion("tags_code like", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeNotLike(String value) {
            addCriterion("tags_code not like", value, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeIn(List<String> values) {
            addCriterion("tags_code in", values, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeNotIn(List<String> values) {
            addCriterion("tags_code not in", values, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeBetween(String value1, String value2) {
            addCriterion("tags_code between", value1, value2, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsCodeNotBetween(String value1, String value2) {
            addCriterion("tags_code not between", value1, value2, "tagsCode");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
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