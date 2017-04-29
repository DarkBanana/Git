package cn.cjpt.mes.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import cn.cjpt.mes.pojo.po.Materiel;

public class MaterielQueryVoCustom {
	private MaterielCustom materielCustom;
	private List<Materiel> list = new ArrayList<Materiel>();
	private String ctypeName;
	private String cytpeId;

	public MaterielCustom getMaterielCustom() {
		return materielCustom;
	}

	public void setMaterielCustom(MaterielCustom materielCustom) {
		this.materielCustom = materielCustom;
	}

	public List<Materiel> getList() {
		return list;
	}

	public void setList(List<Materiel> list) {
		this.list = list;
	}

	public String getCtypeName() {
		return ctypeName;
	}

	public void setCtypeName(String ctypeName) {
		this.ctypeName = ctypeName;
	}

	public String getCytpeId() {
		return cytpeId;
	}

	public void setCytpeId(String cytpeId) {
		this.cytpeId = cytpeId;
	}

}
