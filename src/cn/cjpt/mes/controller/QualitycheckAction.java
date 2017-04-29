package cn.cjpt.mes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.BarCodeMapper;
import cn.cjpt.mes.mapper.QualitycheckMapper;
import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.BarCodeExample;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.CtypeExample.Criteria;
import cn.cjpt.mes.pojo.vo.ActiveUser;
import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.CtypeQueryVo;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.QualitycheckCustom;
import cn.cjpt.mes.pojo.vo.QualitycheckQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.QualitycheckService;

@Controller
@RequestMapping("/qualitycheck")
public class QualitycheckAction {
	@Autowired
	private QualitycheckMapper qualitycheckMapper;
	@Autowired
	private QualitycheckService qualitycheckService;
	@Autowired
	private BarCodeMapper barCodeMapper;

	// 跳转到查询页面
	@RequestMapping("/queryqualitycheck")
	private String queryqualitycheck() {
		return "/base/qualitycheck/queryqualitycheck";
	}

	@RequestMapping("/queryqualitycheck_result")
	public @ResponseBody
	DataGridResultInfo queryqualitycheck_result(
			QualitycheckQueryVo qualitycheckQueryVo, int page, // 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		qualitycheckQueryVo = qualitycheckQueryVo != null ? qualitycheckQueryVo
				: new QualitycheckQueryVo();

		// 查询列表的总数
		int total = qualitycheckService
				.findQualitycheckCount(qualitycheckQueryVo);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		qualitycheckQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<QualitycheckCustom> list = qualitycheckService
				.findQualitycheckList(qualitycheckQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 添加
	@RequestMapping("/addqualitycheck")
	@RequiresPermissions("qualitycheck:create")
	public String addqualitycheck(Model model) throws Exception {
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		return "base/qualitycheck/addqualitycheck";
	}

	// 添加提交
	@RequestMapping("/addqualitychecksubmit")
	@RequiresPermissions("qualitycheck:create")
	public @ResponseBody
	SubmitResultInfo addqualitychecksubmit(
			QualitycheckQueryVo qualitycheckQueryVo) throws Exception {
		QualitycheckCustom qualitycheckCustom = qualitycheckQueryVo
				.getQualitycheckCustom();
		if (qualitycheckCustom.getCheckcode().equals("")
				| qualitycheckCustom.getConclusion().equals("")
				| qualitycheckCustom.getName().equals("")) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;
		} else {
			qualitycheckService.insertQualitycheck(qualitycheckCustom);
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}

	// 删除
	@RequestMapping("/deletequalitycheck")
	@RequiresPermissions("qualitycheck:delete")
	public @ResponseBody
	SubmitResultInfo deletequalitycheck(String id) throws Exception {

		// 调用service
		qualitycheckService.deleteQualitycheck(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	// 修改
	@RequestMapping("/editqualitycheck")
	@RequiresPermissions("qualitycheck:update")
	public String editqualitycheck(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		QualitycheckCustom qualitycheckCustom = qualitycheckService
				.findQualitycheckByid(id);
		// 将数据写到 model 中去
		model.addAttribute("qualitycheckCustom", qualitycheckCustom);
		String conclusion = qualitycheckCustom.getConclusion();
		if (conclusion.equals("合格")) {
			model.addAttribute("list1", "合格");
			model.addAttribute("list2", "不合格");
		} else {
			model.addAttribute("list1", "不合格");
			model.addAttribute("list2", "合格");
		}
		return "/base/qualitycheck/editqualitycheck";
	}

	@RequestMapping("/editqualitychecksubmit")
	public @ResponseBody
	SubmitResultInfo editqualitychecksubmit(String id,
			QualitycheckQueryVo qualitycheckQueryVo) throws Exception {
		// 调用 service 方法，更新数据
		QualitycheckCustom custom = qualitycheckQueryVo.getQualitycheckCustom();
		if (custom.getCheckcode().equals("")
				| custom.getConclusion().equals("")
				| custom.getChecktime().equals("")) {
			// 必填的未填，则返回显示错误
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;
		} else {
			this.qualitycheckService.updateQualitycheck(id, custom);
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, new Object[] {}));
		}

	}

	// 查看
	@RequestMapping("/lookqualitycheck")
	public String lookqualitycheck(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		QualitycheckCustom qualitycheckCustom = qualitycheckService
				.findQualitycheckByid(id);
		// 将数据写到 model 中去
		model.addAttribute("qualitycheckCustom", qualitycheckCustom);
		return "/base/qualitycheck/lookqualitycheck";
	}

	// 根据编码实时获取名称
	@RequestMapping("/requirenamebycode")
	@ResponseBody
	public void requirenamebycode(String code, HttpServletResponse response)
			throws IOException {
		BarCodeExample example = new BarCodeExample();
		cn.cjpt.mes.pojo.po.BarCodeExample.Criteria criteria = example
				.createCriteria();
		criteria.andBarcodenumberEqualTo(code);
		List<BarCode> list = barCodeMapper.selectByExample(example);
		response.setContentType("text/html;charset=utf-8");
		if (list != null && list.size() > 0) {
			System.out.println(list.get(0).getCabinettype());
			response.getWriter().println(list.get(0).getCabinettype());
		} else {
		}
	}
}
