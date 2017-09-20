package cn.ly.srms.entity;

import java.util.List;

// Generated 2017-3-11 15:25:23 by Hibernate Tools 3.4.0.CR1

/**
 * 
 * 权限信息表（LimitInfo）
 */
public class LimitInfo implements java.io.Serializable {

	private String limitId;
	private String limitName;
	private String limitRemark;
	private String limitLevel;
	private String limitParent;
	private String limitUrl;
	private String limitIcon;
	private String limitState;
	private String menuFlag;
	private String limitType;

	public LimitInfo() {
	}

	public LimitInfo(String limitId, String limitName, String limitLevel,
			String limitState, String menuFlag, String limitType) {
		this.limitId = limitId;
		this.limitName = limitName;
		this.limitLevel = limitLevel;
		this.limitState = limitState;
		this.menuFlag = menuFlag;
		this.limitType = limitType;
	}

	public LimitInfo(String limitId, String limitName, String limitRemark,
			String limitLevel, String limitParent, String limitUrl,
			String limitIcon, String limitState, String menuFlag, String limitType) {
		this.limitId = limitId;
		this.limitName = limitName;
		this.limitRemark = limitRemark;
		this.limitLevel = limitLevel;
		this.limitParent = limitParent;
		this.limitUrl = limitUrl;
		this.limitIcon = limitIcon;
		this.limitState = limitState;
		this.menuFlag = menuFlag;
		this.limitType = limitType;
	}

	public String getLimitId() {
		return this.limitId;
	}

	public void setLimitId(String limitId) {
		this.limitId = limitId;
	}

	public String getLimitName() {
		return this.limitName;
	}

	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}

	public String getLimitRemark() {
		return this.limitRemark;
	}

	public void setLimitRemark(String limitRemark) {
		this.limitRemark = limitRemark;
	}

	public String getLimitLevel() {
		return this.limitLevel;
	}

	public void setLimitLevel(String limitLevel) {
		this.limitLevel = limitLevel;
	}

	public String getLimitParent() {
		return this.limitParent;
	}

	public void setLimitParent(String limitParent) {
		this.limitParent = limitParent;
	}

	public String getLimitUrl() {
		return this.limitUrl;
	}

	public void setLimitUrl(String limitUrl) {
		this.limitUrl = limitUrl;
	}

	public String getLimitIcon() {
		return this.limitIcon;
	}

	public void setLimitIcon(String limitIcon) {
		this.limitIcon = limitIcon;
	}

	public String getLimitState() {
		return this.limitState;
	}

	public void setLimitState(String limitState) {
		this.limitState = limitState;
	}

	public String getMenuFlag() {
		return this.menuFlag;
	}

	public void setMenuFlag(String menuFlag) {
		this.menuFlag = menuFlag;
	}

	public String getLimitType() {
		return this.limitType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}

	public List limitChild;

	public List getLimitChild() {
		return limitChild;
	}

	public void setLimitChild(List limitChild) {
		this.limitChild = limitChild;
	}
	
}
