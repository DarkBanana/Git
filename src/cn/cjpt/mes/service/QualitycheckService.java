package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.BomCustom;
import cn.cjpt.mes.pojo.vo.QualitycheckCustom;
import cn.cjpt.mes.pojo.vo.QualitycheckQueryVo;

public interface QualitycheckService {
	public List<QualitycheckCustom> findQualitycheckList(
			QualitycheckQueryVo qualitycheckQueryVo) throws Exception;

	public int findQualitycheckCount(QualitycheckQueryVo qualitycheckQueryVo)
			throws Exception;

	public QualitycheckCustom findQualitycheckByid(String id) throws Exception;

	public void deleteQualitycheck(String id) throws Exception;

	public void insertQualitycheck(QualitycheckCustom qualitycheckCustom)
			throws Exception;

	public void updateQualitycheck(String id,
			QualitycheckCustom qualitycheckCustom) throws Exception;
}
