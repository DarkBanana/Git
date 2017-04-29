package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Todayplan;
import cn.cjpt.mes.pojo.po.TodayplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TodayplanMapper {
    int countByExample(TodayplanExample example);

    int deleteByExample(TodayplanExample example);

    int deleteByPrimaryKey(String id);

    int insert(Todayplan record);

    int insertSelective(Todayplan record);

    List<Todayplan> selectByExample(TodayplanExample example);

    Todayplan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Todayplan record, @Param("example") TodayplanExample example);

    int updateByExample(@Param("record") Todayplan record, @Param("example") TodayplanExample example);

    int updateByPrimaryKeySelective(Todayplan record);

    int updateByPrimaryKey(Todayplan record);
}