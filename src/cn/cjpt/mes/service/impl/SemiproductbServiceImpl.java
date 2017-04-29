package cn.cjpt.mes.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.SemiproductaCustomMapper;
import cn.cjpt.mes.mapper.SemiproductbCustomMapper;
import cn.cjpt.mes.mapper.SemiproductbMapper;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.po.Semiproductb;
import cn.cjpt.mes.pojo.po.SemiproductbExample;
import cn.cjpt.mes.pojo.vo.SemiproductaCustom;
import cn.cjpt.mes.pojo.vo.SemiproductaQueryVo;
import cn.cjpt.mes.pojo.vo.SemiproductbCustom;
import cn.cjpt.mes.pojo.vo.SemiproductbQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.SemiproductaService;
import cn.cjpt.mes.service.SemiproductbService;
import cn.cjpt.mes.util.UUIDBuild;

import com.github.pagehelper.PageHelper;

public class SemiproductbServiceImpl implements SemiproductbService {
	@Autowired
	private SemiproductbCustomMapper semiproductbCustomMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private SemiproductbMapper SemiproductbMapper;
	@Autowired
	private SemiproductaCustomMapper semiproductaCustomMapper;
	@Autowired
	private SemiproductaService semiproductaService;

	@Override
	public int findSemiproductbCount(SemiproductbQueryVo SemiproductbQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return semiproductbCustomMapper.findSemiproductbCount(SemiproductbQueryVo);
	}

	@Override
	public List<SemiproductbCustom> findSemiproductbList(SemiproductbQueryVo SemiproductbQueryVo) throws Exception {
		// TODO Auto-generated method stub
		int page = SemiproductbQueryVo.getPageQuery().getPage();
		int rows = SemiproductbQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return semiproductbCustomMapper.findSemiproductbList(SemiproductbQueryVo);
	}

	/**
	 * 半成品B区 出库确认
	 */
	@Override
	public void outSemiproduct(SemiproductbCustom semiproductbCustom) throws Exception {
		// TODO Auto-generated method stub
		MaterielExample example = new MaterielExample();
		Criteria criteria2 = example.createCriteria();
		criteria2.andUnitnameEqualTo(semiproductbCustom.getMname());
		List<Materiel> list3 = materielMapper.selectByExample(example);
		String mid = list3.get(0).getId();
		// 通过mid定位半成品B区
		SemiproductbExample example2 = new SemiproductbExample();
		cn.cjpt.mes.pojo.po.SemiproductbExample.Criteria criteria = example2.createCriteria();
		criteria.andMidEqualTo(mid);
		Semiproductb Semiproductb = new Semiproductb();
		List<Semiproductb> list2 = SemiproductbMapper.selectByExample(example2);
		SemiproductbQueryVo queryVo = new SemiproductbQueryVo();
		SemiproductbCustom custom = new SemiproductbCustom();
		custom.setMid(mid);
		queryVo.setSemiproductbCustom(custom);
		List<SemiproductbCustom> list4 = semiproductbCustomMapper.findSemiproductbByDate(queryVo);
		int int3 = Integer.parseInt(list4.get(0).getRemainnum());
		int int4 = Integer.parseInt(semiproductbCustom.getOutstorenum());
		if (list4 != null && list4.size() > 0 && int3 >= int4) {
			String remainnum = list4.get(0).getRemainnum();
			int int1 = Integer.parseInt(remainnum);
			int int2 = Integer.parseInt(semiproductbCustom.getOutstorenum());
			int totalRemainnum = int1 - int2;
			Semiproductb.setId((UUIDBuild.getUUID()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			String rtime1 = df.format(new Date());
			Semiproductb.setRtime(rtime1);
			Semiproductb.setRemainnum(totalRemainnum + "");
			Semiproductb.setMid(mid);
			Semiproductb.setOutstorenum(semiproductbCustom.getOutstorenum());
			Semiproductb.setRemark1(semiproductbCustom.getRemark1());
			SemiproductbMapper.insert(Semiproductb);
		} else {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 232, null));
		}
	}

	// 入库确认
	@Override
	public void insertSemiproduct(SemiproductbCustom semiproductbCustom) throws Exception {
		// TODO Auto-generated method stub
		MaterielExample example = new MaterielExample();
		Criteria criteria2 = example.createCriteria();
		criteria2.andUnitnameEqualTo(semiproductbCustom.getMname());
		List<Materiel> list3 = materielMapper.selectByExample(example);
		String mid = list3.get(0).getId();
		// 通过mid定位半成品B区
		SemiproductbExample example2 = new SemiproductbExample();
		cn.cjpt.mes.pojo.po.SemiproductbExample.Criteria criteria = example2.createCriteria();
		criteria.andMidEqualTo(mid);
		Semiproductb Semiproductb = new Semiproductb();
		List<Semiproductb> list2 = SemiproductbMapper.selectByExample(example2);
		SemiproductbQueryVo queryVo = new SemiproductbQueryVo();
		SemiproductbCustom custom = new SemiproductbCustom();
		custom.setMid(mid);
		queryVo.setSemiproductbCustom(custom);
		int int2 = Integer.parseInt(semiproductbCustom.getPutstorenum());

		// 判断B区入库数量，在A区中是否充足
		SemiproductaQueryVo queryVo1 = new SemiproductaQueryVo();
		SemiproductaCustom custom1 = new SemiproductaCustom();
		custom1.setMid(mid);
		queryVo1.setSemiproductaCustom(custom1);
		List<SemiproductaCustom> list = semiproductaCustomMapper.findSemiproductaByDate(queryVo1);
		List<SemiproductbCustom> list4 = semiproductbCustomMapper.findSemiproductbByDate(queryVo);
		// 查找mid所属的ctypeid
		if (Integer.parseInt(list.get(0).getRemainnum()) >= int2) {
			if (list4 != null && list4.size() > 0) {
				String remainnum = list4.get(0).getRemainnum();
				int int1 = Integer.parseInt(remainnum);
				int totalRemainnum = int1 + int2;
				Semiproductb.setId((UUIDBuild.getUUID()));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
				String rtime1 = df.format(new Date());
				Semiproductb.setRtime(rtime1);
				Semiproductb.setRemainnum(totalRemainnum + "");
				Semiproductb.setMid(mid);
				Semiproductb.setPutstorenum(int2 + "");
				Semiproductb.setRemark1(semiproductbCustom.getRemark1());
				SemiproductbMapper.insert(Semiproductb);
				String string1 = semiproductbCustom.getMname();
				String string2 = semiproductbCustom.getPutstorenum();
				// 拿到CtypeID
				Materiel materiel = materielMapper.selectByPrimaryKey(mid);
				String ctypeid = materiel.getCtypeid();
				semiproductaService.outSemiproduct(string1, string2, ctypeid,semiproductbCustom.getRemark1());
			} else {
				Semiproductb.setId((UUIDBuild.getUUID()));
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
				String rtime1 = df.format(new Date());
				Semiproductb.setRtime(rtime1);
				Semiproductb.setRemainnum(int2 + "");
				Semiproductb.setMid(mid);
				Semiproductb.setPutstorenum(int2 + "");
				Semiproductb.setRemark1(semiproductbCustom.getRemark1());
				SemiproductbMapper.insert(Semiproductb);
				String string1 = semiproductbCustom.getMname();
				String string2 = semiproductbCustom.getPutstorenum();
				// 拿到CtypeID
				Materiel materiel = materielMapper.selectByPrimaryKey(mid);
				String ctypeid = materiel.getCtypeid();
				semiproductaService.outSemiproduct(string1, string2, ctypeid,semiproductbCustom.getRemark1());
			}
		} else {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 234, null));
		}

	}

	@Override
	public int findSemiproductbByMaxDate() throws Exception {
		MaterielExample materielExample = new MaterielExample();
		MaterielExample.Criteria criteria = materielExample.createCriteria();
		List<Materiel> list = materielMapper.selectByExample(materielExample);
		int count = 0;
		for (Materiel materiel : list) {
			String materielId = materiel.getId();
			SemiproductbQueryVo semiproductbQueryVo = new SemiproductbQueryVo();
			SemiproductbCustom semiproductbCustom = new SemiproductbCustom();
			semiproductbCustom.setMid(materielId);
			semiproductbQueryVo.setSemiproductbCustom(semiproductbCustom);
			List<SemiproductbCustom> findSemiproductbByDate = semiproductbCustomMapper
					.findSemiproductbByDate(semiproductbQueryVo);
			String number = "0";
			if (findSemiproductbByDate.size() != 0) {
				number = findSemiproductbByDate.get(0).getRemainnum();
			}
			count = count + Integer.parseInt(number);
		}
		return count;
	}
}
