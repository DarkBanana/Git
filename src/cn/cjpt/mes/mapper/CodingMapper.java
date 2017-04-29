package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Coding;
import cn.cjpt.mes.pojo.po.CodingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodingMapper {
	int countByExample(CodingExample example);

	int deleteByExample(CodingExample example);

	int deleteByPrimaryKey(String id);

	int insert(Coding record);

	int insertSelective(Coding record);

	List<Coding> selectByExample(CodingExample example);

	Coding selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Coding record,
			@Param("example") CodingExample example);

	int updateByExample(@Param("record") Coding record,
			@Param("example") CodingExample example);

	int updateByPrimaryKeySelective(Coding record);

	int updateByPrimaryKey(Coding record);
}