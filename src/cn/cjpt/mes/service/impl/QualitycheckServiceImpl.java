package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.QualitycheckCustomMapper;
import cn.cjpt.mes.mapper.QualitycheckMapper;
import cn.cjpt.mes.pojo.po.Qualitycheck;
import cn.cjpt.mes.pojo.po.QualitycheckExample;
import cn.cjpt.mes.pojo.vo.QualitycheckCustom;
import cn.cjpt.mes.pojo.vo.QualitycheckQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.QualitycheckService;
import cn.cjpt.mes.util.UUIDBuild;

import com.github.pagehelper.PageHelper;

public class QualitycheckServiceImpl implements QualitycheckService {
	@Autowired
	private QualitycheckCustomMapper qualitycheckCustomMapper;
	@Autowired
	private QualitycheckMapper qualitycheckMapper;

	@Override
	public List<QualitycheckCustom> findQualitycheckList(
			QualitycheckQueryVo qualitycheckQueryVo) throws Exception {
		// TODO Auto-generated method stub
		int page = qualitycheckQueryVo.getPageQuery().getPage();
		int rows = qualitycheckQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		List<QualitycheckCustom> list = qualitycheckCustomMapper
				.findQualitycheckList(qualitycheckQueryVo);
		return list;
	}

	@Override
	public int findQualitycheckCount(QualitycheckQueryVo qualitycheckQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return qualitycheckCustomMapper
				.findQualitycheckCount(qualitycheckQueryVo);
	}

	@Override
	public void deleteQualitycheck(String id) throws Exception {
		// TODO Auto-generated method stub
		Qualitycheck qualitycheck = qualitycheckMapper.selectByPrimaryKey(id);
		if (qualitycheck == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 231,
					null));
		}
		qualitycheckMapper.deleteByPrimaryKey(id);
	}

	// 确认添加
	@Override
	public void insertQualitycheck(QualitycheckCustom qualitycheckCustom)
			throws Exception {
		// TODO Auto-generated method stub
		String checkcode = qualitycheckCustom.getCheckcode();
		Qualitycheck list = this.findQualitycheckByCheckcode(checkcode);
		if (list != null) {
			// checkcode重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 235,
					null));
		}
		// .. 其他合法性校验
		qualitycheckCustom.setId(UUIDBuild.getUUID());
		qualitycheckMapper.insert(qualitycheckCustom);
	}

	/**
	 * 
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Qualitycheck findQualitycheckByCheckcode(String checkcode)
			throws Exception {

		QualitycheckExample example = new QualitycheckExample();
		cn.cjpt.mes.pojo.po.QualitycheckExample.Criteria criteria = example
				.createCriteria();
		criteria.andCheckcodeEqualTo(checkcode);
		// 设置查询条件
		List<Qualitycheck> list = qualitycheckMapper.selectByExample(example);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 修改BOM
	 */
	@Override
	public void updateQualitycheck(String id,
			QualitycheckCustom qualitycheckCustom) throws Exception {
		// TODO Auto-generated method stub
		// 从数据库查询用户信息
		Qualitycheck qualitycheck = qualitycheckMapper.selectByPrimaryKey(id);
		// 如果修改了
		if (qualitycheckCustom.getCheckcode().equals("")
				|| qualitycheckCustom.getChecktime().equals("")
				|| qualitycheckCustom.getConclusion().equals("")) {
			// 修改后不能重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
		}
		qualitycheck.setCheckcode(qualitycheckCustom.getCheckcode());
		qualitycheck.setConclusion(qualitycheckCustom.getConclusion());
		qualitycheck.setChecktime(qualitycheckCustom.getChecktime());
		qualitycheck.setInspector(qualitycheckCustom.getInspector());
		qualitycheck.setNote(qualitycheckCustom.getNote());
		qualitycheckMapper.updateByPrimaryKey(qualitycheck);
	}

	@Override
	public QualitycheckCustom findQualitycheckByid(String id) throws Exception {
		// TODO Auto-generated method stub
		Qualitycheck qualitycheck = qualitycheckMapper.selectByPrimaryKey(id);
		if (qualitycheck == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 219,
					null));
		}
		QualitycheckCustom qualitycheckCustom = new QualitycheckCustom();
		// 将sysuser中数据设置到sysuserCustom
		BeanUtils.copyProperties(qualitycheck, qualitycheckCustom);
		return qualitycheckCustom;
	}

}
