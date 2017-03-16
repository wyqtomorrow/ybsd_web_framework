package com.gqcp.member.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andOperatorBoIdIsNull() {
            addCriterion("operator_bo_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdIsNotNull() {
            addCriterion("operator_bo_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdEqualTo(Long value) {
            addCriterion("operator_bo_id =", value, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdNotEqualTo(Long value) {
            addCriterion("operator_bo_id <>", value, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdGreaterThan(Long value) {
            addCriterion("operator_bo_id >", value, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("operator_bo_id >=", value, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdLessThan(Long value) {
            addCriterion("operator_bo_id <", value, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdLessThanOrEqualTo(Long value) {
            addCriterion("operator_bo_id <=", value, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdIn(List<Long> values) {
            addCriterion("operator_bo_id in", values, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdNotIn(List<Long> values) {
            addCriterion("operator_bo_id not in", values, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdBetween(Long value1, Long value2) {
            addCriterion("operator_bo_id between", value1, value2, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andOperatorBoIdNotBetween(Long value1, Long value2) {
            addCriterion("operator_bo_id not between", value1, value2, "operatorBoId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdIsNull() {
            addCriterion("org_bo_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdIsNotNull() {
            addCriterion("org_bo_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdEqualTo(String value) {
            addCriterion("org_bo_id =", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdNotEqualTo(String value) {
            addCriterion("org_bo_id <>", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdGreaterThan(String value) {
            addCriterion("org_bo_id >", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_bo_id >=", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdLessThan(String value) {
            addCriterion("org_bo_id <", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdLessThanOrEqualTo(String value) {
            addCriterion("org_bo_id <=", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdLike(String value) {
            addCriterion("org_bo_id like", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdNotLike(String value) {
            addCriterion("org_bo_id not like", value, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdIn(List<String> values) {
            addCriterion("org_bo_id in", values, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdNotIn(List<String> values) {
            addCriterion("org_bo_id not in", values, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdBetween(String value1, String value2) {
            addCriterion("org_bo_id between", value1, value2, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andOrgBoIdNotBetween(String value1, String value2) {
            addCriterion("org_bo_id not between", value1, value2, "orgBoId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andHeadIconIsNull() {
            addCriterion("head_icon is null");
            return (Criteria) this;
        }

        public Criteria andHeadIconIsNotNull() {
            addCriterion("head_icon is not null");
            return (Criteria) this;
        }

        public Criteria andHeadIconEqualTo(String value) {
            addCriterion("head_icon =", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotEqualTo(String value) {
            addCriterion("head_icon <>", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThan(String value) {
            addCriterion("head_icon >", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThanOrEqualTo(String value) {
            addCriterion("head_icon >=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThan(String value) {
            addCriterion("head_icon <", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThanOrEqualTo(String value) {
            addCriterion("head_icon <=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLike(String value) {
            addCriterion("head_icon like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotLike(String value) {
            addCriterion("head_icon not like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconIn(List<String> values) {
            addCriterion("head_icon in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotIn(List<String> values) {
            addCriterion("head_icon not in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconBetween(String value1, String value2) {
            addCriterion("head_icon between", value1, value2, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotBetween(String value1, String value2) {
            addCriterion("head_icon not between", value1, value2, "headIcon");
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

        public Criteria andAgreeContractIsNull() {
            addCriterion("agree_contract is null");
            return (Criteria) this;
        }

        public Criteria andAgreeContractIsNotNull() {
            addCriterion("agree_contract is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeContractEqualTo(Byte value) {
            addCriterion("agree_contract =", value, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractNotEqualTo(Byte value) {
            addCriterion("agree_contract <>", value, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractGreaterThan(Byte value) {
            addCriterion("agree_contract >", value, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractGreaterThanOrEqualTo(Byte value) {
            addCriterion("agree_contract >=", value, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractLessThan(Byte value) {
            addCriterion("agree_contract <", value, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractLessThanOrEqualTo(Byte value) {
            addCriterion("agree_contract <=", value, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractIn(List<Byte> values) {
            addCriterion("agree_contract in", values, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractNotIn(List<Byte> values) {
            addCriterion("agree_contract not in", values, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractBetween(Byte value1, Byte value2) {
            addCriterion("agree_contract between", value1, value2, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andAgreeContractNotBetween(Byte value1, Byte value2) {
            addCriterion("agree_contract not between", value1, value2, "agreeContract");
            return (Criteria) this;
        }

        public Criteria andIsCaIsNull() {
            addCriterion("is_ca is null");
            return (Criteria) this;
        }

        public Criteria andIsCaIsNotNull() {
            addCriterion("is_ca is not null");
            return (Criteria) this;
        }

        public Criteria andIsCaEqualTo(Byte value) {
            addCriterion("is_ca =", value, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaNotEqualTo(Byte value) {
            addCriterion("is_ca <>", value, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaGreaterThan(Byte value) {
            addCriterion("is_ca >", value, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_ca >=", value, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaLessThan(Byte value) {
            addCriterion("is_ca <", value, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaLessThanOrEqualTo(Byte value) {
            addCriterion("is_ca <=", value, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaIn(List<Byte> values) {
            addCriterion("is_ca in", values, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaNotIn(List<Byte> values) {
            addCriterion("is_ca not in", values, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaBetween(Byte value1, Byte value2) {
            addCriterion("is_ca between", value1, value2, "isCa");
            return (Criteria) this;
        }

        public Criteria andIsCaNotBetween(Byte value1, Byte value2) {
            addCriterion("is_ca not between", value1, value2, "isCa");
            return (Criteria) this;
        }

        public Criteria andAuthSignIsNull() {
            addCriterion("auth_sign is null");
            return (Criteria) this;
        }

        public Criteria andAuthSignIsNotNull() {
            addCriterion("auth_sign is not null");
            return (Criteria) this;
        }

        public Criteria andAuthSignEqualTo(String value) {
            addCriterion("auth_sign =", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotEqualTo(String value) {
            addCriterion("auth_sign <>", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignGreaterThan(String value) {
            addCriterion("auth_sign >", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignGreaterThanOrEqualTo(String value) {
            addCriterion("auth_sign >=", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignLessThan(String value) {
            addCriterion("auth_sign <", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignLessThanOrEqualTo(String value) {
            addCriterion("auth_sign <=", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignLike(String value) {
            addCriterion("auth_sign like", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotLike(String value) {
            addCriterion("auth_sign not like", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignIn(List<String> values) {
            addCriterion("auth_sign in", values, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotIn(List<String> values) {
            addCriterion("auth_sign not in", values, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignBetween(String value1, String value2) {
            addCriterion("auth_sign between", value1, value2, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotBetween(String value1, String value2) {
            addCriterion("auth_sign not between", value1, value2, "authSign");
            return (Criteria) this;
        }

        public Criteria andIsCreditIsNull() {
            addCriterion("is_credit is null");
            return (Criteria) this;
        }

        public Criteria andIsCreditIsNotNull() {
            addCriterion("is_credit is not null");
            return (Criteria) this;
        }

        public Criteria andIsCreditEqualTo(Byte value) {
            addCriterion("is_credit =", value, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditNotEqualTo(Byte value) {
            addCriterion("is_credit <>", value, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditGreaterThan(Byte value) {
            addCriterion("is_credit >", value, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_credit >=", value, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditLessThan(Byte value) {
            addCriterion("is_credit <", value, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditLessThanOrEqualTo(Byte value) {
            addCriterion("is_credit <=", value, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditIn(List<Byte> values) {
            addCriterion("is_credit in", values, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditNotIn(List<Byte> values) {
            addCriterion("is_credit not in", values, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditBetween(Byte value1, Byte value2) {
            addCriterion("is_credit between", value1, value2, "isCredit");
            return (Criteria) this;
        }

        public Criteria andIsCreditNotBetween(Byte value1, Byte value2) {
            addCriterion("is_credit not between", value1, value2, "isCredit");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdIsNull() {
            addCriterion("audit_bo_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdIsNotNull() {
            addCriterion("audit_bo_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdEqualTo(Long value) {
            addCriterion("audit_bo_id =", value, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdNotEqualTo(Long value) {
            addCriterion("audit_bo_id <>", value, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdGreaterThan(Long value) {
            addCriterion("audit_bo_id >", value, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_bo_id >=", value, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdLessThan(Long value) {
            addCriterion("audit_bo_id <", value, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdLessThanOrEqualTo(Long value) {
            addCriterion("audit_bo_id <=", value, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdIn(List<Long> values) {
            addCriterion("audit_bo_id in", values, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdNotIn(List<Long> values) {
            addCriterion("audit_bo_id not in", values, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdBetween(Long value1, Long value2) {
            addCriterion("audit_bo_id between", value1, value2, "auditBoId");
            return (Criteria) this;
        }

        public Criteria andAuditBoIdNotBetween(Long value1, Long value2) {
            addCriterion("audit_bo_id not between", value1, value2, "auditBoId");
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