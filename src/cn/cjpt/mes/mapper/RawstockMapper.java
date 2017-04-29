package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Rawstock;
import cn.cjpt.mes.pojo.po.RawstockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RawstockMapper {
	int countByExample(RawstockExample example);

	int deleteByExample(RawstockExample example);

	int deleteByPrimaryKey(String id);

	int insert(Rawstock record);

	int insertSelective(Rawstock record);

	List<Rawstock> selectByExample(RawstockExample example);

	Rawstock selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Rawstock record,
			@Param("example") RawstockExample example);

	int updateByExample(@Param("record") Rawstock record,
			@Param("example") RawstockExample example);

	int updateByPrimaryKeySelective(Rawstock record);

	int updateByPrimaryKey(Rawstock record);
}