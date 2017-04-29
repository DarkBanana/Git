package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.CtypeExample.Criteria;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.vo.BomCustom;
import cn.cjpt.mes.pojo.vo.BomQueryVo;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.BomService;

/**
 * BOM管理
 * 
 * 
 */

@Controller
@RequestMapping("/bom")
public class BomAction {

	@Autowired
	private BomService bomService;
	@Autowired
	private CtypeMapper ctypeMapper;
	@Autowired
	private MaterielMapper materielMapper;

	/**
	 * 查询订单页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querybom")
	public String queryorders() throws Exception {

		return "/base/materielCode/querybom";
	}

	/**
	 * 订单查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querybom_result")
	public @ResponseBody
	DataGridResultInfo querybom_result(BomQueryVo bomQueryVo, int page, // 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		bomQueryVo = bomQueryVo != null ? bomQueryVo : new BomQueryVo();

		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		bomQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<BomCustom> list = bomService.findBomList(bomQueryVo);

		PageInfo<BomCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	/**
	 * 修改BOM信息 页面 数据显示
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editbom")
	@RequiresPermissions("bom:update")
	public String editsysuser(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		BomCustom bomCustom = bomService.findBomById(id);
		// 将数据写到 model 中去
		model.addAttribute("bomCustom", bomCustom);
		// 获取到柜体型号名称
		CtypeExample example = new CtypeExample();
		String typeid = bomCustom.getCtypeid();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(typeid);
		List<Ctype> ctList2 = ctypeMapper.selectByExample(example);
		model.addAttribute("ctList2", ctList2.get(0));
		// 将柜体类型数据放到model中
		CtypeExample example2 = new CtypeExample();
		List<Ctype> ctList = ctypeMapper.selectByExample(example2);
		ArrayList<Ctype> arrayList = new ArrayList<Ctype>();
		for (Ctype ctype : ctList) {
			if (!ctype.getCname().equals(ctList2.get(0).getCname())) {
				arrayList.add(ctype);
			}

		}
		model.addAttribute("ctList", arrayList);
		// 将自产外购封装到model
		MaterielExample example3 = new MaterielExample();
		cn.cjpt.mes.pojo.po.MaterielExample.Criteria criteria3 = example3
				.createCriteria();
		criteria3.andIdEqualTo(id);
		List<Materiel> list = materielMapper.selectByExample(example3);
		if (list.get(0).getMaterielmethod().equals("0")
				| list.get(0).getMaterielmethod().equals("外购")) {
			model.addAttribute("list", "外购");
			model.addAttribute("list1", "自产");
			model.addAttribute("list00", "0");
			model.addAttribute("list11", "1");
		} else {
			model.addAttribute("list", "自产");
			model.addAttribute("list1", "外购");
			model.addAttribute("list00", "1");
			model.addAttribute("list11", "0");
		}
		// 将生产线放到model中
		if (list.get(0).getMaterielmark().equals("1")) {
			model.addAttribute("list2", "钣金生产线（产线一）");
			model.addAttribute("list3", "装配生产线（产线二）");
			model.addAttribute("list22", "1");
			model.addAttribute("list33", "2");
		} else {
			model.addAttribute("list2", "装配生产线（产线二）");
			model.addAttribute("list3", "钣金生产线（产线一）");
			model.addAttribute("list22", "2");
			model.addAttribute("list33", "1");
		}
		return "/base/materielCode/editbom";
	}

	// 添加bom
	@RequestMapping("/addbom")
	@RequiresPermissions("bom:create")
	public String addbom(Model model) throws Exception {
		CtypeExample example = new CtypeExample();
		Criteria criteria = example.createCriteria();
		List<Ctype> ctList = ctypeMapper.selectByExample(example);
		model.addAttribute("ctList", ctList);
		return "/base/materielCode/addbom";
	}

	// 删除BOM
	@RequestMapping("/deletebom")
	@RequiresPermissions("bom:delete")
	public @ResponseBody
	SubmitResultInfo deletebom(String id) throws Exception {

		// 调用service
		bomService.deleteBom(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	// 添加提交
	@RequestMapping("/addbomsubmit")
	@RequiresPermissions("bom:create")
	public @ResponseBody
	SubmitResultInfo addsysusersubmit(BomQueryVo bomQueryVo) throws Exception {
		BomCustom bomCustom = bomQueryVo.getBomCustom();
		if (bomCustom.getUnitname().equals("")
				| bomCustom.getMaterielmethod().equals("")
				| bomCustom.getMaterielnumber().equals("")
				| bomCustom.getTasktime().equals("")
				| bomCustom.getCtypeid().equals("")
				| bomCustom.getMaterielmark().equals("")) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;
		} else {
			bomService.insertBom(bomQueryVo.getBomCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}

	/**
	 * 修改BOM数据提交
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editbomsubmit")
	@RequiresPermissions("bom:update")
	public @ResponseBody
	SubmitResultInfo editsysusersubmit(String id, BomQueryVo bomQueryVo)
			throws Exception {
		// 调用 service 方法，更新数据
		this.bomService.updateBom(id, bomQueryVo.getBomCustom());

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}
}
