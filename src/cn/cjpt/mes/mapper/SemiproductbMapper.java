package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Semiproductb;
import cn.cjpt.mes.pojo.po.SemiproductbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SemiproductbMapper {
	int countByExample(SemiproductbExample example);

	int deleteByExample(SemiproductbExample example);

	int deleteByPrimaryKey(String id);

	int insert(Semiproductb record);

	int insertSelective(Semiproductb record);

	List<Semiproductb> selectByExample(SemiproductbExample example);

	Semiproductb selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Semiproductb record,
			@Param("example") SemiproductbExample example);

	int updateByExample(@Param("record") Semiproductb record,
			@Param("example") SemiproductbExample example);

	int updateByPrimaryKeySelective(Semiproductb record);

	int updateByPrimaryKey(Semiproductb record);
}