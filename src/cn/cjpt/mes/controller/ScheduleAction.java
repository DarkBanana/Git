package cn.cjpt.mes.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cjpt.mes.mapper.BomCustomMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.ProcedurecodingMapperCustom;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.vo.BomCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;

@Controller
@RequestMapping("/schedule")
public class ScheduleAction {
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private ProcedurecodingMapperCustom pmc;
	@Autowired
	private BomCustomMapper bomCustomMapper;
	
	@RequestMapping("/count")
	public String count() throws Exception {

		return "/base/schedule/count";
	}

	@RequestMapping("/querybom")
	public void querybom(HttpServletResponse response) throws Exception {
//		MaterielExample example = new MaterielExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andCtypeidEqualTo("1");
//		criteria.andMaterielmethodNotEqualTo("外购");
//		List<Materiel> list = materielMapper.selectByExample(example);
		List<BomCustom> list = bomCustomMapper.findBom();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size() - 1) {
				buffer.append(list.get(i).getUnitname() + ",");
			} else if (i == list.size() - 1) {
				buffer.append(list.get(i).getUnitname());
			}
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(buffer.toString());
	}

	@RequestMapping("/querycount")
	public void querycount(HttpServletResponse response) throws Exception {
//		MaterielExample example = new MaterielExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andCtypeidEqualTo("1");
//		criteria.andMaterielmethodNotEqualTo("外购");
//		List<Materiel> list = materielMapper.selectByExample(example);
		List<BomCustom> list = bomCustomMapper.findBom();
		StringBuffer buffer = new StringBuffer();
		ProcedurecodingQueryVo procedurecodingQueryVo = new ProcedurecodingQueryVo();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		for (int i = 0; i < list.size(); i++) {
			procedurecodingCustom.setMaterielid(list.get(i).getId());
			procedurecodingCustom.setUnitname(list.get(i).getUnitname());
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String date2 = dateFormat.format(date);
			procedurecodingCustom.setTodaytime(date2);
			// 设置机装电装的materielmark
			procedurecodingCustom
					.setMaterielmark(list.get(i).getMaterielmark());
			// 当电装、机装、总装时设置technicsname
			String technicsname = null;
			if (list.get(i).getUnitname().equals("机装")) {
				technicsname = "mfitting";
			} else if (list.get(i).getUnitname().equals("电装")) {
				technicsname = "efitting";
			} else if (list.get(i).getUnitname().equals("总装")) {
				technicsname = "ffitting";
			}
			procedurecodingCustom.setTechnicsname(technicsname);
			procedurecodingQueryVo
					.setProcedurecodingCustom(procedurecodingCustom);
			int count = pmc.findScheduleCount(procedurecodingQueryVo);
			if (i < list.size() - 1) {
				buffer.append(count + ",");
			} else if (i == list.size() - 1) {
				buffer.append(count);
			}
		}
		buffer.append("#");

		// 统计部件需要完成的总数，并以##分割，用于切割
		for (int i = 0; i < list.size(); i++) {
			procedurecodingCustom.setMaterielid(list.get(i).getId());
			procedurecodingCustom.setUnitname(list.get(i).getUnitname());
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String date2 = dateFormat.format(date);
			procedurecodingCustom.setTodaytime(date2);

			procedurecodingQueryVo
					.setProcedurecodingCustom(procedurecodingCustom);
			int num = 0;
			List<ProcedurecodingCustom> list2 = pmc
					.findScheduleTotalCount(procedurecodingQueryVo);
			for (ProcedurecodingCustom procedurecodingCustom2 : list2) {
				String odnumber = procedurecodingCustom2.getOdnumber();
				int num2 = Integer.parseInt(odnumber);
				num = num + num2;
			}
			System.out.println(list2.toString());
			if (i < list.size() - 1) {
				buffer.append(num + ",");
			} else if (i == list.size() - 1) {
				buffer.append(num);
			}

		}

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(buffer.toString());
	}
	
	//统计工位数量
	@RequestMapping("/stationcount")
	public String stationcount() throws Exception {

		return "/base/schedule/stationcount";
	}
	

	@RequestMapping("/querystationcount")
	public void querystationcount(HttpServletResponse response,String begintime,String endtime) throws Exception {
		StringBuffer buffer = new StringBuffer();	
		ProcedurecodingQueryVo procedurecodingQueryVo = new ProcedurecodingQueryVo();
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		procedurecodingCustom.setBegintime(begintime);
		procedurecodingCustom.setEndtime(endtime);
		procedurecodingCustom.setTechnicsname("cut");
		procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
		int cutcount = pmc.querystationcount(procedurecodingQueryVo);
		procedurecodingCustom.setTechnicsname("punch");
		procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
		int punchcount = pmc.querystationcount(procedurecodingQueryVo);
		procedurecodingCustom.setTechnicsname("bend");
		procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
		int bendcount = pmc.querystationcount(procedurecodingQueryVo);
		procedurecodingCustom.setTechnicsname("mfitting");
		procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
		int mfittingcount = pmc.querystationcount(procedurecodingQueryVo);
		procedurecodingCustom.setTechnicsname("efitting");
		procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
		int efittingcount = pmc.querystationcount(procedurecodingQueryVo);
		procedurecodingCustom.setTechnicsname("ffitting");
		procedurecodingQueryVo.setProcedurecodingCustom(procedurecodingCustom);
		int ffittingcount = pmc.querystationcount(procedurecodingQueryVo);
		buffer.append(cutcount).append(",").append(punchcount).append(",").append(bendcount).append(",")
		.append(mfittingcount).append(",").append(efittingcount).append(",").append(ffittingcount);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(buffer.toString());
	}
}
