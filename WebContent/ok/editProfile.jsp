<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >

<head>
    <title><s:text name="jsp.title.system" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="assets/js/jquery.js"></script>

    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">

    <link rel="stylesheet" href="assets/css/profile.css">

    <link rel="shortcut icon" href="assets/ico/minus.png">
    
    <script type="text/javascript">
    	function editProfile(){
    		var username=document.getElementById("username").value;
        	if(username==null || username==''){
        		alert("用户名不能为空！");
        		return false;

        	}
    		var password=document.getElementById("password").value;
        	if(password==null ||password==''){
        		alert("密码不能为空！");
        		return false;
        	}
        	var repassword=document.getElementById("repassword").value;
        	if(repassword==null ||repassword==''){
        		alert("确认密码不能为空！");
        		return false;
        	}else if(repassword!=password){
        		alert("两次密码不一致！");
        		return false;
        	}
    	}
    	
   		function initRadio(name,value){
   			var obj=document.getElementsByName(name);
   			for(var i=0;i<obj.length;i++){
   				if(value==obj[i].value){
   					obj[i].checked='checked';
   				}
   			}
   		}
    </script>
</head>

<body>
<%@ include file="main.jsp" %>
<div class="wrap-fluid">
    <div class="container-fluid paper-wrap bevel tlbr">
        <!-- CONTENT -->
        <!-- BREADCRUMB -->
        <s:if test="#session.existUser==null">
	        <div class="text-error" >
	        	<span>请先登录!</span>
	        	<div>
	        		<a href="${ pageContext.request.contextPath }/login.jsp"><strong>登录</strong></a>
	        	</div>
	        	<div>
	        		<span>还没账号？点击注册</span>
	                <a href="register.jsp" style="size: 150px"><strong>注册</strong></a>
	        	</div>
	            
            </div>
        </s:if>
        <s:else>
        <ul id="breadcrumb">
            <li>
                <span class="entypo-home"></span>
            </li>
            <li><i class="fa fa-lg fa-angle-right"></i>
            </li>
            <li><a href="${ pageContext.request.contextPath }/page_index.action" title="Sample page 1">首页</a>
            </li>
            <li><i class="fa fa-lg fa-angle-right"></i>
            </li>
            <li><a href="${ pageContext.request.contextPath }/page_editProfile.action" title="Sample page 1">账号设置</a>
            </li>
            <li class="pull-right">
                <div class="input-group input-widget">

                    <input style="border-radius:15px" type="text" placeholder="Search..." class="form-control">
                </div>
            </li>
        </ul>

		<div class="row">
		
		    <div class="col-sm-12">
		        <!-- BLANK PAGE-->
		
		   <div style="margin:-20px 15px;" class="nest" id="Blank_PageClose">
		       <div class="title-alt">
		           <h6>
		               账号设置</h6>
		           <div class="titleClose">
		               <a class="gone" href="#Blank_PageClose">
		                   <span class="entypo-cancel"></span>
		               </a>
		           </div>
		           <div class="titleToggle">
		               <a class="nav-toggle-alt" href="#Blank_Page_Content">
		                   <span class="entypo-up-open"></span>
		               </a>
		           </div>
		
		       </div>
		
		       <div class="body-nest" id="Blank_Page_Content">
		           <div class="row">
		               <!-- left column -->
		               <div class="col-md-3">
		                   <div class="text-center">
		                       <img src="http://placehold.it/150" class="avatar img-circle" alt="avatar">
		                       <h6>修改头像</h6>
		
		                       <div class="input-group">
		                           <span class="input-group-btn">
		                               <span class="btn btn-primary btn-file">
		                                   上传照片
		                                   <input type="file" multiple="">
		                               </span>
		                           </span>
		                           <input type="text" class="form-control">
		                       </div>
		
		                   </div>
		               </div>
		
		               <!-- edit form column -->
		               <div class="col-md-9 personal-info">
		                   <div class="alert alert-info alert-dismissable">
		                       <a class="panel-close close" data-dismiss="alert">×</a> 
		                       <i class="fa fa-coffee"></i>
		                       This is an
		                       <strong>.alert</strong>. Use this to show important messages to the user.
		                   </div>
		                   <h3>个人信息</h3>
		                   <div style="color: red">
		                   	   <s:actionerror/>
		                   </div>
		                   <form class="form-horizontal" id="editProfileFrom" action="${ pageContext.request.contextPath }/user_editProfile.action" method="post" onsubmit="return editProfile();">
		                       <div class="form-group">
		                           <label class="col-lg-3 control-label">用户名：</label>
		                           <div class="col-lg-8">
		                               <input class="form-control"  name="username" value=" <s:property  value="#session.existUser.username"/>" type="text">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-lg-3 control-label">真实姓名:</label>
		                           <div class="col-lg-8">
		                               <input class="form-control"  name="name" value="  <s:property  value="#session.existUser.name"/>" type="text">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-lg-3 control-label">邮箱:</label>
		                           <div class="col-lg-8">
		                               <input class="form-control" name="email" value=" <s:property  value="#session.existUser.email"/>" type="text">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-lg-3 control-label">电话号码:</label>
		                           <div class="col-lg-8">
		                               <input class="form-control" name="phone" value=" <s:property  value="#session.existUser.phone"/>" type="text">
		                           </div>
		                       </div>
		                      <%--  <div class="form-group">
		                           <label class="col-lg-3 control-label">Time Zone:</label>
		                           <div class="col-lg-8">
		                               <div class="ui-select">
		                                   <select id="user_time_zone" class="form-control">
		                                       <option value="Hawaii">(GMT-10:00) Hawaii
		                                       <option value="Alaska">(GMT-09:00) Alaska
		                                       <option value="Pacific Time (US &amp; Canada)">(GMT-08:00) Pacific Time (US &amp; Canada)
		                                       <option value="Arizona">(GMT-07:00) Arizona
		                                       <option value="Mountain Time (US &amp; Canada)">(GMT-07:00) Mountain Time (US &amp; Canada)
		                                       <option value="Central Time (US &amp; Canada)" selected="selected">(GMT-06:00) Central Time (US &amp; Canada)
		                                       <option value="Eastern Time (US &amp; Canada)">(GMT-05:00) Eastern Time (US &amp; Canada)
		                                       <option value="Indiana (East)">(GMT-05:00) Indiana (East)
		                                   </select>
		                               </div>
		                           </div>
		                       </div> --%>
		                       <div class="form-group">
		                           <label class="col-md-3 control-label">地址：</label>
		                           <div class="col-md-8">
		                               <input class="form-control"  name="addr" value=" <s:property  value="#session.existUser.addr"/>" type="text">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-md-3 control-label">性别：</label>
		                           <div class="col-md-8">
		                              
		                               <input type="radio" name="sex" class="" value="0" />男
									   <input type="radio" name="sex" class="" value="1"/>女
		                           </div>
		                          
		                           <script type="text/javascript">
		                           		initRadio("sex", <s:property  value="#session.existUser.sex"/>);
		                           </script>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-md-3 control-label">毕业学校：</label>
		                           <div class="col-md-8">
		                               <input class="form-control" name="school" value=" <s:property  value="#session.existUser.school"/>" type="text">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-md-3 control-label">班级：</label>
		                           <div class="col-md-8">
		                               <input class="form-control"  name="className" value="  <s:property  value="#session.existUser.className"/>" type="text">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-md-3 control-label">密码:</label>
		                           <div class="col-md-8">
		                               <input class="form-control"  name="password" value=" <s:property  value="#session.existUser.password"/>" type="password">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-md-3 control-label">确认密码:</label>
		                           <div class="col-md-8">
		                               <input class="form-control"  name="repassword" value="<s:property  value="#session.existUser.password"/>" type="password">
		                           </div>
		                       </div>
		                       <div class="form-group">
		                           <label class="col-md-3 control-label"></label>
		                           <div class="col-md-8">
		                               <input class="btn btn-primary" value="保存" type="submit">
		                               <span></span>
		                                <input class="btn btn-default" value="取消" type="reset">
		                            </div>
		                        </div>
		                    </form>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		</s:else>
	</div>
</div>
<!-- END OF BLANK PAGE -->

<!-- MAIN EFFECT -->
<script type="text/javascript" src="assets/js/preloader.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/load.js"></script>
<script type="text/javascript" src="assets/js/main.js"></script>

</div>

</body>
</html>