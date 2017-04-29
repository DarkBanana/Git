package cn.cjpt.mes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.RawstocktypeCustomMapper;
import cn.cjpt.mes.mapper.RawstocktypeMapper;
import cn.cjpt.mes.pojo.po.Rawstocktype;
import cn.cjpt.mes.pojo.po.RawstocktypeExample;
import cn.cjpt.mes.pojo.po.RawstocktypeExample.Criteria;
import cn.cjpt.mes.pojo.vo.RawstocktypeCustom;
import cn.cjpt.mes.pojo.vo.RawstocktypeQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.RawstocktypeService;
import cn.cjpt.mes.util.UUIDBuild;

import com.github.pagehelper.PageHelper;

public class RawstocktypeServiceImpl implements RawstocktypeService {
	@Autowired
	private RawstocktypeCustomMapper rawstocktypeCustomMapper;
	@Autowired
	private RawstocktypeMapper rawstocktypeMapper;

	@Override
	public int findRawstocktypeCount(RawstocktypeQueryVo rawstocktypeQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return rawstocktypeCustomMapper.findRawstocktypeCount(rawstocktypeQueryVo);
	}

	@Override
	public List<RawstocktypeCustom> findRawstocktypeList(RawstocktypeQueryVo rawstocktypeQueryVo) throws Exception {
		// TODO Auto-generated method stub

		int page = rawstocktypeQueryVo.getPageQuery().getPage();
		int rows = rawstocktypeQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return rawstocktypeCustomMapper.findRawstocktypeList(rawstocktypeQueryVo);
	}

	@Override
	public void insertRawstock(RawstocktypeCustom rawstocktypeCustom) throws Exception {
		// TODO Auto-generated method stub
		String rtname = rawstocktypeCustom.getRtname();
		String rttype = rawstocktypeCustom.getRttype();
		RawstocktypeExample example = new RawstocktypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andRtnameEqualTo(rtname);
		// 根据零件代码
		criteria.andRemark1EqualTo(rawstocktypeCustom.getRemark1());
		List<Rawstocktype> list = rawstocktypeMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			// BOM重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 290, null));
		}
		// .. 其他合法性校验
		rawstocktypeCustom.setId(UUIDBuild.getUUID());
		rawstocktypeMapper.insert(rawstocktypeCustom);
	}

	@Override
	public void deleterawstocktype(String id) throws Exception {
		// TODO Auto-generated method stub
		Rawstocktype rawstocktype = rawstocktypeMapper.selectByPrimaryKey(id);
		if (rawstocktype == null) {
			// 不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 231, null));
		}
		rawstocktypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public RawstocktypeCustom findrawstocktypeById(String id) throws Exception {
		// TODO Auto-generated method stub
		Rawstocktype rawstocktype = rawstocktypeMapper.selectByPrimaryKey(id);
		if (rawstocktype == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 219, null));
		}
		RawstocktypeCustom rawstocktypeCustom = new RawstocktypeCustom();
		// 将sysuser中数据设置到sysuserCustom
		BeanUtils.copyProperties(rawstocktype, rawstocktypeCustom);
		return rawstocktypeCustom;
	}

	@Override
	public void updateRawstocktype(String id, RawstocktypeCustom rawstocktypeCustom) throws Exception {
		// TODO Auto-generated method stub
		Rawstocktype rawstocktype = rawstocktypeMapper.selectByPrimaryKey(id);

		// 如果修改了
		if (rawstocktypeCustom.getRtname().equals("") || rawstocktypeCustom.getRttype().equals("")) {
			// 修改后不能重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921, null));
		}
		rawstocktype.setRtname(rawstocktypeCustom.getRtname());
		rawstocktype.setRttype(rawstocktypeCustom.getRttype());
		rawstocktypeMapper.updateByPrimaryKey(rawstocktype);
	}

	/**
	 * 查询  锌板  钢板一共有几种类型的
	 */
	@Override
	public List<RawstocktypeCustom> findSteelPlateType() throws Exception {
		// 查出所有的 材料
		List<RawstocktypeCustom> rawstocktypeList = rawstocktypeCustomMapper.findRawstocktypeList(null);

		List<RawstocktypeCustom> list = new ArrayList<>();
		for (RawstocktypeCustom rawstocktypeCustom : rawstocktypeList) {
			String rtname = rawstocktypeCustom.getRtname();
			int index = rtname.indexOf("锌板");
			int index_2 = rtname.indexOf("钢板");
			if (index >= 0 || index_2 >= 0) {
				list.add(rawstocktypeCustom);
			}
		}
		return list;
	}
}
