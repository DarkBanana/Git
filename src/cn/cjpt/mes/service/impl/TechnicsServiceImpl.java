package cn.cjpt.mes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.ProcedurecodingMapperCustom;
import cn.cjpt.mes.mapper.PublishworkorderCustomMapper;
import cn.cjpt.mes.mapper.TechnicsMapper;
import cn.cjpt.mes.mapper.TechnicsMapperCustom;
import cn.cjpt.mes.mapper.TodayplanMapperCustom;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import cn.cjpt.mes.pojo.po.Todayplan;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;
import cn.cjpt.mes.pojo.vo.PublishworkorderCustom;
import cn.cjpt.mes.pojo.vo.PublishworkorderQueryVo;
import cn.cjpt.mes.pojo.vo.TechnicsCustom;
import cn.cjpt.mes.pojo.vo.TechnicsQueryVo;
import cn.cjpt.mes.pojo.vo.TodayplanCustom;
import cn.cjpt.mes.pojo.vo.TodayplanCustomQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.TechnicsService;
import cn.cjpt.mes.service.WorkorderService;
import cn.cjpt.mes.util.DateUtil;

import com.github.pagehelper.PageHelper;

/**
 * 工艺 路线
 * 
 * @author yxf 2017年3月17日 下午2:31:55
 * 
 */
public class TechnicsServiceImpl implements TechnicsService {

	@Autowired
	private TechnicsMapperCustom technicsMapperCustom;
	@Autowired
	private PublishworkorderCustomMapper publishworkorderCustomMapper;
	@Autowired
	private ProcedurecodingMapperCustom procedurecodingMapperCustom;
	@Autowired
	private WorkorderService workorderService;
	@Autowired
	private TechnicsMapper technicsMapper;
	@Autowired
	private TodayplanMapperCustom todayplanMapperCustom;

	/**
	 * 查询 工艺 路线 列表
	 */
	public List<TechnicsCustom> findTechnicsList(TechnicsQueryVo technicsQueryVo)
			throws Exception {
		System.out.println("tech:" + technicsQueryVo.getPageQuery());
		if (technicsQueryVo.getPageQuery() != null) {
			// PageHelper 实现 分页
			PageHelper.startPage(technicsQueryVo.getPageQuery().getPage(),
					technicsQueryVo.getPageQuery().getRows());
		}
		return technicsMapperCustom.findTechnicsList(technicsQueryVo);
	}

	/**
	 * 查询 工艺（工位） 对应得 加工数量。生产计划
	 */
	@Override
	public List<TechnicsCustom> findTechnicsProductionPlan() throws Exception {
		// 当前时间
		String nowTime = DateUtil.getNowDateTime();
		// 总计划数
		int totalCount = 0;
		// 派工单 开始时间
		String beginTime = null;
		// 派工单 结束时间
		String endtime = null;
		// 查询 所有的 工艺路线
		List<TechnicsCustom> findTechnicsList = technicsMapperCustom
				.findTechnicsList(null);
		// 判断 工艺路线 是否为空
		if (findTechnicsList.size() == 0) {
			// 抛出异常，没有找到 工艺路线
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 225,
					null));
		}
		// 查询 每一个 工位 对应的 四条数据
		List<TechnicsCustom> technicsList = new ArrayList<TechnicsCustom>();
		for (TechnicsCustom technics : findTechnicsList) {

			// =========1.查询 总 计划数
			// 创建 TechnicsCustom
			TechnicsCustom technicsCustom = new TechnicsCustom();
			String technicsId = technics.getId();
			technicsCustom.setTcname(technics.getTcname() + "区");
			// 查询 派工单 表，得到 该 时间 段 要加工的 总计划数
			PublishworkorderQueryVo publishworkorderQueryVo = new PublishworkorderQueryVo();
			PublishworkorderCustom publishworkorderCustom = new PublishworkorderCustom();
			publishworkorderCustom.setTechnicsid(technicsId);
			publishworkorderCustom.setNowTime(nowTime);
			publishworkorderQueryVo
					.setPublishworkorderCustom(publishworkorderCustom);
			// 每个 岗位的 总计划数
			totalCount = workorderService
					.findTechnicsCountByDateAndTechnicsId(publishworkorderQueryVo);
			// 设置 工位的总计划数
			technicsCustom.setPlanTotal(totalCount + "");
			technicsCustom.setTechnicsname(technics.getTechnicsname());
			// =========2.查询 总 的已经完成的
			// 查询 procedurecoding 表
			String technicsname = technics.getTechnicsname();
			// 获取当前 工艺的 编号
			String line = technics.getTechnicsmark();

			System.out.println("===当前工位：" + technicsname + "======");
			// 根据 当前 日期 查找 对应的 派工单
			PublishworkorderQueryVo publishworkorderQueryVo2 = new PublishworkorderQueryVo();
			PublishworkorderCustom publishworkorderCustom2 = new PublishworkorderCustom();
			publishworkorderCustom2.setNowTime(nowTime);
			publishworkorderQueryVo2
					.setPublishworkorderCustom(publishworkorderCustom2);

			List<PublishworkorderCustom> finPublishworkorderListByDate = workorderService
					.finPublishworkorderListByDate(publishworkorderQueryVo2);
			int finishedSum = 0;
			// 获取 派工单 对应的 时间区间
			if (finPublishworkorderListByDate.size() != 0) {

				List<String> beginTimeList = new ArrayList<>();
				List<String> endTimeList = new ArrayList<>();
				for (PublishworkorderCustom publishworkorder : finPublishworkorderListByDate) {
					// 如果 有 多个 派工单，求 派工单 日期区间的并集
					beginTimeList.add(publishworkorder.getBegintime());
					endTimeList.add(publishworkorder.getEndtime());
					// 求出 最小时间 和 最大时间
					beginTime = new DateUtil().getMinDate(beginTimeList);
					endtime = new DateUtil().getMaxDate(endTimeList);
				}
				// 然后 根据 时间 区间 去查询 该工位 完成的个数
				ProcedurecodingQueryVo procedurecodingQueryVo = new ProcedurecodingQueryVo();
				ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
				procedurecodingCustom.setBeginTime(beginTime);
				procedurecodingCustom.setEndTime(endtime);
				procedurecodingCustom.setTechnicsname(technicsname);
				procedurecodingQueryVo
						.setProcedurecodingCustom(procedurecodingCustom);
				// 已完成 数目
				finishedSum = procedurecodingMapperCustom
						.findProcedurecodingCount(procedurecodingQueryVo);
			}
			technicsCustom.setCompletedNumber(finishedSum + "");
			// =========3.查询 今日 计划数 读TodayPlan表
			// 今日计划数
			if (line.equals("1")) {
				TodayplanCustomQueryVo todayplanCustomQueryVo = new TodayplanCustomQueryVo();
				TodayplanCustom todayplanCustom = new TodayplanCustom();
				todayplanCustom.setLine(line);
				todayplanCustom.setTime(new DateUtil().getNowDate());
				todayplanCustomQueryVo.setTodayplanCustom(todayplanCustom);
				List<TodayplanCustom> findTodayPlanList = todayplanMapperCustom
						.findTodayPlanList(todayplanCustomQueryVo);

				String todayPlanCount = "0";
				if (findTodayPlanList != null) {
					if (findTodayPlanList.size() >= 1) {
						int count = 0;
						// 查询到有多条记录
						for (TodayplanCustom todayplan : findTodayPlanList) {
							String number = todayplan.getNum();
							count = count + Integer.parseInt(number);
						}
						todayPlanCount = count + "";
					} else {
						// 只有一条记录的时候
						if (findTodayPlanList.size() == 1
								&& findTodayPlanList.get(0) != null) {
							todayPlanCount = findTodayPlanList.get(0).getNum();
						}
					}
				}
				technicsCustom.setPlanToday(todayPlanCount);
			}
			if (line.equals("2")) {
				// 查询每一个工位的
				String tcname = technics.getTcname();
				TodayplanCustomQueryVo todayplanCustomQueryVo = new TodayplanCustomQueryVo();
				TodayplanCustom todayplanCustom = new TodayplanCustom();
				todayplanCustom.setLine(line);
				todayplanCustom.setName(tcname);
				todayplanCustom.setTime(new DateUtil().getNowDate());
				todayplanCustomQueryVo.setTodayplanCustom(todayplanCustom);
				List<TodayplanCustom> findTodayPlanList = todayplanMapperCustom
						.findTodayPlanList(todayplanCustomQueryVo);

				String todayPlanCount = "0";
				if (findTodayPlanList != null) {
					if (findTodayPlanList.size() >= 1) {
						int count = 0;
						// 查询到有多条记录
						for (TodayplanCustom todayplan : findTodayPlanList) {
							String number = todayplan.getNum();
							count = count + Integer.parseInt(number);
						}
						todayPlanCount = count + "";
					} else {
						// 只有一条记录的时候
						if (findTodayPlanList.size() == 1
								&& findTodayPlanList.get(0) != null) {
							todayPlanCount = findTodayPlanList.get(0).getNum();
						}
					}
				}
				technicsCustom.setPlanToday(todayPlanCount);
			}
			// =========3.查询 今日 已完成的
			String todayStartTime = new DateUtil().getTodayStartTime();
			String todayEndTime = new DateUtil().getTodayEndTime();
			ProcedurecodingQueryVo queryVo = new ProcedurecodingQueryVo();
			ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
			procedurecodingCustom.setBeginTime(todayStartTime);
			procedurecodingCustom.setEndTime(todayEndTime);
			procedurecodingCustom.setTechnicsname(technicsname);
			queryVo.setProcedurecodingCustom(procedurecodingCustom);
			// 今日已完成的
			int todayFinished = procedurecodingMapperCustom
					.findProcedurecodingCount(queryVo);
			technicsCustom.setCompletedToday(todayFinished + "");

			// 将封装的 数据 放到 list中去
			technicsList.add(technicsCustom);
		}

		return technicsList;
	}

	@Override
	public Technics findTechnicsByTcname(String tcname) throws Exception {

		TechnicsExample technicsExample = new TechnicsExample();
		TechnicsExample.Criteria criteria = technicsExample.createCriteria();
		criteria.andTechnicsnameEqualTo(tcname);
		List<Technics> list = technicsMapper.selectByExample(technicsExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Technics findTechnicsByUnitName(String unitName) throws Exception {
		// TODO Auto-generated method stub
		TechnicsExample technicsExample = new TechnicsExample();
		TechnicsExample.Criteria criteria = technicsExample.createCriteria();
		criteria.andTechnicsnameEqualTo(unitName);
		List<Technics> list = technicsMapper.selectByExample(technicsExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}
}
