package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Rawstocktype;
import cn.cjpt.mes.pojo.po.RawstocktypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RawstocktypeMapper {
	int countByExample(RawstocktypeExample example);

	int deleteByExample(RawstocktypeExample example);

	int deleteByPrimaryKey(String id);

	int insert(Rawstocktype record);

	int insertSelective(Rawstocktype record);

	List<Rawstocktype> selectByExample(RawstocktypeExample example);

	Rawstocktype selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Rawstocktype record,
			@Param("example") RawstocktypeExample example);

	int updateByExample(@Param("record") Rawstocktype record,
			@Param("example") RawstocktypeExample example);

	int updateByPrimaryKeySelective(Rawstocktype record);

	int updateByPrimaryKey(Rawstocktype record);
}