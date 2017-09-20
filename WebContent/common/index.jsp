<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.ly.srms.entity.LimitInfo"%>
<%@ page import="cn.ly.srms.entity.User"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title><s:text name="jsp.title.system" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assets/js/progress-bar/number-pb.css">
	<script type="text/javascript" src="assets/js/jquery.js"></script>
    <script src="assets/js/progress-bar/src/jquery.velocity.min.js"></script>
    <script src="assets/js/progress-bar/number-pb.js"></script>
    <script src="assets/js/progress-bar/progress-app.js"></script>
	<!-- MAIN EFFECT -->
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/js/load.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
    
    <script type="text/javascript">
    	<%
    		User existUser=(User)session.getAttribute("existUser");
    	%>
    	var user="<%=existUser%>";
    	if(user==null||user=="null"){
    		window.document.location.href="login.jsp";
    	}
    </script>
    <script type="text/javascript">
    
	    //控制iframe 自适应高度宽度
	    function changeFrameHeight(){
	        var ifm= document.getElementById("mainFrame"); 
	        ifm.height=document.documentElement.clientHeight;
	
	   };
	   window.onresize=function(){  
	         changeFrameHeight();  
	
	   } ;
	   
    </script>
   
    <style type="text/css">
    canvas#canvas4 {
        position: relative;
        top: 20px;
    }
    </style>
    <link rel="shortcut icon" href="assets/ico/minus.png">
</head>
<body scroll="no">
<!-- Preloader预载  -->
   <!--  <div id="preloader">
        <div id="status">&nbsp;</div>
    </div> -->
    <!-- Preloader预载  -->
    
    <!-- TOP NAVBAR 顶部导航栏 -->
    <nav role="navigation" class="navbar navbar-static-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="entypo-menu"></span>
                </button>
                <button class="navbar-toggle toggle-menu-mobile toggle-left" type="button">
                    <span class="entypo-list-add"></span>
                </button>

            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <!--  收集导航链接、表单和其他内容切换           -->
            <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
            	<!--  通知栏-->
                <ul class="nav navbar-nav">
					<!-- 悄悄话 -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i style="font-size:20px;" class="icon-conversation"></i><div class="noft-red">23</div></a>
                        <ul style="margin: 11px 0 0 9px;" role="menu" class="dropdown-menu dropdown-wrap">
                            <li>
                                <a href="#">
                                    <img alt="" class="img-msg img-circle" src="http://api.randomuser.me/portraits/thumb/men/1.jpg">Jhon Doe <b>Just Now</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <img alt="" class="img-msg img-circle" src="http://api.randomuser.me/portraits/thumb/women/1.jpg">Jeniffer <b>3 Min Ago</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <img alt="" class="img-msg img-circle" src="http://api.randomuser.me/portraits/thumb/men/2.jpg">Dave <b>2 Hours Ago</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <img alt="" class="img-msg img-circle" src="http://api.randomuser.me/portraits/thumb/men/3.jpg"><i>Keanu</i>  <b>1 Day Ago</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <img alt="" class="img-msg img-circle" src="http://api.randomuser.me/portraits/thumb/men/4.jpg"><i>Masashi</i>  <b>2 Mounth Ago</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div>查看所有的信息</div>
                            </li>
                        </ul>
                    </li>
                    
                    <!-- 提醒 -->
                    <li>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i style="font-size:19px;" class="icon-warning tooltitle"></i><div class="noft-green">5</div></a>
                        <ul style="margin: 12px 0 0 0;" role="menu" class="dropdown-menu dropdown-wrap">
                            <li>
                                <a href="#">
                                    <span style="background:#DF2135" class="noft-icon maki-bus"></span><i>From Station</i>  <b>01B</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <span style="background:#AB6DB0" class="noft-icon maki-ferry"></span><i>Departing at</i>  <b>9:00 AM</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <span style="background:#FFA200" class="noft-icon maki-aboveground-rail"></span><i>Delay for</i>  <b>09 Min</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <span style="background:#86C440" class="noft-icon maki-airport"></span><i>Take of</i>  <b>08:30 AM</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <span style="background:#0DB8DF" class="noft-icon maki-bicycle"></span><i>Take of</i>  <b>08:30 AM</b>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div>See All Notification</div>
                            </li>
                        </ul>
                    </li>
                    <!--帮助  -->
                    <li><a href="#"><i data-toggle="tooltip" data-placement="bottom" title="Help" style="font-size:20px;" class="icon-help tooltitle"></i></a>
                    </li>

                </ul>
                <!-- 时间栏-->
                <div id="nt-title-container" class="navbar-left running-text visible-lg">
                    <ul class="date-top">
                        <li class="entypo-calendar" style="margin-right:5px"></li>
                        <li id="Date"></li>
                    </ul>

                    <ul id="digital-clock" class="digital">
                        <li class="entypo-clock" style="margin-right:5px"></li>
                        <li class="hour"></li>
                        <li>:</li>
                        <li class="min"></li>
                        <li>:</li>
                        <li class="sec"></li>
                        <li class="meridiem"></li>
                    </ul>
                </div>
				<!--登录用户信息  -->
                <ul style="margin-right:0;" class="nav navbar-nav navbar-right">
                   	<s:if test="#session.existUser==null">
                   		<li>
                        	<a href="${ pageContext.request.contextPath }/login/login.jsp">登录</a>
                        </li>
                        <li>
                        	<a href="${ pageContext.request.contextPath }/login/register.jsp">注册</a>
                        </li>
                    </s:if>
                    <s:else>
                        <li>
                        	<a data-toggle="dropdown" class="dropdown-toggle" href="#">
	                            <img alt="" class="admin-pic img-circle" src="${session.existUser.image }">
	                           <%--  <s:property  value="#session.existUser.username"/> --%>
	                            ${session.existUser.username }
	                            <b class="caret"></b>
	                        </a>
	                        <ul style="margin-top:14px;" role="menu" class="dropdown-setting dropdown-menu">
	                            <li>
	                                <a class="top_menu" target="mainFrame" href="${ pageContext.request.contextPath }/page_toProfile.action">
	                                    <span class="entypo-user"></span>&#160;&#160;个人信息</a>
	                            </li>
	                            <li>
	                                <a class="top_menu" target="mainFrame" href="${ pageContext.request.contextPath }/page_editProfile.action">
	                                    <span class="entypo-vcard"></span>&#160;&#160;账户设置</a>
	                            </li>
	                           
	                            <li class="divider"></li>
	                             <li>
	                                <a href="${ pageContext.request.contextPath }/user_exit.action">
	                                    <span class="entypo-lifebuoy"></span>&#160;&#160;退出</a>
	                            </li>
	                        </ul>
	                   </li>
                    </s:else>
                    <li>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="icon-gear"></span>&#160;&#160;设置</a>
                        <ul role="menu" class="dropdown-setting dropdown-menu">

                            <li class="theme-bg">
                                <div id="button-bg"></div>
                                <div id="button-bg2"></div>
                                <div id="button-bg3"></div>
                                <div id="button-bg5"></div>
                                <div id="button-bg6"></div>
                                <div id="button-bg7"></div>
                                <div id="button-bg8"></div>
                                <div id="button-bg9"></div>
                                <div id="button-bg10"></div>
                                <div id="button-bg11"></div>
                                <div id="button-bg12"></div>
                                <div id="button-bg13"></div>
                            </li>
                        </ul>
                    </li>
                    <!-- 右侧隐藏栏按钮-->
                    <li class="hidden-xs">
                        <a class="toggle-left" href="#">
                            <span style="font-size:20px;" class="entypo-list-add"></span>
                        </a>
                    </li>
                </ul>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <!-- /END OF TOP NAVBAR -->
    
    <!-- RIGHT SLIDER CONTENT右滑块内容  -->
    <div class="sb-slidebar sb-right">
        <div class="right-wrapper">
            <div class="row">
                <h3>
                    <span><i class="entypo-gauge"></i>&nbsp;&nbsp;MAIN WIDGET</span>
                </h3>
                <div class="col-lg-12">

                    <div class="widget-knob">
                        <span class="chart" style="position:relative" data-percent="86">
                            <span class="percent"></span>
                        </span>
                    </div>

                    <div class="widget-knob">
                        <span class="speed-car" style="position:relative" data-percent="60">
                            <span class="percent2"></span>
                        </span>
                    </div>


                    <div class="widget-knob">
                        <span class="overall" style="position:relative" data-percent="25">
                            <span class="percent3"></span>
                        </span>
                    </div>
                </div>
            </div>
        </div>

        <div style="margin-top:0;" class="right-wrapper">
            <div class="row">
                <h3>
                    <span><i class="entypo-chat"></i>&nbsp;&nbsp;CHAT</span>
                </h3>
                <div class="col-lg-12">
                    <span class="label label-warning label-chat">Online</span>
                    <ul class="chat">
                        <li>
                            <a href="#">
                                <span>
                                    <img alt="" class="img-chat img-circle" src="http://api.randomuser.me/portraits/thumb/men/20.jpg">
                                </span><b>Dave Junior</b>
                                <br><i>Last seen : 08:00 PM</i>
                            </a>
                        </li>


                    </ul>

                    <span class="label label-chat">Offline</span>
                    <ul class="chat">
                        <li>
                            <a href="#">
                                <span>
                                    <img alt="" class="img-chat img-offline img-circle" src="http://api.randomuser.me/portraits/thumb/men/23.jpg">
                                </span><b>Dave Junior</b>
                                <br><i>Last seen : 08:00 PM</i>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF RIGHT SLIDER CONTENT-->

    <!-- 左侧菜单 -->
    <div id="skin-select">
        <div id="logo">
         <h1><s:text name='jsp.title.system' /></h1>
        </div>

        <a id="toggle">
            <span class="entypo-menu"></span>
        </a>
        <div class="dark">
            <form action="#">
                <span>
                    <input type="text" name="search" value="" class="search rounded id_search" placeholder="搜索菜单...." autofocus="">
                </span>
            </form>
        </div>

        <div class="search-hover">
            <form id="demo-2">
                <input type="search" placeholder="<s:text name="jsp.body.left.search"/>" class="id_search">
            </form>
        </div>


        <div class="skin-part">
            <div id="tree-wrap">
                <div class="side-bar">
                	<script type="text/javascript">
	                	<%-- var a='<%=list%>'; --%>
	            	  	/* var treeList='${session.limitList}'; */
	            	  	var treeList;
	            	  	var tree;
	            	  	var limitsMap = new Object(); 
						var nodesMap = new Object();
	                	<%
	                		
	                		List<LimitInfo> treeList=(List)session.getAttribute("limitList");
	                	   // out.println("//权限记录数："+treeList.size());
	                	%>
						$(function(){
							var tmpNode;
							treeList='<%=treeList%>';
							treeList=eval(treeList);
							/* alert(treeList); */
							for(var index=0;index<treeList.length;index++){
								var contextPath='<%=request.getContextPath()%>'+"/";
								var root=treeList[index];
								var rootUrl;
								if(root.limitUrl==null||root.limitUrl==""){
									rootUrl='';
								}else{
									rootUrl=contextPath+root.limitUrl;
								}
								tmpNode = '<ul class="topnav menu-left-nest">' 
									+'<li>'
									+'<a href="'+ rootUrl +'" style="border-left:0px solid!important;" class="title-menu-left">'
									+'<span>' + root.limitName + '</span>'
									+ '</a>'
									+'</li>'
								for (var child = 0; child < root.limitChild.length; child++) {
									var childNode = root.limitChild[child];
									 tmpNode += '<li>'
									 	+'<a class="tooltip-tip ajax-load" target="mainFrame" href="'+contextPath + childNode.limitUrl +'" >'
									 	+'<i class="'+ childNode.limitIcon +'"></i>'
									 	+'<span>' + childNode.limitName + '</span>'
									 	+ '</a>'
										+'</li>';
								 }
								 tmpNode = tmpNode + '</ul>';
								 $('.side-bar').append($(tmpNode));
							}
						})
                	</script>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF SIDE MENU侧菜单结束  -->
    
    <div class="wrap-fluid">
    <div>
    	<iframe src="<%=request.getContextPath()%>/page_home.action" name="mainFrame" id="mainFrame" style="overflow-x: auto; overflow-y: auto; border:0;" width="100%" height="100%"  noresize="noresize"  onload="changeFrameHeight()"></iframe>
    </div>
    </div> 
    
    
</body>
</html>