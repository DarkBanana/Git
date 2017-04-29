package cn.cjpt.mes.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.BarCodeMapper;
import cn.cjpt.mes.mapper.ProcedurecodingMapper;
import cn.cjpt.mes.mapper.TechnicsMapper;
import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.BarCodeExample;
import cn.cjpt.mes.pojo.po.BarCodeExample.Criteria;
import cn.cjpt.mes.pojo.po.Procedurecoding;
import cn.cjpt.mes.pojo.po.ProcedurecodingExample;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import cn.cjpt.mes.pojo.vo.ActiveUser;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.ProcedurecodingService;

/**
 * 
 * @author qiaorenjie
 * 
 */

@Controller
@RequestMapping("/procedurecoding")
public class ProcedurecodingAction {

	@Autowired
	private ProcedurecodingService procedurecodingService;
	@Autowired
	private BarCodeMapper barCodeMapper;
	@Autowired
	private TechnicsMapper technicsMapper;
	@Autowired
	private ProcedurecodingMapper procedurecodingMapper;

	Procedurecoding procedurecoding = null;

	/**
	 * 查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryprocedurecoding")
	public String queryprocedurecoding(String pc, Model model) throws Exception {
		procedurecoding = new Procedurecoding();
		procedurecoding.setPc(pc);
		model.addAttribute("pc", pc);
		if (pc.equals("cut")) {
			return "/base/procedurecoding/queryprocedurecodingcut";
		} else if (pc.equals("punch")) {
			return "/base/procedurecoding/queryprocedurecodingpunch";
		} else if (pc.equals("bend")) {
			return "/base/procedurecoding/queryprocedurecodingbend";
		} else if (pc.equals("mfitting")) {
			return "/base/procedurecoding/queryprocedurecodingmfitting";
		} else if (pc.equals("efitting")) {
			return "/base/procedurecoding/queryprocedurecodingefitting";
		} else if (pc.equals("ffitting")) {
			return "/base/procedurecoding/queryprocedurecodingffitting";
		} else {
			return null;
		}
	}

	/**
	 * 查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryprocedurecoding_result")
	public @ResponseBody
	DataGridResultInfo queryprocedurecoding_result(
			ProcedurecodingQueryVo procedurecodingQueryVo, int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		String pc = procedurecoding.getPc();
		ProcedurecodingCustom custom = new ProcedurecodingCustom();
		custom.setPc(pc);
		procedurecodingQueryVo.setProcedurecodingCustom(custom);

		// 非空校验
		procedurecodingQueryVo = procedurecodingQueryVo != null ? procedurecodingQueryVo
				: new ProcedurecodingQueryVo();

		// 查询列表的总数
		int total = procedurecodingService
				.findProcedurecodingCount(procedurecodingQueryVo);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		procedurecodingQueryVo.setPageQuery(pageQuery);

		// 分页查询，向procedurecodingQueryVo中传入pageQuery
		List<ProcedurecodingCustom> list = procedurecodingService
				.findProcedurecodingList(procedurecodingQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	/**
	 * 
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editprocedurecoding")
	public String editprocedurecoding(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		ProcedurecodingCustom procedurecodingCustom = procedurecodingService
				.findProcedurecodingById(id);
		// 将数据写到 model 中去
		model.addAttribute("procedurecodingCustom", procedurecodingCustom);

		return "/base/procedurecoding/editprocedurecoding";
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editprocedurecodingsubmit")
	public @ResponseBody
	SubmitResultInfo editprocedurecodingsubmit(String id,
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception {
		// 调用 service 方法，更新数据
		this.procedurecodingService.updateProcedurecoding(id,
				procedurecodingQueryVo.getProcedurecodingCustom());

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	// 删除用户
	@RequestMapping("/deleteprocedurecoding")
	public @ResponseBody
	SubmitResultInfo deleteprocedurecoding(String id) throws Exception {

		// 调用service
		procedurecodingService.deleteProcedurecoding(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addprocedurecodingcut")
	public String addprocedurecodingcut(Model model) throws Exception {
		String pc = procedurecoding.getPc();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		TechnicsExample example = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria = example
				.createCriteria();
		criteria.andTechnicsnameEqualTo(pc);
		List<Technics> list = technicsMapper.selectByExample(example);
		String tcname = list.get(0).getTcname();
		procedurecodingCustom.setPc(tcname);

		model.addAttribute("procedurecodingCustom", procedurecodingCustom);
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "/base/procedurecoding/addprocedurecodingcut";
	}

	@RequestMapping("/addprocedurecodingpunch")
	public String addprocedurecodingpunch(Model model) throws Exception {
		String pc = procedurecoding.getPc();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		TechnicsExample example = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria = example
				.createCriteria();
		criteria.andTechnicsnameEqualTo(pc);
		List<Technics> list = technicsMapper.selectByExample(example);
		String tcname = list.get(0).getTcname();
		procedurecodingCustom.setPc(tcname);

		model.addAttribute("procedurecodingCustom", procedurecodingCustom);
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "/base/procedurecoding/addprocedurecodingpunch";
	}

	@RequestMapping("/addprocedurecodingbend")
	public String addprocedurecodingbend(Model model) throws Exception {
		String pc = procedurecoding.getPc();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		TechnicsExample example = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria = example
				.createCriteria();
		criteria.andTechnicsnameEqualTo(pc);
		List<Technics> list = technicsMapper.selectByExample(example);
		String tcname = list.get(0).getTcname();
		procedurecodingCustom.setPc(tcname);

		model.addAttribute("procedurecodingCustom", procedurecodingCustom);
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "/base/procedurecoding/addprocedurecodingbend";
	}

	@RequestMapping("/addprocedurecodingmfitting")
	public String addprocedurecodingmfitting(Model model) throws Exception {
		String pc = procedurecoding.getPc();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		TechnicsExample example = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria = example
				.createCriteria();
		criteria.andTechnicsnameEqualTo(pc);
		List<Technics> list = technicsMapper.selectByExample(example);
		String tcname = list.get(0).getTcname();
		procedurecodingCustom.setPc(tcname);

		model.addAttribute("procedurecodingCustom", procedurecodingCustom);
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "/base/procedurecoding/addprocedurecodingmfitting";
	}

	@RequestMapping("/addprocedurecodingefitting")
	public String addprocedurecodingefitting(Model model) throws Exception {
		String pc = procedurecoding.getPc();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		TechnicsExample example = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria = example
				.createCriteria();
		criteria.andTechnicsnameEqualTo(pc);
		List<Technics> list = technicsMapper.selectByExample(example);
		String tcname = list.get(0).getTcname();
		procedurecodingCustom.setPc(tcname);

		model.addAttribute("procedurecodingCustom", procedurecodingCustom);
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "/base/procedurecoding/addprocedurecodingefitting";
	}

	@RequestMapping("/addprocedurecodingffitting")
	public String addprocedurecodingffitting(Model model) throws Exception {
		String pc = procedurecoding.getPc();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		TechnicsExample example = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria = example
				.createCriteria();
		criteria.andTechnicsnameEqualTo(pc);
		List<Technics> list = technicsMapper.selectByExample(example);
		String tcname = list.get(0).getTcname();
		procedurecodingCustom.setPc(tcname);

		model.addAttribute("procedurecodingCustom", procedurecodingCustom);
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "/base/procedurecoding/addprocedurecodingffitting";
	}

	/**
	 * 
	 * 
	 * @param procedurecodingQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addprocedurecodingsubmit")
	public @ResponseBody
	SubmitResultInfo addprocedurecodingsubmit(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception {
		ProcedurecodingCustom custom = procedurecodingQueryVo
				.getProcedurecodingCustom();
		try {
			String[] materielcoding = custom.getMaterielcoding().split(",");
			String[] countnum = custom.getCountnum().split(",");
			String[] finishtime = custom.getFinishtime().split(",");
			String[] mname = custom.getMname().split(",");
			String[] operator = custom.getOperator().split(",");
			String[] pc = custom.getPc().split(",");
			for (int i = 0; i < materielcoding.length; i++) {
				ProcedurecodingCustom custom2 = new ProcedurecodingCustom();
				custom2.setMaterielcoding(materielcoding[i]);
				custom2.setCountnum(countnum[i]);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
				String date = sdf.format(new Date());
				custom2.setFinishtime(date);
				custom2.setId("");
				custom2.setMname(mname[i]);
				custom2.setOperator(operator[i]);
				custom2.setPc(pc[i]);
				TechnicsExample example3 = new TechnicsExample();
				cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria3 = example3
						.createCriteria();
				criteria3.andTcnameEqualTo(pc[i]);
				List<Technics> list3 = technicsMapper.selectByExample(example3);
				String technicsname = list3.get(0).getTechnicsname();
				ProcedurecodingExample example = new ProcedurecodingExample();
				cn.cjpt.mes.pojo.po.ProcedurecodingExample.Criteria criteria = example
						.createCriteria();
				criteria.andMaterielcodingEqualTo(materielcoding[i]);
				criteria.andTechnicsnameEqualTo(technicsname);
				List<Procedurecoding> list = procedurecodingMapper
						.selectByExample(example);
				if (list == null || list.size() == 0) {
					procedurecodingService.insertProcedurecoding(custom2);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 922, null));
	}

	// 根据编码实时获取名称
	@RequestMapping("/requirenamebycode")
	@ResponseBody
	public void requirenamebycode(String code, HttpServletResponse response)
			throws IOException {
		BarCodeExample example = new BarCodeExample();
		Criteria criteria = example.createCriteria();
		criteria.andBarcodenumberEqualTo(code);
		List<BarCode> list = barCodeMapper.selectByExample(example);
		response.setContentType("text/html;charset=utf-8");
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getName());
			String str = null;
			if (list.get(0).getName() != null
					&& !list.get(0).getName().equals("null")) {
				str = "<tr><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='procedurecodingCustom.materielcoding' value="
						+ "\""
						+ list.get(0).getBarcodenumber()
						+ "\""
						+ "/>"
						+ "</td><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='procedurecodingCustom.mname' value="
						+ "\"" + list.get(0).getName() + "\"" + "/>";
			} else {
				str = "<tr><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='procedurecodingCustom.materielcoding' value="
						+ "\""
						+ list.get(0).getBarcodenumber()
						+ "\""
						+ "/>"
						+ "</td><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='procedurecodingCustom.mname' value="
						+ "\"" + list.get(0).getCabinettype() + "\"" + "/>";
			}
			response.getWriter().println(str);
		} else {
		}
	}
}
