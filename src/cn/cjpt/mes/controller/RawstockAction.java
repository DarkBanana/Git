package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.RawstocktypeMapper;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.RawstockExample;
import cn.cjpt.mes.pojo.po.RawstockExample.Criteria;
import cn.cjpt.mes.pojo.po.Rawstocktype;
import cn.cjpt.mes.pojo.po.RawstocktypeExample;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.RawstockCustom;
import cn.cjpt.mes.pojo.vo.RawstockQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.RawstockService;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/rawstock")
public class RawstockAction {
	@Autowired
	private RawstockService rawstockService;
	@Autowired
	private RawstocktypeMapper rawstocktypeMapper;

	// 跳转到物料的jsp

	@RequestMapping("/queryrawstock")
	public String queryorders(Model model) throws Exception {
		RawstocktypeExample example = new RawstocktypeExample();
		List<Rawstocktype> list = rawstocktypeMapper.selectByExample(example);
		ArrayList<String> list2 = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (!list2.contains(list.get(i).getRtname())) {
				list2.add(list.get(i).getRtname());
			}
		}
		List<Rawstocktype> list3= new ArrayList<Rawstocktype>();
		for (int i = 0; i < list2.size(); i++) {
			Rawstocktype rawstocktype = new Rawstocktype();
			rawstocktype.setRtname(list2.get(i));
			list3.add(rawstocktype);
		}
		model.addAttribute("list1", list3);
		return "/base/rawstock/queryrawstock";
	}

	// 自动填充数据
	@RequestMapping("/queryrawstock_result")
	public @ResponseBody
	DataGridResultInfo queryrawstock_result(RawstockCustom rawstockCustom,
			int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		RawstockQueryVo rawstockQueryVo = new RawstockQueryVo();
		
		// 非空校验
		rawstockQueryVo = rawstockQueryVo != null ? rawstockQueryVo
				: new RawstockQueryVo();
		rawstockQueryVo.setRawstockCustom(rawstockCustom);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);
		rawstockQueryVo.setPageQuery(pageQuery);
		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<RawstockCustom> list = rawstockService
				.findRawstockList(rawstockQueryVo);

		PageInfo<RawstockCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 入库页面跳转
	@RequestMapping("/addrawstock")
	public String addrawstock(Model model) throws Exception {
		RawstocktypeExample example = new RawstocktypeExample();
		List<Rawstocktype> list = rawstocktypeMapper.selectByExample(example);
		ArrayList<String> list2 = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (!list2.contains(list.get(i).getRtname())) {
				list2.add(list.get(i).getRtname());
			}
		}
		List<Rawstocktype> list3= new ArrayList<Rawstocktype>();
		for (int i = 0; i < list2.size(); i++) {
			Rawstocktype rawstocktype = new Rawstocktype();
			rawstocktype.setRtname(list2.get(i));
			list3.add(rawstocktype);
		}
		model.addAttribute("list", list3);
		return "/base/rawstock/addrawstock";
	}

	// 物料入库确认
	@RequestMapping("/addrawstocksubmit")
	public @ResponseBody
	SubmitResultInfo addrawstocksubmit(RawstockCustom custom)
			throws Exception {
		//RawstockCustom custom = rawstockQueryVo.getRawstockCustom();
		custom.setRname(custom.getName());
		custom.setRemark1(custom.getCode());
		if (custom.getRname().equals("") | custom.getPutstorenum().equals("")) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;

		} else {
			//rawstockService.insertRawstock(rawstockQueryVo.getRawstockCustom());
			rawstockService.insertRawstock(custom);
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}

	@RequestMapping("/outrawstock")
	public String outrawstock(Model model) throws Exception {
		RawstocktypeExample example = new RawstocktypeExample();
		List<Rawstocktype> list = rawstocktypeMapper.selectByExample(example);
		ArrayList<String> list2 = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (!list2.contains(list.get(i).getRtname())) {
				list2.add(list.get(i).getRtname());
			}
		}
		List<Rawstocktype> list3= new ArrayList<Rawstocktype>();
		for (int i = 0; i < list2.size(); i++) {
			Rawstocktype rawstocktype = new Rawstocktype();
			rawstocktype.setRtname(list2.get(i));
			list3.add(rawstocktype);
		}
		model.addAttribute("list", list3);
		return "/base/rawstock/outrawstock";
	}

	// 物料出库确认
	@RequestMapping("/outrawstocksubmit")
	public @ResponseBody
	SubmitResultInfo outrawstocksubmit(RawstockCustom custom)
			throws Exception {
		//RawstockCustom custom = rawstockQueryVo.getRawstockCustom();
		custom.setRname(custom.getName());
		custom.setRemark1(custom.getCode());
		if (custom.getRname().equals("") | custom.getOutstorenum().equals("")) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;

		} else {
			rawstockService.outRawstock(custom);
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}
	
	
	/**
	 * 获取 柜体 对应的 部件
	 */
	@RequestMapping("/querycode")
	public @ResponseBody
	List<Rawstocktype> querycomponent(@RequestBody String cname, Model model)
			throws Exception {
		
		RawstocktypeExample example = new RawstocktypeExample();
		cn.cjpt.mes.pojo.po.RawstocktypeExample.Criteria criteria = example.createCriteria();
		criteria.andRtnameEqualTo(cname);
		List<Rawstocktype> list = rawstocktypeMapper.selectByExample(example);
		return list;
	}
	
	
	/**
	 * 获取 柜体 对应的 部件
	 */
	@RequestMapping("/queryrttype")
	public @ResponseBody
	List<Rawstocktype> queryrttype(@RequestBody String name, Model model)
			throws Exception {
		
		RawstocktypeExample example = new RawstocktypeExample();
		cn.cjpt.mes.pojo.po.RawstocktypeExample.Criteria criteria = example.createCriteria();
		criteria.andRtnameEqualTo(name);
		List<Rawstocktype> list = rawstocktypeMapper.selectByExample(example);
		return list;
	}
	
	
}
