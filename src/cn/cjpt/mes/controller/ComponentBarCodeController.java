package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.vo.ActiveUser;
import cn.cjpt.mes.pojo.vo.BarCodeCustom;
import cn.cjpt.mes.pojo.vo.BarCodeQueryVo;
import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.MaterielQueryVoCustom;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.BarCodeService;
import cn.cjpt.mes.service.CtypeService;
import cn.cjpt.mes.service.MaterielService;
import cn.cjpt.mes.util.DateUtil;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 部件条码管理
 * 
 * @author yxf 2017年2月27日 下午7:40:54
 * 
 */
@Controller
@RequestMapping("/component")
public class ComponentBarCodeController {
	@Autowired
	private BarCodeService barCodeService;
	@Autowired
	private CtypeService ctypeService;
	@Autowired
	private MaterielService materielService;

	/**
	 * 物料 条码 查询 页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querybarcode")
	public String querycomponentbarcode() throws Exception {
		return "/base/componentbarcode/querybarcode";
	}

	/**
	 * 物料 条码，查询结果集
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
		barCodeCustom.setTypes("C");
		barCodeQueryVo.setBarCodeCustom(barCodeCustom);
		// 查询列表的总数

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
	 * 跳转 添加 部件 条码页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addbarcode")
	public String addbarcode(Model model) throws Exception {
		// 查询 所有的 柜体信息
		List<CtypeCustom> ctypeList = ctypeService.findCtypeList(null);
		// 柜体的信息 放到 model 中，显示 柜体名字是使用
		model.addAttribute("ctypeList", ctypeList);
		return "/base/componentbarcode/addbarcode";
	}

	/**
	 * 获取 柜体 对应的 部件
	 */
	@RequestMapping("/querycomponent")
	public @ResponseBody
	List<Materiel> querycomponent(@RequestBody String cname, Model model)
			throws Exception {

		Ctype findCtypeByCname = ctypeService.findCtypeByCname(cname);

		String ctypeid = findCtypeByCname.getId();
		List<Materiel> materielList = materielService
				.findMaterielByCtypeId(ctypeid);
		List<Materiel> materielList2 = new ArrayList<>();
		// 过滤 机装 电装 总装
		for (Materiel materiel : materielList) {
			String unitName = materiel.getUnitname();
			if (!unitName.equals("机装") && !unitName.equals("电装")
					&& !unitName.equals("总装")&& !materiel.getMaterielmethod().equals("外购")) {
				materielList2.add(materiel);
			}
		}
		// 当部件 为 空是给出提示
		if (materielList2.size() == 0) {
			Materiel materiel = new Materiel();
			materiel.setUnitname("未查询到部件信息。");
			materielList2.add(materiel);
		}

		return materielList2;
	}

	/**
	 * 添加 部件 条形码 提交
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("/addbarcode_submit")
	public @ResponseBody
	SubmitResultInfo addbarcode_submit(Materiel materiel, HttpSession session)
			throws Exception {
		// 柜体 名称
		String cname = materiel.getCname();
		Ctype findCtypeByCname = ctypeService.findCtypeByCname(cname);
		// 柜体 编号
		String cNumber = findCtypeByCname.getCnum();
		// 部件 信息
		String unitname = materiel.getUnitname();

		List<Materiel> findMaterielByNnitname = materielService
				.findMaterielByNnitname(unitname);

		String unitcode = null;
		String uniName = null;
		for (Materiel materiel2 : findMaterielByNnitname) {

			if (materiel2.getCtypeid().equals(findCtypeByCname.getId())) {
				// 部件 编号
				unitcode = materiel2.getUnitcode();
				uniName = materiel2.getUnitname();
			}
		}
		// 　当前　时间　日期
		String dataTime = new DateUtil().getFormatDateTime();

		// 部件 编号
		System.out.println("cNumber:" + cNumber + "unitcode:" + unitcode
				+ "dataTime:" + dataTime);
		String componentNumber = "C" + dataTime;
		//
		BarCodeCustom barCode = new BarCodeCustom();
		barCode.setBarcodenumber(componentNumber);
		barCode.setName(uniName);
		barCode.setId(new UUIDBuild().generate());
		barCode.setTypes("C");
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

	/**
	 * 删除 部件 条形码
	 * barcode:delete
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
}
