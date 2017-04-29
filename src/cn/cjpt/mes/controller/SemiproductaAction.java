package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.TechnicsMapper;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.po.Rawstocktype;
import cn.cjpt.mes.pojo.po.RawstocktypeExample;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.SemiproductaCustom;
import cn.cjpt.mes.pojo.vo.SemiproductaQueryVo;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.service.SemiproductaService;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/semiproducta")
public class SemiproductaAction {
	@Autowired
	private SemiproductaService semiproductaService;
	@Autowired
	private CtypeMapper ctypeMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@RequestMapping("/querysemiproducta")
	public String queryorders(Model model) throws Exception {
		CtypeExample example = new CtypeExample();
		List<Ctype> list = ctypeMapper.selectByExample(example);
		model.addAttribute("list1", list);
		return "/base/semiproducta/querysemiproducta";
	}

	// 自动填充数据
	@RequestMapping("/querysemiproducta_result")
	public @ResponseBody
	DataGridResultInfo querysemiproducta_result(
			SemiproductaCustom semiproductaCustom, int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		SemiproductaQueryVo semiproductaQueryVo = new SemiproductaQueryVo();
		// 非空校验
		semiproductaQueryVo = semiproductaQueryVo != null ? semiproductaQueryVo
				: new SemiproductaQueryVo();
		semiproductaQueryVo.setSemiproductaCustom(semiproductaCustom);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);
		semiproductaQueryVo.setPageQuery(pageQuery);
		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<SemiproductaCustom> list = semiproductaService
				.findSemiproductaList(semiproductaQueryVo);

		PageInfo<SemiproductaCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 自动入库方法
	public void addsemiproducta(String name, String ctypeid,String materialcoding) throws Exception {
		semiproductaService.insertSemiproduct(name, ctypeid,materialcoding);
	}

	// 自动出库方法
	public void outsemiproducta(String name, String outstorenum, String ctypeid,String remark1)
			throws Exception {
		semiproductaService.outSemiproduct(name, outstorenum, ctypeid,remark1);
	}

	/**
	 * 获取对应的 部件
	 */
	@RequestMapping("/querybycname")
	public @ResponseBody
	List<Materiel> querybycname(@RequestBody String name, Model model)
			throws Exception {
		CtypeExample ctypeExample = new CtypeExample();
		cn.cjpt.mes.pojo.po.CtypeExample.Criteria criteria = ctypeExample.createCriteria();
		criteria.andCnameEqualTo(name);
		List<Ctype> list2 = ctypeMapper.selectByExample(ctypeExample);
		String ctypid = list2.get(0).getId();
		MaterielExample example = new MaterielExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andMaterielmarkEqualTo("1");
		createCriteria.andMaterielmethodEqualTo("自产");
		createCriteria.andCtypeidEqualTo(ctypid);
		List<Materiel> list = materielMapper.selectByExample(example);
		return list;
	}

	
}
