package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class MaterielExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public MaterielExample() {
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

		public Criteria andMaterielnameIsNull() {
			addCriterion("MATERIELNAME is null");
			return (Criteria) this;
		}

		public Criteria andMaterielnameIsNotNull() {
			addCriterion("MATERIELNAME is not null");
			return (Criteria) this;
		}

		public Criteria andMaterielnameEqualTo(String value) {
			addCriterion("MATERIELNAME =", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameNotEqualTo(String value) {
			addCriterion("MATERIELNAME <>", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameGreaterThan(String value) {
			addCriterion("MATERIELNAME >", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameGreaterThanOrEqualTo(String value) {
			addCriterion("MATERIELNAME >=", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameLessThan(String value) {
			addCriterion("MATERIELNAME <", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameLessThanOrEqualTo(String value) {
			addCriterion("MATERIELNAME <=", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameLike(String value) {
			addCriterion("MATERIELNAME like", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameNotLike(String value) {
			addCriterion("MATERIELNAME not like", value, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameIn(List<String> values) {
			addCriterion("MATERIELNAME in", values, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameNotIn(List<String> values) {
			addCriterion("MATERIELNAME not in", values, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameBetween(String value1, String value2) {
			addCriterion("MATERIELNAME between", value1, value2, "materielname");
			return (Criteria) this;
		}

		public Criteria andMaterielnameNotBetween(String value1, String value2) {
			addCriterion("MATERIELNAME not between", value1, value2,
					"materielname");
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

		public Criteria andMaterielmethodIsNull() {
			addCriterion("MATERIELMETHOD is null");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodIsNotNull() {
			addCriterion("MATERIELMETHOD is not null");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodEqualTo(String value) {
			addCriterion("MATERIELMETHOD =", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodNotEqualTo(String value) {
			addCriterion("MATERIELMETHOD <>", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodGreaterThan(String value) {
			addCriterion("MATERIELMETHOD >", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodGreaterThanOrEqualTo(String value) {
			addCriterion("MATERIELMETHOD >=", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodLessThan(String value) {
			addCriterion("MATERIELMETHOD <", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodLessThanOrEqualTo(String value) {
			addCriterion("MATERIELMETHOD <=", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodLike(String value) {
			addCriterion("MATERIELMETHOD like", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodNotLike(String value) {
			addCriterion("MATERIELMETHOD not like", value, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodIn(List<String> values) {
			addCriterion("MATERIELMETHOD in", values, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodNotIn(List<String> values) {
			addCriterion("MATERIELMETHOD not in", values, "materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodBetween(String value1, String value2) {
			addCriterion("MATERIELMETHOD between", value1, value2,
					"materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielmethodNotBetween(String value1, String value2) {
			addCriterion("MATERIELMETHOD not between", value1, value2,
					"materielmethod");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberIsNull() {
			addCriterion("MATERIELNUMBER is null");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberIsNotNull() {
			addCriterion("MATERIELNUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberEqualTo(String value) {
			addCriterion("MATERIELNUMBER =", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberNotEqualTo(String value) {
			addCriterion("MATERIELNUMBER <>", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberGreaterThan(String value) {
			addCriterion("MATERIELNUMBER >", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberGreaterThanOrEqualTo(String value) {
			addCriterion("MATERIELNUMBER >=", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberLessThan(String value) {
			addCriterion("MATERIELNUMBER <", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberLessThanOrEqualTo(String value) {
			addCriterion("MATERIELNUMBER <=", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberLike(String value) {
			addCriterion("MATERIELNUMBER like", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberNotLike(String value) {
			addCriterion("MATERIELNUMBER not like", value, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberIn(List<String> values) {
			addCriterion("MATERIELNUMBER in", values, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberNotIn(List<String> values) {
			addCriterion("MATERIELNUMBER not in", values, "materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberBetween(String value1, String value2) {
			addCriterion("MATERIELNUMBER between", value1, value2,
					"materielnumber");
			return (Criteria) this;
		}

		public Criteria andMaterielnumberNotBetween(String value1, String value2) {
			addCriterion("MATERIELNUMBER not between", value1, value2,
					"materielnumber");
			return (Criteria) this;
		}

		public Criteria andTasktimeIsNull() {
			addCriterion("TASKTIME is null");
			return (Criteria) this;
		}

		public Criteria andTasktimeIsNotNull() {
			addCriterion("TASKTIME is not null");
			return (Criteria) this;
		}

		public Criteria andTasktimeEqualTo(String value) {
			addCriterion("TASKTIME =", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeNotEqualTo(String value) {
			addCriterion("TASKTIME <>", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeGreaterThan(String value) {
			addCriterion("TASKTIME >", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeGreaterThanOrEqualTo(String value) {
			addCriterion("TASKTIME >=", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeLessThan(String value) {
			addCriterion("TASKTIME <", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeLessThanOrEqualTo(String value) {
			addCriterion("TASKTIME <=", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeLike(String value) {
			addCriterion("TASKTIME like", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeNotLike(String value) {
			addCriterion("TASKTIME not like", value, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeIn(List<String> values) {
			addCriterion("TASKTIME in", values, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeNotIn(List<String> values) {
			addCriterion("TASKTIME not in", values, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeBetween(String value1, String value2) {
			addCriterion("TASKTIME between", value1, value2, "tasktime");
			return (Criteria) this;
		}

		public Criteria andTasktimeNotBetween(String value1, String value2) {
			addCriterion("TASKTIME not between", value1, value2, "tasktime");
			return (Criteria) this;
		}

		public Criteria andCmodelIsNull() {
			addCriterion("CMODEL is null");
			return (Criteria) this;
		}

		public Criteria andCmodelIsNotNull() {
			addCriterion("CMODEL is not null");
			return (Criteria) this;
		}

		public Criteria andCmodelEqualTo(String value) {
			addCriterion("CMODEL =", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelNotEqualTo(String value) {
			addCriterion("CMODEL <>", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelGreaterThan(String value) {
			addCriterion("CMODEL >", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelGreaterThanOrEqualTo(String value) {
			addCriterion("CMODEL >=", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelLessThan(String value) {
			addCriterion("CMODEL <", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelLessThanOrEqualTo(String value) {
			addCriterion("CMODEL <=", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelLike(String value) {
			addCriterion("CMODEL like", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelNotLike(String value) {
			addCriterion("CMODEL not like", value, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelIn(List<String> values) {
			addCriterion("CMODEL in", values, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelNotIn(List<String> values) {
			addCriterion("CMODEL not in", values, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelBetween(String value1, String value2) {
			addCriterion("CMODEL between", value1, value2, "cmodel");
			return (Criteria) this;
		}

		public Criteria andCmodelNotBetween(String value1, String value2) {
			addCriterion("CMODEL not between", value1, value2, "cmodel");
			return (Criteria) this;
		}

		public Criteria andUnitnameIsNull() {
			addCriterion("UNITNAME is null");
			return (Criteria) this;
		}

		public Criteria andUnitnameIsNotNull() {
			addCriterion("UNITNAME is not null");
			return (Criteria) this;
		}

		public Criteria andUnitnameEqualTo(String value) {
			addCriterion("UNITNAME =", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameNotEqualTo(String value) {
			addCriterion("UNITNAME <>", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameGreaterThan(String value) {
			addCriterion("UNITNAME >", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameGreaterThanOrEqualTo(String value) {
			addCriterion("UNITNAME >=", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameLessThan(String value) {
			addCriterion("UNITNAME <", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameLessThanOrEqualTo(String value) {
			addCriterion("UNITNAME <=", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameLike(String value) {
			addCriterion("UNITNAME like", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameNotLike(String value) {
			addCriterion("UNITNAME not like", value, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameIn(List<String> values) {
			addCriterion("UNITNAME in", values, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameNotIn(List<String> values) {
			addCriterion("UNITNAME not in", values, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameBetween(String value1, String value2) {
			addCriterion("UNITNAME between", value1, value2, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitnameNotBetween(String value1, String value2) {
			addCriterion("UNITNAME not between", value1, value2, "unitname");
			return (Criteria) this;
		}

		public Criteria andUnitcodeIsNull() {
			addCriterion("UNITCODE is null");
			return (Criteria) this;
		}

		public Criteria andUnitcodeIsNotNull() {
			addCriterion("UNITCODE is not null");
			return (Criteria) this;
		}

		public Criteria andUnitcodeEqualTo(String value) {
			addCriterion("UNITCODE =", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeNotEqualTo(String value) {
			addCriterion("UNITCODE <>", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeGreaterThan(String value) {
			addCriterion("UNITCODE >", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeGreaterThanOrEqualTo(String value) {
			addCriterion("UNITCODE >=", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeLessThan(String value) {
			addCriterion("UNITCODE <", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeLessThanOrEqualTo(String value) {
			addCriterion("UNITCODE <=", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeLike(String value) {
			addCriterion("UNITCODE like", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeNotLike(String value) {
			addCriterion("UNITCODE not like", value, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeIn(List<String> values) {
			addCriterion("UNITCODE in", values, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeNotIn(List<String> values) {
			addCriterion("UNITCODE not in", values, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeBetween(String value1, String value2) {
			addCriterion("UNITCODE between", value1, value2, "unitcode");
			return (Criteria) this;
		}

		public Criteria andUnitcodeNotBetween(String value1, String value2) {
			addCriterion("UNITCODE not between", value1, value2, "unitcode");
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

		public Criteria andCtypeidIsNull() {
			addCriterion("CTYPEID is null");
			return (Criteria) this;
		}

		public Criteria andCtypeidIsNotNull() {
			addCriterion("CTYPEID is not null");
			return (Criteria) this;
		}

		public Criteria andCtypeidEqualTo(String value) {
			addCriterion("CTYPEID =", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidNotEqualTo(String value) {
			addCriterion("CTYPEID <>", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidGreaterThan(String value) {
			addCriterion("CTYPEID >", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidGreaterThanOrEqualTo(String value) {
			addCriterion("CTYPEID >=", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidLessThan(String value) {
			addCriterion("CTYPEID <", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidLessThanOrEqualTo(String value) {
			addCriterion("CTYPEID <=", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidLike(String value) {
			addCriterion("CTYPEID like", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidNotLike(String value) {
			addCriterion("CTYPEID not like", value, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidIn(List<String> values) {
			addCriterion("CTYPEID in", values, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidNotIn(List<String> values) {
			addCriterion("CTYPEID not in", values, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidBetween(String value1, String value2) {
			addCriterion("CTYPEID between", value1, value2, "ctypeid");
			return (Criteria) this;
		}

		public Criteria andCtypeidNotBetween(String value1, String value2) {
			addCriterion("CTYPEID not between", value1, value2, "ctypeid");
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