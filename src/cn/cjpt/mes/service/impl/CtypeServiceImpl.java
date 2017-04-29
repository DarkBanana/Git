package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.CtypeMapperCustom;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.CtypeExample.Criteria;
import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.CtypeQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.CtypeService;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 柜体
 * 
 * @author yxf 2017年2月28日 下午9:06:32
 * 
 */
public class CtypeServiceImpl implements CtypeService {

	@Autowired
	private CtypeMapperCustom ctypeMapperCustom;
	@Autowired
	private CtypeMapper ctypeMapper;

	@Override
	public List<CtypeCustom> findCtypeList(CtypeQueryVo ctypeQueryVO)
			throws Exception {
		if (ctypeQueryVO != null) {
			int page = ctypeQueryVO.getPageQuery().getPage();
			int rows = ctypeQueryVO.getPageQuery().getRows();
			// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
			PageHelper.startPage(page, rows);
		}
		// TODO Auto-generated method stub
		return ctypeMapperCustom.findCtypeList(ctypeQueryVO);
	}

	@Override
	public int findCtypeCount(CtypeQueryVo ctypeQueryVO) throws Exception {
		// TODO Auto-generated method stub
		return ctypeMapperCustom.findCtypeCount(ctypeQueryVO);
	}

	@Override
	public Ctype findCtypeByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return ctypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public Ctype findCtypeByCname(String cname) throws Exception {

		CtypeExample ctypeExample = new CtypeExample();
		CtypeExample.Criteria criteria = ctypeExample.createCriteria();
		criteria.andCnameEqualTo(cname);
		List<Ctype> ctypeList = ctypeMapper.selectByExample(ctypeExample);
		if (ctypeList != null && ctypeList.size() == 1) {
			return ctypeList.get(0);
		}
		return null;
	}

	@Override
	public void updateCtype(String id, CtypeCustom ctypeCustom)
			throws Exception {
		// TODO Auto-generated method stub
		Ctype ctype = ctypeMapper.selectByPrimaryKey(id);

		// 如果修改了
		if (ctypeCustom.getCnum().equals("")
				|| ctypeCustom.getCname().equals("")) {
			// 修改后不能重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
		}
		ctype.setCname(ctypeCustom.getCname());
		ctype.setCnum(ctypeCustom.getCnum());
		ctypeMapper.updateByPrimaryKey(ctype);
	}

	private Ctype findCtypeByCnum(String cnum) {
		// TODO Auto-generated method stub
		CtypeExample example = new CtypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andCnumEqualTo(cnum);
		List<Ctype> list = ctypeMapper.selectByExample(example);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public CtypeCustom findCtypeById(String id) throws Exception {
		// TODO Auto-generated method stub
		Ctype ctype = ctypeMapper.selectByPrimaryKey(id);
		if (ctype == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 219,
					null));
		}
		CtypeCustom ctypeCustom = new CtypeCustom();
		// 将sysuser中数据设置到sysuserCustom
		BeanUtils.copyProperties(ctype, ctypeCustom);
		return ctypeCustom;
	}

	@Override
	public void deleteCtype(String id) throws Exception {
		// TODO Auto-generated method stub
		Ctype ctype = ctypeMapper.selectByPrimaryKey(id);
		if (ctype == null) {
			// BOM不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 216,
					null));
		}
		ctypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insertCtype(CtypeCustom ctypeCustom) throws Exception {
		// TODO Auto-generated method stub
		// 信息 合法性 校验
		// 1.unitname 不能 重复
		String cnum = ctypeCustom.getCnum();
		String cname = ctypeCustom.getCname();
		Ctype list = this.findCtypeByCnum(cnum);
		Ctype list2 = this.findCtypeByCname(cname);
		if (list != null && list2 != null) {
			// BOM重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 213,
					null));
		}
		// .. 其他合法性校验
		ctypeCustom.setId(UUIDBuild.getUUID());
		ctypeMapper.insert(ctypeCustom);
	}
}
