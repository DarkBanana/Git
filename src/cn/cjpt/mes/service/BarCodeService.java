package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.vo.BarCodeCustom;
import cn.cjpt.mes.pojo.vo.BarCodeQueryVo;

/**
 * 条码
 * 
 * @author yxf 2017年2月27日 下午7:38:28
 * 
 */
public interface BarCodeService {

	// 查询 条码 列表
	public List<BarCodeCustom> findBarCodeList(BarCodeQueryVo barCodeQueryVo)
			throws Exception;

	// 删除 条码
	public void deleteBarCode(String barcodeid) throws Exception;

	// 添加 条码
	public void insertBarCode(BarCodeCustom barCodeCustom) throws Exception;

	// 根据 条码号 查询 条码信息
	public BarCode findBarCodeByNumber(String barcodeNumber) throws Exception;
}
