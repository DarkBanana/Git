package cn.cjpt.mes.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.CtypeQueryVo;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.CtypeService;

@Controller
@RequestMapping("/ctype")
public class CtypeAction {
	@Autowired
	private CtypeMapper ctypeMapper;
	@Autowired
	private CtypeService ctypeService;

	// 跳转到查询页面
	@RequestMapping("/queryctype")
	private String queryctype() {
		return "/base/materielCode/queryctype";
	}

	/**
	 * 柜体类型查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryctype_result")
	public @ResponseBody
	DataGridResultInfo queryctype_result(CtypeQueryVo ctypeQueryVo, int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		ctypeQueryVo = ctypeQueryVo != null ? ctypeQueryVo : new CtypeQueryVo();
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);
		ctypeQueryVo.setPageQuery(pageQuery);
		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<CtypeCustom> list = ctypeService.findCtypeList(ctypeQueryVo);

		PageInfo<CtypeCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 添加柜体类型
	@RequestMapping("/addctype")
	@RequiresPermissions("bom:create")
	public String addctype(Model model) throws Exception {
		return "/base/materielCode/addctype";
	}

	// 添加提交
	@RequiresPermissions("bom:create")
	@RequestMapping("/addctypesubmit")
	public @ResponseBody
	SubmitResultInfo addctypesubmit(CtypeQueryVo ctypeQueryVo) throws Exception {
		CtypeCustom ctypeCustom = ctypeQueryVo.getCtypeCustom();
		if (ctypeCustom.getCnum().equals("")
				| ctypeCustom.getCname().equals("")) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;
		} else {
			ctypeService.insertCtype(ctypeQueryVo.getCtypeCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}

	// 删除柜体类型
	@RequestMapping("/deletectype")
	@RequiresPermissions("bom:delete")
	public @ResponseBody
	SubmitResultInfo deletectype(String id) throws Exception {

		// 调用service
		ctypeService.deleteCtype(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	// 修改柜体
	@RequestMapping("/editctype")
	@RequiresPermissions("bom:update")
	public String editorders(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		CtypeCustom ctypeCustom = ctypeService.findCtypeById(id);
		// 将数据写到 model 中去
		model.addAttribute("ctypeCustom", ctypeCustom);
		return "/base/materielCode/editctype";
	}

	@RequestMapping("/editctypesubmit")
	@RequiresPermissions("bom:update")
	public @ResponseBody
	SubmitResultInfo editctypesubmit(String id, CtypeQueryVo ctypeQueryVo)
			throws Exception {
		// 调用 service 方法，更新数据
		CtypeCustom custom = ctypeQueryVo.getCtypeCustom();
		if (custom.getCnum().equals("") | custom.getCname().equals("")) {
			// 必填的未填，则返回显示错误
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;
		} else {
			this.ctypeService.updateCtype(id, ctypeQueryVo.getCtypeCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, new Object[] {}));
		}

	}
}
