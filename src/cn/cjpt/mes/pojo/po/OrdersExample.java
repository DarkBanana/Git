package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class OrdersExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrdersExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andOrdernumIsNull() {
			addCriterion("ORDERNUM is null");
			return (Criteria) this;
		}

		public Criteria andOrdernumIsNotNull() {
			addCriterion("ORDERNUM is not null");
			return (Criteria) this;
		}

		public Criteria andOrdernumEqualTo(String value) {
			addCriterion("ORDERNUM =", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumNotEqualTo(String value) {
			addCriterion("ORDERNUM <>", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumGreaterThan(String value) {
			addCriterion("ORDERNUM >", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
			addCriterion("ORDERNUM >=", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumLessThan(String value) {
			addCriterion("ORDERNUM <", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumLessThanOrEqualTo(String value) {
			addCriterion("ORDERNUM <=", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumLike(String value) {
			addCriterion("ORDERNUM like", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumNotLike(String value) {
			addCriterion("ORDERNUM not like", value, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumIn(List<String> values) {
			addCriterion("ORDERNUM in", values, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumNotIn(List<String> values) {
			addCriterion("ORDERNUM not in", values, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumBetween(String value1, String value2) {
			addCriterion("ORDERNUM between", value1, value2, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdernumNotBetween(String value1, String value2) {
			addCriterion("ORDERNUM not between", value1, value2, "ordernum");
			return (Criteria) this;
		}

		public Criteria andOrdercontractIsNull() {
			addCriterion("ORDERCONTRACT is null");
			return (Criteria) this;
		}

		public Criteria andOrdercontractIsNotNull() {
			addCriterion("ORDERCONTRACT is not null");
			return (Criteria) this;
		}

		public Criteria andOrdercontractEqualTo(String value) {
			addCriterion("ORDERCONTRACT =", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractNotEqualTo(String value) {
			addCriterion("ORDERCONTRACT <>", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractGreaterThan(String value) {
			addCriterion("ORDERCONTRACT >", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractGreaterThanOrEqualTo(String value) {
			addCriterion("ORDERCONTRACT >=", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractLessThan(String value) {
			addCriterion("ORDERCONTRACT <", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractLessThanOrEqualTo(String value) {
			addCriterion("ORDERCONTRACT <=", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractLike(String value) {
			addCriterion("ORDERCONTRACT like", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractNotLike(String value) {
			addCriterion("ORDERCONTRACT not like", value, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractIn(List<String> values) {
			addCriterion("ORDERCONTRACT in", values, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractNotIn(List<String> values) {
			addCriterion("ORDERCONTRACT not in", values, "ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractBetween(String value1, String value2) {
			addCriterion("ORDERCONTRACT between", value1, value2,
					"ordercontract");
			return (Criteria) this;
		}

		public Criteria andOrdercontractNotBetween(String value1, String value2) {
			addCriterion("ORDERCONTRACT not between", value1, value2,
					"ordercontract");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberIsNull() {
			addCriterion("CABINETNUMBER is null");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberIsNotNull() {
			addCriterion("CABINETNUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberEqualTo(String value) {
			addCriterion("CABINETNUMBER =", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberNotEqualTo(String value) {
			addCriterion("CABINETNUMBER <>", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberGreaterThan(String value) {
			addCriterion("CABINETNUMBER >", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberGreaterThanOrEqualTo(String value) {
			addCriterion("CABINETNUMBER >=", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberLessThan(String value) {
			addCriterion("CABINETNUMBER <", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberLessThanOrEqualTo(String value) {
			addCriterion("CABINETNUMBER <=", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberLike(String value) {
			addCriterion("CABINETNUMBER like", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberNotLike(String value) {
			addCriterion("CABINETNUMBER not like", value, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberIn(List<String> values) {
			addCriterion("CABINETNUMBER in", values, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberNotIn(List<String> values) {
			addCriterion("CABINETNUMBER not in", values, "cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberBetween(String value1, String value2) {
			addCriterion("CABINETNUMBER between", value1, value2,
					"cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andCabinetnumberNotBetween(String value1, String value2) {
			addCriterion("CABINETNUMBER not between", value1, value2,
					"cabinetnumber");
			return (Criteria) this;
		}

		public Criteria andBegintimeIsNull() {
			addCriterion("BEGINTIME is null");
			return (Criteria) this;
		}

		public Criteria andBegintimeIsNotNull() {
			addCriterion("BEGINTIME is not null");
			return (Criteria) this;
		}

		public Criteria andBegintimeEqualTo(String value) {
			addCriterion("BEGINTIME =", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeNotEqualTo(String value) {
			addCriterion("BEGINTIME <>", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeGreaterThan(String value) {
			addCriterion("BEGINTIME >", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeGreaterThanOrEqualTo(String value) {
			addCriterion("BEGINTIME >=", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeLessThan(String value) {
			addCriterion("BEGINTIME <", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeLessThanOrEqualTo(String value) {
			addCriterion("BEGINTIME <=", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeLike(String value) {
			addCriterion("BEGINTIME like", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeNotLike(String value) {
			addCriterion("BEGINTIME not like", value, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeIn(List<String> values) {
			addCriterion("BEGINTIME in", values, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeNotIn(List<String> values) {
			addCriterion("BEGINTIME not in", values, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeBetween(String value1, String value2) {
			addCriterion("BEGINTIME between", value1, value2, "begintime");
			return (Criteria) this;
		}

		public Criteria andBegintimeNotBetween(String value1, String value2) {
			addCriterion("BEGINTIME not between", value1, value2, "begintime");
			return (Criteria) this;
		}

		public Criteria andEndtimeIsNull() {
			addCriterion("ENDTIME is null");
			return (Criteria) this;
		}

		public Criteria andEndtimeIsNotNull() {
			addCriterion("ENDTIME is not null");
			return (Criteria) this;
		}

		public Criteria andEndtimeEqualTo(String value) {
			addCriterion("ENDTIME =", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotEqualTo(String value) {
			addCriterion("ENDTIME <>", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThan(String value) {
			addCriterion("ENDTIME >", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
			addCriterion("ENDTIME >=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThan(String value) {
			addCriterion("ENDTIME <", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLessThanOrEqualTo(String value) {
			addCriterion("ENDTIME <=", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeLike(String value) {
			addCriterion("ENDTIME like", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotLike(String value) {
			addCriterion("ENDTIME not like", value, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeIn(List<String> values) {
			addCriterion("ENDTIME in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotIn(List<String> values) {
			addCriterion("ENDTIME not in", values, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeBetween(String value1, String value2) {
			addCriterion("ENDTIME between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andEndtimeNotBetween(String value1, String value2) {
			addCriterion("ENDTIME not between", value1, value2, "endtime");
			return (Criteria) this;
		}

		public Criteria andOrdernatureIsNull() {
			addCriterion("ORDERNATURE is null");
			return (Criteria) this;
		}

		public Criteria andOrdernatureIsNotNull() {
			addCriterion("ORDERNATURE is not null");
			return (Criteria) this;
		}

		public Criteria andOrdernatureEqualTo(String value) {
			addCriterion("ORDERNATURE =", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureNotEqualTo(String value) {
			addCriterion("ORDERNATURE <>", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureGreaterThan(String value) {
			addCriterion("ORDERNATURE >", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureGreaterThanOrEqualTo(String value) {
			addCriterion("ORDERNATURE >=", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureLessThan(String value) {
			addCriterion("ORDERNATURE <", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureLessThanOrEqualTo(String value) {
			addCriterion("ORDERNATURE <=", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureLike(String value) {
			addCriterion("ORDERNATURE like", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureNotLike(String value) {
			addCriterion("ORDERNATURE not like", value, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureIn(List<String> values) {
			addCriterion("ORDERNATURE in", values, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureNotIn(List<String> values) {
			addCriterion("ORDERNATURE not in", values, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureBetween(String value1, String value2) {
			addCriterion("ORDERNATURE between", value1, value2, "ordernature");
			return (Criteria) this;
		}

		public Criteria andOrdernatureNotBetween(String value1, String value2) {
			addCriterion("ORDERNATURE not between", value1, value2,
					"ordernature");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityIsNull() {
			addCriterion("ORDERPRIORITY is null");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityIsNotNull() {
			addCriterion("ORDERPRIORITY is not null");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityEqualTo(String value) {
			addCriterion("ORDERPRIORITY =", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityNotEqualTo(String value) {
			addCriterion("ORDERPRIORITY <>", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityGreaterThan(String value) {
			addCriterion("ORDERPRIORITY >", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityGreaterThanOrEqualTo(String value) {
			addCriterion("ORDERPRIORITY >=", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityLessThan(String value) {
			addCriterion("ORDERPRIORITY <", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityLessThanOrEqualTo(String value) {
			addCriterion("ORDERPRIORITY <=", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityLike(String value) {
			addCriterion("ORDERPRIORITY like", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityNotLike(String value) {
			addCriterion("ORDERPRIORITY not like", value, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityIn(List<String> values) {
			addCriterion("ORDERPRIORITY in", values, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityNotIn(List<String> values) {
			addCriterion("ORDERPRIORITY not in", values, "orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityBetween(String value1, String value2) {
			addCriterion("ORDERPRIORITY between", value1, value2,
					"orderpriority");
			return (Criteria) this;
		}

		public Criteria andOrderpriorityNotBetween(String value1, String value2) {
			addCriterion("ORDERPRIORITY not between", value1, value2,
					"orderpriority");
			return (Criteria) this;
		}

		public Criteria andLoadcenterIsNull() {
			addCriterion("LOADCENTER is null");
			return (Criteria) this;
		}

		public Criteria andLoadcenterIsNotNull() {
			addCriterion("LOADCENTER is not null");
			return (Criteria) this;
		}

		public Criteria andLoadcenterEqualTo(String value) {
			addCriterion("LOADCENTER =", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterNotEqualTo(String value) {
			addCriterion("LOADCENTER <>", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterGreaterThan(String value) {
			addCriterion("LOADCENTER >", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterGreaterThanOrEqualTo(String value) {
			addCriterion("LOADCENTER >=", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterLessThan(String value) {
			addCriterion("LOADCENTER <", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterLessThanOrEqualTo(String value) {
			addCriterion("LOADCENTER <=", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterLike(String value) {
			addCriterion("LOADCENTER like", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterNotLike(String value) {
			addCriterion("LOADCENTER not like", value, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterIn(List<String> values) {
			addCriterion("LOADCENTER in", values, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterNotIn(List<String> values) {
			addCriterion("LOADCENTER not in", values, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterBetween(String value1, String value2) {
			addCriterion("LOADCENTER between", value1, value2, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andLoadcenterNotBetween(String value1, String value2) {
			addCriterion("LOADCENTER not between", value1, value2, "loadcenter");
			return (Criteria) this;
		}

		public Criteria andModeproductionIsNull() {
			addCriterion("MODEPRODUCTION is null");
			return (Criteria) this;
		}

		public Criteria andModeproductionIsNotNull() {
			addCriterion("MODEPRODUCTION is not null");
			return (Criteria) this;
		}

		public Criteria andModeproductionEqualTo(String value) {
			addCriterion("MODEPRODUCTION =", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionNotEqualTo(String value) {
			addCriterion("MODEPRODUCTION <>", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionGreaterThan(String value) {
			addCriterion("MODEPRODUCTION >", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionGreaterThanOrEqualTo(String value) {
			addCriterion("MODEPRODUCTION >=", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionLessThan(String value) {
			addCriterion("MODEPRODUCTION <", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionLessThanOrEqualTo(String value) {
			addCriterion("MODEPRODUCTION <=", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionLike(String value) {
			addCriterion("MODEPRODUCTION like", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionNotLike(String value) {
			addCriterion("MODEPRODUCTION not like", value, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionIn(List<String> values) {
			addCriterion("MODEPRODUCTION in", values, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionNotIn(List<String> values) {
			addCriterion("MODEPRODUCTION not in", values, "modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionBetween(String value1, String value2) {
			addCriterion("MODEPRODUCTION between", value1, value2,
					"modeproduction");
			return (Criteria) this;
		}

		public Criteria andModeproductionNotBetween(String value1, String value2) {
			addCriterion("MODEPRODUCTION not between", value1, value2,
					"modeproduction");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkIsNull() {
			addCriterion("MATERIELMARK is null");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkIsNotNull() {
			addCriterion("MATERIELMARK is not null");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkEqualTo(String value) {
			addCriterion("MATERIELMARK =", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkNotEqualTo(String value) {
			addCriterion("MATERIELMARK <>", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkGreaterThan(String value) {
			addCriterion("MATERIELMARK >", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkGreaterThanOrEqualTo(String value) {
			addCriterion("MATERIELMARK >=", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkLessThan(String value) {
			addCriterion("MATERIELMARK <", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkLessThanOrEqualTo(String value) {
			addCriterion("MATERIELMARK <=", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkLike(String value) {
			addCriterion("MATERIELMARK like", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkNotLike(String value) {
			addCriterion("MATERIELMARK not like", value, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkIn(List<String> values) {
			addCriterion("MATERIELMARK in", values, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkNotIn(List<String> values) {
			addCriterion("MATERIELMARK not in", values, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkBetween(String value1, String value2) {
			addCriterion("MATERIELMARK between", value1, value2, "materielmark");
			return (Criteria) this;
		}

		public Criteria andMaterielmarkNotBetween(String value1, String value2) {
			addCriterion("MATERIELMARK not between", value1, value2,
					"materielmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkIsNull() {
			addCriterion("TECHNICSMARK is null");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkIsNotNull() {
			addCriterion("TECHNICSMARK is not null");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkEqualTo(String value) {
			addCriterion("TECHNICSMARK =", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkNotEqualTo(String value) {
			addCriterion("TECHNICSMARK <>", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkGreaterThan(String value) {
			addCriterion("TECHNICSMARK >", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkGreaterThanOrEqualTo(String value) {
			addCriterion("TECHNICSMARK >=", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkLessThan(String value) {
			addCriterion("TECHNICSMARK <", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkLessThanOrEqualTo(String value) {
			addCriterion("TECHNICSMARK <=", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkLike(String value) {
			addCriterion("TECHNICSMARK like", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkNotLike(String value) {
			addCriterion("TECHNICSMARK not like", value, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkIn(List<String> values) {
			addCriterion("TECHNICSMARK in", values, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkNotIn(List<String> values) {
			addCriterion("TECHNICSMARK not in", values, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkBetween(String value1, String value2) {
			addCriterion("TECHNICSMARK between", value1, value2, "technicsmark");
			return (Criteria) this;
		}

		public Criteria andTechnicsmarkNotBetween(String value1, String value2) {
			addCriterion("TECHNICSMARK not between", value1, value2,
					"technicsmark");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeIsNull() {
			addCriterion("MATERIELTYPE is null");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeIsNotNull() {
			addCriterion("MATERIELTYPE is not null");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeEqualTo(String value) {
			addCriterion("MATERIELTYPE =", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeNotEqualTo(String value) {
			addCriterion("MATERIELTYPE <>", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeGreaterThan(String value) {
			addCriterion("MATERIELTYPE >", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeGreaterThanOrEqualTo(String value) {
			addCriterion("MATERIELTYPE >=", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeLessThan(String value) {
			addCriterion("MATERIELTYPE <", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeLessThanOrEqualTo(String value) {
			addCriterion("MATERIELTYPE <=", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeLike(String value) {
			addCriterion("MATERIELTYPE like", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeNotLike(String value) {
			addCriterion("MATERIELTYPE not like", value, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeIn(List<String> values) {
			addCriterion("MATERIELTYPE in", values, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeNotIn(List<String> values) {
			addCriterion("MATERIELTYPE not in", values, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeBetween(String value1, String value2) {
			addCriterion("MATERIELTYPE between", value1, value2, "materieltype");
			return (Criteria) this;
		}

		public Criteria andMaterieltypeNotBetween(String value1, String value2) {
			addCriterion("MATERIELTYPE not between", value1, value2,
					"materieltype");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("REMARK is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("REMARK =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("REMARK <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("REMARK >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("REMARK >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("REMARK <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("REMARK <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("REMARK like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("REMARK not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("REMARK in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("REMARK not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("REMARK between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("REMARK not between", value1, value2, "remark");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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