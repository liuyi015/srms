package cn.ly.srms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class RoleInfo implements Serializable{
	private String roleId;
	private String roleName;
	private String roleType;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	
}
