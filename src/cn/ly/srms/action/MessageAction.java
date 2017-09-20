package cn.ly.srms.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ly.srms.common.util.StringUtil;
import cn.ly.srms.entity.MessageInfo;
import cn.ly.srms.entity.User;
import cn.ly.srms.service.MessageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller @Scope("prototype")
public class MessageAction extends BaseAction implements ModelDriven<MessageInfo>{

	private MessageInfo messageInfo=new MessageInfo();

	@Override
	public MessageInfo getModel() {
		return messageInfo;
	}
	
	@Resource MessageService messageService;
	
	public String toList(){
		ActionContext actionContext=ActionContext.getContext();
		HttpServletRequest request=(HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		
		//获取当前用户
		User loginUser=(User) session.get("existUser");
		if(StringUtil.isNullOrWhiteSpace(loginUser)){
			request.setAttribute("alertInfo", "请先登陆！");
			return "add";
		}
		
		int userId=loginUser.getUserId();
		List msgList=messageService.getMailList(userId);
		request.setAttribute("msgList", msgList);
		return "list";
	}
	
    /*发送新邮件 */
	public String send(){
     	User loginUser=(User) session.get("existUser");
		System.out.println(loginUser.getUsername());
		return "success";
	}

}
