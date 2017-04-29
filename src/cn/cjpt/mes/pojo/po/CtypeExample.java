package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class CtypeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CtypeExample() {
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

		public Criteria andCnumIsNull() {
			addCriterion("CNUM is null");
			return (Criteria) this;
		}

		public Criteria andCnumIsNotNull() {
			addCriterion("CNUM is not null");
			return (Criteria) this;
		}

		public Criteria andCnumEqualTo(String value) {
			addCriterion("CNUM =", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumNotEqualTo(String value) {
			addCriterion("CNUM <>", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumGreaterThan(String value) {
			addCriterion("CNUM >", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumGreaterThanOrEqualTo(String value) {
			addCriterion("CNUM >=", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumLessThan(String value) {
			addCriterion("CNUM <", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumLessThanOrEqualTo(String value) {
			addCriterion("CNUM <=", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumLike(String value) {
			addCriterion("CNUM like", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumNotLike(String value) {
			addCriterion("CNUM not like", value, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumIn(List<String> values) {
			addCriterion("CNUM in", values, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumNotIn(List<String> values) {
			addCriterion("CNUM not in", values, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumBetween(String value1, String value2) {
			addCriterion("CNUM between", value1, value2, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnumNotBetween(String value1, String value2) {
			addCriterion("CNUM not between", value1, value2, "cnum");
			return (Criteria) this;
		}

		public Criteria andCnameIsNull() {
			addCriterion("CNAME is null");
			return (Criteria) this;
		}

		public Criteria andCnameIsNotNull() {
			addCriterion("CNAME is not null");
			return (Criteria) this;
		}

		public Criteria andCnameEqualTo(String value) {
			addCriterion("CNAME =", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotEqualTo(String value) {
			addCriterion("CNAME <>", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameGreaterThan(String value) {
			addCriterion("CNAME >", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameGreaterThanOrEqualTo(String value) {
			addCriterion("CNAME >=", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameLessThan(String value) {
			addCriterion("CNAME <", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameLessThanOrEqualTo(String value) {
			addCriterion("CNAME <=", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameLike(String value) {
			addCriterion("CNAME like", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotLike(String value) {
			addCriterion("CNAME not like", value, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameIn(List<String> values) {
			addCriterion("CNAME in", values, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotIn(List<String> values) {
			addCriterion("CNAME not in", values, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameBetween(String value1, String value2) {
			addCriterion("CNAME between", value1, value2, "cname");
			return (Criteria) this;
		}

		public Criteria andCnameNotBetween(String value1, String value2) {
			addCriterion("CNAME not between", value1, value2, "cname");
			return (Criteria) this;
		}

		public Criteria andRemakeIsNull() {
			addCriterion("REMAKE is null");
			return (Criteria) this;
		}

		public Criteria andRemakeIsNotNull() {
			addCriterion("REMAKE is not null");
			return (Criteria) this;
		}

		public Criteria andRemakeEqualTo(String value) {
			addCriterion("REMAKE =", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeNotEqualTo(String value) {
			addCriterion("REMAKE <>", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeGreaterThan(String value) {
			addCriterion("REMAKE >", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeGreaterThanOrEqualTo(String value) {
			addCriterion("REMAKE >=", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeLessThan(String value) {
			addCriterion("REMAKE <", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeLessThanOrEqualTo(String value) {
			addCriterion("REMAKE <=", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeLike(String value) {
			addCriterion("REMAKE like", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeNotLike(String value) {
			addCriterion("REMAKE not like", value, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeIn(List<String> values) {
			addCriterion("REMAKE in", values, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeNotIn(List<String> values) {
			addCriterion("REMAKE not in", values, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeBetween(String value1, String value2) {
			addCriterion("REMAKE between", value1, value2, "remake");
			return (Criteria) this;
		}

		public Criteria andRemakeNotBetween(String value1, String value2) {
			addCriterion("REMAKE not between", value1, value2, "remake");
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