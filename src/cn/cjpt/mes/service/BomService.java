package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.BomCustom;
import cn.cjpt.mes.pojo.vo.BomQueryVo;

public interface BomService {
	public List<BomCustom> findBomList(BomQueryVo bomQueryVo) throws Exception;

	public int findBomCount(BomQueryVo bomQueryVo) throws Exception;

	public BomCustom findBomById(String id) throws Exception;

	public void deleteBom(String id) throws Exception;

	public void insertBom(BomCustom bomCustom) throws Exception;

	public void updateBom(String id, BomCustom bomCustom) throws Exception;
}
