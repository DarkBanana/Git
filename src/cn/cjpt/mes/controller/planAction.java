package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.vo.FproductCustom;
import cn.cjpt.mes.pojo.vo.MaterielCustom;
import cn.cjpt.mes.pojo.vo.PlanDetail;
import cn.cjpt.mes.pojo.vo.SemiproductaCustom;
import cn.cjpt.mes.pojo.vo.SemiproductbCustom;
import cn.cjpt.mes.pojo.vo.TechnicsCustom;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.service.FproductService;
import cn.cjpt.mes.service.MaterielService;
import cn.cjpt.mes.service.RawstockService;
import cn.cjpt.mes.service.SemiproductaService;
import cn.cjpt.mes.service.SemiproductbService;
import cn.cjpt.mes.service.TechnicsService;
import cn.cjpt.mes.service.WorkorderService;

/**
 * 生产总计划 大屏 小看版
 * 
 * @author yxf 2017年1月16日 上午11:18:45
 */
@Controller
@RequestMapping("/plan")
public class planAction {

	@Autowired
	private WorkorderService workorderService;
	@Autowired
	private TechnicsService technicsService;
	@Autowired
	private MaterielService materielService;
	@Autowired
	private FproductService fproductService;
	@Autowired
	private SemiproductaService semiproductaService;
	@Autowired
	private SemiproductbService semiproductbService;
	@Autowired
	private RawstockService rawstockService;

	/**
	 * 生产总计划
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/plan")
	public String plan(Model model) throws Exception {
		// 查询数据
		List<TechnicsCustom> technicsCustomList = technicsService.findTechnicsProductionPlan();

		for (TechnicsCustom technics : technicsCustomList) {
			String technicsname = technics.getTechnicsname();
			model.addAttribute(technicsname, technics);
		}
		// 成品 库存余量
		FproductCustom findMaxDate = fproductService.findMaxDate();
		String productNumber = "0";
		if (findMaxDate != null) {
			productNumber = findMaxDate.getRemainnum();
		}
		model.addAttribute("product", productNumber);

		// 半成品 A区 库存
		int SemiproductaNumber = semiproductaService.findSemiproductaByMaxDate();
		model.addAttribute("SemiproductaNumber", SemiproductaNumber);

		int SemiproductbNumber = semiproductbService.findSemiproductbByMaxDate();
		model.addAttribute("SemiproductbNumber", SemiproductbNumber);
		// 材料区
		int steelPlateCount = rawstockService.findSteelPlateCount();
		model.addAttribute("steelPlateCount", steelPlateCount + "");
		return "/base/plan/plan";
	}

	/**
	 * 生产总计划 LED 屏幕上显示
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/planLED")
	public String planLED(Model model) throws Exception {

		// 查询数据
		List<TechnicsCustom> technicsCustomList = technicsService.findTechnicsProductionPlan();

		model.addAttribute("technicsCustomList", technicsCustomList);
		return "/base/plan/planLED";
	}

	/**
	 * 小看板 剪板区 页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/planDetail/{tcname}")
	public String productionDetail(@PathVariable String tcname, Model model) throws Exception {

		// 设置 面板 标题
		Technics findTechnicsByTcname = technicsService.findTechnicsByTcname(tcname);
		String tcTitle = findTechnicsByTcname.getTcname() + "区电子看板";
		model.addAttribute("tcTitle", tcTitle);
		// 根据 tcname 不同，对应页面的描述也不同
		String tDesc = "";
		if (tcname.equals("cut")) {
			tDesc = "剪板：使用剪板机运动的上刀片和固定的下刀片，采用合理的刀片间隙，对各种厚度的金属板材施加剪切力，使之按照一定的尺寸断裂分离。";
		}
		if (tcname.equals("punch")) {
			tDesc = "冲压：使用冲压机和冲压模具对板材施加外力，使之产生塑性变形或分离，从而获得一定形状和尺寸的工件。";
		}
		if (tcname.equals("bend")) {
			tDesc = "折弯：在折弯机上下模的压力下，金属板材经过弹性变形和塑性变形，加压至行程终止，使上下模与板材三点紧靠并完全接触从而形成弯曲变形。";
		}
		if (tcname.equals("mfitting")) {
			tDesc = "机装：指配电柜骨架和抽屉的装配，将钣金加工后的零部件和外购件按照所需方式装配在一起，使之成为一个完整的骨架和抽屉。";
		}
		if (tcname.equals("efitting")) {
			tDesc = "电装：指配电柜中各种电子元器件、仪器仪表、电缆线等零部件的装配。";
		}
		if (tcname.equals("ffitting")) {
			tDesc = "总装：指单元抽屉隔板、边屏盖板、前面板、电缆室门板等零部件的安装，完成后将成为一个完整的配电柜产品。";
		}
		model.addAttribute("tDesc", tDesc);
		model.addAttribute("tcname_page", tcname);

		return "/base/plan/planDetail";
	}

	/**
	 * 小看板 查询 结果 集
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/queryplandetail_result/{tcname}")
	public @ResponseBody MaterielCustom queryplandetail_result(@PathVariable String tcname) throws Exception {
		// 总计划数
		String planTotal = null;
		// 总的 已经完成的
		String completedNumber = null;
		// 完成率
		int completionRate = 0;
		// 今日计划数
		String planToday = null;
		// 今日已完成
		String completedToday = null;
		String tcname_page = tcname;
		// 查询数据
		List<TechnicsCustom> technicsCustomList = technicsService.findTechnicsProductionPlan();
		// 取出 该工位对应的数据
		for (TechnicsCustom technicsCustom : technicsCustomList) {
			String tcname_db = technicsCustom.getTechnicsname();
			if (tcname_db.endsWith(tcname_page)) {
				// 总计划数
				planTotal = technicsCustom.getPlanTotal();
				// 总的 已经完成的
				completedNumber = technicsCustom.getCompletedNumber();
				// 今日计划数
				planToday = technicsCustom.getPlanToday();
				// 今日已完成
				completedToday = technicsCustom.getCompletedToday();
				int complete = Integer.parseInt(completedNumber) * 100;
				int total = Integer.parseInt(planTotal);
				int i = 0;
				if (total != 0) {
					i = complete / total;
				}
				// 完成率
				completionRate = i;
			}
		}
		// 查询 部件 的 生产进度
		List<MaterielCustom> partsPlanList = materielService.getPartsPlan();

		List<MaterielCustom> list = new ArrayList<>();

		for (MaterielCustom materielCustom : partsPlanList) {
			MaterielCustom materielCustom2 = new MaterielCustom();
			// 名称
			materielCustom2.setCtname(materielCustom.getCtname());

			// System.out.println(materielCustom.getCtname() + "-----------");
			// 总计划
			materielCustom2.setPlanTotal(materielCustom.getPlanTotal());
			// 今日计划
			materielCustom2.setPlanToday(materielCustom.getPlanToday());
			// 已完成
			materielCustom2.setCompletedNumber(materielCustom.getCompletedNumber());
			// 今日今已完已完
			materielCustom2.setCompletedToday(materielCustom.getCompletedToday());

			materielCustom2.setMaterielmethod("123");
			list.add(materielCustom2);
		}

		MaterielCustom materielcustom = new MaterielCustom();
		materielcustom.setPartsPlanList(list);
		materielcustom.setPlanToday(planToday);
		materielcustom.setPlanTotal(planTotal);
		materielcustom.setCompletedNumber(completedNumber);
		materielcustom.setCompletedToday(completedToday);
		materielcustom.setCompletionRate(completionRate + "");
		materielcustom.setMaterielmethod("123");
		return materielcustom;
	}
}
