package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class PublishworkorderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PublishworkorderExample() {
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

		public Criteria andPublishworkordenumIsNull() {
			addCriterion("PUBLISHWORKORDENUM is null");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumIsNotNull() {
			addCriterion("PUBLISHWORKORDENUM is not null");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumEqualTo(String value) {
			addCriterion("PUBLISHWORKORDENUM =", value, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumNotEqualTo(String value) {
			addCriterion("PUBLISHWORKORDENUM <>", value, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumGreaterThan(String value) {
			addCriterion("PUBLISHWORKORDENUM >", value, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumGreaterThanOrEqualTo(String value) {
			addCriterion("PUBLISHWORKORDENUM >=", value, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumLessThan(String value) {
			addCriterion("PUBLISHWORKORDENUM <", value, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumLessThanOrEqualTo(String value) {
			addCriterion("PUBLISHWORKORDENUM <=", value, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumLike(String value) {
			addCriterion("PUBLISHWORKORDENUM like", value, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumNotLike(String value) {
			addCriterion("PUBLISHWORKORDENUM not like", value,
					"publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumIn(List<String> values) {
			addCriterion("PUBLISHWORKORDENUM in", values, "publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumNotIn(List<String> values) {
			addCriterion("PUBLISHWORKORDENUM not in", values,
					"publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumBetween(String value1,
				String value2) {
			addCriterion("PUBLISHWORKORDENUM between", value1, value2,
					"publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPublishworkordenumNotBetween(String value1,
				String value2) {
			addCriterion("PUBLISHWORKORDENUM not between", value1, value2,
					"publishworkordenum");
			return (Criteria) this;
		}

		public Criteria andPwonumberIsNull() {
			addCriterion("PWONUMBER is null");
			return (Criteria) this;
		}

		public Criteria andPwonumberIsNotNull() {
			addCriterion("PWONUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andPwonumberEqualTo(String value) {
			addCriterion("PWONUMBER =", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberNotEqualTo(String value) {
			addCriterion("PWONUMBER <>", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberGreaterThan(String value) {
			addCriterion("PWONUMBER >", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberGreaterThanOrEqualTo(String value) {
			addCriterion("PWONUMBER >=", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberLessThan(String value) {
			addCriterion("PWONUMBER <", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberLessThanOrEqualTo(String value) {
			addCriterion("PWONUMBER <=", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberLike(String value) {
			addCriterion("PWONUMBER like", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberNotLike(String value) {
			addCriterion("PWONUMBER not like", value, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberIn(List<String> values) {
			addCriterion("PWONUMBER in", values, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberNotIn(List<String> values) {
			addCriterion("PWONUMBER not in", values, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberBetween(String value1, String value2) {
			addCriterion("PWONUMBER between", value1, value2, "pwonumber");
			return (Criteria) this;
		}

		public Criteria andPwonumberNotBetween(String value1, String value2) {
			addCriterion("PWONUMBER not between", value1, value2, "pwonumber");
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

		public Criteria andOrderdecomposeidIsNull() {
			addCriterion("ORDERDECOMPOSEID is null");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidIsNotNull() {
			addCriterion("ORDERDECOMPOSEID is not null");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidEqualTo(String value) {
			addCriterion("ORDERDECOMPOSEID =", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidNotEqualTo(String value) {
			addCriterion("ORDERDECOMPOSEID <>", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidGreaterThan(String value) {
			addCriterion("ORDERDECOMPOSEID >", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidGreaterThanOrEqualTo(String value) {
			addCriterion("ORDERDECOMPOSEID >=", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidLessThan(String value) {
			addCriterion("ORDERDECOMPOSEID <", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidLessThanOrEqualTo(String value) {
			addCriterion("ORDERDECOMPOSEID <=", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidLike(String value) {
			addCriterion("ORDERDECOMPOSEID like", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidNotLike(String value) {
			addCriterion("ORDERDECOMPOSEID not like", value, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidIn(List<String> values) {
			addCriterion("ORDERDECOMPOSEID in", values, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidNotIn(List<String> values) {
			addCriterion("ORDERDECOMPOSEID not in", values, "orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidBetween(String value1, String value2) {
			addCriterion("ORDERDECOMPOSEID between", value1, value2,
					"orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andOrderdecomposeidNotBetween(String value1,
				String value2) {
			addCriterion("ORDERDECOMPOSEID not between", value1, value2,
					"orderdecomposeid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidIsNull() {
			addCriterion("TECHNICSID is null");
			return (Criteria) this;
		}

		public Criteria andTechnicsidIsNotNull() {
			addCriterion("TECHNICSID is not null");
			return (Criteria) this;
		}

		public Criteria andTechnicsidEqualTo(String value) {
			addCriterion("TECHNICSID =", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidNotEqualTo(String value) {
			addCriterion("TECHNICSID <>", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidGreaterThan(String value) {
			addCriterion("TECHNICSID >", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidGreaterThanOrEqualTo(String value) {
			addCriterion("TECHNICSID >=", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidLessThan(String value) {
			addCriterion("TECHNICSID <", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidLessThanOrEqualTo(String value) {
			addCriterion("TECHNICSID <=", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidLike(String value) {
			addCriterion("TECHNICSID like", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidNotLike(String value) {
			addCriterion("TECHNICSID not like", value, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidIn(List<String> values) {
			addCriterion("TECHNICSID in", values, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidNotIn(List<String> values) {
			addCriterion("TECHNICSID not in", values, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidBetween(String value1, String value2) {
			addCriterion("TECHNICSID between", value1, value2, "technicsid");
			return (Criteria) this;
		}

		public Criteria andTechnicsidNotBetween(String value1, String value2) {
			addCriterion("TECHNICSID not between", value1, value2, "technicsid");
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