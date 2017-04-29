package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.SysUserRoleMapper;
import cn.cjpt.mes.pojo.po.SysUserRole;
import cn.cjpt.mes.pojo.po.SysUserRoleExample;
import cn.cjpt.mes.service.SysUserRoleService;

public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	/**
	 * 根据 用户 id 查询 角色和 用户信息
	 */
	@Override
	public SysUserRole findSysUserRoleByUserID(String userid) throws Exception {

		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = sysUserRoleExample
				.createCriteria();
		criteria.andSysUserIdEqualTo(userid);
		List<SysUserRole> sysUserRoleList = sysUserRoleMapper
				.selectByExample(sysUserRoleExample);

		if (sysUserRoleList != null && sysUserRoleList.size() == 1) {
			return sysUserRoleList.get(0);
		}

		return null;
	}
}
