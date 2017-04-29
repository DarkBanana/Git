package cn.cjpt.mes.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import cn.cjpt.mes.pojo.po.SysRole;
import cn.cjpt.mes.pojo.po.SysUser;

/**
 * 自定义 的 SysUser 扩展属性
 * 
 * @author yxf Feb 24, 2017 8:33:20 PM
 * 
 */
public class SysUserCustom extends SysUser {

	private String roleName;

	private List<SysRole> roleList = new ArrayList<SysRole>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

}
