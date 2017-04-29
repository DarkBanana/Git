package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class TechnicsExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TechnicsExample() {
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

		public Criteria andTechnicsnameIsNull() {
			addCriterion("TECHNICSNAME is null");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameIsNotNull() {
			addCriterion("TECHNICSNAME is not null");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameEqualTo(String value) {
			addCriterion("TECHNICSNAME =", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameNotEqualTo(String value) {
			addCriterion("TECHNICSNAME <>", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameGreaterThan(String value) {
			addCriterion("TECHNICSNAME >", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameGreaterThanOrEqualTo(String value) {
			addCriterion("TECHNICSNAME >=", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameLessThan(String value) {
			addCriterion("TECHNICSNAME <", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameLessThanOrEqualTo(String value) {
			addCriterion("TECHNICSNAME <=", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameLike(String value) {
			addCriterion("TECHNICSNAME like", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameNotLike(String value) {
			addCriterion("TECHNICSNAME not like", value, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameIn(List<String> values) {
			addCriterion("TECHNICSNAME in", values, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameNotIn(List<String> values) {
			addCriterion("TECHNICSNAME not in", values, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameBetween(String value1, String value2) {
			addCriterion("TECHNICSNAME between", value1, value2, "technicsname");
			return (Criteria) this;
		}

		public Criteria andTechnicsnameNotBetween(String value1, String value2) {
			addCriterion("TECHNICSNAME not between", value1, value2,
					"technicsname");
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

		public Criteria andTcnameIsNull() {
			addCriterion("TCNAME is null");
			return (Criteria) this;
		}

		public Criteria andTcnameIsNotNull() {
			addCriterion("TCNAME is not null");
			return (Criteria) this;
		}

		public Criteria andTcnameEqualTo(String value) {
			addCriterion("TCNAME =", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameNotEqualTo(String value) {
			addCriterion("TCNAME <>", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameGreaterThan(String value) {
			addCriterion("TCNAME >", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameGreaterThanOrEqualTo(String value) {
			addCriterion("TCNAME >=", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameLessThan(String value) {
			addCriterion("TCNAME <", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameLessThanOrEqualTo(String value) {
			addCriterion("TCNAME <=", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameLike(String value) {
			addCriterion("TCNAME like", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameNotLike(String value) {
			addCriterion("TCNAME not like", value, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameIn(List<String> values) {
			addCriterion("TCNAME in", values, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameNotIn(List<String> values) {
			addCriterion("TCNAME not in", values, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameBetween(String value1, String value2) {
			addCriterion("TCNAME between", value1, value2, "tcname");
			return (Criteria) this;
		}

		public Criteria andTcnameNotBetween(String value1, String value2) {
			addCriterion("TCNAME not between", value1, value2, "tcname");
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