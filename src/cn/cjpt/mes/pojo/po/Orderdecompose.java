package cn.cjpt.mes.pojo.po;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;

/**
 * @author root
 * 
 */
public class Orderdecompose {

	private String id;

	private String odnumber;

	private String begintime;

	private String endtime;

	private String materieltype;

	private String remark;

	private String ordersid;

	private String materielid;

	private String materielname;
	private String ordernum;
	private String tasktime;
	private String unitname;
	private String totaltime;
	private String btime;
	private String etime;
	private String cname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOdnumber() {
		return odnumber;
	}

	public void setOdnumber(String odnumber) {
		this.odnumber = odnumber == null ? null : odnumber.trim();
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime == null ? null : begintime.trim();
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime == null ? null : endtime.trim();
	}

	public String getMaterieltype() {
		return materieltype;
	}

	public void setMaterieltype(String materieltype) {
		this.materieltype = materieltype == null ? null : materieltype.trim();
	}

	public String getRemark() {
		if (remark == null || remark.equals("") || remark.equals("未发布")) {
			return "未发布";
		} else {
			return "已发布";
		}

	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid == null ? null : ordersid.trim();
	}

	public String getMaterielid() {
		return materielid;
	}

	public void setMaterielid(String materielid) {
		this.materielid = materielid == null ? null : materielid.trim();
	}

	public String getMaterielname() {
		return materielname;
	}

	public void setMaterielname(String materielname) {
		this.materielname = materielname;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getTasktime() {
		return tasktime;
	}

	public void setTasktime(String tasktime) {
		this.tasktime = tasktime;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}

	public String getBtime() {
		return btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}