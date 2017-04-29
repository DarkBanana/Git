package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.BarCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BarCodeMapper {
	int countByExample(BarCodeExample example);

	int deleteByExample(BarCodeExample example);

	int deleteByPrimaryKey(String id);

	int insert(BarCode record);

	int insertSelective(BarCode record);

	List<BarCode> selectByExample(BarCodeExample example);

	BarCode selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") BarCode record,
			@Param("example") BarCodeExample example);

	int updateByExample(@Param("record") BarCode record,
			@Param("example") BarCodeExample example);

	int updateByPrimaryKeySelective(BarCode record);

	int updateByPrimaryKey(BarCode record);
}