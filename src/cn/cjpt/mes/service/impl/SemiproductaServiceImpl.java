package cn.cjpt.mes.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.SemiproductaCustomMapper;
import cn.cjpt.mes.mapper.SemiproductaMapper;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.po.Semiproducta;
import cn.cjpt.mes.pojo.po.SemiproductaExample;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;
import cn.cjpt.mes.pojo.vo.SemiproductaCustom;
import cn.cjpt.mes.pojo.vo.SemiproductaQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.SemiproductaService;
import cn.cjpt.mes.util.UUIDBuild;

import com.github.pagehelper.PageHelper;

public class SemiproductaServiceImpl implements SemiproductaService {
	@Autowired
	private SemiproductaCustomMapper semiproductaCustomMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private SemiproductaMapper semiproductaMapper;

	@Override
	public int findSemiproductaCount(SemiproductaQueryVo semiproductaQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return semiproductaCustomMapper.findSemiproductaCount(semiproductaQueryVo);
	}

	@Override
	public List<SemiproductaCustom> findSemiproductaList(SemiproductaQueryVo semiproductaQueryVo) throws Exception {
		// TODO Auto-generated method stub
		int page = semiproductaQueryVo.getPageQuery().getPage();
		int rows = semiproductaQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return semiproductaCustomMapper.findSemiproductaList(semiproductaQueryVo);
	}

	/**
	 * 直接添加半成品A区
	 */
	@Override
	public void insertSemiproduct(String name, String ctypeid,String materielcoding) throws Exception {
		// TODO Auto-generated method stub
		MaterielExample example = new MaterielExample();
		Criteria criteria2 = example.createCriteria();
		criteria2.andUnitnameEqualTo(name);
		criteria2.andCtypeidEqualTo(ctypeid);
		List<Materiel> list3 = materielMapper.selectByExample(example);
		String mid = list3.get(0).getId();
		// 通过mid定位半成品A区
		SemiproductaExample example2 = new SemiproductaExample();
		cn.cjpt.mes.pojo.po.SemiproductaExample.Criteria criteria = example2.createCriteria();
		criteria.andMidEqualTo(mid);
		Semiproducta semiproducta = new Semiproducta();
		List<Semiproducta> list2 = semiproductaMapper.selectByExample(example2);
		SemiproductaQueryVo queryVo = new SemiproductaQueryVo();
		SemiproductaCustom custom = new SemiproductaCustom();
		custom.setMid(mid);
		queryVo.setSemiproductaCustom(custom);
		List<SemiproductaCustom> list4 = semiproductaCustomMapper.findSemiproductaByDate(queryVo);
		if (list4 != null && list4.size() > 0) {
			String remainnum = list4.get(0).getRemainnum();
			int int1 = Integer.parseInt(remainnum);
			int totalRemainnum = int1 + 1;
			semiproducta.setId((UUIDBuild.getUUID()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			String rtime1 = df.format(new Date());
			semiproducta.setRtime(rtime1);
			semiproducta.setRemainnum(totalRemainnum + "");
			semiproducta.setMid(mid);
			semiproducta.setPutstorenum("1");
			semiproducta.setRemark1(materielcoding);
			semiproductaMapper.insert(semiproducta);
		} else {
			semiproducta.setId((UUIDBuild.getUUID()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			String rtime1 = df.format(new Date());
			semiproducta.setRtime(rtime1);
			semiproducta.setRemainnum("1");
			semiproducta.setMid(mid);
			semiproducta.setPutstorenum("1");
			semiproducta.setRemark1(materielcoding);
			semiproductaMapper.insert(semiproducta);
		}
	}

	/**
	 * 半成品A区直接出货
	 */
	@Override
	public void outSemiproduct(String name, String outstorenum, String ctypeid,String remark1) throws Exception {
		// TODO Auto-generated method stub
		MaterielExample example = new MaterielExample();
		Criteria criteria2 = example.createCriteria();
		criteria2.andUnitnameEqualTo(name);
		criteria2.andCtypeidEqualTo(ctypeid);
		List<Materiel> list3 = materielMapper.selectByExample(example);
		String mid = list3.get(0).getId();
		// 通过mid定位半成品A区
		SemiproductaExample example2 = new SemiproductaExample();
		cn.cjpt.mes.pojo.po.SemiproductaExample.Criteria criteria = example2.createCriteria();
		criteria.andMidEqualTo(mid);
		Semiproducta semiproducta = new Semiproducta();
		List<Semiproducta> list2 = semiproductaMapper.selectByExample(example2);
		SemiproductaQueryVo queryVo = new SemiproductaQueryVo();
		SemiproductaCustom custom = new SemiproductaCustom();
		custom.setMid(mid);
		queryVo.setSemiproductaCustom(custom);
		List<SemiproductaCustom> list4 = semiproductaCustomMapper.findSemiproductaByDate(queryVo);
		if (list4 != null && list4.size() > 0 && list4.get(0).getRemainnum().compareTo("0") > 0) {
			String remainnum = list4.get(0).getRemainnum();
			int int1 = Integer.parseInt(remainnum);
			int int2 = Integer.parseInt(outstorenum);
			int totalRemainnum = int1 - int2;
			semiproducta.setId((UUIDBuild.getUUID()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			String rtime1 = df.format(new Date());
			semiproducta.setRtime(rtime1);
			semiproducta.setRemainnum(totalRemainnum + "");
			semiproducta.setMid(mid);
			semiproducta.setOutstorenum(outstorenum);
			semiproducta.setRemark1(remark1);
			semiproductaMapper.insert(semiproducta);
		} else {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 232, null));
		}
	}

	/**
	 * 查詢 半成品 A 区 所有 所有部件的总共余量
	 */
	@Override
	public int findSemiproductaByMaxDate() throws Exception {

		MaterielExample materielExample = new MaterielExample();
		MaterielExample.Criteria criteria = materielExample.createCriteria();
		List<Materiel> list = materielMapper.selectByExample(materielExample);
		int count = 0;
		for (Materiel materiel : list) {
			String materielId = materiel.getId();
			SemiproductaQueryVo semiproductaQueryVo = new SemiproductaQueryVo();
			SemiproductaCustom semiproductaCustom = new SemiproductaCustom();
			semiproductaCustom.setMid(materielId);
			semiproductaQueryVo.setSemiproductaCustom(semiproductaCustom);
			List<SemiproductaCustom> findSemiproductaByDate = semiproductaCustomMapper
					.findSemiproductaByDate(semiproductaQueryVo);
			String number = "0";
			if (findSemiproductaByDate.size() != 0) {
				number = findSemiproductaByDate.get(0).getRemainnum();
			}
			count = count + Integer.parseInt(number);
		}
		return count;
	}
}
