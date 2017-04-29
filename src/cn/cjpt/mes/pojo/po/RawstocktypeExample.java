package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class RawstocktypeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RawstocktypeExample() {
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

		public Criteria andRtnameIsNull() {
			addCriterion("RTNAME is null");
			return (Criteria) this;
		}

		public Criteria andRtnameIsNotNull() {
			addCriterion("RTNAME is not null");
			return (Criteria) this;
		}

		public Criteria andRtnameEqualTo(String value) {
			addCriterion("RTNAME =", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameNotEqualTo(String value) {
			addCriterion("RTNAME <>", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameGreaterThan(String value) {
			addCriterion("RTNAME >", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameGreaterThanOrEqualTo(String value) {
			addCriterion("RTNAME >=", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameLessThan(String value) {
			addCriterion("RTNAME <", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameLessThanOrEqualTo(String value) {
			addCriterion("RTNAME <=", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameLike(String value) {
			addCriterion("RTNAME like", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameNotLike(String value) {
			addCriterion("RTNAME not like", value, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameIn(List<String> values) {
			addCriterion("RTNAME in", values, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameNotIn(List<String> values) {
			addCriterion("RTNAME not in", values, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameBetween(String value1, String value2) {
			addCriterion("RTNAME between", value1, value2, "rtname");
			return (Criteria) this;
		}

		public Criteria andRtnameNotBetween(String value1, String value2) {
			addCriterion("RTNAME not between", value1, value2, "rtname");
			return (Criteria) this;
		}

		public Criteria andRttypeIsNull() {
			addCriterion("RTTYPE is null");
			return (Criteria) this;
		}

		public Criteria andRttypeIsNotNull() {
			addCriterion("RTTYPE is not null");
			return (Criteria) this;
		}

		public Criteria andRttypeEqualTo(String value) {
			addCriterion("RTTYPE =", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeNotEqualTo(String value) {
			addCriterion("RTTYPE <>", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeGreaterThan(String value) {
			addCriterion("RTTYPE >", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeGreaterThanOrEqualTo(String value) {
			addCriterion("RTTYPE >=", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeLessThan(String value) {
			addCriterion("RTTYPE <", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeLessThanOrEqualTo(String value) {
			addCriterion("RTTYPE <=", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeLike(String value) {
			addCriterion("RTTYPE like", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeNotLike(String value) {
			addCriterion("RTTYPE not like", value, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeIn(List<String> values) {
			addCriterion("RTTYPE in", values, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeNotIn(List<String> values) {
			addCriterion("RTTYPE not in", values, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeBetween(String value1, String value2) {
			addCriterion("RTTYPE between", value1, value2, "rttype");
			return (Criteria) this;
		}

		public Criteria andRttypeNotBetween(String value1, String value2) {
			addCriterion("RTTYPE not between", value1, value2, "rttype");
			return (Criteria) this;
		}

		public Criteria andRtvenderIsNull() {
			addCriterion("RTVENDER is null");
			return (Criteria) this;
		}

		public Criteria andRtvenderIsNotNull() {
			addCriterion("RTVENDER is not null");
			return (Criteria) this;
		}

		public Criteria andRtvenderEqualTo(String value) {
			addCriterion("RTVENDER =", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderNotEqualTo(String value) {
			addCriterion("RTVENDER <>", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderGreaterThan(String value) {
			addCriterion("RTVENDER >", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderGreaterThanOrEqualTo(String value) {
			addCriterion("RTVENDER >=", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderLessThan(String value) {
			addCriterion("RTVENDER <", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderLessThanOrEqualTo(String value) {
			addCriterion("RTVENDER <=", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderLike(String value) {
			addCriterion("RTVENDER like", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderNotLike(String value) {
			addCriterion("RTVENDER not like", value, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderIn(List<String> values) {
			addCriterion("RTVENDER in", values, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderNotIn(List<String> values) {
			addCriterion("RTVENDER not in", values, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderBetween(String value1, String value2) {
			addCriterion("RTVENDER between", value1, value2, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRtvenderNotBetween(String value1, String value2) {
			addCriterion("RTVENDER not between", value1, value2, "rtvender");
			return (Criteria) this;
		}

		public Criteria andRemark1IsNull() {
			addCriterion("REMARK1 is null");
			return (Criteria) this;
		}

		public Criteria andRemark1IsNotNull() {
			addCriterion("REMARK1 is not null");
			return (Criteria) this;
		}

		public Criteria andRemark1EqualTo(String value) {
			addCriterion("REMARK1 =", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1NotEqualTo(String value) {
			addCriterion("REMARK1 <>", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1GreaterThan(String value) {
			addCriterion("REMARK1 >", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1GreaterThanOrEqualTo(String value) {
			addCriterion("REMARK1 >=", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1LessThan(String value) {
			addCriterion("REMARK1 <", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1LessThanOrEqualTo(String value) {
			addCriterion("REMARK1 <=", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1Like(String value) {
			addCriterion("REMARK1 like", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1NotLike(String value) {
			addCriterion("REMARK1 not like", value, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1In(List<String> values) {
			addCriterion("REMARK1 in", values, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1NotIn(List<String> values) {
			addCriterion("REMARK1 not in", values, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1Between(String value1, String value2) {
			addCriterion("REMARK1 between", value1, value2, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark1NotBetween(String value1, String value2) {
			addCriterion("REMARK1 not between", value1, value2, "remark1");
			return (Criteria) this;
		}

		public Criteria andRemark2IsNull() {
			addCriterion("REMARK2 is null");
			return (Criteria) this;
		}

		public Criteria andRemark2IsNotNull() {
			addCriterion("REMARK2 is not null");
			return (Criteria) this;
		}

		public Criteria andRemark2EqualTo(String value) {
			addCriterion("REMARK2 =", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2NotEqualTo(String value) {
			addCriterion("REMARK2 <>", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2GreaterThan(String value) {
			addCriterion("REMARK2 >", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2GreaterThanOrEqualTo(String value) {
			addCriterion("REMARK2 >=", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2LessThan(String value) {
			addCriterion("REMARK2 <", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2LessThanOrEqualTo(String value) {
			addCriterion("REMARK2 <=", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2Like(String value) {
			addCriterion("REMARK2 like", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2NotLike(String value) {
			addCriterion("REMARK2 not like", value, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2In(List<String> values) {
			addCriterion("REMARK2 in", values, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2NotIn(List<String> values) {
			addCriterion("REMARK2 not in", values, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2Between(String value1, String value2) {
			addCriterion("REMARK2 between", value1, value2, "remark2");
			return (Criteria) this;
		}

		public Criteria andRemark2NotBetween(String value1, String value2) {
			addCriterion("REMARK2 not between", value1, value2, "remark2");
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