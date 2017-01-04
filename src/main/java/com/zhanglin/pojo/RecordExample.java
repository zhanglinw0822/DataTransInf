package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordExample() {
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

        public Criteria andMsguidIsNull() {
            addCriterion("MSGUID is null");
            return (Criteria) this;
        }

        public Criteria andMsguidIsNotNull() {
            addCriterion("MSGUID is not null");
            return (Criteria) this;
        }

        public Criteria andMsguidEqualTo(Object value) {
            addCriterion("MSGUID =", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidNotEqualTo(Object value) {
            addCriterion("MSGUID <>", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidGreaterThan(Object value) {
            addCriterion("MSGUID >", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidGreaterThanOrEqualTo(Object value) {
            addCriterion("MSGUID >=", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidLessThan(Object value) {
            addCriterion("MSGUID <", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidLessThanOrEqualTo(Object value) {
            addCriterion("MSGUID <=", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidIn(List<Object> values) {
            addCriterion("MSGUID in", values, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidNotIn(List<Object> values) {
            addCriterion("MSGUID not in", values, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidBetween(Object value1, Object value2) {
            addCriterion("MSGUID between", value1, value2, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidNotBetween(Object value1, Object value2) {
            addCriterion("MSGUID not between", value1, value2, "msguid");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Object value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Object value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Object value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Object value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Object value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Object value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Object> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Object> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Object value1, Object value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Object value1, Object value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andOrdertimeIsNull() {
            addCriterion("ORDERTIME is null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNotNull() {
            addCriterion("ORDERTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeEqualTo(String value) {
            addCriterion("ORDERTIME =", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotEqualTo(String value) {
            addCriterion("ORDERTIME <>", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThan(String value) {
            addCriterion("ORDERTIME >", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERTIME >=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThan(String value) {
            addCriterion("ORDERTIME <", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThanOrEqualTo(String value) {
            addCriterion("ORDERTIME <=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLike(String value) {
            addCriterion("ORDERTIME like", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotLike(String value) {
            addCriterion("ORDERTIME not like", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIn(List<String> values) {
            addCriterion("ORDERTIME in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotIn(List<String> values) {
            addCriterion("ORDERTIME not in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeBetween(String value1, String value2) {
            addCriterion("ORDERTIME between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotBetween(String value1, String value2) {
            addCriterion("ORDERTIME not between", value1, value2, "ordertime");
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

        public Criteria andTradetypeIsNull() {
            addCriterion("TRADETYPE is null");
            return (Criteria) this;
        }

        public Criteria andTradetypeIsNotNull() {
            addCriterion("TRADETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTradetypeEqualTo(BigDecimal value) {
            addCriterion("TRADETYPE =", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotEqualTo(BigDecimal value) {
            addCriterion("TRADETYPE <>", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeGreaterThan(BigDecimal value) {
            addCriterion("TRADETYPE >", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADETYPE >=", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLessThan(BigDecimal value) {
            addCriterion("TRADETYPE <", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRADETYPE <=", value, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeIn(List<BigDecimal> values) {
            addCriterion("TRADETYPE in", values, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotIn(List<BigDecimal> values) {
            addCriterion("TRADETYPE not in", values, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADETYPE between", value1, value2, "tradetype");
            return (Criteria) this;
        }

        public Criteria andTradetypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRADETYPE not between", value1, value2, "tradetype");
            return (Criteria) this;
        }

        public Criteria andRealtimeIsNull() {
            addCriterion("REALTIME is null");
            return (Criteria) this;
        }

        public Criteria andRealtimeIsNotNull() {
            addCriterion("REALTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRealtimeEqualTo(String value) {
            addCriterion("REALTIME =", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotEqualTo(String value) {
            addCriterion("REALTIME <>", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeGreaterThan(String value) {
            addCriterion("REALTIME >", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeGreaterThanOrEqualTo(String value) {
            addCriterion("REALTIME >=", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeLessThan(String value) {
            addCriterion("REALTIME <", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeLessThanOrEqualTo(String value) {
            addCriterion("REALTIME <=", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeLike(String value) {
            addCriterion("REALTIME like", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotLike(String value) {
            addCriterion("REALTIME not like", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeIn(List<String> values) {
            addCriterion("REALTIME in", values, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotIn(List<String> values) {
            addCriterion("REALTIME not in", values, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeBetween(String value1, String value2) {
            addCriterion("REALTIME between", value1, value2, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotBetween(String value1, String value2) {
            addCriterion("REALTIME not between", value1, value2, "realtime");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(BigDecimal value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(BigDecimal value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(BigDecimal value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(BigDecimal value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<BigDecimal> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<BigDecimal> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NUM not between", value1, value2, "num");
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