package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.TodayplanCustom;
import cn.cjpt.mes.pojo.vo.TodayplanCustomQueryVo;

/**
 * 
 * @author xyf
 *
 *今日 计划
 */
public interface TodayplanMapperCustom {
	// 查询 今日計劃
		public List<TodayplanCustom> findTodayPlanList(TodayplanCustomQueryVo todayplanCustomQueryVo)
				throws Exception;
}
