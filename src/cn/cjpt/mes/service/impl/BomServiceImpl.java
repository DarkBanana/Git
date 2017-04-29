package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.BomCustomMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.vo.BomCustom;
import cn.cjpt.mes.pojo.vo.BomQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.BomService;
import cn.cjpt.mes.util.UUIDBuild;

public class BomServiceImpl implements BomService {
	@Autowired
	private BomCustomMapper bomCustomMapper;
	@Autowired
	private MaterielMapper materielMapper;

	@Override
	public List<BomCustom> findBomList(BomQueryVo bomQueryVo) throws Exception {
		// TODO Auto-generated method stub
		int page = bomQueryVo.getPageQuery().getPage();
		int rows = bomQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);
		List<BomCustom> list = bomCustomMapper.findBomList(bomQueryVo);
		return list;
	}

	@Override
	public int findBomCount(BomQueryVo bomQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return bomCustomMapper.findBomCount(bomQueryVo);
	}

	@Override
	public BomCustom findBomById(String id) throws Exception {
		// TODO Auto-generated method stub
		// 从数据库查询BOM
		Materiel materiel = materielMapper.selectByPrimaryKey(id);
		if (materiel == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 219,
					null));
		}
		BomCustom bomCustom = new BomCustom();
		// 将sysuser中数据设置到sysuserCustom
		BeanUtils.copyProperties(materiel, bomCustom);
		return bomCustom;
	}

	@Override
	public void deleteBom(String id) throws Exception {
		// TODO Auto-generated method stub
		Materiel materiel = materielMapper.selectByPrimaryKey(id);
		if (materiel == null) {
			// BOM不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 231,
					null));
		}
		materielMapper.deleteByPrimaryKey(id);
	}

	// 确认添加bom
	@Override
	public void insertBom(BomCustom bomCustom) throws Exception {
		// TODO Auto-generated method stub
		// 信息 合法性 校验
		// 1.unitname 不能 重复
		String unitname = bomCustom.getUnitname();
		Materiel list = this.findBomByUnitname(unitname);
		if (list != null) {
			// BOM重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 213,
					null));
		}
		// .. 其他合法性校验
		bomCustom.setId(UUIDBuild.getUUID());
		//添加remak1用来排序
		BomQueryVo bomQueryVo = new BomQueryVo();
		BomCustom bomCustom2 = new BomCustom();
		bomCustom2.setMaterielmark(bomCustom.getMaterielmark());
		bomCustom2.setMaterielmethod(bomCustom.getMaterielmethod());
		bomQueryVo.setBomCustom(bomCustom2);
		List<BomCustom> bom = bomCustomMapper.findBomListMaxRemark1(bomQueryVo);
		String remark1;
		if (bom!=null||bom.size()>0) {
			 remark1 = bom.get(0).getRemark1();
		}else {
			 remark1 ="0";
		}
		
		int intRemark1 = Integer.parseInt(remark1)+1;
		bomCustom.setRemark1(intRemark1+"");
		materielMapper.insert(bomCustom);
	}

	/**
	 * 根据bom字段查询bom信息
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Materiel findBomByUnitname(String unitname) throws Exception {

		MaterielExample example = new MaterielExample();
		Criteria criteria = example.createCriteria();
		criteria.andMaterielnameEqualTo(unitname);
		// 设置查询条件，根据materielname查询
		List<Materiel> list = materielMapper.selectByExample(example);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 修改BOM
	 */
	@Override
	public void updateBom(String id, BomCustom bomCustom) throws Exception {
		// TODO Auto-generated method stub
		// 从数据库查询用户信息
		Materiel materiel = materielMapper.selectByPrimaryKey(id);
		if (bomCustom.getUnitname() != null
				&& !bomCustom.getUnitname().equals("")) {
			// 如果修改了bom名称
			if (!bomCustom.getUnitname().equals(materiel.getUnitname())) {
				// 修改后的Unitname不能重复
				Materiel materiel2 = this.findBomByUnitname(bomCustom
						.getUnitname());
				if (materiel2 != null) {
					ResultUtil.throwExcepion(ResultUtil.createFail(
							Config.MESSAGE, 213, null));
				}
			}
			materiel.setUnitname(bomCustom.getUnitname());
			materiel.setUnitcode(bomCustom.getUnitcode());
			materiel.setCtypeid(bomCustom.getCtypeid());
			materiel.setMaterielmethod(bomCustom.getMaterielmethod().equals(
					"外购") ? "0" : "1");
			materiel.setMaterielnumber(bomCustom.getMaterielnumber());
			materiel.setTasktime(bomCustom.getTasktime());
			materiel.setMaterielmark(bomCustom.getMaterielmark());
			materielMapper.updateByPrimaryKey(materiel);

		} else {
			// 必填的未填，则返回显示错误
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
		}
	}

}
