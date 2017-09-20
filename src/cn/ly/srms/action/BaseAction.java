/*
 * 文件名：BaseAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： BaseAction.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年8月22日
 * 修改内容：新增
 */
package cn.ly.srms.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO添加类描述
 * @author     liuyi 1610140
 * @version    SRMS 2017年8月22日
 * @since      SRMS
 */
public class BaseAction extends ActionSupport implements SessionAware{
	public ByteArrayInputStream inputStream;
	public Map<String, Object> session;
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	

}

