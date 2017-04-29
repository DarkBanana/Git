package cn.cjpt.mes.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class CodingExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CodingExample() {
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

		public Criteria andCutIsNull() {
			addCriterion("CUT is null");
			return (Criteria) this;
		}

		public Criteria andCutIsNotNull() {
			addCriterion("CUT is not null");
			return (Criteria) this;
		}

		public Criteria andCutEqualTo(String value) {
			addCriterion("CUT =", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutNotEqualTo(String value) {
			addCriterion("CUT <>", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutGreaterThan(String value) {
			addCriterion("CUT >", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutGreaterThanOrEqualTo(String value) {
			addCriterion("CUT >=", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutLessThan(String value) {
			addCriterion("CUT <", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutLessThanOrEqualTo(String value) {
			addCriterion("CUT <=", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutLike(String value) {
			addCriterion("CUT like", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutNotLike(String value) {
			addCriterion("CUT not like", value, "cut");
			return (Criteria) this;
		}

		public Criteria andCutIn(List<String> values) {
			addCriterion("CUT in", values, "cut");
			return (Criteria) this;
		}

		public Criteria andCutNotIn(List<String> values) {
			addCriterion("CUT not in", values, "cut");
			return (Criteria) this;
		}

		public Criteria andCutBetween(String value1, String value2) {
			addCriterion("CUT between", value1, value2, "cut");
			return (Criteria) this;
		}

		public Criteria andCutNotBetween(String value1, String value2) {
			addCriterion("CUT not between", value1, value2, "cut");
			return (Criteria) this;
		}

		public Criteria andPunchIsNull() {
			addCriterion("PUNCH is null");
			return (Criteria) this;
		}

		public Criteria andPunchIsNotNull() {
			addCriterion("PUNCH is not null");
			return (Criteria) this;
		}

		public Criteria andPunchEqualTo(String value) {
			addCriterion("PUNCH =", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchNotEqualTo(String value) {
			addCriterion("PUNCH <>", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchGreaterThan(String value) {
			addCriterion("PUNCH >", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchGreaterThanOrEqualTo(String value) {
			addCriterion("PUNCH >=", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchLessThan(String value) {
			addCriterion("PUNCH <", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchLessThanOrEqualTo(String value) {
			addCriterion("PUNCH <=", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchLike(String value) {
			addCriterion("PUNCH like", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchNotLike(String value) {
			addCriterion("PUNCH not like", value, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchIn(List<String> values) {
			addCriterion("PUNCH in", values, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchNotIn(List<String> values) {
			addCriterion("PUNCH not in", values, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchBetween(String value1, String value2) {
			addCriterion("PUNCH between", value1, value2, "punch");
			return (Criteria) this;
		}

		public Criteria andPunchNotBetween(String value1, String value2) {
			addCriterion("PUNCH not between", value1, value2, "punch");
			return (Criteria) this;
		}

		public Criteria andBendIsNull() {
			addCriterion("BEND is null");
			return (Criteria) this;
		}

		public Criteria andBendIsNotNull() {
			addCriterion("BEND is not null");
			return (Criteria) this;
		}

		public Criteria andBendEqualTo(String value) {
			addCriterion("BEND =", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendNotEqualTo(String value) {
			addCriterion("BEND <>", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendGreaterThan(String value) {
			addCriterion("BEND >", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendGreaterThanOrEqualTo(String value) {
			addCriterion("BEND >=", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendLessThan(String value) {
			addCriterion("BEND <", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendLessThanOrEqualTo(String value) {
			addCriterion("BEND <=", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendLike(String value) {
			addCriterion("BEND like", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendNotLike(String value) {
			addCriterion("BEND not like", value, "bend");
			return (Criteria) this;
		}

		public Criteria andBendIn(List<String> values) {
			addCriterion("BEND in", values, "bend");
			return (Criteria) this;
		}

		public Criteria andBendNotIn(List<String> values) {
			addCriterion("BEND not in", values, "bend");
			return (Criteria) this;
		}

		public Criteria andBendBetween(String value1, String value2) {
			addCriterion("BEND between", value1, value2, "bend");
			return (Criteria) this;
		}

		public Criteria andBendNotBetween(String value1, String value2) {
			addCriterion("BEND not between", value1, value2, "bend");
			return (Criteria) this;
		}

		public Criteria andEfittingIsNull() {
			addCriterion("EFITTING is null");
			return (Criteria) this;
		}

		public Criteria andEfittingIsNotNull() {
			addCriterion("EFITTING is not null");
			return (Criteria) this;
		}

		public Criteria andEfittingEqualTo(String value) {
			addCriterion("EFITTING =", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingNotEqualTo(String value) {
			addCriterion("EFITTING <>", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingGreaterThan(String value) {
			addCriterion("EFITTING >", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingGreaterThanOrEqualTo(String value) {
			addCriterion("EFITTING >=", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingLessThan(String value) {
			addCriterion("EFITTING <", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingLessThanOrEqualTo(String value) {
			addCriterion("EFITTING <=", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingLike(String value) {
			addCriterion("EFITTING like", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingNotLike(String value) {
			addCriterion("EFITTING not like", value, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingIn(List<String> values) {
			addCriterion("EFITTING in", values, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingNotIn(List<String> values) {
			addCriterion("EFITTING not in", values, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingBetween(String value1, String value2) {
			addCriterion("EFITTING between", value1, value2, "efitting");
			return (Criteria) this;
		}

		public Criteria andEfittingNotBetween(String value1, String value2) {
			addCriterion("EFITTING not between", value1, value2, "efitting");
			return (Criteria) this;
		}

		public Criteria andMfittingIsNull() {
			addCriterion("MFITTING is null");
			return (Criteria) this;
		}

		public Criteria andMfittingIsNotNull() {
			addCriterion("MFITTING is not null");
			return (Criteria) this;
		}

		public Criteria andMfittingEqualTo(String value) {
			addCriterion("MFITTING =", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingNotEqualTo(String value) {
			addCriterion("MFITTING <>", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingGreaterThan(String value) {
			addCriterion("MFITTING >", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingGreaterThanOrEqualTo(String value) {
			addCriterion("MFITTING >=", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingLessThan(String value) {
			addCriterion("MFITTING <", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingLessThanOrEqualTo(String value) {
			addCriterion("MFITTING <=", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingLike(String value) {
			addCriterion("MFITTING like", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingNotLike(String value) {
			addCriterion("MFITTING not like", value, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingIn(List<String> values) {
			addCriterion("MFITTING in", values, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingNotIn(List<String> values) {
			addCriterion("MFITTING not in", values, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingBetween(String value1, String value2) {
			addCriterion("MFITTING between", value1, value2, "mfitting");
			return (Criteria) this;
		}

		public Criteria andMfittingNotBetween(String value1, String value2) {
			addCriterion("MFITTING not between", value1, value2, "mfitting");
			return (Criteria) this;
		}

		public Criteria andFfittingIsNull() {
			addCriterion("FFITTING is null");
			return (Criteria) this;
		}

		public Criteria andFfittingIsNotNull() {
			addCriterion("FFITTING is not null");
			return (Criteria) this;
		}

		public Criteria andFfittingEqualTo(String value) {
			addCriterion("FFITTING =", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingNotEqualTo(String value) {
			addCriterion("FFITTING <>", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingGreaterThan(String value) {
			addCriterion("FFITTING >", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingGreaterThanOrEqualTo(String value) {
			addCriterion("FFITTING >=", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingLessThan(String value) {
			addCriterion("FFITTING <", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingLessThanOrEqualTo(String value) {
			addCriterion("FFITTING <=", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingLike(String value) {
			addCriterion("FFITTING like", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingNotLike(String value) {
			addCriterion("FFITTING not like", value, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingIn(List<String> values) {
			addCriterion("FFITTING in", values, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingNotIn(List<String> values) {
			addCriterion("FFITTING not in", values, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingBetween(String value1, String value2) {
			addCriterion("FFITTING between", value1, value2, "ffitting");
			return (Criteria) this;
		}

		public Criteria andFfittingNotBetween(String value1, String value2) {
			addCriterion("FFITTING not between", value1, value2, "ffitting");
			return (Criteria) this;
		}

		public Criteria andCutdateIsNull() {
			addCriterion("CUTDATE is null");
			return (Criteria) this;
		}

		public Criteria andCutdateIsNotNull() {
			addCriterion("CUTDATE is not null");
			return (Criteria) this;
		}

		public Criteria andCutdateEqualTo(String value) {
			addCriterion("CUTDATE =", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateNotEqualTo(String value) {
			addCriterion("CUTDATE <>", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateGreaterThan(String value) {
			addCriterion("CUTDATE >", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateGreaterThanOrEqualTo(String value) {
			addCriterion("CUTDATE >=", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateLessThan(String value) {
			addCriterion("CUTDATE <", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateLessThanOrEqualTo(String value) {
			addCriterion("CUTDATE <=", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateLike(String value) {
			addCriterion("CUTDATE like", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateNotLike(String value) {
			addCriterion("CUTDATE not like", value, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateIn(List<String> values) {
			addCriterion("CUTDATE in", values, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateNotIn(List<String> values) {
			addCriterion("CUTDATE not in", values, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateBetween(String value1, String value2) {
			addCriterion("CUTDATE between", value1, value2, "cutdate");
			return (Criteria) this;
		}

		public Criteria andCutdateNotBetween(String value1, String value2) {
			addCriterion("CUTDATE not between", value1, value2, "cutdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateIsNull() {
			addCriterion("PUNCHDATE is null");
			return (Criteria) this;
		}

		public Criteria andPunchdateIsNotNull() {
			addCriterion("PUNCHDATE is not null");
			return (Criteria) this;
		}

		public Criteria andPunchdateEqualTo(String value) {
			addCriterion("PUNCHDATE =", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateNotEqualTo(String value) {
			addCriterion("PUNCHDATE <>", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateGreaterThan(String value) {
			addCriterion("PUNCHDATE >", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateGreaterThanOrEqualTo(String value) {
			addCriterion("PUNCHDATE >=", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateLessThan(String value) {
			addCriterion("PUNCHDATE <", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateLessThanOrEqualTo(String value) {
			addCriterion("PUNCHDATE <=", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateLike(String value) {
			addCriterion("PUNCHDATE like", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateNotLike(String value) {
			addCriterion("PUNCHDATE not like", value, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateIn(List<String> values) {
			addCriterion("PUNCHDATE in", values, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateNotIn(List<String> values) {
			addCriterion("PUNCHDATE not in", values, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateBetween(String value1, String value2) {
			addCriterion("PUNCHDATE between", value1, value2, "punchdate");
			return (Criteria) this;
		}

		public Criteria andPunchdateNotBetween(String value1, String value2) {
			addCriterion("PUNCHDATE not between", value1, value2, "punchdate");
			return (Criteria) this;
		}

		public Criteria andBenddateIsNull() {
			addCriterion("BENDDATE is null");
			return (Criteria) this;
		}

		public Criteria andBenddateIsNotNull() {
			addCriterion("BENDDATE is not null");
			return (Criteria) this;
		}

		public Criteria andBenddateEqualTo(String value) {
			addCriterion("BENDDATE =", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateNotEqualTo(String value) {
			addCriterion("BENDDATE <>", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateGreaterThan(String value) {
			addCriterion("BENDDATE >", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateGreaterThanOrEqualTo(String value) {
			addCriterion("BENDDATE >=", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateLessThan(String value) {
			addCriterion("BENDDATE <", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateLessThanOrEqualTo(String value) {
			addCriterion("BENDDATE <=", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateLike(String value) {
			addCriterion("BENDDATE like", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateNotLike(String value) {
			addCriterion("BENDDATE not like", value, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateIn(List<String> values) {
			addCriterion("BENDDATE in", values, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateNotIn(List<String> values) {
			addCriterion("BENDDATE not in", values, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateBetween(String value1, String value2) {
			addCriterion("BENDDATE between", value1, value2, "benddate");
			return (Criteria) this;
		}

		public Criteria andBenddateNotBetween(String value1, String value2) {
			addCriterion("BENDDATE not between", value1, value2, "benddate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateIsNull() {
			addCriterion("EFITTINGDATE is null");
			return (Criteria) this;
		}

		public Criteria andEfittingdateIsNotNull() {
			addCriterion("EFITTINGDATE is not null");
			return (Criteria) this;
		}

		public Criteria andEfittingdateEqualTo(String value) {
			addCriterion("EFITTINGDATE =", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateNotEqualTo(String value) {
			addCriterion("EFITTINGDATE <>", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateGreaterThan(String value) {
			addCriterion("EFITTINGDATE >", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateGreaterThanOrEqualTo(String value) {
			addCriterion("EFITTINGDATE >=", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateLessThan(String value) {
			addCriterion("EFITTINGDATE <", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateLessThanOrEqualTo(String value) {
			addCriterion("EFITTINGDATE <=", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateLike(String value) {
			addCriterion("EFITTINGDATE like", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateNotLike(String value) {
			addCriterion("EFITTINGDATE not like", value, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateIn(List<String> values) {
			addCriterion("EFITTINGDATE in", values, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateNotIn(List<String> values) {
			addCriterion("EFITTINGDATE not in", values, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateBetween(String value1, String value2) {
			addCriterion("EFITTINGDATE between", value1, value2, "efittingdate");
			return (Criteria) this;
		}

		public Criteria andEfittingdateNotBetween(String value1, String value2) {
			addCriterion("EFITTINGDATE not between", value1, value2,
					"efittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateIsNull() {
			addCriterion("MFITTINGDATE is null");
			return (Criteria) this;
		}

		public Criteria andMfittingdateIsNotNull() {
			addCriterion("MFITTINGDATE is not null");
			return (Criteria) this;
		}

		public Criteria andMfittingdateEqualTo(String value) {
			addCriterion("MFITTINGDATE =", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateNotEqualTo(String value) {
			addCriterion("MFITTINGDATE <>", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateGreaterThan(String value) {
			addCriterion("MFITTINGDATE >", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateGreaterThanOrEqualTo(String value) {
			addCriterion("MFITTINGDATE >=", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateLessThan(String value) {
			addCriterion("MFITTINGDATE <", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateLessThanOrEqualTo(String value) {
			addCriterion("MFITTINGDATE <=", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateLike(String value) {
			addCriterion("MFITTINGDATE like", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateNotLike(String value) {
			addCriterion("MFITTINGDATE not like", value, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateIn(List<String> values) {
			addCriterion("MFITTINGDATE in", values, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateNotIn(List<String> values) {
			addCriterion("MFITTINGDATE not in", values, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateBetween(String value1, String value2) {
			addCriterion("MFITTINGDATE between", value1, value2, "mfittingdate");
			return (Criteria) this;
		}

		public Criteria andMfittingdateNotBetween(String value1, String value2) {
			addCriterion("MFITTINGDATE not between", value1, value2,
					"mfittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateIsNull() {
			addCriterion("FFITTINGDATE is null");
			return (Criteria) this;
		}

		public Criteria andFfittingdateIsNotNull() {
			addCriterion("FFITTINGDATE is not null");
			return (Criteria) this;
		}

		public Criteria andFfittingdateEqualTo(String value) {
			addCriterion("FFITTINGDATE =", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateNotEqualTo(String value) {
			addCriterion("FFITTINGDATE <>", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateGreaterThan(String value) {
			addCriterion("FFITTINGDATE >", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateGreaterThanOrEqualTo(String value) {
			addCriterion("FFITTINGDATE >=", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateLessThan(String value) {
			addCriterion("FFITTINGDATE <", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateLessThanOrEqualTo(String value) {
			addCriterion("FFITTINGDATE <=", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateLike(String value) {
			addCriterion("FFITTINGDATE like", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateNotLike(String value) {
			addCriterion("FFITTINGDATE not like", value, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateIn(List<String> values) {
			addCriterion("FFITTINGDATE in", values, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateNotIn(List<String> values) {
			addCriterion("FFITTINGDATE not in", values, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateBetween(String value1, String value2) {
			addCriterion("FFITTINGDATE between", value1, value2, "ffittingdate");
			return (Criteria) this;
		}

		public Criteria andFfittingdateNotBetween(String value1, String value2) {
			addCriterion("FFITTINGDATE not between", value1, value2,
					"ffittingdate");
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