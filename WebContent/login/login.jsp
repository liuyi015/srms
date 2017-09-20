<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
 <!--    <meta charset="utf-8"> -->
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

    <link rel="shortcut icon" href="assets/ico/minus.png">
    
    <script type="text/javascript">
    	function login(){
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
        	/*先屏蔽 
        	checkCode();
        	var msg=$("#codeInput").val();
        	if(msg==null||msg==""){
        		return false;
        	} */
    	}
    	
    	function changeValidateCode(obj){
    	/*** 
   		  *   获取当前的时间作为参数，无具体意义    
   		  *   每次请求需要一个不同的参数，否则可能会返回同样的验证码     
   		  *   这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
   		  */  
   		var time=new Date().getTime();
    	obj.src="random.action?time="+time;
    	}
    	
    	function checkCode(){
    		var verfCode=$("#codeInput").val();
    		var r;
    		$.post("user_checkVerfCode.action",{"verfCode":verfCode},function(result){
    			if(result=="0"){
    				$(".spanMsg").html("验证码不能为空！").css("color","red");
    				$("#codeInput").val("");
    				changeValidateCode($("#imgCode")[0]);
    			}else if(result=="1"){
    				$(".spanMsg").html("验证码错误！").css("color","red");
    				$("#codeInput").val("");
    				changeValidateCode($("#imgCode")[0]);
    			}if(result=="2"){
    				$(".spanMsg").html("验证码正确！").css("color","green");
    			}
    		});
    	}
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
                <div class="col-md-4 col-md-offset-4">
                    <div id="logo-login">
                        <h1>锁忆同学录管理系统
                        </h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="account-box"> 
                        <form id="loginForm" action="user_login.action" method="post" onsubmit="return login();">
                        	<%-- <div><s:actionerror /></div> --%>
                        	<font color="red">${requestScope.error }</font>
                            <div class="form-group">
                                <label for="inputUsernameEmail">用户名</label>
                                <input type="text" id="username" name="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="inputPassword">密码</label>
                                <input type="password" id="password"  name="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="inputPassword">请输入验证码</label>
                                <input id="codeInput" class="form-control" type="text" placeholder="验证码" onblur="checkCode();"/>
        					    <img id="imgCode" src="random.action" onclick="changeValidateCode(this)" title="点击刷新图片" /> 
        					    <span class="spanMsg" ></span>
                            </div>
                            <button class="btn btn-primary btn-block" type="submit">
                                登 录
                            </button>
                        </form>
                        <hr>
  
                        <div class="row-block">
                            <div class="row">
                                <div class="col-md-12 row-block">
                                	<span>还没账号？点击注册</span>
                                    <a href="page_regist.action" style="size: 150px">注册</a>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!--  END OF PAPER WRAP -->

</body>

</html>
