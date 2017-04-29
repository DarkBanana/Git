package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtypeMapper {
	int countByExample(CtypeExample example);

	int deleteByExample(CtypeExample example);

	int deleteByPrimaryKey(String id);

	int insert(Ctype record);

	int insertSelective(Ctype record);

	List<Ctype> selectByExample(CtypeExample example);

	Ctype selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Ctype record,
			@Param("example") CtypeExample example);

	int updateByExample(@Param("record") Ctype record,
			@Param("example") CtypeExample example);

	int updateByPrimaryKeySelective(Ctype record);

	int updateByPrimaryKey(Ctype record);
}