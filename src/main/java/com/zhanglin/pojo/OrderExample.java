package com.zhanglin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderPriceIsNull() {
            addCriterion("ORDER_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("ORDER_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(BigDecimal value) {
            addCriterion("ORDER_PRICE =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_PRICE <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("ORDER_PRICE >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_PRICE >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(BigDecimal value) {
            addCriterion("ORDER_PRICE <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_PRICE <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<BigDecimal> values) {
            addCriterion("ORDER_PRICE in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_PRICE not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_PRICE between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_PRICE not between", value1, value2, "orderPrice");
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

        public Criteria andOrderTimeIsNull() {
            addCriterion("ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(String value) {
            addCriterion("ORDER_TIME =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(String value) {
            addCriterion("ORDER_TIME <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(String value) {
            addCriterion("ORDER_TIME >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(String value) {
            addCriterion("ORDER_TIME <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLike(String value) {
            addCriterion("ORDER_TIME like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotLike(String value) {
            addCriterion("ORDER_TIME not like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<String> values) {
            addCriterion("ORDER_TIME in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<String> values) {
            addCriterion("ORDER_TIME not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(String value1, String value2) {
            addCriterion("ORDER_TIME between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TIME not between", value1, value2, "orderTime");
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

        public Criteria andRecvtimeIsNull() {
            addCriterion("RECVTIME is null");
            return (Criteria) this;
        }

        public Criteria andRecvtimeIsNotNull() {
            addCriterion("RECVTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecvtimeEqualTo(String value) {
            addCriterion("RECVTIME =", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeNotEqualTo(String value) {
            addCriterion("RECVTIME <>", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeGreaterThan(String value) {
            addCriterion("RECVTIME >", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeGreaterThanOrEqualTo(String value) {
            addCriterion("RECVTIME >=", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeLessThan(String value) {
            addCriterion("RECVTIME <", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeLessThanOrEqualTo(String value) {
            addCriterion("RECVTIME <=", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeLike(String value) {
            addCriterion("RECVTIME like", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeNotLike(String value) {
            addCriterion("RECVTIME not like", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeIn(List<String> values) {
            addCriterion("RECVTIME in", values, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeNotIn(List<String> values) {
            addCriterion("RECVTIME not in", values, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeBetween(String value1, String value2) {
            addCriterion("RECVTIME between", value1, value2, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeNotBetween(String value1, String value2) {
            addCriterion("RECVTIME not between", value1, value2, "recvtime");
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

        public Criteria andW1IsNull() {
            addCriterion("W1 is null");
            return (Criteria) this;
        }

        public Criteria andW1IsNotNull() {
            addCriterion("W1 is not null");
            return (Criteria) this;
        }

        public Criteria andW1EqualTo(BigDecimal value) {
            addCriterion("W1 =", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1NotEqualTo(BigDecimal value) {
            addCriterion("W1 <>", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1GreaterThan(BigDecimal value) {
            addCriterion("W1 >", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("W1 >=", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1LessThan(BigDecimal value) {
            addCriterion("W1 <", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("W1 <=", value, "w1");
            return (Criteria) this;
        }

        public Criteria andW1In(List<BigDecimal> values) {
            addCriterion("W1 in", values, "w1");
            return (Criteria) this;
        }

        public Criteria andW1NotIn(List<BigDecimal> values) {
            addCriterion("W1 not in", values, "w1");
            return (Criteria) this;
        }

        public Criteria andW1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("W1 between", value1, value2, "w1");
            return (Criteria) this;
        }

        public Criteria andW1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("W1 not between", value1, value2, "w1");
            return (Criteria) this;
        }

        public Criteria andW2IsNull() {
            addCriterion("W2 is null");
            return (Criteria) this;
        }

        public Criteria andW2IsNotNull() {
            addCriterion("W2 is not null");
            return (Criteria) this;
        }

        public Criteria andW2EqualTo(BigDecimal value) {
            addCriterion("W2 =", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2NotEqualTo(BigDecimal value) {
            addCriterion("W2 <>", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2GreaterThan(BigDecimal value) {
            addCriterion("W2 >", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("W2 >=", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2LessThan(BigDecimal value) {
            addCriterion("W2 <", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("W2 <=", value, "w2");
            return (Criteria) this;
        }

        public Criteria andW2In(List<BigDecimal> values) {
            addCriterion("W2 in", values, "w2");
            return (Criteria) this;
        }

        public Criteria andW2NotIn(List<BigDecimal> values) {
            addCriterion("W2 not in", values, "w2");
            return (Criteria) this;
        }

        public Criteria andW2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("W2 between", value1, value2, "w2");
            return (Criteria) this;
        }

        public Criteria andW2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("W2 not between", value1, value2, "w2");
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