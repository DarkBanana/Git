package cn.cjpt.mes.service;

import cn.cjpt.mes.pojo.po.SysUserRole;

/**
 * 用户 角色 关系
 * 
 * @author yxf 2017年2月26日 下午1:58:31
 * 
 */
public interface SysUserRoleService {

	public SysUserRole findSysUserRoleByUserID(String userid) throws Exception;
}
