package cn.ly.srms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;




public class UserRole implements Serializable{
	private Integer userId;
	private String roleId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
}
