package cn.ly.srms.entity;

import java.io.Serializable;



public class RoleLimit implements Serializable {
	private String roleId;
	private String limitId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getLimitId() {
		return limitId;
	}
	public void setLimitId(String limitId) {
		this.limitId = limitId;
	}
	
}
