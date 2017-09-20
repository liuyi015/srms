/*
 * 文件名：UserAction.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserAction.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年2月14日
 * 修改内容：新增
 */
package cn.ly.srms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.ly.srms.action.common.tool.FileUtil;
import cn.ly.srms.action.exception.ApplicationException;
import cn.ly.srms.common.util.StringUtil;
import cn.ly.srms.entity.LimitInfo;
import cn.ly.srms.entity.User;
import cn.ly.srms.entity.UserRole;
import cn.ly.srms.entity.model.UserModel;
import cn.ly.srms.service.LimitService;
import cn.ly.srms.service.UserRoleService;
import cn.ly.srms.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.mail.iap.Response;

/**
 * 用户模块Action的类
 * @author     liuyi 1610140
 * @version    CCAS 2017年2月14日
 * @since      CCAS
 */
//
@Controller @Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserModel>,ServletRequestAware,SessionAware{
	
	private UserModel userModel=new UserModel();
	private HttpServletRequest request;
	private Map<String, Object> session;
	

	// 注入UserService
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="limitService")
	private LimitService limitService;
	@Resource UserRoleService userRoleService;
	
	
	@Override
	public UserModel getModel() {
		return userModel;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	/**
	 * AJAX进行异步校验用户名的执行方法
	 * 
	 * @throws IOException
	 */
	public String findByName() throws Exception{
		// 获得response对象,项页面输出:
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		String name=userModel.getUsername().trim();
		String username=request.getParameter("username").trim();
		if(username==null ||"".equals(name)){
			response.getWriter().println("<font color='red'>用户名不能为空</font>");
			return NONE;
		}
		
		User existUser=userService.findByUsername(username);
		if(existUser!=null){
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else{
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;

	}
	/**
	 * AJAX进行异步校验验证码的执行方法
	 * 
	 * @throws IOException
	 */
	public String checkVerfCode() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		
		String verfCode=request.getParameter("verfCode").trim();
		String sessionCode=(String) session.get("verfCode");
		String result;
		if(verfCode==null ||verfCode==""){
			result="0";
		}else if(!verfCode.equals(sessionCode)){
			 result="1";
		}else{
			result="2";
		}
		response.getWriter().print(result);
		return NONE;
	}
	
	//用户注册
	public String regist() throws Exception{
		
		User existUser= userService.findByUsername(userModel.getUsername());
		if(existUser==null){
			userModel.setOnlineState("0");
			userService.save(userModel);
			return "login";
		}else{
			this.addActionError("用户名不可用!");
			return "regist";
		}
	}
	
	//用户登录
	public String login()throws Exception{
		User existUser =userService.findByUser(userModel);
		ActionContext actionContext=ActionContext.getContext();
		//Map session=actionContext.getSession();
		if(existUser==null){
			actionContext.put("error", "登录失败:用户名或密码错误!");
			return LOGIN;
		}else{
			//初始化权限
			this.initSystemPriv(existUser.getUserId());
			
			//设置在线状态0-离线1-在线
			existUser.setOnlineState("1");
			
			//更新在线用户信息
			userService.update(existUser);
			
			// 将用户的信息存入到session中
			session.put("existUser", existUser);
//			String roleId=this.getUserRole(existUser.getUserId(),actionContext);
//			session.put("roleId", roleId);
			return "loginSuccess";
		}
		
	}
	
	/*
	 * 用户的角色
	 */
	public String getUserRole(Integer userId,ActionContext ac)throws Exception{
		String roleId= userRoleService.getRoleId(userId);
		return roleId;
	}
	
	/*
	 * 初始化用户的权限配置到Session中 输入参数：用户标识
	 */
	/*public boolean initSystemPriv(Integer userId) throws Exception{
		
		//获取所有分组权限id
		List limitsList=limitService.getRealLimitByUserKey(userId);
		if(limitsList==null && limitsList.size()==0){
			return true;
		}
		
		HashMap<String, List<LimitInfo>> limitsMap=new HashMap<String, List<LimitInfo>>();
		for(int i=0;i<limitsList.size();i++){
			//获取每组的权限id
			String a = (String) limitsList.get(i);
			List<LimitInfo> limitList=new ArrayList<LimitInfo>();
			List<LimitInfo> limitList=new ArrayList<LimitInfo>();
			
			for(String id:limitIds){
				//根据权限id获取权限信息
				LimitInfo limitInfo=limitService.getLimitInfoByLimitId(id);
				if(limitInfo.getLimitParent()!=null){
					//根据权限id获取权限信息
					LimitInfo limitParentInfo=limitService.getLimitInfoByLimitId(limitInfo.getLimitParent());
					List limitChildList= limitParentInfo.getLimitChild();
					if(limitChildList==null||"".equals(limitChildList)){
						limitChildList=new ArrayList<LimitInfo>();
					}
					limitChildList.add(limitInfo);
				}else{
					limitList.add(limitInfo);
				}
				
			}
			//为了不覆盖，key有唯一性
			String key=i+"key";
			limitsMap.put(key, limitList);
		}
		
		session.put("limitsMap", limitsMap);
		return true;
	}*/
	
	public boolean initSystemPriv(Integer userId) throws Exception{
		
		//获取所有分组权限
		List<LimitInfo> limitsList=limitService.getRealLimitByUserKey(userId);
		if(limitsList==null && limitsList.size()==0){
			return true;
		}
		
		List<LimitInfo> limitList=new ArrayList<LimitInfo>();
		int length=limitsList.size();
		for(int i=0;i<length;i++){
			//父节点
			LimitInfo parent=limitsList.get(i);
			if("1".equals(parent.getMenuFlag())){
				if(parent.getLimitParent()==null){
					parent.setLimitChild(new ArrayList<LimitInfo>());
					for(int a=0;a<length;a++){
						//子节点
						LimitInfo child=limitsList.get(a);
						if(parent.getLimitId().equals(child.getLimitParent())){
							if("1".equals(child.getMenuFlag())){
								parent.getLimitChild().add(child);
							}
						}
					}
					limitList.add(parent);
				}
			}
		}
		
		JSONArray limitJson = null;
	    if(limitList!=null){
	    	limitJson = JSONArray.fromObject(limitList);
		}
		session.put("limitList",limitJson);
		return true;
	}
	
	
	//用户退出
	public String exit() throws Exception{
		User sessionUser=(User) session.get("existUser");
		sessionUser.setOnlineState("0");
		//销毁session
		request.getSession().invalidate();
		return "exit";
	}
	
	//编辑个人信息
	public String editProfile() throws Exception{
//		User sessionUser=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		User sessionUser=(User) session.get("existUser");
		if(sessionUser==null){
			this.addActionError("请先登录！");
			return "error";
		}
		User existUser=userService.findByUserid(sessionUser.getUserId());
		if(existUser==null){
			this.addActionError("没有该用户");
		}else{
			if(userModel.getUsername()!=null && userModel.getUsername()!=""){
			 existUser.setUsername(userModel.getUsername());
			}
			if(userModel.getPassword()!=null && userModel.getPassword()!=""){
				existUser.setPassword(userModel.getPassword());
			}
			if(userModel.getName()!=null && userModel.getName()!=""){
				existUser.setName(userModel.getName());
			}
			if(userModel.getEmail()!=null && userModel.getEmail()!=""){
				existUser.setEmail(userModel.getEmail());
			}
			if(userModel.getPhone()!=null && userModel.getPhone()!=""){
				existUser.setPhone(userModel.getPhone());
			}
			if(userModel.getAddr()!=null && userModel.getAddr()!=""){
				existUser.setAddr(userModel.getAddr());
			}
			if(userModel.getSchool()!=null && userModel.getSchool()!=""){
				existUser.setSchool(userModel.getSchool());
			}
			if(userModel.getClassName()!=null && userModel.getClassName()!=""){
				existUser.setClassName(userModel.getClassName());
			}
			existUser.setSex(userModel.getSex());
			userService.update(existUser);
			session.put("existUser", existUser);
		}
		return "editprofile";
	}
	/*
	 * 上传头像
	 */
	public String uploadImg() throws Exception{
    	File imgFile=userModel.getImg();
    	if(imgFile==null){
    		this.addActionError("请上传图片！");
    		return "editprofile";
    	}
		String[] imgFileName=userModel.getImgFileName().split("\\.");
		String fileType=imgFileName[imgFileName.length-1];  //获得文件后缀名
		String[] arr={"jpg","png"};
		boolean isImg=false;
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(fileType)){
				isImg=true;
			}
		}
		if(!isImg){
			this.addFieldError("img", "图片格式不对,请重新上传！");
			//this.addActionError("图片格式不对,请重新上传！");
    		return "editprofile";
		}
		//重命名
		String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+fileType;
		
		//存储文件名到本地的images文件夹下
		ServletContext servletContext=ServletActionContext.getServletContext();
		String path=servletContext.getRealPath("/images/"+fileName);
		try {
			FileUtil.writeFile(path, userModel.getImg());
		} catch (IOException e) {
			this.addActionError("上传失败");
		}
		
		//修改数据库中的image路径
		User existUser=(User) session.get("existUser");
		existUser.setImage("images/"+fileName);
		userService.update(existUser);
		session.put("existUser", existUser);
		this.addActionMessage("上传成功");
		return "editprofile";
	}

}

