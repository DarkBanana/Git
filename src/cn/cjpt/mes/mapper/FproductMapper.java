package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Fproduct;
import cn.cjpt.mes.pojo.po.FproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FproductMapper {
	int countByExample(FproductExample example);

	int deleteByExample(FproductExample example);

	int deleteByPrimaryKey(String id);

	int insert(Fproduct record);

	int insertSelective(Fproduct record);

	List<Fproduct> selectByExample(FproductExample example);

	Fproduct selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Fproduct record,
			@Param("example") FproductExample example);

	int updateByExample(@Param("record") Fproduct record,
			@Param("example") FproductExample example);

	int updateByPrimaryKeySelective(Fproduct record);

	int updateByPrimaryKey(Fproduct record);
}