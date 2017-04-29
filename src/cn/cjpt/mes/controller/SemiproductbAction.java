package cn.cjpt.mes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.BarCodeMapper;
import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.ProcedurecodingMapper;
import cn.cjpt.mes.mapper.SemiproductbMapper;
import cn.cjpt.mes.mapper.TechnicsMapper;
import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.BarCodeExample;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.Procedurecoding;
import cn.cjpt.mes.pojo.po.ProcedurecodingExample;
import cn.cjpt.mes.pojo.po.Semiproductb;
import cn.cjpt.mes.pojo.po.SemiproductbExample;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.RawstockCustom;
import cn.cjpt.mes.pojo.vo.RawstockQueryVo;
import cn.cjpt.mes.pojo.vo.SemiproductbCustom;
import cn.cjpt.mes.pojo.vo.SemiproductbQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.SemiproductbService;

@Controller
@RequestMapping("/semiproductb")
public class SemiproductbAction {
	@Autowired
	private SemiproductbService semiproductbService;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private CtypeMapper ctypeMapper;
	@Autowired
	private BarCodeMapper barCodeMapper;
	@Autowired
	private TechnicsMapper technicsMapper;
	@Autowired
	private ProcedurecodingMapper procedurecodingMapper;
	@Autowired
	private SemiproductbMapper semiproductbMapper;

	@RequestMapping("/querysemiproductb")
	public String queryorders(Model model) throws Exception {
		CtypeExample example = new CtypeExample();
		List<Ctype> list = ctypeMapper.selectByExample(example);
		model.addAttribute("list1", list);
		return "/base/semiproductb/querysemiproductb";
	}

	// 自动填充数据
	@RequestMapping("/querysemiproductb_result")
	public @ResponseBody DataGridResultInfo querysemiproductb_result(SemiproductbCustom semiproductbCustom, int page, // 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		SemiproductbQueryVo semiproductbQueryVo = new SemiproductbQueryVo();
		// 非空校验
		semiproductbQueryVo = semiproductbQueryVo != null ? semiproductbQueryVo : new SemiproductbQueryVo();
		semiproductbQueryVo.setSemiproductbCustom(semiproductbCustom);
		// 查询列表的总数
		int total = semiproductbService.findSemiproductbCount(semiproductbQueryVo);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);
		semiproductbQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<SemiproductbCustom> list = semiproductbService.findSemiproductbList(semiproductbQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 入库确认
	@RequestMapping("/addsemiproductbsubmit")
	public @ResponseBody SubmitResultInfo addsemiproductbsubmit(SemiproductbQueryVo semiproductbQueryVo)
			throws Exception {
		SemiproductbCustom custom = semiproductbQueryVo.getSemiproductbCustom();
		try {
			String[] materielcoding = custom.getMaterielcoding().split(",");
			String[] countnum = custom.getCountnum().split(",");
			String[] finishtime = custom.getFinishtime().split(",");
			String[] mname = custom.getMname().split(",");
			String[] operator = custom.getOperator().split(",");
			String[] pc = custom.getPc().split(",");
			SemiproductbCustom custom2 = new SemiproductbCustom();
			for (int i = 0; i < materielcoding.length; i++) {
				// 存放条码,用备用字段remark1存放条码
				custom2.setRemark1(materielcoding[i]);
				custom2.setPutstorenum(countnum[i]);
				MaterielExample materielExample = new MaterielExample();
				Criteria createCriteria = materielExample.createCriteria();
				createCriteria.andUnitnameEqualTo(mname[i]);
				List<Materiel> list = materielMapper.selectByExample(materielExample);
				custom2.setMid(list.get(0).getId());
				custom2.setMname(mname[i]);
				// 判断通过该条形码判断，如果已经存过就不再存了，没有存的就入库
				SemiproductbExample semiproductbExample = new SemiproductbExample();
				cn.cjpt.mes.pojo.po.SemiproductbExample.Criteria semiproductbCriteria = semiproductbExample
						.createCriteria();
				semiproductbCriteria.andRemark1EqualTo(materielcoding[i]);
				List<Semiproductb> semiproductbList = semiproductbMapper.selectByExample(semiproductbExample);
				if (semiproductbList == null || semiproductbList.size() <= 0) {
					semiproductbService.insertSemiproduct(custom2);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 922, null));
	}

	// 入库
	@RequestMapping("/addsemiproductb")
	@RequiresPermissions("fproduct:create")
	public String addsemiproductb(Model model) throws Exception {
		MaterielExample example = new MaterielExample();
		Criteria criteria = example.createCriteria();
		criteria.andMaterielmarkEqualTo("1");
		List<Materiel> list = materielMapper.selectByExample(example);
		ArrayList<Materiel> list2 = new ArrayList<Materiel>();
		for (Materiel materiel : list) {
			if (materiel.getMaterielmethod().equals("1") || materiel.getMaterielmethod().equals("自产")) {
				list2.add(materiel);
			}
		}
		model.addAttribute("list2", list2);
		CtypeExample example2 = new CtypeExample();
		List<Ctype> list3 = ctypeMapper.selectByExample(example2);
		model.addAttribute("list3", list3);
		return "/base/semiproductb/addsemiproductb";
	}

	// 出库
	@RequestMapping("/outsemiproductb")
	@RequiresPermissions("fproduct:delete")
	public String outsemiproductb(Model model) throws Exception {
		MaterielExample example = new MaterielExample();
		Criteria criteria = example.createCriteria();
		criteria.andMaterielmarkEqualTo("1");
		List<Materiel> list = materielMapper.selectByExample(example);
		ArrayList<Materiel> list2 = new ArrayList<Materiel>();
		for (Materiel materiel : list) {
			if (materiel.getMaterielmethod().equals("1") || materiel.getMaterielmethod().equals("自产")) {
				list2.add(materiel);
			}
		}
		model.addAttribute("list2", list2);
		CtypeExample example2 = new CtypeExample();
		List<Ctype> list3 = ctypeMapper.selectByExample(example2);
		model.addAttribute("list3", list3);
		return "/base/semiproductb/outsemiproductb";
	}

	// 出库确认
	@RequestMapping("/outsemiproductbsubmit")
	public @ResponseBody SubmitResultInfo outrawstocksubmit(SemiproductbQueryVo semiproductbQueryVo) throws Exception {
		SemiproductbCustom custom = semiproductbQueryVo.getSemiproductbCustom();
		try {
			String[] materielcoding = custom.getMaterielcoding().split(",");
			String[] countnum = custom.getCountnum().split(",");
			String[] finishtime = custom.getFinishtime().split(",");
			String[] mname = custom.getMname().split(",");
			String[] operator = custom.getOperator().split(",");
			String[] pc = custom.getPc().split(",");
			SemiproductbCustom custom2 = new SemiproductbCustom();
			for (int i = 0; i < materielcoding.length; i++) {
				// 存放条码,用备用字段remark1存放条码
				custom2.setRemark1(materielcoding[i]);
				custom2.setOutstorenum(countnum[i]);
				MaterielExample materielExample = new MaterielExample();
				Criteria createCriteria = materielExample.createCriteria();
				createCriteria.andUnitnameEqualTo(mname[i]);
				List<Materiel> list = materielMapper.selectByExample(materielExample);
				custom2.setMid(list.get(0).getId());
				custom2.setMname(mname[i]);
				// 判断通过该条形码判断，如果已经存过就不再存了，没有存的就入库
				SemiproductbExample semiproductbExample = new SemiproductbExample();
				cn.cjpt.mes.pojo.po.SemiproductbExample.Criteria semiproductbCriteria = semiproductbExample
						.createCriteria();
				semiproductbCriteria.andRemark1EqualTo(materielcoding[i]);
				semiproductbCriteria.andOutstorenumIsNotNull();
				List<Semiproductb> semiproductbList = semiproductbMapper.selectByExample(semiproductbExample);
				if (semiproductbList == null || semiproductbList.size() <= 0) {

					semiproductbService.outSemiproduct(custom2);

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 923, null));

	}

	// 根据编码实时获取名称
	@RequestMapping("/requirenamebycode")
	@ResponseBody
	public void requirenamebycode(String code, HttpServletResponse response) throws IOException {
		BarCodeExample example = new BarCodeExample();
		cn.cjpt.mes.pojo.po.BarCodeExample.Criteria criteria = example.createCriteria();
		criteria.andBarcodenumberEqualTo(code);
		List<BarCode> list = barCodeMapper.selectByExample(example);
		response.setContentType("text/html;charset=utf-8");
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getName());
			String str = null;
			if (list.get(0).getName() != null && !list.get(0).getName().equals("null")) {
				str = "<tr><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='semiproductbCustom.materielcoding' value="
						+ "\"" + list.get(0).getBarcodenumber() + "\"" + "/>" + "</td><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='semiproductbCustom.mname' value="
						+ "\"" + list.get(0).getName() + "\"" + "/>";
			} else {
				str = "<tr><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='semiproductbCustom.materielcoding' value="
						+ "\"" + list.get(0).getBarcodenumber() + "\"" + "/>" + "</td><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='semiproductbCustom.mname' value="
						+ "\"" + list.get(0).getCabinettype() + "\"" + "/>";
			}
			response.getWriter().println(str);
		} else {
		}
	}

	/**
	 * 获取对应的 部件
	 */
	@RequestMapping("/querybycname")
	public @ResponseBody List<Materiel> querybycname(@RequestBody String name, Model model) throws Exception {
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
