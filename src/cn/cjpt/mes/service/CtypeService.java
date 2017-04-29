package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.CtypeQueryVo;

public interface CtypeService {

	public List<CtypeCustom> findCtypeList(CtypeQueryVo ctypeQueryVO)
			throws Exception;

	public CtypeCustom findCtypeById(String id) throws Exception;

	public void deleteCtype(String id) throws Exception;

	public void insertCtype(CtypeCustom ctypeCustom) throws Exception;

	public void updateCtype(String id, CtypeCustom ctypeCustom)
			throws Exception;

	public int findCtypeCount(CtypeQueryVo ctypeQueryVO) throws Exception;

	// 根据 id 查找 Ctype
	public Ctype findCtypeByid(String id) throws Exception;

	// 根据 柜子的 名称 查询 柜子 信息
	public Ctype findCtypeByCname(String cname) throws Exception;

}
