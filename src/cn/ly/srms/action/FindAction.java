package cn.ly.srms.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ly.srms.common.util.StringUtil;
import cn.ly.srms.dao.FindUserInfoDao;
import cn.ly.srms.dao.MessageInfoDao;
import cn.ly.srms.entity.FindUserInfo;
import cn.ly.srms.entity.MessageInfo;
import cn.ly.srms.entity.User;
import cn.ly.srms.service.FindUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller @Scope("prototype")
public class FindAction extends ActionSupport implements ModelDriven<FindUserInfo>{

	private FindUserInfo findUserInfo=new FindUserInfo();

	@Override
	public FindUserInfo getModel() {
		return findUserInfo;
	}
	
	@Resource FindUserService findUserService;
	@Resource FindUserInfoDao findUserInfoDao;
	@Resource MessageInfoDao messageInfoDao;
	
	/*
	 * 查询和显示列表
	 */
	@SuppressWarnings("unchecked")
	public String toList(){
		ActionContext actionContext=ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		
		List<FindUserInfo> list=findUserService.getFindUserList(findUserInfo);
		System.out.println(list.size());
		request.setAttribute("findUserList", list);
		return SUCCESS;
	}
	
	/*
	 * 查看详情
	 */
	public String toDetail(){
		ActionContext actionContext=ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		String id=request.getParameter("id");
		FindUserInfo findUserInfo=findUserService.getFindUserByKey(Integer.parseInt(id));
		request.setAttribute("findUserInfo", findUserInfo);
		return "detail";
	}
	
	/*
	 * 发布寻人启事页面
	 */
	public String toAdd(){
		return "add";
	}
	
	/*
	 * 发布寻人启事
	 */
	public String doAdd(){
		ActionContext actionContext=ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		//获取当前用户
		User user=(User) request.getSession().getAttribute("existUser");
		if(StringUtil.isNullOrWhiteSpace(user)){
			request.setAttribute("alertInfo", "请先登陆！");
			return "add";
		}
		int userId=user.getUserId();
		FindUserInfo fu=new FindUserInfo();
		fu.setPublisher(userId);
		fu.setPublisherName(findUserInfo.getPublisherName());
		fu.setUserName(findUserInfo.getUserName());
		fu.setAddress(findUserInfo.getAddress());
		fu.setSchool(findUserInfo.getSchool());
		fu.setMessage(findUserInfo.getMessage());
		fu.setPublishTime(new Timestamp(System.currentTimeMillis()).toString());
		findUserInfoDao.save(fu);
		request.setAttribute("alertInfo", "发布成功");
		return "ok";
	}
	
	/*
	 *留言页面
	 */
	public String toMessage(){
		ActionContext actionContext=ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		String id=request.getParameter("id");
		FindUserInfo findUserInfo=findUserService.getFindUserByKey(Integer.parseInt(id));
		request.setAttribute("findUserInfo", findUserInfo);
		return "message";
	}
	/*
	 * 留言
	 */
	public String doMessage(){
		ActionContext actionContext=ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		//获取当前用户
		User user=(User) request.getSession().getAttribute("existUser");
		if(StringUtil.isNullOrWhiteSpace(user)){
			request.setAttribute("alertInfo", "请先登陆！");
			return "message";
		}
		int userId=user.getUserId();
		int publisherId=Integer.parseInt(request.getParameter("publisherId"));
		if(userId==publisherId){
			request.setAttribute("alertInfo", "不能给自己留言");
			return "ok";
		}
		MessageInfo mi=new MessageInfo();
		mi.setSendId(userId);
		mi.setReceiveId(publisherId);
		mi.setMessage(findUserInfo.getMessage());
		mi.setSendTime((new Timestamp(System.currentTimeMillis()).toString()));
		mi.setStatus("0");
		messageInfoDao.save(mi);
		request.setAttribute("alertInfo", "留言成功");
		return "ok";
	}
}
