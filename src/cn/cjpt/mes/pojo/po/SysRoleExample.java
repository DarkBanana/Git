package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class SysRoleExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SysRoleExample() {
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

		public Criteria andCreatedataIsNull() {
			addCriterion("CREATEDATA is null");
			return (Criteria) this;
		}

		public Criteria andCreatedataIsNotNull() {
			addCriterion("CREATEDATA is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedataEqualTo(String value) {
			addCriterion("CREATEDATA =", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataNotEqualTo(String value) {
			addCriterion("CREATEDATA <>", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataGreaterThan(String value) {
			addCriterion("CREATEDATA >", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataGreaterThanOrEqualTo(String value) {
			addCriterion("CREATEDATA >=", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataLessThan(String value) {
			addCriterion("CREATEDATA <", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataLessThanOrEqualTo(String value) {
			addCriterion("CREATEDATA <=", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataLike(String value) {
			addCriterion("CREATEDATA like", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataNotLike(String value) {
			addCriterion("CREATEDATA not like", value, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataIn(List<String> values) {
			addCriterion("CREATEDATA in", values, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataNotIn(List<String> values) {
			addCriterion("CREATEDATA not in", values, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataBetween(String value1, String value2) {
			addCriterion("CREATEDATA between", value1, value2, "createdata");
			return (Criteria) this;
		}

		public Criteria andCreatedataNotBetween(String value1, String value2) {
			addCriterion("CREATEDATA not between", value1, value2, "createdata");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andDescribeIsNull() {
			addCriterion("DESCRIBE is null");
			return (Criteria) this;
		}

		public Criteria andDescribeIsNotNull() {
			addCriterion("DESCRIBE is not null");
			return (Criteria) this;
		}

		public Criteria andDescribeEqualTo(String value) {
			addCriterion("DESCRIBE =", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotEqualTo(String value) {
			addCriterion("DESCRIBE <>", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeGreaterThan(String value) {
			addCriterion("DESCRIBE >", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("DESCRIBE >=", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeLessThan(String value) {
			addCriterion("DESCRIBE <", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeLessThanOrEqualTo(String value) {
			addCriterion("DESCRIBE <=", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeLike(String value) {
			addCriterion("DESCRIBE like", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotLike(String value) {
			addCriterion("DESCRIBE not like", value, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeIn(List<String> values) {
			addCriterion("DESCRIBE in", values, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotIn(List<String> values) {
			addCriterion("DESCRIBE not in", values, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeBetween(String value1, String value2) {
			addCriterion("DESCRIBE between", value1, value2, "describe");
			return (Criteria) this;
		}

		public Criteria andDescribeNotBetween(String value1, String value2) {
			addCriterion("DESCRIBE not between", value1, value2, "describe");
			return (Criteria) this;
		}

		public Criteria andAvailableIsNull() {
			addCriterion("AVAILABLE is null");
			return (Criteria) this;
		}

		public Criteria andAvailableIsNotNull() {
			addCriterion("AVAILABLE is not null");
			return (Criteria) this;
		}

		public Criteria andAvailableEqualTo(String value) {
			addCriterion("AVAILABLE =", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableNotEqualTo(String value) {
			addCriterion("AVAILABLE <>", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableGreaterThan(String value) {
			addCriterion("AVAILABLE >", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableGreaterThanOrEqualTo(String value) {
			addCriterion("AVAILABLE >=", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableLessThan(String value) {
			addCriterion("AVAILABLE <", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableLessThanOrEqualTo(String value) {
			addCriterion("AVAILABLE <=", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableLike(String value) {
			addCriterion("AVAILABLE like", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableNotLike(String value) {
			addCriterion("AVAILABLE not like", value, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableIn(List<String> values) {
			addCriterion("AVAILABLE in", values, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableNotIn(List<String> values) {
			addCriterion("AVAILABLE not in", values, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableBetween(String value1, String value2) {
			addCriterion("AVAILABLE between", value1, value2, "available");
			return (Criteria) this;
		}

		public Criteria andAvailableNotBetween(String value1, String value2) {
			addCriterion("AVAILABLE not between", value1, value2, "available");
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