package cn.cjpt.mes.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.RawstockCustomMapper;
import cn.cjpt.mes.mapper.RawstockMapper;
import cn.cjpt.mes.mapper.RawstocktypeMapper;
import cn.cjpt.mes.pojo.po.Rawstocktype;
import cn.cjpt.mes.pojo.po.RawstocktypeExample;
import cn.cjpt.mes.pojo.vo.RawstockCustom;
import cn.cjpt.mes.pojo.vo.RawstockQueryVo;
import cn.cjpt.mes.pojo.vo.RawstocktypeCustom;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.RawstockService;
import cn.cjpt.mes.service.RawstocktypeService;
import cn.cjpt.mes.util.UUIDBuild;

import com.github.pagehelper.PageHelper;

public class RawstockServiceImpl implements RawstockService {
	@Autowired
	private RawstockCustomMapper rawstockCustomMapper;
	@Autowired
	private RawstockMapper rawstockMapper;
	@Autowired
	private RawstocktypeMapper rawstocktypeMapper;
	@Autowired
	private RawstocktypeService rawstocktypeService;

	@Override
	public List<RawstockCustom> findRawstockList(RawstockQueryVo rawstockQueryVo) throws Exception {

		int page = rawstockQueryVo.getPageQuery().getPage();
		int rows = rawstockQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);
		// TODO Auto-generated method stub
		return rawstockCustomMapper.findRawstockList(rawstockQueryVo);
	}

	@Override
	public int findRawstockCount(RawstockQueryVo rawstockQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return rawstockCustomMapper.findRawstockCount(rawstockQueryVo);
	}

	@Override
	public void insertRawstock(RawstockCustom rawstockCustom) throws Exception {
		// TODO Auto-generated method stub
		String rname = rawstockCustom.getRname();
		RawstockQueryVo rawstockQueryVo = new RawstockQueryVo();
		RawstockCustom rawstockCustom2 = new RawstockCustom();
		rawstockCustom2.setRname(rname);
		rawstockCustom2.setRemark1(rawstockCustom.getRemark1());
		rawstockQueryVo.setRawstockCustom(rawstockCustom2);
		RawstocktypeExample example = new RawstocktypeExample();
		cn.cjpt.mes.pojo.po.RawstocktypeExample.Criteria criteria = example.createCriteria();
		criteria.andRtnameEqualTo(rname);
		criteria.andRemark1EqualTo(rawstockCustom.getRemark1());
		List<Rawstocktype> list2 = rawstocktypeMapper.selectByExample(example);
		String rtid = list2.get(0).getId();
		// 如果rname、rmodel都存在，则余量要增加
		List<RawstockCustom> list = rawstockCustomMapper.findRawstockByDate(rawstockQueryVo);
		if (list != null && list.size() > 0) {
			String remainnum = list.get(0).getRemainnum();
			int int1 = Integer.parseInt(remainnum);
			int int2 = Integer.parseInt(rawstockCustom.getPutstorenum());
			int totalRemainnum = int1 + int2;
			rawstockCustom.setId((UUIDBuild.getUUID()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String rtime1 = df.format(new Date());
			rawstockCustom.setRtime(rtime1);
			rawstockCustom.setRemainnum(totalRemainnum + "");
			rawstockCustom.setRtid(rtid);
			rawstockMapper.insert(rawstockCustom);
		} else {
			rawstockCustom.setId((UUIDBuild.getUUID()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String rtime1 = df.format(new Date());
			rawstockCustom.setRtime(rtime1);
			rawstockCustom.setRtid(rtid);
			rawstockCustom.setRemainnum(rawstockCustom.getPutstorenum());
			rawstockMapper.insert(rawstockCustom);
		}
	}

	@Override
	public void outRawstock(RawstockCustom rawstockCustom) throws Exception {
		// TODO Auto-generated method stub
		String rname = rawstockCustom.getRname();
		RawstockQueryVo rawstockQueryVo = new RawstockQueryVo();
		RawstockCustom rawstockCustom2 = new RawstockCustom();
		rawstockCustom2.setRname(rname);
		rawstockQueryVo.setRawstockCustom(rawstockCustom2);
		RawstocktypeExample example = new RawstocktypeExample();
		cn.cjpt.mes.pojo.po.RawstocktypeExample.Criteria criteria = example.createCriteria();
		criteria.andRtnameEqualTo(rname);
		criteria.andRemark1EqualTo(rawstockCustom.getRemark1());
		List<Rawstocktype> list2 = rawstocktypeMapper.selectByExample(example);
		String rtid = list2.get(0).getId();
		// 如果rname、rmodel都存在，则余量要增加
		List<RawstockCustom> list = rawstockCustomMapper.findRawstockByDate(rawstockQueryVo);
		if (list != null && list.size() > 0) {
			String remainnum = list.get(0).getRemainnum();
			int int1 = Integer.parseInt(remainnum);
			int int2 = Integer.parseInt(rawstockCustom.getOutstorenum());
			if (int1 >= int2) {
				int totalRemainnum = int1 - int2;
				rawstockCustom.setId((UUIDBuild.getUUID()));
				rawstockCustom.setRemainnum(totalRemainnum + "");
				rawstockCustom.setRtid(rtid);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String rtime1 = df.format(new Date());
				rawstockCustom.setRtime(rtime1);
				rawstockMapper.insert(rawstockCustom);
			} else {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 232, null));
			}
		} else {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 233, null));
		}
	}

	/**
	 * 查询 库存中 钢材 一共剩余 多少
	 */
	@Override
	public int findSteelPlateCount() throws Exception {
		// 查询 钢材的 种类 一共有几种
		List<RawstocktypeCustom> list = rawstocktypeService.findSteelPlateType();
		int count = 0;
		for (RawstocktypeCustom rawstocktypeCustom : list) {
			RawstockQueryVo rawstockQueryVo = new RawstockQueryVo();
			RawstockCustom rawstock = new RawstockCustom();
			rawstock.setRname(rawstocktypeCustom.getRtname());
			rawstock.setRemark1(rawstocktypeCustom.getRemark1());
			rawstockQueryVo.setRawstockCustom(rawstock);
			List<RawstockCustom> rawstocklist = rawstockCustomMapper.findRawstockByDate(rawstockQueryVo);
			if(rawstocklist.size()!=0){
				int i = Integer.valueOf(rawstocklist.get(0).getRemainnum());
				count = count + i;
			}
		}
		return count;
	}
}
