package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InitHoldingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InitHoldingExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCurdateIsNull() {
            addCriterion("CURDATE is null");
            return (Criteria) this;
        }

        public Criteria andCurdateIsNotNull() {
            addCriterion("CURDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCurdateEqualTo(String value) {
            addCriterion("CURDATE =", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateNotEqualTo(String value) {
            addCriterion("CURDATE <>", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateGreaterThan(String value) {
            addCriterion("CURDATE >", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateGreaterThanOrEqualTo(String value) {
            addCriterion("CURDATE >=", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateLessThan(String value) {
            addCriterion("CURDATE <", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateLessThanOrEqualTo(String value) {
            addCriterion("CURDATE <=", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateLike(String value) {
            addCriterion("CURDATE like", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateNotLike(String value) {
            addCriterion("CURDATE not like", value, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateIn(List<String> values) {
            addCriterion("CURDATE in", values, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateNotIn(List<String> values) {
            addCriterion("CURDATE not in", values, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateBetween(String value1, String value2) {
            addCriterion("CURDATE between", value1, value2, "curdate");
            return (Criteria) this;
        }

        public Criteria andCurdateNotBetween(String value1, String value2) {
            addCriterion("CURDATE not between", value1, value2, "curdate");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andNetIsNull() {
            addCriterion("NET is null");
            return (Criteria) this;
        }

        public Criteria andNetIsNotNull() {
            addCriterion("NET is not null");
            return (Criteria) this;
        }

        public Criteria andNetEqualTo(BigDecimal value) {
            addCriterion("NET =", value, "net");
            return (Criteria) this;
        }

        public Criteria andNetNotEqualTo(BigDecimal value) {
            addCriterion("NET <>", value, "net");
            return (Criteria) this;
        }

        public Criteria andNetGreaterThan(BigDecimal value) {
            addCriterion("NET >", value, "net");
            return (Criteria) this;
        }

        public Criteria andNetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NET >=", value, "net");
            return (Criteria) this;
        }

        public Criteria andNetLessThan(BigDecimal value) {
            addCriterion("NET <", value, "net");
            return (Criteria) this;
        }

        public Criteria andNetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NET <=", value, "net");
            return (Criteria) this;
        }

        public Criteria andNetIn(List<BigDecimal> values) {
            addCriterion("NET in", values, "net");
            return (Criteria) this;
        }

        public Criteria andNetNotIn(List<BigDecimal> values) {
            addCriterion("NET not in", values, "net");
            return (Criteria) this;
        }

        public Criteria andNetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET between", value1, value2, "net");
            return (Criteria) this;
        }

        public Criteria andNetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET not between", value1, value2, "net");
            return (Criteria) this;
        }

        public Criteria andNewidIsNull() {
            addCriterion("NEWID is null");
            return (Criteria) this;
        }

        public Criteria andNewidIsNotNull() {
            addCriterion("NEWID is not null");
            return (Criteria) this;
        }

        public Criteria andNewidEqualTo(BigDecimal value) {
            addCriterion("NEWID =", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidNotEqualTo(BigDecimal value) {
            addCriterion("NEWID <>", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidGreaterThan(BigDecimal value) {
            addCriterion("NEWID >", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NEWID >=", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidLessThan(BigDecimal value) {
            addCriterion("NEWID <", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NEWID <=", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidIn(List<BigDecimal> values) {
            addCriterion("NEWID in", values, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidNotIn(List<BigDecimal> values) {
            addCriterion("NEWID not in", values, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEWID between", value1, value2, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEWID not between", value1, value2, "newid");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("VOLUME is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("VOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(BigDecimal value) {
            addCriterion("VOLUME =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(BigDecimal value) {
            addCriterion("VOLUME <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(BigDecimal value) {
            addCriterion("VOLUME >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VOLUME >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(BigDecimal value) {
            addCriterion("VOLUME <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VOLUME <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<BigDecimal> values) {
            addCriterion("VOLUME in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<BigDecimal> values) {
            addCriterion("VOLUME not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VOLUME between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VOLUME not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andClosepriceIsNull() {
            addCriterion("CLOSEPRICE is null");
            return (Criteria) this;
        }

        public Criteria andClosepriceIsNotNull() {
            addCriterion("CLOSEPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andClosepriceEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE =", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE <>", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceGreaterThan(BigDecimal value) {
            addCriterion("CLOSEPRICE >", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE >=", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceLessThan(BigDecimal value) {
            addCriterion("CLOSEPRICE <", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE <=", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceIn(List<BigDecimal> values) {
            addCriterion("CLOSEPRICE in", values, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotIn(List<BigDecimal> values) {
            addCriterion("CLOSEPRICE not in", values, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLOSEPRICE between", value1, value2, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLOSEPRICE not between", value1, value2, "closeprice");
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