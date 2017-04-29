package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Orderdecompose;
import cn.cjpt.mes.pojo.po.OrderdecomposeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderdecomposeMapper {
	int countByExample(OrderdecomposeExample example);

	int deleteByExample(OrderdecomposeExample example);

	int deleteByPrimaryKey(String id);

	int insert(Orderdecompose record);

	int insertSelective(Orderdecompose record);

	List<Orderdecompose> selectByExample(OrderdecomposeExample example);

	Orderdecompose selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Orderdecompose record,
			@Param("example") OrderdecomposeExample example);

	int updateByExample(@Param("record") Orderdecompose record,
			@Param("example") OrderdecomposeExample example);

	int updateByPrimaryKeySelective(Orderdecompose record);

	int updateByPrimaryKey(Orderdecompose record);
}