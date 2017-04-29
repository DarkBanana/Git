package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.BarCodeCustom;
import cn.cjpt.mes.pojo.vo.BarCodeQueryVo;

public interface BarCodeMapperCustom {
	// 查询 条码 列表
	public List<BarCodeCustom> findBarCodeList(BarCodeQueryVo barCodeQueryVo)
			throws Exception;

}