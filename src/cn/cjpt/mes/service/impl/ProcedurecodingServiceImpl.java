package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.BarCodeMapper;
import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.ProcedurecodingMapper;
import cn.cjpt.mes.mapper.ProcedurecodingMapperCustom;
import cn.cjpt.mes.mapper.TechnicsMapper;
import cn.cjpt.mes.pojo.po.BarCode;
import cn.cjpt.mes.pojo.po.BarCodeExample;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.CtypeExample.Criteria;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.Procedurecoding;
import cn.cjpt.mes.pojo.po.ProcedurecodingExample;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import cn.cjpt.mes.pojo.vo.ActiveProcedurecoding;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.FproductService;
import cn.cjpt.mes.service.ProcedurecodingService;
import cn.cjpt.mes.service.SemiproductaService;
import cn.cjpt.mes.util.MD5;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 接口实现类 2017年2月16日 上午11:04:44
 * 
 * @author yxf
 */
public class ProcedurecodingServiceImpl implements ProcedurecodingService {

	@Autowired
	private ProcedurecodingMapperCustom procedurecodingMapperCustom;
	@Autowired
	private ProcedurecodingMapper procedurecodingMapper;
	@Autowired
	private CtypeMapper ctypeMapper;
	@Autowired
	private TechnicsMapper technicsMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private SemiproductaService semiproductaService;
	@Autowired
	private FproductService fproductService;
	@Autowired
	private BarCodeMapper barCodeMapper;

	@Override
	public List<ProcedurecodingCustom> findProcedurecodingList(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception {
		int page = procedurecodingQueryVo.getPageQuery().getPage();
		int rows = procedurecodingQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return procedurecodingMapperCustom
				.findProcedurecodingList(procedurecodingQueryVo);
	}

	@Override
	public int findProcedurecodingCount(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return procedurecodingMapperCustom
				.findProcedurecodingCount(procedurecodingQueryVo);
	}

	/**
	 * 根据用户 账号查询 用户信息
	 * 
	 * @param procedurecodingid
	 * @return
	 * @throws Exception
	 */

	public Procedurecoding findProcedurecodingByprocedurecodingid(
			String procedurecodingid) throws Exception {

		ProcedurecodingExample procedurecodingExample = new ProcedurecodingExample();
		ProcedurecodingExample.Criteria criteria = procedurecodingExample
				.createCriteria();
		// 设置查询条件，根据账号查询
		criteria.andIdEqualTo(procedurecodingid);
		List<Procedurecoding> list = procedurecodingMapper
				.selectByExample(procedurecodingExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 用户身份 认证
	 */
	@Override
	public ActiveProcedurecoding checkProcedurecodingInfo(String Id, String pwd)
			throws Exception {

		Procedurecoding procedurecoding_db = this
				.findProcedurecodingByprocedurecodingid(Id);
		if (procedurecoding_db == null) {
			// 账号不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		// 校验 身份 信息 是否合法
		String pwd_MD5 = new MD5().getMD5ofStr(pwd);
		if (!procedurecoding_db.getId().equalsIgnoreCase(pwd_MD5)) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 114,
					null));
		}

		// 构建用户身份信息
		ActiveProcedurecoding activeProcedurecoding = new ActiveProcedurecoding();
		activeProcedurecoding.setId(procedurecoding_db.getId());

		return activeProcedurecoding;
	}

	/**
	 * 根据 ID 查找用户信息
	 */
	@Override
	public ProcedurecodingCustom findProcedurecodingById(String id)
			throws Exception {
		// 从数据库查询用户
		Procedurecoding procedurecoding = procedurecodingMapper
				.selectByPrimaryKey(id);
		if (procedurecoding == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		ProcedurecodingCustom procedurecodingCustom = new ProcedurecodingCustom();
		// 将procedurecoding中数据设置到procedurecodingCustom
		BeanUtils.copyProperties(procedurecoding, procedurecodingCustom);
		return procedurecodingCustom;
	}

	/**
	 * 修改 用户信息
	 * 
	 * @param id
	 * @param procedurecodingCustom
	 * @throws Exception
	 */
	@Override
	public void updateProcedurecoding(String id,
			ProcedurecodingCustom procedurecodingCustom) throws Exception {
		// 从数据库查询用户信息
		Procedurecoding procedurecoding_db = procedurecodingMapper
				.selectByPrimaryKey(id);

		// 如果修改了账号
		if (!procedurecodingCustom.getId().equals(procedurecoding_db.getId())) {
			// 修改后的账号不能重复
			Procedurecoding findProcedurecodingByprocedurecodingid = this
					.findProcedurecodingByprocedurecodingid(procedurecodingCustom
							.getId());
			if (findProcedurecodingByprocedurecodingid != null) {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						213, null));
			}
		}
		// 密码修改
		// 如果从页面提交的密码值为空说明用户不修改密码，否则 就需要对密码进行加密存储
		String pwd_page = procedurecodingCustom.getId().trim();
		String pwd_md5 = null;
		if (pwd_page != null && !pwd_page.equals("")) {
			// 说明用户修改密码了
			pwd_md5 = new MD5().getMD5ofStr(pwd_page);
		}
		procedurecoding_db.setId(procedurecodingCustom.getId());
		procedurecoding_db.setMaterielcoding(procedurecodingCustom
				.getMaterielcoding());
		procedurecoding_db.setTechnicsname(procedurecodingCustom
				.getTechnicsname());
		procedurecoding_db.setFinishtime(procedurecodingCustom.getFinishtime());
		procedurecoding_db.setMaterielid(procedurecodingCustom.getMaterielid());
		procedurecoding_db.setOperator(procedurecodingCustom.getOperator());
		procedurecoding_db.setRemark(procedurecodingCustom.getRemark());
		if (pwd_md5 != null) {
			procedurecoding_db.setId(pwd_md5);
		}
		procedurecoding_db.setId(procedurecodingCustom.getId());
		procedurecodingMapper.updateByPrimaryKey(procedurecoding_db);
	}

	/**
	 * 删除系统用户
	 */
	@Override
	public void deleteProcedurecoding(String id) throws Exception {
		// 校验 用户是否存在
		Procedurecoding procedurecoding_db = procedurecodingMapper
				.selectByPrimaryKey(id);
		if (procedurecoding_db == null) {
			// 用户不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 212,
					null));
		}
		procedurecodingMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 添加系统用户信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void insertProcedurecoding(
			ProcedurecodingCustom procedurecodingCustom) throws Exception {
		// 将mname的值付给unitname
		String mname = procedurecodingCustom.getMname();
		procedurecodingCustom.setUnitname(mname);
		// 获取配低柜的类型
		String materielcoding = procedurecodingCustom.getMaterielcoding();
		BarCodeExample barCodeExample = new BarCodeExample();
		cn.cjpt.mes.pojo.po.BarCodeExample.Criteria criteria4 = barCodeExample
				.createCriteria();
		criteria4.andBarcodenumberEqualTo(materielcoding);
		List<BarCode> list4 = barCodeMapper.selectByExample(barCodeExample);
		String cabinettype = list4.get(0).getCabinettype();
		CtypeExample example = new CtypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andCnameEqualTo(cabinettype);
		List<Ctype> list = ctypeMapper.selectByExample(example);
		String ctypeid = list.get(0).getId();
		MaterielExample example2 = new MaterielExample();
		cn.cjpt.mes.pojo.po.MaterielExample.Criteria criteria2 = example2
				.createCriteria();
		criteria2.andCtypeidEqualTo(ctypeid);
		if (procedurecodingCustom.getUnitname() != null
				&& !procedurecodingCustom.getUnitname().equals("null")
				&& !procedurecodingCustom.getUnitname().equals("")
				&& list4.get(0).getName() != null
				&& !list4.get(0).getName().equals("")) {
			criteria2.andUnitnameEqualTo(procedurecodingCustom.getUnitname());
		} else {
			criteria2.andUnitnameEqualTo(procedurecodingCustom.getPc());
		}
		List<Materiel> list2 = materielMapper.selectByExample(example2);
		String mid = list2.get(0).getId();
		// 将工艺的中文名字变成英文
		String pc = procedurecodingCustom.getPc();
		TechnicsExample example3 = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria3 = example3
				.createCriteria();
		criteria3.andTcnameEqualTo(pc);
		List<Technics> list3 = technicsMapper.selectByExample(example3);
		String technicsname = list3.get(0).getTechnicsname();

		// 信息 合法性 校验
		// 1.用户账号 不能 重复
		String procedurecodingid_page = procedurecodingCustom.getId();
		Procedurecoding procedurecoding_db = this
				.findProcedurecodingByprocedurecodingid(procedurecodingid_page);
		if (procedurecoding_db != null) {
			// 用户 输入的账号重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 213,
					null));
		}
		// .. 其他合法性校验

		// 设置主键
		procedurecodingCustom.setId(UUIDBuild.getUUID());
		procedurecodingCustom.setTechnicsname(technicsname);
		procedurecodingCustom.setMaterielid(mid);
		procedurecodingMapper.insert(procedurecodingCustom);
		if (procedurecodingCustom.getPc().equals("折弯")) {
			semiproductaService.insertSemiproduct(mname, ctypeid,procedurecodingCustom.getMaterielcoding());
		} else if (procedurecodingCustom.getPc().equals("总装")) {
			fproductService.insertFproduct(ctypeid,procedurecodingCustom.getMaterielcoding());
		}
	}

	@Override
	public Procedurecoding findProcedurecodingByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
