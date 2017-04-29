package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterielMapper {
	int countByExample(MaterielExample example);

	int deleteByExample(MaterielExample example);

	int deleteByPrimaryKey(String id);

	int insert(Materiel record);

	int insertSelective(Materiel record);

	List<Materiel> selectByExample(MaterielExample example);

	Materiel selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Materiel record,
			@Param("example") MaterielExample example);

	int updateByExample(@Param("record") Materiel record,
			@Param("example") MaterielExample example);

	int updateByPrimaryKeySelective(Materiel record);

	int updateByPrimaryKey(Materiel record);
}