package com.fit2cloud.cache.domain;

import java.util.ArrayList;
import java.util.List;

public class CacheFlavorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CacheFlavorExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkspaceIsNull() {
            addCriterion("workspace is null");
            return (Criteria) this;
        }

        public Criteria andWorkspaceIsNotNull() {
            addCriterion("workspace is not null");
            return (Criteria) this;
        }

        public Criteria andWorkspaceEqualTo(String value) {
            addCriterion("workspace =", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceNotEqualTo(String value) {
            addCriterion("workspace <>", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceGreaterThan(String value) {
            addCriterion("workspace >", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceGreaterThanOrEqualTo(String value) {
            addCriterion("workspace >=", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceLessThan(String value) {
            addCriterion("workspace <", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceLessThanOrEqualTo(String value) {
            addCriterion("workspace <=", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceLike(String value) {
            addCriterion("workspace like", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceNotLike(String value) {
            addCriterion("workspace not like", value, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceIn(List<String> values) {
            addCriterion("workspace in", values, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceNotIn(List<String> values) {
            addCriterion("workspace not in", values, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceBetween(String value1, String value2) {
            addCriterion("workspace between", value1, value2, "workspace");
            return (Criteria) this;
        }

        public Criteria andWorkspaceNotBetween(String value1, String value2) {
            addCriterion("workspace not between", value1, value2, "workspace");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeIsNull() {
            addCriterion("instance_type is null");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeIsNotNull() {
            addCriterion("instance_type is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeEqualTo(String value) {
            addCriterion("instance_type =", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeNotEqualTo(String value) {
            addCriterion("instance_type <>", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeGreaterThan(String value) {
            addCriterion("instance_type >", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("instance_type >=", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeLessThan(String value) {
            addCriterion("instance_type <", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeLessThanOrEqualTo(String value) {
            addCriterion("instance_type <=", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeLike(String value) {
            addCriterion("instance_type like", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeNotLike(String value) {
            addCriterion("instance_type not like", value, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeIn(List<String> values) {
            addCriterion("instance_type in", values, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeNotIn(List<String> values) {
            addCriterion("instance_type not in", values, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeBetween(String value1, String value2) {
            addCriterion("instance_type between", value1, value2, "instanceType");
            return (Criteria) this;
        }

        public Criteria andInstanceTypeNotBetween(String value1, String value2) {
            addCriterion("instance_type not between", value1, value2, "instanceType");
            return (Criteria) this;
        }

        public Criteria andEngineIsNull() {
            addCriterion("engine is null");
            return (Criteria) this;
        }

        public Criteria andEngineIsNotNull() {
            addCriterion("engine is not null");
            return (Criteria) this;
        }

        public Criteria andEngineEqualTo(String value) {
            addCriterion("engine =", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotEqualTo(String value) {
            addCriterion("engine <>", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThan(String value) {
            addCriterion("engine >", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThanOrEqualTo(String value) {
            addCriterion("engine >=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThan(String value) {
            addCriterion("engine <", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThanOrEqualTo(String value) {
            addCriterion("engine <=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLike(String value) {
            addCriterion("engine like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotLike(String value) {
            addCriterion("engine not like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineIn(List<String> values) {
            addCriterion("engine in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotIn(List<String> values) {
            addCriterion("engine not in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineBetween(String value1, String value2) {
            addCriterion("engine between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotBetween(String value1, String value2) {
            addCriterion("engine not between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineVersionIsNull() {
            addCriterion("engine_version is null");
            return (Criteria) this;
        }

        public Criteria andEngineVersionIsNotNull() {
            addCriterion("engine_version is not null");
            return (Criteria) this;
        }

        public Criteria andEngineVersionEqualTo(String value) {
            addCriterion("engine_version =", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotEqualTo(String value) {
            addCriterion("engine_version <>", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionGreaterThan(String value) {
            addCriterion("engine_version >", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionGreaterThanOrEqualTo(String value) {
            addCriterion("engine_version >=", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionLessThan(String value) {
            addCriterion("engine_version <", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionLessThanOrEqualTo(String value) {
            addCriterion("engine_version <=", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionLike(String value) {
            addCriterion("engine_version like", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotLike(String value) {
            addCriterion("engine_version not like", value, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionIn(List<String> values) {
            addCriterion("engine_version in", values, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotIn(List<String> values) {
            addCriterion("engine_version not in", values, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionBetween(String value1, String value2) {
            addCriterion("engine_version between", value1, value2, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andEngineVersionNotBetween(String value1, String value2) {
            addCriterion("engine_version not between", value1, value2, "engineVersion");
            return (Criteria) this;
        }

        public Criteria andSqlCriterion(String value) {
            addCriterion("(" + value + ")");
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