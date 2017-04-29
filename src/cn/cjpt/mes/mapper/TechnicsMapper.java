package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnicsMapper {
	int countByExample(TechnicsExample example);

	int deleteByExample(TechnicsExample example);

	int deleteByPrimaryKey(String id);

	int insert(Technics record);

	int insertSelective(Technics record);

	List<Technics> selectByExample(TechnicsExample example);

	Technics selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Technics record,
			@Param("example") TechnicsExample example);

	int updateByExample(@Param("record") Technics record,
			@Param("example") TechnicsExample example);

	int updateByPrimaryKeySelective(Technics record);

	int updateByPrimaryKey(Technics record);
}