package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.pojo.po.SysUser;
import cn.cjpt.mes.pojo.vo.ActiveUser;

/**
 * 认证授权服务接口 2017年2月19日 下午10:03:49
 * 
 * @author yxf
 */
public interface SysService {

	// 根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode) throws Exception;

	// 根据用户id查询权限范围的菜单
	public List<SysPermission> findMenuListByUserId(String userid)
			throws Exception;

	// 根据用户id查询权限范围的url
	public List<SysPermission> findPermissionListByUserId(String userid)
			throws Exception;
}
