package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Publishworkorder;
import cn.cjpt.mes.pojo.po.PublishworkorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PublishworkorderMapper {
	int countByExample(PublishworkorderExample example);

	int deleteByExample(PublishworkorderExample example);

	int deleteByPrimaryKey(String id);

	int insert(Publishworkorder record);

	int insertSelective(Publishworkorder record);

	List<Publishworkorder> selectByExample(PublishworkorderExample example);

	Publishworkorder selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Publishworkorder record,
			@Param("example") PublishworkorderExample example);

	int updateByExample(@Param("record") Publishworkorder record,
			@Param("example") PublishworkorderExample example);

	int updateByPrimaryKeySelective(Publishworkorder record);

	int updateByPrimaryKey(Publishworkorder record);
}