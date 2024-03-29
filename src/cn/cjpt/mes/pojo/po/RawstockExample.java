package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class RawstockExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RawstockExample() {
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

		public Criteria andRnameIsNull() {
			addCriterion("RNAME is null");
			return (Criteria) this;
		}

		public Criteria andRnameIsNotNull() {
			addCriterion("RNAME is not null");
			return (Criteria) this;
		}

		public Criteria andRnameEqualTo(String value) {
			addCriterion("RNAME =", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameNotEqualTo(String value) {
			addCriterion("RNAME <>", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameGreaterThan(String value) {
			addCriterion("RNAME >", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameGreaterThanOrEqualTo(String value) {
			addCriterion("RNAME >=", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameLessThan(String value) {
			addCriterion("RNAME <", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameLessThanOrEqualTo(String value) {
			addCriterion("RNAME <=", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameLike(String value) {
			addCriterion("RNAME like", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameNotLike(String value) {
			addCriterion("RNAME not like", value, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameIn(List<String> values) {
			addCriterion("RNAME in", values, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameNotIn(List<String> values) {
			addCriterion("RNAME not in", values, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameBetween(String value1, String value2) {
			addCriterion("RNAME between", value1, value2, "rname");
			return (Criteria) this;
		}

		public Criteria andRnameNotBetween(String value1, String value2) {
			addCriterion("RNAME not between", value1, value2, "rname");
			return (Criteria) this;
		}

		public Criteria andRmodelIsNull() {
			addCriterion("RMODEL is null");
			return (Criteria) this;
		}

		public Criteria andRmodelIsNotNull() {
			addCriterion("RMODEL is not null");
			return (Criteria) this;
		}

		public Criteria andRmodelEqualTo(String value) {
			addCriterion("RMODEL =", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelNotEqualTo(String value) {
			addCriterion("RMODEL <>", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelGreaterThan(String value) {
			addCriterion("RMODEL >", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelGreaterThanOrEqualTo(String value) {
			addCriterion("RMODEL >=", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelLessThan(String value) {
			addCriterion("RMODEL <", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelLessThanOrEqualTo(String value) {
			addCriterion("RMODEL <=", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelLike(String value) {
			addCriterion("RMODEL like", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelNotLike(String value) {
			addCriterion("RMODEL not like", value, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelIn(List<String> values) {
			addCriterion("RMODEL in", values, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelNotIn(List<String> values) {
			addCriterion("RMODEL not in", values, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelBetween(String value1, String value2) {
			addCriterion("RMODEL between", value1, value2, "rmodel");
			return (Criteria) this;
		}

		public Criteria andRmodelNotBetween(String value1, String value2) {
			addCriterion("RMODEL not between", value1, value2, "rmodel");
			return (Criteria) this;
		}

		public Criteria andVenderIsNull() {
			addCriterion("VENDER is null");
			return (Criteria) this;
		}

		public Criteria andVenderIsNotNull() {
			addCriterion("VENDER is not null");
			return (Criteria) this;
		}

		public Criteria andVenderEqualTo(String value) {
			addCriterion("VENDER =", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderNotEqualTo(String value) {
			addCriterion("VENDER <>", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderGreaterThan(String value) {
			addCriterion("VENDER >", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderGreaterThanOrEqualTo(String value) {
			addCriterion("VENDER >=", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderLessThan(String value) {
			addCriterion("VENDER <", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderLessThanOrEqualTo(String value) {
			addCriterion("VENDER <=", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderLike(String value) {
			addCriterion("VENDER like", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderNotLike(String value) {
			addCriterion("VENDER not like", value, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderIn(List<String> values) {
			addCriterion("VENDER in", values, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderNotIn(List<String> values) {
			addCriterion("VENDER not in", values, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderBetween(String value1, String value2) {
			addCriterion("VENDER between", value1, value2, "vender");
			return (Criteria) this;
		}

		public Criteria andVenderNotBetween(String value1, String value2) {
			addCriterion("VENDER not between", value1, value2, "vender");
			return (Criteria) this;
		}

		public Criteria andPutstorenumIsNull() {
			addCriterion("PUTSTORENUM is null");
			return (Criteria) this;
		}

		public Criteria andPutstorenumIsNotNull() {
			addCriterion("PUTSTORENUM is not null");
			return (Criteria) this;
		}

		public Criteria andPutstorenumEqualTo(String value) {
			addCriterion("PUTSTORENUM =", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumNotEqualTo(String value) {
			addCriterion("PUTSTORENUM <>", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumGreaterThan(String value) {
			addCriterion("PUTSTORENUM >", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumGreaterThanOrEqualTo(String value) {
			addCriterion("PUTSTORENUM >=", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumLessThan(String value) {
			addCriterion("PUTSTORENUM <", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumLessThanOrEqualTo(String value) {
			addCriterion("PUTSTORENUM <=", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumLike(String value) {
			addCriterion("PUTSTORENUM like", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumNotLike(String value) {
			addCriterion("PUTSTORENUM not like", value, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumIn(List<String> values) {
			addCriterion("PUTSTORENUM in", values, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumNotIn(List<String> values) {
			addCriterion("PUTSTORENUM not in", values, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumBetween(String value1, String value2) {
			addCriterion("PUTSTORENUM between", value1, value2, "putstorenum");
			return (Criteria) this;
		}

		public Criteria andPutstorenumNotBetween(String value1, String value2) {
			addCriterion("PUTSTORENUM not between", value1, value2,
					"putstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumIsNull() {
			addCriterion("OUTSTORENUM is null");
			return (Criteria) this;
		}

		public Criteria andOutstorenumIsNotNull() {
			addCriterion("OUTSTORENUM is not null");
			return (Criteria) this;
		}

		public Criteria andOutstorenumEqualTo(String value) {
			addCriterion("OUTSTORENUM =", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumNotEqualTo(String value) {
			addCriterion("OUTSTORENUM <>", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumGreaterThan(String value) {
			addCriterion("OUTSTORENUM >", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumGreaterThanOrEqualTo(String value) {
			addCriterion("OUTSTORENUM >=", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumLessThan(String value) {
			addCriterion("OUTSTORENUM <", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumLessThanOrEqualTo(String value) {
			addCriterion("OUTSTORENUM <=", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumLike(String value) {
			addCriterion("OUTSTORENUM like", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumNotLike(String value) {
			addCriterion("OUTSTORENUM not like", value, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumIn(List<String> values) {
			addCriterion("OUTSTORENUM in", values, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumNotIn(List<String> values) {
			addCriterion("OUTSTORENUM not in", values, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumBetween(String value1, String value2) {
			addCriterion("OUTSTORENUM between", value1, value2, "outstorenum");
			return (Criteria) this;
		}

		public Criteria andOutstorenumNotBetween(String value1, String value2) {
			addCriterion("OUTSTORENUM not between", value1, value2,
					"outstorenum");
			return (Criteria) this;
		}

		public Criteria andRemainnumIsNull() {
			addCriterion("REMAINNUM is null");
			return (Criteria) this;
		}

		public Criteria andRemainnumIsNotNull() {
			addCriterion("REMAINNUM is not null");
			return (Criteria) this;
		}

		public Criteria andRemainnumEqualTo(String value) {
			addCriterion("REMAINNUM =", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumNotEqualTo(String value) {
			addCriterion("REMAINNUM <>", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumGreaterThan(String value) {
			addCriterion("REMAINNUM >", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumGreaterThanOrEqualTo(String value) {
			addCriterion("REMAINNUM >=", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumLessThan(String value) {
			addCriterion("REMAINNUM <", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumLessThanOrEqualTo(String value) {
			addCriterion("REMAINNUM <=", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumLike(String value) {
			addCriterion("REMAINNUM like", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumNotLike(String value) {
			addCriterion("REMAINNUM not like", value, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumIn(List<String> values) {
			addCriterion("REMAINNUM in", values, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumNotIn(List<String> values) {
			addCriterion("REMAINNUM not in", values, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumBetween(String value1, String value2) {
			addCriterion("REMAINNUM between", value1, value2, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRemainnumNotBetween(String value1, String value2) {
			addCriterion("REMAINNUM not between", value1, value2, "remainnum");
			return (Criteria) this;
		}

		public Criteria andRtimeIsNull() {
			addCriterion("RTIME is null");
			return (Criteria) this;
		}

		public Criteria andRtimeIsNotNull() {
			addCriterion("RTIME is not null");
			return (Criteria) this;
		}

		public Criteria andRtimeEqualTo(String value) {
			addCriterion("RTIME =", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeNotEqualTo(String value) {
			addCriterion("RTIME <>", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeGreaterThan(String value) {
			addCriterion("RTIME >", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeGreaterThanOrEqualTo(String value) {
			addCriterion("RTIME >=", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeLessThan(String value) {
			addCriterion("RTIME <", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeLessThanOrEqualTo(String value) {
			addCriterion("RTIME <=", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeLike(String value) {
			addCriterion("RTIME like", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeNotLike(String value) {
			addCriterion("RTIME not like", value, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeIn(List<String> values) {
			addCriterion("RTIME in", values, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeNotIn(List<String> values) {
			addCriterion("RTIME not in", values, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeBetween(String value1, String value2) {
			addCriterion("RTIME between", value1, value2, "rtime");
			return (Criteria) this;
		}

		public Criteria andRtimeNotBetween(String value1, String value2) {
			addCriterion("RTIME not between", value1, value2, "rtime");
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

		public Criteria andRtidIsNull() {
			addCriterion("RTID is null");
			return (Criteria) this;
		}

		public Criteria andRtidIsNotNull() {
			addCriterion("RTID is not null");
			return (Criteria) this;
		}

		public Criteria andRtidEqualTo(String value) {
			addCriterion("RTID =", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidNotEqualTo(String value) {
			addCriterion("RTID <>", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidGreaterThan(String value) {
			addCriterion("RTID >", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidGreaterThanOrEqualTo(String value) {
			addCriterion("RTID >=", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidLessThan(String value) {
			addCriterion("RTID <", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidLessThanOrEqualTo(String value) {
			addCriterion("RTID <=", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidLike(String value) {
			addCriterion("RTID like", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidNotLike(String value) {
			addCriterion("RTID not like", value, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidIn(List<String> values) {
			addCriterion("RTID in", values, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidNotIn(List<String> values) {
			addCriterion("RTID not in", values, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidBetween(String value1, String value2) {
			addCriterion("RTID between", value1, value2, "rtid");
			return (Criteria) this;
		}

		public Criteria andRtidNotBetween(String value1, String value2) {
			addCriterion("RTID not between", value1, value2, "rtid");
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