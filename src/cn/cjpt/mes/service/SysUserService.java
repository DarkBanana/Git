package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.SysUser;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.pojo.vo.SysUserQueryVo;

/**
 * 系统用户管理
 * 
 * @author yxf Feb 24, 2017 9:00:06 PM
 * 
 */
public interface SysUserService {
	// 查询 用户 列表
	public List<SysUserCustom> findSysUserList(SysUserQueryVo sysUserQueryVo)
			throws Exception;

	// 根据 用户 id 查询 用户信息
	public SysUser findSysUserById(String userid) throws Exception;

	// 更新 用户 信息 包括 用户 对应的 角色信息
	public void updateSysUser(String userid, SysUserCustom sysUserCustom)
			throws Exception;

	// 根据 用户 账号 查找 用户信息
	public SysUser findSysUserByUsercode(String usercode) throws Exception;

	// 插入 用户信息
	public void insertSysUser(SysUserCustom sysUserCustom) throws Exception;

	// 删除用户
	public void deleteSysUser(String userid) throws Exception;
}
