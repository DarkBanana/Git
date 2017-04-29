package cn.cjpt.mes.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.ProcedurecodingMapperCustom;
import cn.cjpt.mes.mapper.TodayplanMapperCustom;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.vo.MaterielCustom;
import cn.cjpt.mes.pojo.vo.OrderdecomposeCustom;
import cn.cjpt.mes.pojo.vo.OrderdecomposeQueryVo;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;
import cn.cjpt.mes.pojo.vo.TodayplanCustom;
import cn.cjpt.mes.pojo.vo.TodayplanCustomQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.MaterielService;
import cn.cjpt.mes.service.OrderdecomposeService;
import cn.cjpt.mes.service.ProcedurecodingService;
import cn.cjpt.mes.service.TechnicsService;
import cn.cjpt.mes.util.DateUtil;

public class MaterielServiceImpl implements MaterielService {
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private OrderdecomposeService orderdecomposeService;
	@Autowired
	private ProcedurecodingMapperCustom procedurecodingMapperCustom;
	@Autowired
	private TechnicsService technicsService;
	@Autowired
	private TodayplanMapperCustom todayplanMapperCustom;

	@Override
	public List<Materiel> findMaterielByCtypeId(String ctypeid)
			throws Exception {

		MaterielExample materielExample = new MaterielExample();
		materielExample.setOrderByClause("to_number(remark1) ASC");
		MaterielExample.Criteria criteria = materielExample.createCriteria();
		criteria.andCtypeidEqualTo(ctypeid);
		List<Materiel> list = materielMapper.selectByExample(materielExample);
		if (list == null) {
			// 没有找到 部件
			// 用户 不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 401,
					null));
			return null;
		}

		return list;

	}

	/**
	 * 根据 部件名称 查找部件信息
	 */
	@Override
	public List<Materiel> findMaterielByNnitname(String unitname)
			throws Exception {
		// TODO Auto-generated method stub
		MaterielExample materielExample = new MaterielExample();
		MaterielExample.Criteria criteria = materielExample.createCriteria();
		criteria.andUnitnameEqualTo(unitname);
		List<Materiel> list = materielMapper.selectByExample(materielExample);

		// 如果 没有 找到 部件 ，抛出异常信息
		if (list.size() == 0) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 401,
					null));
		}
		return list;
	}

	/**
	 * 获取 部件的 生产进度
	 */
	@Override
	public List<MaterielCustom> getPartsPlan() throws Exception {

		// 获取 订单分解中  已经发布的订单
		OrderdecomposeQueryVo orderdecomposeQueryVo = new OrderdecomposeQueryVo();
		OrderdecomposeCustom orderdecomposeCustom = new OrderdecomposeCustom();
		// 今天的时间
		orderdecomposeCustom.setNowTime(new DateUtil().getNowDateTime());
		orderdecomposeCustom.setRemark("已发布");
		orderdecomposeQueryVo.setOrderdecomposeCustom(orderdecomposeCustom);
		// ======== 1.查询 部件 总计数
		// 部件 计划数 信息
		List<OrderdecomposeCustom> orderdecomposeMaterialList = orderdecomposeService
				.findOrderdecomposeAndMaterial(orderdecomposeQueryVo);

		List<MaterielCustom> list = new ArrayList<>();

		for (OrderdecomposeCustom orderdecomposeCustom2 : orderdecomposeMaterialList) {
				//unitname 部件名字 
				String unitname = orderdecomposeCustom2.getUnitname();
				//System.out.println("unitname:"+unitname);
				String beginTime = "";
				String endTime = "";
				beginTime = orderdecomposeCustom2.getBegintime();
				endTime = orderdecomposeCustom2.getEndtime();
				// ========设置 总计划数
				MaterielCustom materielCustom = new MaterielCustom();
				materielCustom.setMaterielname(unitname);
				materielCustom
						.setPlanTotal(orderdecomposeCustom2.getOdnumber());
				materielCustom.setCtname(orderdecomposeCustom2.getUnitname());
				// ========总的已完成 数目 2017-01-15  修改
				// 如果是第一条工艺路线，部件经过第三个工位后则完成， 如果是第二条工艺路线，经过该工位则完成
				
				List<Materiel> findMaterielByNnitname = this.findMaterielByNnitname(unitname);
				Materiel materiel = findMaterielByNnitname.get(0);
				String materielId = materiel.getId(); //部件 id
				String line = "1"; // 默认 是第一条 工艺路线
				if(unitname.equals("机装")||unitname.equals("电装")||unitname.equals("总装")){
					line = "2";
					// 第二条工艺路线，查詢 各自的已完成   查询 在派工单 的周期里面 ，部件完成了多少个
					//先查询 部件的  id
					ProcedurecodingQueryVo procedurecodingQueryVo = new ProcedurecodingQueryVo();
					ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
					procedurecodingCustom.setBegintime(beginTime);
					procedurecodingCustom.setEndtime(endTime);
					procedurecodingCustom.setMaterielid(materielId);
					procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
					int finishCount = procedurecodingMapperCustom.findMaterialFinishCount(procedurecodingQueryVo);
					materielCustom.setCompletedNumber(finishCount+"");
				}else{
					ProcedurecodingQueryVo procedurecodingQueryVo = new ProcedurecodingQueryVo();
					ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
					procedurecodingCustom.setBegintime(beginTime);
					procedurecodingCustom.setEndtime(endTime);
					procedurecodingCustom.setTechnicsname("bend");
					procedurecodingCustom.setMaterielid(materielId);
					procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
					int finishCount = procedurecodingMapperCustom.findMaterialFinishCount(procedurecodingQueryVo);
					materielCustom.setCompletedNumber(finishCount+"");
				}
				// 3.=====查询 部件 今日的计划数 Todayplan  同一部件 有多條 记录则相加
				// 查询数据库
				TodayplanCustomQueryVo todayplanCustomQueryVo = new TodayplanCustomQueryVo();
				TodayplanCustom todayplanCustom = new TodayplanCustom();
				todayplanCustomQueryVo.setTodayplanCustom(todayplanCustom);
				String lines = "1";
				if(unitname.equals("机装")||unitname.equals("电装")||unitname.equals("总装")){
					lines = "2";
				}
				todayplanCustom.setLine(lines);
				todayplanCustom.setTime(new DateUtil().getNowDate());
				List<TodayplanCustom> findTodayPlanList = todayplanMapperCustom
						.findTodayPlanList(todayplanCustomQueryVo);
				int  todayPlanCount = 0;
				// 同一部件  多条记录 則相加
				for(TodayplanCustom todayplan:findTodayPlanList){
					if(todayplan.getName().equals(unitname)){
						todayPlanCount = todayPlanCount+Integer.parseInt(todayplan.getNum());
					}
				}
				materielCustom.setPlanToday(todayPlanCount+"");

				// =======4.查询 今日已经完成的
				String todayStartTime = new DateUtil().getTodayStartTime();
				String todayEndTime = new DateUtil().getTodayEndTime();
				if(unitname.equals("机装")||unitname.equals("电装")||unitname.equals("总装")){
					line = "2";
					// 第二条工艺路线，查詢 各自的已完成   查询 在派工单 的周期里面 ，部件完成了多少个
					//先查询 部件的  id
					ProcedurecodingQueryVo procedurecodingQueryVo = new ProcedurecodingQueryVo();
					ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
					procedurecodingCustom.setBeginTime(todayStartTime);
					procedurecodingCustom.setEndTime(todayEndTime);
					procedurecodingCustom.setMaterielid(materielId);
					procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
					int todayFinishCount = procedurecodingMapperCustom.findMaterialFinishCount(procedurecodingQueryVo);
					materielCustom.setCompletedToday(todayFinishCount+"");
				}else{
					ProcedurecodingQueryVo procedurecodingQueryVo = new ProcedurecodingQueryVo();
					ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
					procedurecodingCustom.setBeginTime(todayStartTime);
					procedurecodingCustom.setEndTime(todayEndTime);
					procedurecodingCustom.setTechnicsname("bend");
					procedurecodingCustom.setMaterielid(materielId);
					procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
					int  todayFinishCount= procedurecodingMapperCustom.findMaterialFinishCount(procedurecodingQueryVo);
					materielCustom.setCompletedToday(todayFinishCount+"");
				}
				list.add(materielCustom);
		}

		return list;
	}
}
