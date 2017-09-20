/*
 * 文件名：ProfileAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ProfileAction.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年8月25日
 * 修改内容：新增
 */
package cn.ly.srms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.ly.srms.entity.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TODO添加类描述
 * @author     liuyi 1610140
 * @version    CCAS 2017年8月25日
 * @since      CCAS
 */
@Controller @Scope("prototype")
public class ProfileAction extends BaseAction implements ModelDriven<User>{
	
	



	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}