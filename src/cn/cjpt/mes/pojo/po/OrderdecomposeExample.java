package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class OrderdecomposeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderdecomposeExample() {
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

		public Criteria andOdnumberIsNull() {
			addCriterion("ODNUMBER is null");
			return (Criteria) this;
		}

		public Criteria andOdnumberIsNotNull() {
			addCriterion("ODNUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andOdnumberEqualTo(String value) {
			addCriterion("ODNUMBER =", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberNotEqualTo(String value) {
			addCriterion("ODNUMBER <>", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberGreaterThan(String value) {
			addCriterion("ODNUMBER >", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberGreaterThanOrEqualTo(String value) {
			addCriterion("ODNUMBER >=", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberLessThan(String value) {
			addCriterion("ODNUMBER <", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberLessThanOrEqualTo(String value) {
			addCriterion("ODNUMBER <=", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberLike(String value) {
			addCriterion("ODNUMBER like", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberNotLike(String value) {
			addCriterion("ODNUMBER not like", value, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberIn(List<String> values) {
			addCriterion("ODNUMBER in", values, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberNotIn(List<String> values) {
			addCriterion("ODNUMBER not in", values, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberBetween(String value1, String value2) {
			addCriterion("ODNUMBER between", value1, value2, "odnumber");
			return (Criteria) this;
		}

		public Criteria andOdnumberNotBetween(String value1, String value2) {
			addCriterion("ODNUMBER not between", value1, value2, "odnumber");
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

		public Criteria andOrdersidIsNull() {
			addCriterion("ORDERSID is null");
			return (Criteria) this;
		}

		public Criteria andOrdersidIsNotNull() {
			addCriterion("ORDERSID is not null");
			return (Criteria) this;
		}

		public Criteria andOrdersidEqualTo(String value) {
			addCriterion("ORDERSID =", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidNotEqualTo(String value) {
			addCriterion("ORDERSID <>", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidGreaterThan(String value) {
			addCriterion("ORDERSID >", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidGreaterThanOrEqualTo(String value) {
			addCriterion("ORDERSID >=", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidLessThan(String value) {
			addCriterion("ORDERSID <", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidLessThanOrEqualTo(String value) {
			addCriterion("ORDERSID <=", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidLike(String value) {
			addCriterion("ORDERSID like", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidNotLike(String value) {
			addCriterion("ORDERSID not like", value, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidIn(List<String> values) {
			addCriterion("ORDERSID in", values, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidNotIn(List<String> values) {
			addCriterion("ORDERSID not in", values, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidBetween(String value1, String value2) {
			addCriterion("ORDERSID between", value1, value2, "ordersid");
			return (Criteria) this;
		}

		public Criteria andOrdersidNotBetween(String value1, String value2) {
			addCriterion("ORDERSID not between", value1, value2, "ordersid");
			return (Criteria) this;
		}

		public Criteria andMaterielidIsNull() {
			addCriterion("MATERIELID is null");
			return (Criteria) this;
		}

		public Criteria andMaterielidIsNotNull() {
			addCriterion("MATERIELID is not null");
			return (Criteria) this;
		}

		public Criteria andMaterielidEqualTo(String value) {
			addCriterion("MATERIELID =", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidNotEqualTo(String value) {
			addCriterion("MATERIELID <>", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidGreaterThan(String value) {
			addCriterion("MATERIELID >", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidGreaterThanOrEqualTo(String value) {
			addCriterion("MATERIELID >=", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidLessThan(String value) {
			addCriterion("MATERIELID <", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidLessThanOrEqualTo(String value) {
			addCriterion("MATERIELID <=", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidLike(String value) {
			addCriterion("MATERIELID like", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidNotLike(String value) {
			addCriterion("MATERIELID not like", value, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidIn(List<String> values) {
			addCriterion("MATERIELID in", values, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidNotIn(List<String> values) {
			addCriterion("MATERIELID not in", values, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidBetween(String value1, String value2) {
			addCriterion("MATERIELID between", value1, value2, "materielid");
			return (Criteria) this;
		}

		public Criteria andMaterielidNotBetween(String value1, String value2) {
			addCriterion("MATERIELID not between", value1, value2, "materielid");
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