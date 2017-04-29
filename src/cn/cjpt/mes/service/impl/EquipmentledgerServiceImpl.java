package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.EquipmentledgerMapper;
import cn.cjpt.mes.mapper.EquipmentledgerMapperCustom;
import cn.cjpt.mes.pojo.po.Equipmentledger;
import cn.cjpt.mes.pojo.po.EquipmentledgerExample;
import cn.cjpt.mes.pojo.vo.ActiveEquipmentledger;
import cn.cjpt.mes.pojo.vo.EquipmentledgerCustom;
import cn.cjpt.mes.pojo.vo.EquipmentledgerQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.EquipmentledgerService;
import cn.cjpt.mes.util.MD5;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 接口实现类 2017年2月16日 上午11:04:44
 * 
 * @author yxf
 */
public class EquipmentledgerServiceImpl implements EquipmentledgerService {

	@Autowired
	private EquipmentledgerMapperCustom equipmentledgerMapperCustom;
	@Autowired
	private EquipmentledgerMapper equipmentledgerMapper;

	@Override
	public List<EquipmentledgerCustom> findEquipmentledgerList(
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception {

		int page = equipmentledgerQueryVo.getPageQuery().getPage();
		int rows = equipmentledgerQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return equipmentledgerMapperCustom
				.findEquipmentledgerList(equipmentledgerQueryVo);
	}

	@Override
	public int findEquipmentledgerCount(
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return equipmentledgerMapperCustom
				.findEquipmentledgerCount(equipmentledgerQueryVo);
	}

	/**
	 * 根据设备 账号查询 设备信息
	 * 
	 * @param equipmentledgerid
	 * @return
	 * @throws Exception
	 */

	public Equipmentledger findEquipmentledgerByequipmentledgerid(
			String equipmentledgerid) throws Exception {

		EquipmentledgerExample equipmentledgerExample = new EquipmentledgerExample();
		EquipmentledgerExample.Criteria criteria = equipmentledgerExample
				.createCriteria();
		// 设置查询条件，根据账号查询
		criteria.andIdEqualTo(equipmentledgerid);
		List<Equipmentledger> list = equipmentledgerMapper
				.selectByExample(equipmentledgerExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 设备身份 认证
	 */
	@Override
	public ActiveEquipmentledger checkEquipmentledgerInfo(String Id, String pwd)
			throws Exception {

		Equipmentledger equipmentledger_db = this
				.findEquipmentledgerByequipmentledgerid(Id);
		if (equipmentledger_db == null) {
			// 账号不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		// 校验 身份 信息 是否合法
		String pwd_MD5 = new MD5().getMD5ofStr(pwd);
		if (!equipmentledger_db.getId().equalsIgnoreCase(pwd_MD5)) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 114,
					null));
		}

		// 构建设备身份信息
		ActiveEquipmentledger activeEquipmentledger = new ActiveEquipmentledger();
		activeEquipmentledger.setId(equipmentledger_db.getId());
		activeEquipmentledger.setToolname(equipmentledger_db.getToolname());

		return activeEquipmentledger;
	}

	/**
	 * 根据 ID 查找设备信息
	 */
	@Override
	public EquipmentledgerCustom findEquipmentledgerById(String id)
			throws Exception {
		// 从数据库查询设备
		Equipmentledger equipmentledger = equipmentledgerMapper
				.selectByPrimaryKey(id);
		if (equipmentledger == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		EquipmentledgerCustom equipmentledgerCustom = new EquipmentledgerCustom();
		// 将equipmentledger中数据设置到equipmentledgerCustom
		BeanUtils.copyProperties(equipmentledger, equipmentledgerCustom);
		return equipmentledgerCustom;
	}

	/**
	 * 修改 设备信息
	 * 
	 * @param id
	 * @param equipmentledgerCustom
	 * @throws Exception
	 */
	@Override
	public void updateEquipmentledger(String id,
			EquipmentledgerCustom equipmentledgerCustom) throws Exception {
		// 从数据库查询设备信息
		Equipmentledger equipmentledger_db = equipmentledgerMapper
				.selectByPrimaryKey(id);

		// 如果修改了账号
		if (!equipmentledgerCustom.getId().equals(equipmentledger_db.getId())) {
			// 修改后的账号不能重复
			Equipmentledger findEquipmentledgerByequipmentledgerid = this
					.findEquipmentledgerByequipmentledgerid(equipmentledgerCustom
							.getId());
			if (findEquipmentledgerByequipmentledgerid != null) {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						213, null));
			}
		}
		// 密码修改
		// 如果从页面提交的密码值为空说明设备不修改密码，否则 就需要对密码进行加密存储
		String pwd_page = equipmentledgerCustom.getId().trim();
		String pwd_md5 = null;
		if (pwd_page != null && !pwd_page.equals("")) {
			// 说明设备修改密码了
			pwd_md5 = new MD5().getMD5ofStr(pwd_page);
		}
		equipmentledger_db.setId(equipmentledgerCustom.getId());
		equipmentledger_db.setToolname(equipmentledgerCustom.getToolname());
		equipmentledger_db.setSpecifications(equipmentledgerCustom
				.getSpecifications());
		equipmentledger_db.setToolnumber(equipmentledgerCustom.getToolnumber());
		equipmentledger_db.setManufacturer(equipmentledgerCustom
				.getManufacturer());
		equipmentledger_db.setPurchasedate(equipmentledgerCustom
				.getPurchasedate());
		if (pwd_md5 != null) {
			equipmentledger_db.setId(pwd_md5);
		}
		equipmentledger_db.setId(equipmentledgerCustom.getId());
		equipmentledgerMapper.updateByPrimaryKey(equipmentledger_db);
	}

	/**
	 * 删除系统设备
	 */
	@Override
	public void deleteEquipmentledger(String id) throws Exception {
		// 校验 设备是否存在
		Equipmentledger equipmentledger_db = equipmentledgerMapper
				.selectByPrimaryKey(id);
		if (equipmentledger_db == null) {
			// 设备不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 212,
					null));
		}
		equipmentledgerMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 添加系统设备信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void insertEquipmentledger(
			EquipmentledgerCustom equipmentledgerCustom) throws Exception {
		// 信息 合法性 校验
		// 1.设备账号 不能 重复
		String equipmentledgerid_page = equipmentledgerCustom.getId();
		Equipmentledger equipmentledger_db = this
				.findEquipmentledgerByequipmentledgerid(equipmentledgerid_page);
		if (equipmentledger_db != null) {
			// 设备 输入的账号重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 213,
					null));
		}
		// .. 其他合法性校验

		// 设置主键
		equipmentledgerCustom.setId(equipmentledgerCustom.getId());
		// 设备密码 MD5 加密
		equipmentledgerMapper.insert(equipmentledgerCustom);
	}

	@Override
	public Equipmentledger findEquipmentledgerByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
