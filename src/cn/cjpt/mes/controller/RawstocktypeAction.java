package cn.cjpt.mes.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.RawstocktypeCustom;
import cn.cjpt.mes.pojo.vo.RawstocktypeQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.RawstocktypeService;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/rawstocktype")
public class RawstocktypeAction {
	@Autowired
	private RawstocktypeService rawstocktypeService;

	// 跳转到物料类型的jsp

	@RequestMapping("/queryrawstocktype")
	public String queryorders() throws Exception {

		return "/base/rawstock/queryrawstocktype";
	}

	// 自动填充数据
	@RequestMapping("/queryrawstocktype_result")
	public @ResponseBody DataGridResultInfo queryrawstocktype_result(RawstocktypeQueryVo rawstocktypeQueryVo, int page, // 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		rawstocktypeQueryVo = rawstocktypeQueryVo != null ? rawstocktypeQueryVo : new RawstocktypeQueryVo();
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);
		rawstocktypeQueryVo.setPageQuery(pageQuery);
		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<RawstocktypeCustom> list = rawstocktypeService.findRawstocktypeList(rawstocktypeQueryVo);

		PageInfo<RawstocktypeCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addrawstocktype")
	@RequiresPermissions("rawstocktype:create")
	public String addrawstocktype() throws Exception {

		return "/base/rawstock/addrawstocktype";
	}

	/**
	 * 添加提交
	 * 
	 * @param rawstockQueryVo
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("/addrawstocktypesubmit")
	@RequiresPermissions("rawstocktype:create")
	public @ResponseBody SubmitResultInfo addrawstocksubmit(RawstocktypeQueryVo rawstocktypeQueryVo) throws Exception {
		RawstocktypeCustom custom = rawstocktypeQueryVo.getRawstocktypeCustom();
		if (custom.getRtname().equals("") | custom.getRttype().equals("") | custom.getRemark1().equals("")) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921, null));
			return null;

		} else {
			rawstocktypeService.insertRawstock(rawstocktypeQueryVo.getRawstocktypeCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
		}

	}

	// 删除
	@RequestMapping("/deleterawstocktype")
	@RequiresPermissions("rawstocktype:delete")
	public @ResponseBody SubmitResultInfo deleterawstocktype(String id) throws Exception {

		// 调用service
		rawstocktypeService.deleterawstocktype(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editrawstocktype")
	@RequiresPermissions("rawstocktype:update")
	public String editrawstocktype(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		RawstocktypeCustom rawstocktypeCustom = rawstocktypeService.findrawstocktypeById(id);
		// 将数据写到 model 中去
		model.addAttribute("rawstocktypeCustom", rawstocktypeCustom);
		return "/base/rawstock/editrawstocktype";
	}

	/**
	 * 修改提交
	 * 
	 * @param id
	 * @param ctypeQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editrawstocktypesubmit")
	@RequiresPermissions("rawstocktype:update")
	public @ResponseBody SubmitResultInfo editrawstocktypesubmit(String id, RawstocktypeQueryVo rawstocktypeQueryVo)
			throws Exception {
		// 调用 service 方法，更新数据
		RawstocktypeCustom custom = rawstocktypeQueryVo.getRawstocktypeCustom();
		if (custom.getRtname().equals("") | custom.getRttype().equals("")) {
			// 必填的未填，则返回显示错误
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921, null));
			return null;
		} else {
			this.rawstocktypeService.updateRawstocktype(id, rawstocktypeQueryVo.getRawstocktypeCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, new Object[] {}));
		}

	}
}
