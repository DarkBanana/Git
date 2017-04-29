package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public MaintenanceExample() {
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

		public Criteria andToolnameIsNull() {
			addCriterion("TOOLNAME is null");
			return (Criteria) this;
		}

		public Criteria andToolnameIsNotNull() {
			addCriterion("TOOLNAME is not null");
			return (Criteria) this;
		}

		public Criteria andToolnameEqualTo(String value) {
			addCriterion("TOOLNAME =", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameNotEqualTo(String value) {
			addCriterion("TOOLNAME <>", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameGreaterThan(String value) {
			addCriterion("TOOLNAME >", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameGreaterThanOrEqualTo(String value) {
			addCriterion("TOOLNAME >=", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameLessThan(String value) {
			addCriterion("TOOLNAME <", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameLessThanOrEqualTo(String value) {
			addCriterion("TOOLNAME <=", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameLike(String value) {
			addCriterion("TOOLNAME like", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameNotLike(String value) {
			addCriterion("TOOLNAME not like", value, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameIn(List<String> values) {
			addCriterion("TOOLNAME in", values, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameNotIn(List<String> values) {
			addCriterion("TOOLNAME not in", values, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameBetween(String value1, String value2) {
			addCriterion("TOOLNAME between", value1, value2, "toolname");
			return (Criteria) this;
		}

		public Criteria andToolnameNotBetween(String value1, String value2) {
			addCriterion("TOOLNAME not between", value1, value2, "toolname");
			return (Criteria) this;
		}

		public Criteria andSpecificationsIsNull() {
			addCriterion("SPECIFICATIONS is null");
			return (Criteria) this;
		}

		public Criteria andSpecificationsIsNotNull() {
			addCriterion("SPECIFICATIONS is not null");
			return (Criteria) this;
		}

		public Criteria andSpecificationsEqualTo(String value) {
			addCriterion("SPECIFICATIONS =", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsNotEqualTo(String value) {
			addCriterion("SPECIFICATIONS <>", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsGreaterThan(String value) {
			addCriterion("SPECIFICATIONS >", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsGreaterThanOrEqualTo(String value) {
			addCriterion("SPECIFICATIONS >=", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsLessThan(String value) {
			addCriterion("SPECIFICATIONS <", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsLessThanOrEqualTo(String value) {
			addCriterion("SPECIFICATIONS <=", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsLike(String value) {
			addCriterion("SPECIFICATIONS like", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsNotLike(String value) {
			addCriterion("SPECIFICATIONS not like", value, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsIn(List<String> values) {
			addCriterion("SPECIFICATIONS in", values, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsNotIn(List<String> values) {
			addCriterion("SPECIFICATIONS not in", values, "specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsBetween(String value1, String value2) {
			addCriterion("SPECIFICATIONS between", value1, value2,
					"specifications");
			return (Criteria) this;
		}

		public Criteria andSpecificationsNotBetween(String value1, String value2) {
			addCriterion("SPECIFICATIONS not between", value1, value2,
					"specifications");
			return (Criteria) this;
		}

		public Criteria andMtimeIsNull() {
			addCriterion("MTIME is null");
			return (Criteria) this;
		}

		public Criteria andMtimeIsNotNull() {
			addCriterion("MTIME is not null");
			return (Criteria) this;
		}

		public Criteria andMtimeEqualTo(String value) {
			addCriterion("MTIME =", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeNotEqualTo(String value) {
			addCriterion("MTIME <>", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeGreaterThan(String value) {
			addCriterion("MTIME >", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeGreaterThanOrEqualTo(String value) {
			addCriterion("MTIME >=", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeLessThan(String value) {
			addCriterion("MTIME <", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeLessThanOrEqualTo(String value) {
			addCriterion("MTIME <=", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeLike(String value) {
			addCriterion("MTIME like", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeNotLike(String value) {
			addCriterion("MTIME not like", value, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeIn(List<String> values) {
			addCriterion("MTIME in", values, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeNotIn(List<String> values) {
			addCriterion("MTIME not in", values, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeBetween(String value1, String value2) {
			addCriterion("MTIME between", value1, value2, "mtime");
			return (Criteria) this;
		}

		public Criteria andMtimeNotBetween(String value1, String value2) {
			addCriterion("MTIME not between", value1, value2, "mtime");
			return (Criteria) this;
		}

		public Criteria andNoteIsNull() {
			addCriterion("NOTE is null");
			return (Criteria) this;
		}

		public Criteria andNoteIsNotNull() {
			addCriterion("NOTE is not null");
			return (Criteria) this;
		}

		public Criteria andNoteEqualTo(String value) {
			addCriterion("NOTE =", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotEqualTo(String value) {
			addCriterion("NOTE <>", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThan(String value) {
			addCriterion("NOTE >", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThanOrEqualTo(String value) {
			addCriterion("NOTE >=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThan(String value) {
			addCriterion("NOTE <", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThanOrEqualTo(String value) {
			addCriterion("NOTE <=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLike(String value) {
			addCriterion("NOTE like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotLike(String value) {
			addCriterion("NOTE not like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteIn(List<String> values) {
			addCriterion("NOTE in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotIn(List<String> values) {
			addCriterion("NOTE not in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteBetween(String value1, String value2) {
			addCriterion("NOTE between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotBetween(String value1, String value2) {
			addCriterion("NOTE not between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andPersonIsNull() {
			addCriterion("PERSON is null");
			return (Criteria) this;
		}

		public Criteria andPersonIsNotNull() {
			addCriterion("PERSON is not null");
			return (Criteria) this;
		}

		public Criteria andPersonEqualTo(String value) {
			addCriterion("PERSON =", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonNotEqualTo(String value) {
			addCriterion("PERSON <>", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonGreaterThan(String value) {
			addCriterion("PERSON >", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonGreaterThanOrEqualTo(String value) {
			addCriterion("PERSON >=", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonLessThan(String value) {
			addCriterion("PERSON <", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonLessThanOrEqualTo(String value) {
			addCriterion("PERSON <=", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonLike(String value) {
			addCriterion("PERSON like", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonNotLike(String value) {
			addCriterion("PERSON not like", value, "person");
			return (Criteria) this;
		}

		public Criteria andPersonIn(List<String> values) {
			addCriterion("PERSON in", values, "person");
			return (Criteria) this;
		}

		public Criteria andPersonNotIn(List<String> values) {
			addCriterion("PERSON not in", values, "person");
			return (Criteria) this;
		}

		public Criteria andPersonBetween(String value1, String value2) {
			addCriterion("PERSON between", value1, value2, "person");
			return (Criteria) this;
		}

		public Criteria andPersonNotBetween(String value1, String value2) {
			addCriterion("PERSON not between", value1, value2, "person");
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