package cn.cjpt.mes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.BarCodeMapper;
import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.FproductMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.BarCodeExample;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.Fproduct;
import cn.cjpt.mes.pojo.po.FproductExample;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.Semiproductb;
import cn.cjpt.mes.pojo.po.SemiproductbExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.vo.FproductCustom;
import cn.cjpt.mes.pojo.vo.FproductQueryVo;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.RawstockCustom;
import cn.cjpt.mes.pojo.vo.RawstockQueryVo;
import cn.cjpt.mes.pojo.vo.SemiproductbCustom;
import cn.cjpt.mes.pojo.vo.SemiproductbQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.FproductService;

@Controller
@RequestMapping("/fproduct")
public class FproductAction {
	@Autowired
	private FproductService fproductService;
	@Autowired
	private CtypeMapper ctypeMapper;
	@Autowired
	private BarCodeMapper barCodeMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private FproductMapper fproductMapper;

	@RequestMapping("/queryfproduct")
	public String queryfproduct() throws Exception {

		return "/base/fproduct/queryfproduct";
	}

	// 自动填充数据
	@RequestMapping("/queryfproduct_result")
	public @ResponseBody DataGridResultInfo queryfproduct_result(FproductQueryVo fproductQueryVo, int page, // 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		fproductQueryVo = fproductQueryVo != null ? fproductQueryVo : new FproductQueryVo();

		// 查询列表的总数
		int total = fproductService.findFproductCount(fproductQueryVo);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);
		fproductQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<FproductCustom> list = fproductService.findFproductList(fproductQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 自动入库方法
	public void addfproduct(String ctypeid, String materielcoding) throws Exception {
		fproductService.insertFproduct(ctypeid, materielcoding);
	}

	@RequestMapping("/outfproduct")
	@RequiresPermissions("fproduct:delete")
	public String outfproduct(Model model) throws Exception {
		CtypeExample example2 = new CtypeExample();
		List<Ctype> list3 = ctypeMapper.selectByExample(example2);
		model.addAttribute("list3", list3);
		return "/base/fproduct/outfproduct";
	}

	// 出库确认
	@RequestMapping("/outfproductsubmit")
	@RequiresPermissions("fproduct:delete")
	public @ResponseBody SubmitResultInfo outfproductsubmit(FproductQueryVo fproductQueryVo) throws Exception {
		FproductCustom custom = fproductQueryVo.getFproductCustom();
		try {
			String[] materielcoding = custom.getMaterielcoding().split(",");
			String[] countnum = custom.getCountnum().split(",");
			String[] finishtime = custom.getFinishtime().split(",");
			String[] mname = custom.getMname().split(",");
			String[] operator = custom.getOperator().split(",");
			String[] pc = custom.getPc().split(",");
			FproductCustom custom2 = new FproductCustom();
			for (int i = 0; i < materielcoding.length; i++) {
				// 存放条码,用备用字段remark1存放条码
				custom2.setRemark1(materielcoding[i]);
				custom2.setOutstorenum(countnum[i]);
				CtypeExample ctypeExample = new CtypeExample();
				cn.cjpt.mes.pojo.po.CtypeExample.Criteria createCriteria = ctypeExample.createCriteria();
				createCriteria.andCnameEqualTo(mname[i]);
				List<Ctype> list = ctypeMapper.selectByExample(ctypeExample);
				custom2.setCtypeid(list.get(0).getId());
				custom2.setMname(mname[i]);
				// 判断通过该条形码判断，如果已经存过就不再存了，没有存的就入库
				FproductExample fproductExample = new FproductExample();
				cn.cjpt.mes.pojo.po.FproductExample.Criteria fproductCriteria = fproductExample.createCriteria();
				fproductCriteria.andRemark1EqualTo(materielcoding[i]);
				fproductCriteria.andOutstorenumIsNotNull();
				List<Fproduct> fproductList = fproductMapper.selectByExample(fproductExample);
				if (fproductList == null || fproductList.size() <= 0) {
					// 如果该产品没有入库就不允许出库
					FproductExample fproductExample2 = new FproductExample();
					cn.cjpt.mes.pojo.po.FproductExample.Criteria createCriteria2 = fproductExample2.createCriteria();
					createCriteria2.andPutstorenumIsNotNull();
					createCriteria2.andOutstorenumIsNull();
					createCriteria2.andRemark1EqualTo(materielcoding[i]);
					List<Fproduct> list2 = fproductMapper.selectByExample(fproductExample2);
					if (list2 != null && list2.size() > 0) {
						fproductService.outFproduct(custom2);
					}
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
						+ "<input readonly='readonly' style='border:0'  type='text' name='fproductCustom.materielcoding' value="
						+ "\"" + list.get(0).getBarcodenumber() + "\"" + "/>" + "</td><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='fproductCustom.mname' value="
						+ "\"" + list.get(0).getName() + "\"" + "/>";
			} else {
				str = "<tr><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='fproductCustom.materielcoding' value="
						+ "\"" + list.get(0).getBarcodenumber() + "\"" + "/>" + "</td><td width=‘120’>"
						+ "<input readonly='readonly' style='border:0'  type='text' name='fproductCustom.mname' value="
						+ "\"" + list.get(0).getCabinettype() + "\"" + "/>";
			}
			response.getWriter().println(str);
		} else {
		}
	}
}
