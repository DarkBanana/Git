package cn.cjpt.mes.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.FproductCustomMapper;
import cn.cjpt.mes.mapper.FproductMapper;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.po.Rawstocktype;
import cn.cjpt.mes.pojo.po.RawstocktypeExample;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.Fproduct;
import cn.cjpt.mes.pojo.po.FproductExample;
import cn.cjpt.mes.pojo.vo.FproductCustom;
import cn.cjpt.mes.pojo.vo.FproductQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.FproductService;
import cn.cjpt.mes.util.UUIDBuild;

public class FproductServiceImpl implements FproductService {
	@Autowired
	private FproductCustomMapper FproductCustomMapper;
	@Autowired
	private CtypeMapper ctypeMapper;
	@Autowired
	private FproductMapper FproductMapper;

	@Override
	public int findFproductCount(FproductQueryVo FproductQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return FproductCustomMapper.findFproductCount(FproductQueryVo);
	}

	@Override
	public List<FproductCustom> findFproductList(FproductQueryVo FproductQueryVo)
			throws Exception {

		int page = FproductQueryVo.getPageQuery().getPage();
		int rows = FproductQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		// TODO Auto-generated method stub
		return FproductCustomMapper.findFproductList(FproductQueryVo);
	}

	/**
	 * 添加成品区
	 */
	@Override
	public void insertFproduct(String ctypeid,String materielcoding) throws Exception {
		// TODO Auto-generated method stub
		CtypeExample example = new CtypeExample();
		cn.cjpt.mes.pojo.po.CtypeExample.Criteria criteria2 = example.createCriteria();
		criteria2.andIdEqualTo(ctypeid);
		List<Ctype> list3 = ctypeMapper.selectByExample(example);
		 String cid=list3.get(0).getId();
		 FproductExample example2 = new FproductExample();
		 cn.cjpt.mes.pojo.po.FproductExample.Criteria criteria = example2.createCriteria();
		 criteria.andCtypeidEqualTo(cid);
		 Fproduct fproduct = new Fproduct();
		 List<Fproduct> list2 = FproductMapper.selectByExample(example2);
		 FproductQueryVo queryVo = new FproductQueryVo();
		 FproductCustom custom = new FproductCustom();
		 custom.setCtypeid(cid);
		 queryVo.setFproductCustom(custom);
		 List<FproductCustom> list4 = FproductCustomMapper.findFproductByDate(queryVo);
		  if(list4!=null&&list4.size()>0){
		  String remainnum = list4.get(0).getRemainnum();
		  int int1 = Integer.parseInt(remainnum);
		  int totalRemainnum = int1+1;
		  fproduct.setId((UUIDBuild.getUUID()));
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			String rtime1=df.format(new Date());
			fproduct.setRtime(rtime1);
			fproduct.setRemainnum(totalRemainnum+"");
			fproduct.setCtypeid(cid);
			fproduct.setPutstorenum("1");
			fproduct.setRemark1(materielcoding);
			FproductMapper.insert(fproduct);
		  }else {
			  fproduct.setId((UUIDBuild.getUUID()));
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
				String rtime1=df.format(new Date());
				fproduct.setRtime(rtime1);
				fproduct.setRemainnum("1");
				fproduct.setCtypeid(cid);
				fproduct.setPutstorenum("1");
				fproduct.setRemark1(materielcoding);
				FproductMapper.insert(fproduct);
		}
	}
	/**
	 * 成品区出货
	 */
	@Override
	public void outFproduct(FproductCustom fproductCustom) throws Exception {
		// TODO Auto-generated method stub
		CtypeExample example = new CtypeExample();
		cn.cjpt.mes.pojo.po.CtypeExample.Criteria criteria2 = example.createCriteria();
		criteria2.andIdEqualTo(fproductCustom.getCtypeid());
		List<Ctype> list3 = ctypeMapper.selectByExample(example);
		 String cid=list3.get(0).getId();
		 FproductExample example2 = new FproductExample();
		 cn.cjpt.mes.pojo.po.FproductExample.Criteria criteria = example2.createCriteria();
		 criteria.andCtypeidEqualTo(cid);
		 Fproduct Fproduct = new Fproduct();
		 List<Fproduct> list2 = FproductMapper.selectByExample(example2);
		 FproductQueryVo queryVo = new FproductQueryVo();
		 FproductCustom custom = new FproductCustom();
		 custom.setCtypeid(cid);
		 queryVo.setFproductCustom(custom);
		 List<FproductCustom> list4 = FproductCustomMapper.findFproductByDate(queryVo);
		  if(list4!=null&&list4.size()>0&&list4.get(0).getRemainnum().compareTo("0")>0){
		  String remainnum = list4.get(0).getRemainnum();
		  int int1 = Integer.parseInt(remainnum);
		  int int2 = Integer.parseInt(fproductCustom.getOutstorenum());
		  int totalRemainnum = int1-int2;
		  Fproduct.setId((UUIDBuild.getUUID()));
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			String rtime1=df.format(new Date());
			Fproduct.setRtime(rtime1);
			Fproduct.setRemainnum(totalRemainnum+"");
			Fproduct.setCtypeid(cid);
			Fproduct.setOutstorenum(fproductCustom.getOutstorenum());
			FproductMapper.insert(Fproduct);
		  }else {
			  ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 232,
						null));
		}
	}
	/**
	 * 查询 日期最大的数据
	 */
	@Override
	public FproductCustom findMaxDate() throws Exception {
		// TODO Auto-generated method stub
		return FproductCustomMapper.findMaxDate();
	}
}
