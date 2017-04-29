package cn.cjpt.mes.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.SysUserMapper;
import cn.cjpt.mes.mapper.SysUserMapperCustom;
import cn.cjpt.mes.mapper.SysUserRoleMapper;
import cn.cjpt.mes.pojo.po.SysRole;
import cn.cjpt.mes.pojo.po.SysUser;
import cn.cjpt.mes.pojo.po.SysUserExample;
import cn.cjpt.mes.pojo.po.SysUserRole;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.pojo.vo.SysUserQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.SysRoleService;
import cn.cjpt.mes.service.SysUserRoleService;
import cn.cjpt.mes.service.SysUserService;
import cn.cjpt.mes.shiro.CustomRealm;
import cn.cjpt.mes.util.RandomUtils;
import cn.cjpt.mes.util.UUIDBuild;

public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapperCustom sysUserMapperCustom;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private CustomRealm customRealm;

	/**
	 * 查询 用户列表
	 */
	@Override
	public List<SysUserCustom> findSysUserList(SysUserQueryVo sysUserQueryVo)
			throws Exception {

		int page = sysUserQueryVo.getPageQuery().getPage();
		int rows = sysUserQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return sysUserMapperCustom.findSysUserList(sysUserQueryVo);
	}

	/**
	 * 根据 用户 id 查询 用户信息
	 */
	@Override
	public SysUser findSysUserById(String userid) throws Exception {

		return sysUserMapper.selectByPrimaryKey(userid);
	}

	// 更新 用户信息
	@Override
	public void updateSysUser(String userid, SysUserCustom sysUserCustom)
			throws Exception {

		SysUser sysuser_db = sysUserMapper.selectByPrimaryKey(userid);
		if (sysuser_db == null) {
			// 用户 不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 204,
					null));
		}

		// 用户修改了账号
		String usercode_page = sysUserCustom.getUsercode();
		String usercode_db = sysuser_db.getUsercode();
		if (!usercode_page.equals(usercode_db)) {
			// 通过页面提交的账号查询数据库，如果查到说明暂用别人的账号
			SysUser sysUser_1 = this.findSysUserByUsercode(usercode_page);
			if (sysUser_1 != null) {
				// 说明暂用别人的账号
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						213, null));
			}
		}

		// 数据库 中的 用户密码
		String pwd_db = sysuser_db.getPassword();
		// 获取 页面的输入的密码
		String pwd_page;
		// 加密后的 密码
		String pwd_MD5;
		if (sysUserCustom.getPassword() != "") {
			pwd_page = sysUserCustom.getPassword();
			String salt = new RandomUtils().generateLowerString(4);
			pwd_MD5 = new Md5Hash(pwd_page, salt, 1).toString();
			// 校验 密码与之前的是否一样
			if (!pwd_db.equals(pwd_MD5)) {
				sysuser_db.setPassword(pwd_MD5);
				sysuser_db.setSalt(salt);
			}
		}
		// 更新 用户权限
		if (sysUserCustom.getRoleName() != "") {
			// 用户 修改了权限
			String roleName_page = sysUserCustom.getRoleName();
			// 先查看用户 之前是否有角色 信息存在，如果有，修改。没有，则创建 对应的角色信息
			SysRole findSysRoleByUserId = sysRoleService
					.findSysRoleByUserId(userid);

			if (findSysRoleByUserId != null) { // 之前 有分配 角色
				// 对比角色是否修改了
				if (!roleName_page.equals(findSysRoleByUserId.getName())) {
					// 修改了权限
					SysRole sysRole_db = sysRoleService
							.findSysRoleByRoleName(roleName_page);
					// 用户 对应的 角色信息
					SysUserRole sysUserRole_db = sysUserRoleService
							.findSysUserRoleByUserID(sysuser_db.getId());
					sysUserRole_db.setSysRoleId(sysRole_db.getId());
					sysUserRoleMapper.updateByPrimaryKey(sysUserRole_db);
				}
			} else {
				// 用户之前 没有 角色信息
				SysRole sysRole_db = sysRoleService
						.findSysRoleByRoleName(roleName_page);
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setSysRoleId(sysRole_db.getId());
				sysUserRole.setSysUserId(sysuser_db.getId());
				sysUserRoleMapper.insert(sysUserRole);
			}
			// 修改了 角色信息 ，清楚缓存
			customRealm.clearCached();
		}

		// 根据 用户的其他信息
		sysuser_db.setUsercode(sysUserCustom.getUsercode());
		sysuser_db.setAge(sysUserCustom.getAge());
		sysuser_db.setDepartment(sysUserCustom.getDepartment());
		sysuser_db.setJobnumber(sysUserCustom.getJobnumber());
		sysuser_db.setPositionaltitles(sysUserCustom.getPositionaltitles());
		sysuser_db.setSex(sysUserCustom.getSex());
		sysuser_db.setTel(sysUserCustom.getTel());
		sysuser_db.setUsername(sysUserCustom.getUsername());
		sysuser_db.setWorktype(sysUserCustom.getWorktype());
		sysUserMapper.updateByPrimaryKey(sysuser_db);
	}

	/**
	 * 根据 用户 名查找用户信息
	 */
	@Override
	public SysUser findSysUserByUsercode(String usercode) throws Exception {
		// TODO Auto-generated method stub

		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		List<SysUser> sysUserList = sysUserMapper
				.selectByExample(sysUserExample);

		if (sysUserList != null && sysUserList.size() == 1) {
			return sysUserList.get(0);
		}

		return null;
	}

	/**
	 * 添加用户信息
	 */

	@Override
	public void insertSysUser(SysUserCustom sysUserCustom) throws Exception {

		// 1.校验 账号是否重复
		String usercode_page = sysUserCustom.getUsercode();
		// 根据 用户账号 查询用户
		SysUser findSysUserByUsercode = this
				.findSysUserByUsercode(usercode_page);
		if (findSysUserByUsercode != null) {
			// 用户账号重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 213,
					null));
		}
		// 2.校验对应的角色信息
		String roleName = sysUserCustom.getRoleName();
		SysRole sysRole_db = sysRoleService.findSysRoleByRoleName(roleName);
		if (sysRole_db == null) {
			// 角色不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 211,
					null));
		}
		// 角色的id
		String roleid = sysRole_db.getId();
		// new 一个 sysUser
		SysUser sysUser = new SysUser();
		String userid = new UUIDBuild().getUUID();
		// 密码 md5 加密
		String pwd_page = sysUserCustom.getPassword();
		String salt = new RandomUtils().generateLowerString(4);
		String pwd_MD5 = new Md5Hash(pwd_page, salt, 1).toString();
		sysUser.setPassword(pwd_MD5);
		sysUser.setSalt(salt);
		// 设置 sysUser的基本属性
		sysUser.setId(userid);
		sysUser.setAge(sysUserCustom.getAge());
		sysUser.setDepartment(sysUserCustom.getDepartment());
		sysUser.setJobnumber(sysUserCustom.getJobnumber());
		sysUser.setPositionaltitles(sysUserCustom.getPositionaltitles());
		sysUser.setSex(sysUserCustom.getSex());
		sysUser.setTel(sysUserCustom.getTel());
		sysUser.setUsercode(usercode_page);
		sysUser.setUsername(sysUserCustom.getUsername());
		sysUser.setWorktype(sysUserCustom.getWorktype());

		sysUserMapper.insert(sysUser);

		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setId(new UUIDBuild().getUUID());
		sysUserRole.setSysRoleId(roleid);
		sysUserRole.setSysUserId(userid);
		sysUserRoleMapper.insert(sysUserRole);
		// TODO Auto-generated method stub
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deleteSysUser(String userid) throws Exception {
		SysUser sysUser_db = sysUserMapper.selectByPrimaryKey(userid);
		if (sysUser_db == null) {
			// 用户不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 212,
					null));
		}

		// 并删除 用户 对应的 角色
		// 用户对应的 角色信息
		SysUserRole sysUserRole = sysUserRoleService
				.findSysUserRoleByUserID(userid);
		if (sysUserRole != null) {
			sysUserRoleMapper.deleteByPrimaryKey(sysUserRole.getId());
		}
		// 删除用户
		sysUserMapper.deleteByPrimaryKey(userid);
	}
}
