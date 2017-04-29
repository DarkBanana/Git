package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.BarCodeMapper;
import cn.cjpt.mes.mapper.BarCodeMapperCustom;
import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.BarCodeExample;
import cn.cjpt.mes.pojo.vo.BarCodeCustom;
import cn.cjpt.mes.pojo.vo.BarCodeQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.BarCodeService;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 条码
 * 
 * @author yxf 2017年2月27日 下午7:38:58
 * 
 */
public class BarCodeServiceImpl implements BarCodeService {

	@Autowired
	private BarCodeMapperCustom barCodeMapperCustom;
	@Autowired
	private BarCodeMapper barCodeMapper;

	/**
	 * 查询 条码 列表
	 */
	@Override
	public List<BarCodeCustom> findBarCodeList(BarCodeQueryVo barCodeQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		int page = barCodeQueryVo.getPageQuery().getPage();
		int rows = barCodeQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);
		return barCodeMapperCustom.findBarCodeList(barCodeQueryVo);
	}

	/**
	 * 删除 条码
	 */
	@Override
	public void deleteBarCode(String barcodeid) throws Exception {
		barCodeMapper.deleteByPrimaryKey(barcodeid);
	}

	/**
	 * 插入 条码
	 */
	@Override
	public void insertBarCode(BarCodeCustom barCodeCustom) throws Exception {
		// TODO Auto-generated method stub
		// 数据 校验
		// 条码 号 不能重复
		String barcodenumber = barCodeCustom.getBarcodenumber();
		BarCode barCodeFindByNumber = this.findBarCodeByNumber(barcodenumber);
		if (barCodeFindByNumber != null) {
			// 条码 号重复 抛出异常
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 400,
					null));
		}
		barCodeCustom.setId(UUIDBuild.getUUID());
		barCodeMapper.insert(barCodeCustom);
	}

	/**
	 * 根据 条码 号 查找条码 信息
	 */
	@Override
	public BarCode findBarCodeByNumber(String barcodeNumber) throws Exception {
		BarCodeExample barCodeExample = new BarCodeExample();
		BarCodeExample.Criteria criteria = barCodeExample.createCriteria();
		criteria.andBarcodenumberEqualTo(barcodeNumber);
		List<BarCode> barCodeList = barCodeMapper
				.selectByExample(barCodeExample);
		if (barCodeList != null && barCodeList.size() == 1) {
			return barCodeList.get(0);
		}
		return null;

	}

}
