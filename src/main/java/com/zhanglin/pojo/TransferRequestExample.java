package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferRequestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransferRequestExample() {
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

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMsguidIsNull() {
            addCriterion("MSGUID is null");
            return (Criteria) this;
        }

        public Criteria andMsguidIsNotNull() {
            addCriterion("MSGUID is not null");
            return (Criteria) this;
        }

        public Criteria andMsguidEqualTo(String value) {
            addCriterion("MSGUID =", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidNotEqualTo(String value) {
            addCriterion("MSGUID <>", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidGreaterThan(String value) {
            addCriterion("MSGUID >", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidGreaterThanOrEqualTo(String value) {
            addCriterion("MSGUID >=", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidLessThan(String value) {
            addCriterion("MSGUID <", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidLessThanOrEqualTo(String value) {
            addCriterion("MSGUID <=", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidLike(String value) {
            addCriterion("MSGUID like", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidNotLike(String value) {
            addCriterion("MSGUID not like", value, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidIn(List<String> values) {
            addCriterion("MSGUID in", values, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidNotIn(List<String> values) {
            addCriterion("MSGUID not in", values, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidBetween(String value1, String value2) {
            addCriterion("MSGUID between", value1, value2, "msguid");
            return (Criteria) this;
        }

        public Criteria andMsguidNotBetween(String value1, String value2) {
            addCriterion("MSGUID not between", value1, value2, "msguid");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("DATA is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("DATA is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("DATA =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("DATA <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("DATA >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("DATA >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("DATA <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("DATA <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("DATA like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("DATA not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("DATA in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("DATA not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("DATA between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("DATA not between", value1, value2, "data");
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

        public Criteria andDelayIsNull() {
            addCriterion("DELAY is null");
            return (Criteria) this;
        }

        public Criteria andDelayIsNotNull() {
            addCriterion("DELAY is not null");
            return (Criteria) this;
        }

        public Criteria andDelayEqualTo(BigDecimal value) {
            addCriterion("DELAY =", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotEqualTo(BigDecimal value) {
            addCriterion("DELAY <>", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayGreaterThan(BigDecimal value) {
            addCriterion("DELAY >", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELAY >=", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayLessThan(BigDecimal value) {
            addCriterion("DELAY <", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELAY <=", value, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayIn(List<BigDecimal> values) {
            addCriterion("DELAY in", values, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotIn(List<BigDecimal> values) {
            addCriterion("DELAY not in", values, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELAY between", value1, value2, "delay");
            return (Criteria) this;
        }

        public Criteria andDelayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELAY not between", value1, value2, "delay");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andDescomidIsNull() {
            addCriterion("DESCOMID is null");
            return (Criteria) this;
        }

        public Criteria andDescomidIsNotNull() {
            addCriterion("DESCOMID is not null");
            return (Criteria) this;
        }

        public Criteria andDescomidEqualTo(String value) {
            addCriterion("DESCOMID =", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidNotEqualTo(String value) {
            addCriterion("DESCOMID <>", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidGreaterThan(String value) {
            addCriterion("DESCOMID >", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidGreaterThanOrEqualTo(String value) {
            addCriterion("DESCOMID >=", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidLessThan(String value) {
            addCriterion("DESCOMID <", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidLessThanOrEqualTo(String value) {
            addCriterion("DESCOMID <=", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidLike(String value) {
            addCriterion("DESCOMID like", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidNotLike(String value) {
            addCriterion("DESCOMID not like", value, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidIn(List<String> values) {
            addCriterion("DESCOMID in", values, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidNotIn(List<String> values) {
            addCriterion("DESCOMID not in", values, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidBetween(String value1, String value2) {
            addCriterion("DESCOMID between", value1, value2, "descomid");
            return (Criteria) this;
        }

        public Criteria andDescomidNotBetween(String value1, String value2) {
            addCriterion("DESCOMID not between", value1, value2, "descomid");
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