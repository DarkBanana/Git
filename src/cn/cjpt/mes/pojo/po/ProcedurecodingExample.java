package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class ProcedurecodingExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ProcedurecodingExample() {
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

		public Criteria andMaterielcodingIsNull() {
			addCriterion("MATERIELCODING is null");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingIsNotNull() {
			addCriterion("MATERIELCODING is not null");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingEqualTo(String value) {
			addCriterion("MATERIELCODING =", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingNotEqualTo(String value) {
			addCriterion("MATERIELCODING <>", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingGreaterThan(String value) {
			addCriterion("MATERIELCODING >", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingGreaterThanOrEqualTo(String value) {
			addCriterion("MATERIELCODING >=", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingLessThan(String value) {
			addCriterion("MATERIELCODING <", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingLessThanOrEqualTo(String value) {
			addCriterion("MATERIELCODING <=", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingLike(String value) {
			addCriterion("MATERIELCODING like", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingNotLike(String value) {
			addCriterion("MATERIELCODING not like", value, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingIn(List<String> values) {
			addCriterion("MATERIELCODING in", values, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingNotIn(List<String> values) {
			addCriterion("MATERIELCODING not in", values, "materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingBetween(String value1, String value2) {
			addCriterion("MATERIELCODING between", value1, value2,
					"materielcoding");
			return (Criteria) this;
		}

		public Criteria andMaterielcodingNotBetween(String value1, String value2) {
			addCriterion("MATERIELCODING not between", value1, value2,
					"materielcoding");
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

		public Criteria andFinishtimeIsNull() {
			addCriterion("FINISHTIME is null");
			return (Criteria) this;
		}

		public Criteria andFinishtimeIsNotNull() {
			addCriterion("FINISHTIME is not null");
			return (Criteria) this;
		}

		public Criteria andFinishtimeEqualTo(String value) {
			addCriterion("FINISHTIME =", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeNotEqualTo(String value) {
			addCriterion("FINISHTIME <>", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeGreaterThan(String value) {
			addCriterion("FINISHTIME >", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeGreaterThanOrEqualTo(String value) {
			addCriterion("FINISHTIME >=", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeLessThan(String value) {
			addCriterion("FINISHTIME <", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeLessThanOrEqualTo(String value) {
			addCriterion("FINISHTIME <=", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeLike(String value) {
			addCriterion("FINISHTIME like", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeNotLike(String value) {
			addCriterion("FINISHTIME not like", value, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeIn(List<String> values) {
			addCriterion("FINISHTIME in", values, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeNotIn(List<String> values) {
			addCriterion("FINISHTIME not in", values, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeBetween(String value1, String value2) {
			addCriterion("FINISHTIME between", value1, value2, "finishtime");
			return (Criteria) this;
		}

		public Criteria andFinishtimeNotBetween(String value1, String value2) {
			addCriterion("FINISHTIME not between", value1, value2, "finishtime");
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

		public Criteria andOperatorIsNull() {
			addCriterion("OPERATOR is null");
			return (Criteria) this;
		}

		public Criteria andOperatorIsNotNull() {
			addCriterion("OPERATOR is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorEqualTo(String value) {
			addCriterion("OPERATOR =", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotEqualTo(String value) {
			addCriterion("OPERATOR <>", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorGreaterThan(String value) {
			addCriterion("OPERATOR >", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorGreaterThanOrEqualTo(String value) {
			addCriterion("OPERATOR >=", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLessThan(String value) {
			addCriterion("OPERATOR <", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLessThanOrEqualTo(String value) {
			addCriterion("OPERATOR <=", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLike(String value) {
			addCriterion("OPERATOR like", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotLike(String value) {
			addCriterion("OPERATOR not like", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorIn(List<String> values) {
			addCriterion("OPERATOR in", values, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotIn(List<String> values) {
			addCriterion("OPERATOR not in", values, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorBetween(String value1, String value2) {
			addCriterion("OPERATOR between", value1, value2, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotBetween(String value1, String value2) {
			addCriterion("OPERATOR not between", value1, value2, "operator");
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