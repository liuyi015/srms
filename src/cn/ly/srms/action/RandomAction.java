/*
 * 文件名：RandomAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： RandomAction.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年8月21日
 * 修改内容：新增
 */
package cn.ly.srms.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;





import cn.ly.srms.action.common.tool.RandomNumUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 随机获取动态验证码（图片）
 * @author     liuyi 1610140
 * @version    srms 2017年8月21日
 * @since      srms
 */
@Controller @Scope("prototype")
public class RandomAction extends BaseAction implements SessionAware {

	private Map<String, Object> session;
	private RandomNumUtil rnu=RandomNumUtil.Instance();
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	public String execute() throws Exception{
		/*取得带有随机字符串的图片*/		
		this.setInputStream(rnu.getImage());
		/*取得随机字符串放入HttpSession*/		
		session.put("verfCode",rnu.getString());
		return SUCCESS;     
	}
	
}

