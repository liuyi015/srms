<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>私人信箱</title>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/loader-style.css">
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="assets/css/mail.css">

<script type="text/javascript">
	function selectAll(){
		if($('#selectAll').prop("checked")){
			$('.list:checkbox').prop("checked", true);  
		}else{
			$('.list:checkbox').prop("checked", false);  
		}
		
	}
	$(function(){
		$('.list').click(function(){
			allcheck();
		})
	})
	function allcheck(){
		
	    var chknum = $(".list").size();//选项总个数
		var chk = 0;
		$(".list").each(function () {  
	        if($(this).prop("checked")==true){
				chk++;
			}
	    });
		if(chknum==chk){//全选
			$("#selectAll").prop("checked",true);
		}else{//不全选
			$("#selectAll").prop("checked",false);
		}
	}
	
	function send(){
		var tosb=$('#to').val();
		
		if(tosb==null ||tosb==""){
			alert("收件人不能为空");
			return false;
		}
		var subject=$('#subject').val();
		if(subject==null||subject==""){
			alert("主题不能为空");
			return false;
		}
		$("#mailForm").attr("action", "msg_send.action");
	}
	function detail(msgId){
		alert(msgId);
	}
</script>
</head>
<body>
 <!--  PAPER WRAP -->
<div class="wrap-fluid">
    <div class="container-fluid paper-wrap bevel tlbr">
	    <!-- CONTENT -->
	    <!--TITLE -->
	    <div class="row">
	        <div id="paper-top">
	            <div class="col-sm-3">
	                <h2 class="tittle-content-header">
	                    <i class="icon-mail"></i> 
	                    <span>私人信箱
	                    </span>
	                </h2>
	
	            </div>
	        </div>
	    </div>
	    <!--/ TITLE -->
	
	    <!-- BREADCRUMB -->
	    <ul id="breadcrumb">
	        <li>
	            <span class="entypo-home"></span>
	        </li>
	        <li><i class="fa fa-lg fa-angle-right"></i>
	        </li>
	        <li><a href="${ pageContext.request.contextPath }/page_home.action" title="Sample page 1">首页</a>
	        </li>
	        <li><i class="fa fa-lg fa-angle-right"></i>
	        </li>
	        <li><a href="${ pageContext.request.contextPath }/msg_toList.action" title="Sample page 1">私人信箱</a>
	        </li>
	        <li class="pull-right">
	            <div class="input-group input-widget">
	
	                <input style="border-radius:15px" type="text" placeholder="Search..." class="form-control">
	            </div>
	        </li>
	    </ul>
	    <!-- END OF BREADCRUMB -->
	
	    <div class="content-wrap">
	        <div class="row">
	            <!-- SIDEMENU MAIL -->
	            <div class="col-sm-2">
	                <div class="side-mail">
	                    <div class="btn btn-info button-mail" data-toggle="modal" data-target="#myModal"><i class="entypo-pencil"></i>
	                    	&nbsp;&nbsp;撰写新信息</div>
	                    <div class="list-btn-mail active">
	                        <span class="entypo-download"></span><a>收件箱</a><i>648</i>
	                    </div>
	                    <div class="list-btn-mail">
	                        <span class="entypo-floppy"></span><a>草稿</a><i>5</i>
	                    </div>
	                    <div class="list-btn-mail">
	                        <span class="entypo-logout"></span><a>发件箱</a>
	                    </div>
	                    <div class="list-btn-mail">
	                        <span class="entypo-trash"></span><a>垃圾</a>
	                    </div>
	                    <div class="list-btn-mail">
	                        <span class="entypo-alert"></span><a>垃圾信息</a><i>123</i>
	                    </div>
						<div aria-labelledby="myLargeModalLabel" role="dialog" tabindex="-1" class="modal fade bs-example-modal-lg" style="display: none;" id="myModal">
						   <div class="modal-dialog modal-lg">
						        <div class="modal-content">
						
						            <div class="modal-header">
						                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">
						                    <span class="entypo-cancel"></span>
						                </button>
						                <h6 id="myLargeModalLabel" class="modal-title">撰写新信息</h6>
						            </div>
						            <div class="modal-body">
						                <div class="compose_mail">
						                    <form role="form" name="mailForm" id="mailForm" action="" method="post" enctype="multipart/form-data">
						                        <div class="form-group">
						                            <input type="text" placeholder="收件人" id="to" class="form-control">
						                        </div>
						                        <div class="form-group">
						                            <input type="text" placeholder="主题" id="subject" class="form-control">
						                        </div>
						
						                        <div class="btn-group">
						                            <button data-toggle="dropdown" class="btn dropdown-toggle" type="button">
						                                <span class="fontawesome-font"></span>Normal text
						                                <span class="caret"></span>
						                            </button>
						                            <ul role="menu" class="dropdown-menu">
						                                <li><a href="#">Action</a>
						                                </li>
						                                <li><a href="#">Another action</a>
						                                </li>
						                                <li><a href="#">Something else here</a>
						                                </li>
						                            </ul>
						                        </div>
						                        <div class="btn-group">
						                            <button type="button" class="btn">
						                                <span class="fontawesome-bold"></span>
						                            </button>
						                            <button type="button" class="btn">
						                                <span class="fontawesome-italic"></span>
						                            </button>
						                            <button type="button" class="btn">
						                                <span class="fontawesome-underline"></span>
						                            </button>
						                        </div>
						
						                        <div class="btn-group">
						                            <button type="button" class="btn">
						                                <span class="fontawesome-list-ul"></span>
						                            </button>
						                            <button type="button" class="btn">
						                                <span class="fontawesome-list-ol"></span>
						                            </button>
						                            <button type="button" class="btn">
						                                <span class="fontawesome-indent-left"></span>
						                            </button>
						                            <button type="button" class="btn">
						                                <span class="fontawesome-indent-right"></span>
						                            </button>
						                        </div>
						
						                        <button type="button" class="btn">
						                            <span class="entypo-link"></span>
						                        </button>
						                        <button type="button" class="btn">
						                            <span class="entypo-attach"></span>
						                        </button>
						                        <button type="button" class="btn">
						                            <span class="fontawesome-table"></span>
						                        </button>
						                        <button type="button" class="btn">
						                            <span class="fontawesome-camera"></span>
						                        </button>
						
						                        <textarea style="height:200px!important;margin:20px 0" class="form-control" rows="8"></textarea>
						
						                        <button class="btn" type="submit" onclick="send();">发送</button>
						                        <button class="btn" type="submit">
						                            <span class="fontawesome-save" onclick="save();"></span>&nbsp;&nbsp;保存为草稿
						                        </button>
						                    </form>
						
						                </div>
						
						            </div>
						        </div>
						
						    </div>
						
						</div>
	                </div>
	
	                
	            </div>
	            <!-- /SIDEMENU MAIL -->
	            <!-- CONTENT MAIL -->
	            <div class="col-sm-10">
	
	                <div class="mail_header">
	                    <div class="row">
	                        <div class="col-sm-6">
	
	                            <div style="margin-right:10px" class="btn-group pull-left">
	                                <div class="btn">
	                                    <input type="checkbox" id="selectAll" style="margin:0 5px;padding:0;position:relative;top:2px;" onclick="selectAll();">
		                                    所有
		                            </div>
	                                <button type="button" class="btn dropdown-toggle" data-toggle="dropdown">
	                                	&nbsp;&nbsp;
	                                    <span class="caret"></span>
	                                    <span class="sr-only">Toggle Dropdown</span>
	                                </button>
	                                <ul class="dropdown-menu" role="menu">
	                                    <li><a href="#">没有</a>
	                                    </li>
	                                    <li><a href="#">已读</a>
	                                    </li>
	                                    <li><a href="#">未读</a>
	                                    </li>
	                                </ul>
	                            </div>
	
	                            <div style="margin-right:10px" class="btn-group pull-left">
	                                <button type="button" class="btn  dropdown-toggle" data-toggle="dropdown">更多
	                                    <span class="caret"></span>
	                                </button>
	                                <ul class="dropdown-menu" role="menu">
	                                    <li><a href="#"><i class="fa fa-pencil"></i> 标记为已读</a>
	                                    </li>
	                                    <li><a href="#"><i class="fa fa-ban"></i> 垃圾短信息</a>
	                                    </li>
	                                    <li class="divider"></li>
	                                    <li><a href="#"><i class="fa fa-trash-o"></i> 删除</a>
	                                    </li>
	                                </ul>
	                            </div>
	
	                            <a href="msg_toList.action" style="margin-right:10px" type="button" data-color="#39B3D7" data-opacity="0.95" class="btn button test pull-left">
	                                <span class="entypo-arrows-ccw"></span>&nbsp;&nbsp;刷新</a>
	                        </div>
							
	                        <div class="col-sm-6">
	                        <!-- 翻页 -->
	                            <div class="btn-group pull-right">
	                                <button type="button" class="btn">
	                                    <span class="entypo-left-open"></span>
	                                </button>
	                                <button type="button" class="btn">
	                                    <span class="entypo-right-open"></span>
	                                </button>
	                            </div>
							<!-- /翻页 -->
	                            <div class="btn-group pull-right" style="margin-right:10px;">
	                                <button type="button" class="btn">1-50 of 124</button>
	                            </div>
	
	                        </div>
	                    </div>
	                </div>
	
	                <div id="content-mail">
	                    <div class="table-responsive">
	                        <!-- THE MESSAGES -->
	                        <table class="table table-mailbox">
	                        	<s:iterator value="#request.msgList">
		                            <tr class="unread" onclick="detail(${id })">
		                                <td class="small-col" style="width: 35px">
		                                    <input type="checkbox" class="list" value="${id }">
		                                </td>
		                                <td class="small-col" style="width: 35px"><i class="fa fa-star"></i>
		                                </td>
		                             <!--    <td class="name"><a class="star" href=""><i class="fa fa-twitter"></i></a>
		                                </td> -->
		                                <td style="width: 100px">${sendName }</td>
		                                <td class="subject">
		                                    <p class="email-summary">${title }</p>
		                                </td>
		                                <td class="time text-right">${sendTime }</td>
		                            </tr>
		                          </s:iterator>
	                        </table>
	                    </div>
	                    <!-- /.table-responsive -->
	
	                </div>
	            </div>
	            <!-- /CONTENT MAIL -->
	        </div>
	    </div>
	    <!-- /END OF CONTENT -->
	    
	      <!-- FOOTER -->
	            <div id="footer"></div>
	     <!-- / END OF FOOTER -->
	  </div>
</div>
	<!-- MAIN EFFECT -->
    <script type="text/javascript" src="assets/js/preloader.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/js/app.js"></script>
    <script type="text/javascript" src="assets/js/load.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>
</body>
</html>