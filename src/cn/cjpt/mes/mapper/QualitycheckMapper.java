package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Qualitycheck;
import cn.cjpt.mes.pojo.po.QualitycheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QualitycheckMapper {
	int countByExample(QualitycheckExample example);

	int deleteByExample(QualitycheckExample example);

	int deleteByPrimaryKey(String id);

	int insert(Qualitycheck record);

	int insertSelective(Qualitycheck record);

	List<Qualitycheck> selectByExample(QualitycheckExample example);

	Qualitycheck selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Qualitycheck record,
			@Param("example") QualitycheckExample example);

	int updateByExample(@Param("record") Qualitycheck record,
			@Param("example") QualitycheckExample example);

	int updateByPrimaryKeySelective(Qualitycheck record);

	int updateByPrimaryKey(Qualitycheck record);
}