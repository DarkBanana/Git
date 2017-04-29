package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Semiproducta;
import cn.cjpt.mes.pojo.po.SemiproductaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SemiproductaMapper {
	int countByExample(SemiproductaExample example);

	int deleteByExample(SemiproductaExample example);

	int deleteByPrimaryKey(String id);

	int insert(Semiproducta record);

	int insertSelective(Semiproducta record);

	List<Semiproducta> selectByExample(SemiproductaExample example);

	Semiproducta selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Semiproducta record,
			@Param("example") SemiproductaExample example);

	int updateByExample(@Param("record") Semiproducta record,
			@Param("example") SemiproductaExample example);

	int updateByPrimaryKeySelective(Semiproducta record);

	int updateByPrimaryKey(Semiproducta record);
}