package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.ToolmanagementMapper;
import cn.cjpt.mes.mapper.ToolmanagementMapperCustom;
import cn.cjpt.mes.pojo.po.Toolmanagement;
import cn.cjpt.mes.pojo.po.ToolmanagementExample;
import cn.cjpt.mes.pojo.vo.ActiveToolmanagement;
import cn.cjpt.mes.pojo.vo.ToolmanagementCustom;
import cn.cjpt.mes.pojo.vo.ToolmanagementQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.ToolmanagementService;
import cn.cjpt.mes.util.MD5;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 接口实现类 2017年2月16日 上午11:04:44
 * 
 * @author yxf
 */
public class ToolmanagementServiceImpl implements ToolmanagementService {

	@Autowired
	private ToolmanagementMapperCustom toolmanagementMapperCustom;
	@Autowired
	private ToolmanagementMapper toolmanagementMapper;

	@Override
	public List<ToolmanagementCustom> findToolmanagementList(
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception {

		int page = toolmanagementQueryVo.getPageQuery().getPage();
		int rows = toolmanagementQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return toolmanagementMapperCustom
				.findToolmanagementList(toolmanagementQueryVo);
	}

	@Override
	public int findToolmanagementCount(
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return toolmanagementMapperCustom
				.findToolmanagementCount(toolmanagementQueryVo);
	}

	/**
	 * 根据用户 账号查询 用户信息
	 * 
	 * @param toolmanagementid
	 * @return
	 * @throws Exception
	 */

	public Toolmanagement findToolmanagementBytoolmanagementid(
			String toolmanagementid) throws Exception {

		ToolmanagementExample toolmanagementExample = new ToolmanagementExample();
		ToolmanagementExample.Criteria criteria = toolmanagementExample
				.createCriteria();
		// 设置查询条件，根据账号查询
		criteria.andIdEqualTo(toolmanagementid);
		List<Toolmanagement> list = toolmanagementMapper
				.selectByExample(toolmanagementExample);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 用户身份 认证
	 */
	@Override
	public ActiveToolmanagement checkToolmanagementInfo(String Id, String pwd)
			throws Exception {

		Toolmanagement toolmanagement_db = this
				.findToolmanagementBytoolmanagementid(Id);
		if (toolmanagement_db == null) {
			// 账号不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		// 校验 身份 信息 是否合法
		String pwd_MD5 = new MD5().getMD5ofStr(pwd);
		if (!toolmanagement_db.getId().equalsIgnoreCase(pwd_MD5)) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 114,
					null));
		}

		// 构建用户身份信息
		ActiveToolmanagement activeToolmanagement = new ActiveToolmanagement();
		activeToolmanagement.setId(toolmanagement_db.getId());
		activeToolmanagement.setToolname(toolmanagement_db.getToolname());

		return activeToolmanagement;
	}

	/**
	 * 根据 ID 查找用户信息
	 */
	@Override
	public ToolmanagementCustom findToolmanagementById(String id)
			throws Exception {
		// 从数据库查询用户
		Toolmanagement toolmanagement = toolmanagementMapper
				.selectByPrimaryKey(id);
		if (toolmanagement == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101,
					null));
		}
		ToolmanagementCustom toolmanagementCustom = new ToolmanagementCustom();
		// 将toolmanagement中数据设置到toolmanagementCustom
		BeanUtils.copyProperties(toolmanagement, toolmanagementCustom);
		return toolmanagementCustom;
	}

	/**
	 * 修改 用户信息
	 * 
	 * @param id
	 * @param toolmanagementCustom
	 * @throws Exception
	 */
	@Override
	public void updateToolmanagement(String id,
			ToolmanagementCustom toolmanagementCustom) throws Exception {
		// 从数据库查询用户信息
		Toolmanagement toolmanagement_db = toolmanagementMapper
				.selectByPrimaryKey(id);

		// 如果修改了账号
		if (!toolmanagementCustom.getId().equals(toolmanagement_db.getId())) {
			// 修改后的账号不能重复
			Toolmanagement findToolmanagementBytoolmanagementid = this
					.findToolmanagementBytoolmanagementid(toolmanagementCustom
							.getId());
			if (findToolmanagementBytoolmanagementid != null) {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						213, null));
			}
		}
		// 密码修改
		// 如果从页面提交的密码值为空说明用户不修改密码，否则 就需要对密码进行加密存储
		String pwd_page = toolmanagementCustom.getId().trim();
		String pwd_md5 = null;
		if (pwd_page != null && !pwd_page.equals("")) {
			// 说明用户修改密码了
			pwd_md5 = new MD5().getMD5ofStr(pwd_page);
		}
		toolmanagement_db.setId(toolmanagementCustom.getId());
		toolmanagement_db.setToolname(toolmanagementCustom.getToolname());
		toolmanagement_db.setSpecifications(toolmanagementCustom
				.getSpecifications());
		toolmanagement_db.setToolnumber(toolmanagementCustom.getToolnumber());
		toolmanagement_db.setManufacturer(toolmanagementCustom
				.getManufacturer());
		toolmanagement_db.setRemark(toolmanagementCustom.getRemark());
		if (pwd_md5 != null) {
			toolmanagement_db.setId(pwd_md5);
		}
		toolmanagement_db.setId(toolmanagementCustom.getId());
		toolmanagementMapper.updateByPrimaryKey(toolmanagement_db);
	}

	/**
	 * 删除系统用户
	 */
	@Override
	public void deleteToolmanagement(String id) throws Exception {
		// 校验 用户是否存在
		Toolmanagement toolmanagement_db = toolmanagementMapper
				.selectByPrimaryKey(id);
		if (toolmanagement_db == null) {
			// 用户不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 212,
					null));
		}
		toolmanagementMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 添加系统用户信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void insertToolmanagement(ToolmanagementCustom toolmanagementCustom)
			throws Exception {
		// 信息 合法性 校验
		// 1.用户账号 不能 重复
		String toolmanagementid_page = toolmanagementCustom.getId();
		Toolmanagement toolmanagement_db = this
				.findToolmanagementBytoolmanagementid(toolmanagementid_page);
		if (toolmanagement_db != null) {
			// 用户 输入的账号重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 213,
					null));
		}
		// .. 其他合法性校验

		// 设置主键
		toolmanagementCustom.setId(toolmanagementCustom.getId());
		// 用户密码 MD5 加密
		toolmanagementMapper.insert(toolmanagementCustom);
	}

	@Override
	public Toolmanagement findToolmanagementByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
