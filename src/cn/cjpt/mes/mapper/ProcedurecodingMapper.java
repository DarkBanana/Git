package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Procedurecoding;
import cn.cjpt.mes.pojo.po.ProcedurecodingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcedurecodingMapper {
	int countByExample(ProcedurecodingExample example);

	int deleteByExample(ProcedurecodingExample example);

	int deleteByPrimaryKey(String id);

	int insert(Procedurecoding record);

	int insertSelective(Procedurecoding record);

	List<Procedurecoding> selectByExample(ProcedurecodingExample example);

	Procedurecoding selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Procedurecoding record,
			@Param("example") ProcedurecodingExample example);

	int updateByExample(@Param("record") Procedurecoding record,
			@Param("example") ProcedurecodingExample example);

	int updateByPrimaryKeySelective(Procedurecoding record);

	int updateByPrimaryKey(Procedurecoding record);
}