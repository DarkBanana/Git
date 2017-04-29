package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.SysPermissionMapperCustom;
import cn.cjpt.mes.mapper.SysUserMapper;
import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.pojo.po.SysUser;
import cn.cjpt.mes.pojo.po.SysUserExample;
import cn.cjpt.mes.pojo.vo.ActiveUser;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.SysService;
import cn.cjpt.mes.util.MD5;

/**
 * 认证和授权的服务
 * 
 * @author yxf Feb 21, 2017 9:40:57 AM
 * 
 */
public class SysServiceImpl implements SysService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;

	// 根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode) throws Exception {
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(userCode);

		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}

		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String userid)
			throws Exception {

		return sysPermissionMapperCustom.findMenuListByUserId(userid);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid)
			throws Exception {

		return sysPermissionMapperCustom.findPermissionListByUserId(userid);
	}

}
