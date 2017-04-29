package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.MaintenanceMapper;
import cn.cjpt.mes.mapper.MaintenanceMapperCustom;
import cn.cjpt.mes.pojo.po.Maintenance;
import cn.cjpt.mes.pojo.po.MaintenanceExample;
import cn.cjpt.mes.pojo.vo.ActiveMaintenance;
import cn.cjpt.mes.pojo.vo.MaintenanceCustom;
import cn.cjpt.mes.pojo.vo.MaintenanceQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.MaintenanceService;
import cn.cjpt.mes.util.MD5;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 接口实现类 2017年2月16日 上午11:04:44
 * 
 * @author yxf
 */
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	private MaintenanceMapperCustom maintenanceMapperCustom;
	@Autowired
	private MaintenanceMapper maintenanceMapper;

	@Override
	public List<MaintenanceCustom> findMaintenanceList(
			MaintenanceQueryVo maintenanceQueryVo) throws Exception {

		int page = maintenanceQueryVo.getPageQuery().getPage();
		int rows = maintenanceQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return maintenanceMapperCustom.findMaintenanceList(maintenanceQueryVo);
	}

	@Override
	public int findMaintenanceCount(MaintenanceQueryVo maintenanceQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return maintenanceMapperCustom.findMaintenanceCount(maintenanceQueryVo);
	}

	/**
	 * 根据用户 账号查询 用户信息
	 * 
	 * @param maintenanceid
	 * @return
	 * @throws Exception
	 */

	public Maintenance findMaintenanceBymaintenanceid(String maintenanceid)
			throws Exception {

		MaintenanceExample maintenanceExample = new MaintenanceExample();
		MaintenanceExample.Criteria criteria = maintenanceExample
				.createCriteria();
		// 设置查询条件，根据账号查询
		criteria.andIdEqualTo(maintenanceid);
		List<Maintenance> list = maintenanceMapper
				.selectByExample(maintenanceExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 用户身份 认证
	 */
	@Override
	public ActiveMaintenance checkMaintenanceInfo(String Id, String pwd)
			throws Exception {

		Maintenance maintenance_db = this.findMaintenanceBymaintenanceid(Id);
		if (maintenance_db == null) {
			// 账号不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		// 校验 身份 信息 是否合法
		String pwd_MD5 = new MD5().getMD5ofStr(pwd);
		if (!maintenance_db.getId().equalsIgnoreCase(pwd_MD5)) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 114,
					null));
		}

		// 构建用户身份信息
		ActiveMaintenance activeMaintenance = new ActiveMaintenance();
		activeMaintenance.setId(maintenance_db.getId());
		activeMaintenance.setToolname(maintenance_db.getToolname());

		return activeMaintenance;
	}

	/**
	 * 根据 ID 查找用户信息
	 */
	@Override
	public MaintenanceCustom findMaintenanceById(String id) throws Exception {
		// 从数据库查询用户
		Maintenance maintenance = maintenanceMapper.selectByPrimaryKey(id);
		if (maintenance == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		MaintenanceCustom maintenanceCustom = new MaintenanceCustom();
		// 将maintenance中数据设置到maintenanceCustom
		BeanUtils.copyProperties(maintenance, maintenanceCustom);
		return maintenanceCustom;
	}

	/**
	 * 修改 用户信息
	 * 
	 * @param id
	 * @param maintenanceCustom
	 * @throws Exception
	 */
	@Override
	public void updateMaintenance(String id, MaintenanceCustom maintenanceCustom)
			throws Exception {
		// 从数据库查询用户信息
		Maintenance maintenance_db = maintenanceMapper.selectByPrimaryKey(id);

		// 如果修改了账号
		if (!maintenanceCustom.getId().equals(maintenance_db.getId())) {
			// 修改后的账号不能重复
			Maintenance findMaintenanceBymaintenanceid = this
					.findMaintenanceBymaintenanceid(maintenanceCustom.getId());
			if (findMaintenanceBymaintenanceid != null) {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						213, null));
			}
		}
		// 密码修改
		// 如果从页面提交的密码值为空说明用户不修改密码，否则 就需要对密码进行加密存储
		String pwd_page = maintenanceCustom.getId().trim();
		String pwd_md5 = null;
		if (pwd_page != null && !pwd_page.equals("")) {
			// 说明用户修改密码了
			pwd_md5 = new MD5().getMD5ofStr(pwd_page);
		}
		maintenance_db.setId(maintenanceCustom.getId());
		maintenance_db.setToolname(maintenanceCustom.getToolname());
		maintenance_db.setSpecifications(maintenanceCustom.getSpecifications());
		maintenance_db.setMtime(maintenanceCustom.getMtime());
		maintenance_db.setNote(maintenanceCustom.getNote());
		maintenance_db.setPerson(maintenanceCustom.getPerson());
		if (pwd_md5 != null) {
			maintenance_db.setId(pwd_md5);
		}
		maintenance_db.setId(maintenanceCustom.getId());
		maintenanceMapper.updateByPrimaryKey(maintenance_db);
	}

	/**
	 * 删除系统用户
	 */
	@Override
	public void deleteMaintenance(String id) throws Exception {
		// 校验 用户是否存在
		Maintenance maintenance_db = maintenanceMapper.selectByPrimaryKey(id);
		if (maintenance_db == null) {
			// 用户不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 212,
					null));
		}
		maintenanceMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 添加系统用户信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void insertMaintenance(MaintenanceCustom maintenanceCustom)
			throws Exception {
		// 信息 合法性 校验
		// 1.用户账号 不能 重复
		String maintenanceid_page = maintenanceCustom.getId();
		Maintenance maintenance_db = this
				.findMaintenanceBymaintenanceid(maintenanceid_page);
		if (maintenance_db != null) {
			// 用户 输入的账号重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 213,
					null));
		}
		// .. 其他合法性校验

		// 设置主键
		maintenanceCustom.setId(maintenanceCustom.getId());
		// 用户密码 MD5 加密
		maintenanceMapper.insert(maintenanceCustom);
	}

	@Override
	public Maintenance findMaintenanceByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
