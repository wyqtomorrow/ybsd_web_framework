package com.gqcp.area.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaExample() {
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

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeIsNull() {
            addCriterion("area_full_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeIsNotNull() {
            addCriterion("area_full_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeEqualTo(String value) {
            addCriterion("area_full_code =", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeNotEqualTo(String value) {
            addCriterion("area_full_code <>", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeGreaterThan(String value) {
            addCriterion("area_full_code >", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_full_code >=", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeLessThan(String value) {
            addCriterion("area_full_code <", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeLessThanOrEqualTo(String value) {
            addCriterion("area_full_code <=", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeLike(String value) {
            addCriterion("area_full_code like", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeNotLike(String value) {
            addCriterion("area_full_code not like", value, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeIn(List<String> values) {
            addCriterion("area_full_code in", values, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeNotIn(List<String> values) {
            addCriterion("area_full_code not in", values, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeBetween(String value1, String value2) {
            addCriterion("area_full_code between", value1, value2, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullCodeNotBetween(String value1, String value2) {
            addCriterion("area_full_code not between", value1, value2, "areaFullCode");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameIsNull() {
            addCriterion("area_full_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameIsNotNull() {
            addCriterion("area_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameEqualTo(String value) {
            addCriterion("area_full_name =", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameNotEqualTo(String value) {
            addCriterion("area_full_name <>", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameGreaterThan(String value) {
            addCriterion("area_full_name >", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_full_name >=", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameLessThan(String value) {
            addCriterion("area_full_name <", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameLessThanOrEqualTo(String value) {
            addCriterion("area_full_name <=", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameLike(String value) {
            addCriterion("area_full_name like", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameNotLike(String value) {
            addCriterion("area_full_name not like", value, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameIn(List<String> values) {
            addCriterion("area_full_name in", values, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameNotIn(List<String> values) {
            addCriterion("area_full_name not in", values, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameBetween(String value1, String value2) {
            addCriterion("area_full_name between", value1, value2, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andAreaFullNameNotBetween(String value1, String value2) {
            addCriterion("area_full_name not between", value1, value2, "areaFullName");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andOrderIsNull() {
            addCriterion("order is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsNotNull() {
            addCriterion("order is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEqualTo(Integer value) {
            addCriterion("order =", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotEqualTo(Integer value) {
            addCriterion("order <>", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThan(Integer value) {
            addCriterion("order >", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("order >=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThan(Integer value) {
            addCriterion("order <", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderLessThanOrEqualTo(Integer value) {
            addCriterion("order <=", value, "order");
            return (Criteria) this;
        }

        public Criteria andOrderIn(List<Integer> values) {
            addCriterion("order in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotIn(List<Integer> values) {
            addCriterion("order not in", values, "order");
            return (Criteria) this;
        }

        public Criteria andOrderBetween(Integer value1, Integer value2) {
            addCriterion("order between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("order not between", value1, value2, "order");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellIsNull() {
            addCriterion("area_name_spell is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellIsNotNull() {
            addCriterion("area_name_spell is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellEqualTo(String value) {
            addCriterion("area_name_spell =", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellNotEqualTo(String value) {
            addCriterion("area_name_spell <>", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellGreaterThan(String value) {
            addCriterion("area_name_spell >", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellGreaterThanOrEqualTo(String value) {
            addCriterion("area_name_spell >=", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellLessThan(String value) {
            addCriterion("area_name_spell <", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellLessThanOrEqualTo(String value) {
            addCriterion("area_name_spell <=", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellLike(String value) {
            addCriterion("area_name_spell like", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellNotLike(String value) {
            addCriterion("area_name_spell not like", value, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellIn(List<String> values) {
            addCriterion("area_name_spell in", values, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellNotIn(List<String> values) {
            addCriterion("area_name_spell not in", values, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellBetween(String value1, String value2) {
            addCriterion("area_name_spell between", value1, value2, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameSpellNotBetween(String value1, String value2) {
            addCriterion("area_name_spell not between", value1, value2, "areaNameSpell");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymIsNull() {
            addCriterion("area_name_acronym is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymIsNotNull() {
            addCriterion("area_name_acronym is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymEqualTo(String value) {
            addCriterion("area_name_acronym =", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymNotEqualTo(String value) {
            addCriterion("area_name_acronym <>", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymGreaterThan(String value) {
            addCriterion("area_name_acronym >", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymGreaterThanOrEqualTo(String value) {
            addCriterion("area_name_acronym >=", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymLessThan(String value) {
            addCriterion("area_name_acronym <", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymLessThanOrEqualTo(String value) {
            addCriterion("area_name_acronym <=", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymLike(String value) {
            addCriterion("area_name_acronym like", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymNotLike(String value) {
            addCriterion("area_name_acronym not like", value, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymIn(List<String> values) {
            addCriterion("area_name_acronym in", values, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymNotIn(List<String> values) {
            addCriterion("area_name_acronym not in", values, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymBetween(String value1, String value2) {
            addCriterion("area_name_acronym between", value1, value2, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andAreaNameAcronymNotBetween(String value1, String value2) {
            addCriterion("area_name_acronym not between", value1, value2, "areaNameAcronym");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIsNull() {
            addCriterion("tel_area_code is null");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIsNotNull() {
            addCriterion("tel_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeEqualTo(String value) {
            addCriterion("tel_area_code =", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotEqualTo(String value) {
            addCriterion("tel_area_code <>", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeGreaterThan(String value) {
            addCriterion("tel_area_code >", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tel_area_code >=", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLessThan(String value) {
            addCriterion("tel_area_code <", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("tel_area_code <=", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLike(String value) {
            addCriterion("tel_area_code like", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotLike(String value) {
            addCriterion("tel_area_code not like", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIn(List<String> values) {
            addCriterion("tel_area_code in", values, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotIn(List<String> values) {
            addCriterion("tel_area_code not in", values, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeBetween(String value1, String value2) {
            addCriterion("tel_area_code between", value1, value2, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotBetween(String value1, String value2) {
            addCriterion("tel_area_code not between", value1, value2, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andAxisIsNull() {
            addCriterion("axis is null");
            return (Criteria) this;
        }

        public Criteria andAxisIsNotNull() {
            addCriterion("axis is not null");
            return (Criteria) this;
        }

        public Criteria andAxisEqualTo(String value) {
            addCriterion("axis =", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisNotEqualTo(String value) {
            addCriterion("axis <>", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisGreaterThan(String value) {
            addCriterion("axis >", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisGreaterThanOrEqualTo(String value) {
            addCriterion("axis >=", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisLessThan(String value) {
            addCriterion("axis <", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisLessThanOrEqualTo(String value) {
            addCriterion("axis <=", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisLike(String value) {
            addCriterion("axis like", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisNotLike(String value) {
            addCriterion("axis not like", value, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisIn(List<String> values) {
            addCriterion("axis in", values, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisNotIn(List<String> values) {
            addCriterion("axis not in", values, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisBetween(String value1, String value2) {
            addCriterion("axis between", value1, value2, "axis");
            return (Criteria) this;
        }

        public Criteria andAxisNotBetween(String value1, String value2) {
            addCriterion("axis not between", value1, value2, "axis");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andIsEndIsNull() {
            addCriterion("is_end is null");
            return (Criteria) this;
        }

        public Criteria andIsEndIsNotNull() {
            addCriterion("is_end is not null");
            return (Criteria) this;
        }

        public Criteria andIsEndEqualTo(Byte value) {
            addCriterion("is_end =", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotEqualTo(Byte value) {
            addCriterion("is_end <>", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndGreaterThan(Byte value) {
            addCriterion("is_end >", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_end >=", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndLessThan(Byte value) {
            addCriterion("is_end <", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndLessThanOrEqualTo(Byte value) {
            addCriterion("is_end <=", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndIn(List<Byte> values) {
            addCriterion("is_end in", values, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotIn(List<Byte> values) {
            addCriterion("is_end not in", values, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndBetween(Byte value1, Byte value2) {
            addCriterion("is_end between", value1, value2, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotBetween(Byte value1, Byte value2) {
            addCriterion("is_end not between", value1, value2, "isEnd");
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

        public Criteria andEffectiveStartDateIsNull() {
            addCriterion("effective_start_date is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateIsNotNull() {
            addCriterion("effective_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateEqualTo(Date value) {
            addCriterion("effective_start_date =", value, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateNotEqualTo(Date value) {
            addCriterion("effective_start_date <>", value, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateGreaterThan(Date value) {
            addCriterion("effective_start_date >", value, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_start_date >=", value, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateLessThan(Date value) {
            addCriterion("effective_start_date <", value, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateLessThanOrEqualTo(Date value) {
            addCriterion("effective_start_date <=", value, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateIn(List<Date> values) {
            addCriterion("effective_start_date in", values, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateNotIn(List<Date> values) {
            addCriterion("effective_start_date not in", values, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateBetween(Date value1, Date value2) {
            addCriterion("effective_start_date between", value1, value2, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartDateNotBetween(Date value1, Date value2) {
            addCriterion("effective_start_date not between", value1, value2, "effectiveStartDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateIsNull() {
            addCriterion("effective_end_date is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateIsNotNull() {
            addCriterion("effective_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateEqualTo(Date value) {
            addCriterion("effective_end_date =", value, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateNotEqualTo(Date value) {
            addCriterion("effective_end_date <>", value, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateGreaterThan(Date value) {
            addCriterion("effective_end_date >", value, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_end_date >=", value, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateLessThan(Date value) {
            addCriterion("effective_end_date <", value, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateLessThanOrEqualTo(Date value) {
            addCriterion("effective_end_date <=", value, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateIn(List<Date> values) {
            addCriterion("effective_end_date in", values, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateNotIn(List<Date> values) {
            addCriterion("effective_end_date not in", values, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateBetween(Date value1, Date value2) {
            addCriterion("effective_end_date between", value1, value2, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndDateNotBetween(Date value1, Date value2) {
            addCriterion("effective_end_date not between", value1, value2, "effectiveEndDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("creation_date is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("creation_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(Date value) {
            addCriterion("creation_date =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(Date value) {
            addCriterion("creation_date <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(Date value) {
            addCriterion("creation_date >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_date >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(Date value) {
            addCriterion("creation_date <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(Date value) {
            addCriterion("creation_date <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<Date> values) {
            addCriterion("creation_date in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<Date> values) {
            addCriterion("creation_date not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(Date value1, Date value2) {
            addCriterion("creation_date between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(Date value1, Date value2) {
            addCriterion("creation_date not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNull() {
            addCriterion("last_update_date is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNotNull() {
            addCriterion("last_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateEqualTo(Date value) {
            addCriterion("last_update_date =", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotEqualTo(Date value) {
            addCriterion("last_update_date <>", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThan(Date value) {
            addCriterion("last_update_date >", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_date >=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThan(Date value) {
            addCriterion("last_update_date <", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("last_update_date <=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIn(List<Date> values) {
            addCriterion("last_update_date in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotIn(List<Date> values) {
            addCriterion("last_update_date not in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateBetween(Date value1, Date value2) {
            addCriterion("last_update_date between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("last_update_date not between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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