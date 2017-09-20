package cn.ly.srms.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.ly.srms.entity.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PowerInterceptor extends AbstractInterceptor{

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		/*
		 * 实际上是用session得到action里面设置进去的值，但是要试一下在struts.xml里面配置把属性值作为参数传过来。
		 * */
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		Class action= arg0.getProxy().getClass();
		String className=action.getName();
		String methodName=arg0.getProxy().getMethod();
		System.out.println("到了  权限  interceptor 中, class："+className+",methodName："+methodName);
		
		String path=request.getContextPath();
		
		String requestURI=request.getRequestURI().toString();
		String actionPath=requestURI.substring(path.length()+1,requestURI.length());
		
		System.out.println("actionPath : "+actionPath);
		System.out.println("到了  权限  interceptor 中了。。。。。。。。。。");
		
		if(actionPath.equals("user_login.action")){
			User user = (User) session.get("existUser");
			System.out.println("user:"+user);
			if(user!=null){
				System.out.println("已经登录了。登陆用户对应的权限："+session.get("roleId"));
				
			}else{
				System.out.println("user 为空，请登录！");
				return Action.LOGIN;
			}
		}
		
		return arg0.invoke();
		
	}
}