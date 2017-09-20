package cn.ly.srms.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class IndexAction extends ActionSupport{

	public String index() throws Exception {
		return "index";
	}
	public String toProfile() throws Exception {
		return "profile";
	}
	public String editProfile() throws Exception {
		return "editProfile";
	}
	public String home() throws Exception {
		return "home";
	}
	public String regist(){
		return "regist";
	}
}
