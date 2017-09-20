<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>锁忆同学录管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>

   <!--  <link rel="stylesheet" href="assets/css/style.css"> -->
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/signin.css">

	<link href="assets/css/register.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="assets/ico/minus.png">
    
    <script type="text/javascript">
    function checkForm(){
    	var username=$("#username").val();
    	if(username==null || username==''){
    		alert("用户名不能为空！");
    		return false;
    	}
    	var password=$("#password").val();
    	if(password==null ||password==''){
    		alert("密码不能为空！");
    		return false;
    	}
    	var repassword=$("#repassword").val();
    	if(repassword==null ||repassword==''){
    		alert("确认密码不能为空！");
    		return false;
    	}
    	if(password!=repassword){
    		alert("输入的两次密码不一致！");
    		return false;
    	}
       // checkUsername();
    }
    
    function checkUsername(){
    	var name=$("#username").val();
    	$.post("user_findByName.action",{username:name},function(result){
    		$('#span1').html(result);
    	});
    }
   /*  function checkUsername(){
    	//获得文件框值
    	var username=document.getElementById("username").value;
    	//创建异步交互对象
    	var xhr=createXmlHttp();
    	//设置监听
    	xhr.onreadystatechange=function(){
    		if(xhr.readyState==4){
    			if(xhr.status==200){
    				document.getElementById("span1").innerHTML = xhr.responseText;
    			}
    		}
    	}

    	//打开连接
    	xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?username="+username,true);
    	//发送
    	xhr.send(null);
    }
    
    function createXmlHttp(){
		   var xmlHttp;
		   try{ // Firefox, Opera 8.0+, Safari
		        xmlHttp=new XMLHttpRequest();
		    }
		    catch (e){
			   try{// Internet Explorer
			         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			      }
			    catch (e){
			      try{
			         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }
			      catch (e){}
			      }
		    }

			return xmlHttp;
		 } */
    </script>
</head>

<body> 
    <!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>
    
    <div class="container">

        <div class="" id="login-wrapper">
            <div class="row">
                <div class="col-md-4 col-md-offset-4" style="width: 430px">
                    <div id="logo-login">
                        <h1>注册
                        </h1>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="account-box" style="width: 400px"> 
                        <form id="registerForm" action="user_regist.action" method="post" novalidate="novalidate" onsubmit="return checkForm();">
                        <s:actionerror/>
						<table >
							<tr >
								<th height="30">
									<span >*</span>
									<span >用户名:</span>
								</th>
								<td align="left">
									<input type="text" id="username" name="username" class="text" maxlength="20" onblur="checkUsername()"/>
									<span id="span1"></span>
								</td>
							</tr>
							
							<tr>
								<th height="30">
									<span >*</span>
									<span >密&nbsp;&nbsp;码:</span>
								</th>
								<td align="left">
									<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off"/>
									<span><s:fielderror  fieldName="password"/></span>
								</td>
							</tr>
							<tr>
								<th height="30">
								<span >*</span>
									<span >确认密码：</span>
								</th>
								<td align="left">
									<input id="repassword" type="password" name="repassword" class="text" maxlength="20" autocomplete="off"/>

								</td>
							</tr>
							
							<tr >
								<th height="30">
									<span class="requiredField">*</span>E-mail:
								</th>
								<td align="left">
									<input type="text" id="email" name="email" class="text" maxlength="200">
									<span><s:fielderror fieldName="email"/></span>
								</td>
							</tr>
							<tr>
								<th height="30">
									<span >姓名:</span>
								</th>
								<td align="left">
									<input type="text" id="name" name="name" class="text" maxlength="200" />
								</td>
							</tr>
							<tr>
								<th height="30">
									<span >姓别:</span>
								</th>
								<td align="left">
									<input type="radio" id="sex" name="sex" class="text" value="0" checked/>男
									<input type="radio" id="sex" name="sex" class="text" value="1"/>女
								</td>
							</tr>
									
							<tr>
								<th height="30">
									<span >电话:</span>
								</th>
								<td align="left">
									<input type="text" name="phone" class="text" />
								</td>
							</tr>
									
							<tr>
								<th height="30">
									<span >地址:</span>
								</th>
								<td align="left">
										<input type="text" name="addr" class="text" maxlength="200"/>
										<span><s:fielderror fieldName="addr"/></span>
								</td>
							</tr>
							<tr>
								<th height="30">
									<span >学校:</span>
								</th>
								<td align="left">
										<input type="text" name="school" class="text" maxlength="200"/>
										<span><s:fielderror fieldName="school"/></span>
								</td>
							</tr>
							<tr>
								<th height="30">
									<span >班级:</span>
								</th>
								<td align="left">
										<input type="text" name="className" class="text" maxlength="200"/>
										<span><s:fielderror fieldName="school"/></span>
								</td>
							</tr>
						</table>
						<div class="or-box">
                        <div class="row-block">
                            <div class="row">
                                <div class="col-md-12 row-block">
                                    <input type="submit" class="btn btn-primary btn-block" value="注册">
                                </div>
                            </div>
                        </div>
                    </div>
						
					</form>
					<hr>
					<div >
								<dt>已经拥有账号了？</dt>
								<dd>
									立即登录即可体验在线同学录！
									<a href="login.jsp">立即登录</a>
								</dd>
							</dl>
						</div>
                        
                </div>
            </div>
        </div>

 		

    </div>


    <!--  END OF PAPER WRAP -->


    <!-- MAIN EFFECT -->
 <%--    <script type="text/javascript" src="assets/js/preloader.js"></script> --%>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/js/app.js"></script>
    <script type="text/javascript" src="assets/js/load.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>

<%--     <script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script> --%>
    <script type="text/javascript" src="assets/js/map/gmap3.js"></script>


</body>

</html>
