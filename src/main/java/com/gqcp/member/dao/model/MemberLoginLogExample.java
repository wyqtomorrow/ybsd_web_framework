package com.gqcp.member.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberLoginLogExample() {
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

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andRefUrlIsNull() {
            addCriterion("ref_url is null");
            return (Criteria) this;
        }

        public Criteria andRefUrlIsNotNull() {
            addCriterion("ref_url is not null");
            return (Criteria) this;
        }

        public Criteria andRefUrlEqualTo(String value) {
            addCriterion("ref_url =", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlNotEqualTo(String value) {
            addCriterion("ref_url <>", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlGreaterThan(String value) {
            addCriterion("ref_url >", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ref_url >=", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlLessThan(String value) {
            addCriterion("ref_url <", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlLessThanOrEqualTo(String value) {
            addCriterion("ref_url <=", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlLike(String value) {
            addCriterion("ref_url like", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlNotLike(String value) {
            addCriterion("ref_url not like", value, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlIn(List<String> values) {
            addCriterion("ref_url in", values, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlNotIn(List<String> values) {
            addCriterion("ref_url not in", values, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlBetween(String value1, String value2) {
            addCriterion("ref_url between", value1, value2, "refUrl");
            return (Criteria) this;
        }

        public Criteria andRefUrlNotBetween(String value1, String value2) {
            addCriterion("ref_url not between", value1, value2, "refUrl");
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

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Byte value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Byte value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Byte value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Byte value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Byte value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Byte> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Byte> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Byte value1, Byte value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Byte value1, Byte value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
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