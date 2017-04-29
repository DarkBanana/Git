package cn.cjpt.mes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.vo.ActiveUser;
import cn.cjpt.mes.pojo.vo.BarCodeCustom;
import cn.cjpt.mes.pojo.vo.BarCodeQueryVo;
import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.BarCodeService;
import cn.cjpt.mes.service.CtypeService;
import cn.cjpt.mes.util.DateUtil;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 产品 条码管理
 * 
 * @author yxf 2017年2月28日 下午3:11:46
 * 
 */

@Controller
@RequestMapping("/product")
public class ProductBarcodeController {
	@Autowired
	private BarCodeService barCodeService;
	@Autowired
	private CtypeService ctypeService;

	/**
	 * 跳转 查询 产品 编码 页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querybarcode")
	public String querybarcode() throws Exception {

		return "/base/productbarcode/querybarcode";
	}

	/**
	 * 产品 条码，查询结果集
	 * 
	 * @param barCodeQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querybarcode_result")
	public @ResponseBody
	DataGridResultInfo querybarcode_result(BarCodeQueryVo barCodeQueryVo,
			int rows, int page) throws Exception {
		// 非空校验
		barCodeQueryVo = barCodeQueryVo != null ? barCodeQueryVo
				: new BarCodeQueryVo();
		// 获取 barCodeCustom
		BarCodeCustom barCodeCustom = barCodeQueryVo.getBarCodeCustom();
		// 非空 校验
		barCodeCustom = barCodeCustom != null ? barCodeCustom
				: new BarCodeCustom();
		// 查询出的 结果集 应该为 物料的
		barCodeCustom.setTypes("P");
		barCodeQueryVo.setBarCodeCustom(barCodeCustom);

		PageQuery pageQuery = new PageQuery(page, rows);
		barCodeQueryVo.setPageQuery(pageQuery);
		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<BarCodeCustom> list = barCodeService
				.findBarCodeList(barCodeQueryVo);

		PageInfo<BarCodeCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);
		return dataGridResultInfo;
	}

	/**
	 * 删除 产品 条码
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletebarcode")
	@RequiresPermissions("barcode:delete")
	public @ResponseBody
	SubmitResultInfo deletebarcode(String id) throws Exception {
		barCodeService.deleteBarCode(id);
		// 默认为成功
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	/**
	 * 添加 产品 编码
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addbarcode")
	public String addbarcode(Model model) throws Exception {
		// 查询 所有的 柜体信息
		List<CtypeCustom> ctypeList = ctypeService.findCtypeList(null);
		// 柜体的信息 放到 model 中，显示 柜体名字是使用
		model.addAttribute("ctypeList", ctypeList);
		return "/base/productbarcode/addbarcode";
	}

	/**
	 * 添加 产品 编码 提交
	 * 
	 * @param materiel
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addbarcode_submit")
	public @ResponseBody
	SubmitResultInfo addbarcode_submit(Materiel materiel, HttpSession session)
			throws Exception {

		String cname = materiel.getCname();
		// 柜体 名称
		Ctype findCtypeByCname = ctypeService.findCtypeByCname(cname);
		// 柜体 编号
		String cNumber = findCtypeByCname.getCnum();
		// 　当前　时间　日期
		String dataTime = new DateUtil().getFormatDateTime();
		// 柜体 产品 编号
		System.out.println("cNumber:" + cNumber + "dataTime:" + dataTime);
		String productNumber = "P" + dataTime;
		//
		BarCodeCustom barCode = new BarCodeCustom();
		barCode.setId(new UUIDBuild().generate());
		barCode.setBarcodenumber(productNumber);
		barCode.setTypes("P");
		barCode.setCreatetime(new DateUtil().getNowDateTime());
		barCode.setCabinettype(cname);
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 操作 着姓名
		barCode.setOperatorname(activeUser.getUsername());
		barCodeService.insertBarCode(barCode);
		// 默认为成功
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}
}
