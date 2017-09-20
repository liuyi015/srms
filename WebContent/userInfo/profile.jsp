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
</head>

<body>

<!--  PAPER WRAP -->
<div class="wrap-fluid">
    <div class="container-fluid paper-wrap bevel tlbr">
        <!-- CONTENT -->
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
            <li><a href="page_toProfile.action" title="Sample page 1">个人资料</a>
            </li>
        </ul>
		
        <div class="content-wrap">
            <!-- PROFILE -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="well profile">
                        <div class="col-sm-12">
                            <div class="col-xs-12 col-sm-4 text-center">

                                <ul class="list-group">
                                    <li class="list-group-item text-left">
                                        <span class="entypo-user"></span>&nbsp;&nbsp;个人资料</li>
                                    <li class="list-group-item text-center">
                                        <img src="${session.existUser.image}" alt="" class="img-circle img-responsive img-profile">

                                    </li>
                                    <li class="list-group-item text-center">
                                        <span class="pull-left">
                                            <strong>Ratings</strong>
                                        </span>


                                        <div class="ratings">

                                            <a href="#">
                                                <span class="fa fa-star"></span>
                                            </a>
                                            <a href="#">
                                                <span class="fa fa-star"></span>
                                            </a>
                                            <a href="#">
                                                <span class="fa fa-star"></span>
                                            </a>
                                            <a href="#">
                                                <span class="fa fa-star"></span>
                                            </a>
                                            <a href="#">
                                                <span class="fa fa-star-o"></span>
                                            </a>

                                        </div>


                                    </li>

                                    <li class="list-group-item text-right">
                                        <span class="pull-left">
                                            <strong>Joined</strong>
                                        </span>2.13.2014</li>
                                    <li class="list-group-item text-right">
                                        <span class="pull-left">
                                            <strong>Last seen</strong>
                                        </span>Yesterday</li>
                                    <li class="list-group-item text-right">
                                        <span class="pull-left">
                                            <strong>Nickname</strong>
                                        </span>themesmile</li>

                                </ul>

                            </div>
                            <div class="col-xs-12 col-sm-8 profile-name">
                                <h2> <s:property  value="#session.existUser.username"/>
                                    <span class="pull-right social-profile">
                                        <i class="entypo-facebook-circled"></i>  <i class="entypo-twitter-circled"></i>  <i class="entypo-linkedin-circled"></i>  <i class="entypo-github-circled"></i>  <i class="entypo-gplus-circled"></i>
                                    </span>
                                </h2>
                                <hr>

                                <dl class="dl-horizontal-profile">
                                    <dt>用户名</dt>
                                    <dd> <s:property  value="#session.existUser.username"/></dd>

                                    <dt>真实姓名</dt>
                                    <dd> <s:property  value="#session.existUser.name"/></dd>

                                    <dt>邮箱</dt>
                                    <dd> <s:property  value="#session.existUser.email"/></dd>

                                    <dt>手机号码</dt>
                                    <dd> <s:property  value="#session.existUser.phone"/></dd>

                                    <dt>地址</dt>
                                    <dd> <s:property  value="#session.existUser.addr"/></dd>

                                    <dt>性别</dt>
                                    <dd> <s:property  value="#session.existUser.sex"/></dd>

                                    <dt>毕业学校</dt>
                                    <dd> <s:property  value="#session.existUser.school"/></dd>

                                    <dt>班级</dt>
                                    <dd> <s:property  value="#session.existUser.className"/></dd>

                                </dl>


                                <hr>

                                <h5>
                                    <span class="entypo-arrows-ccw"></span>&nbsp;&nbsp;Recent Activities</h5>

                                <div class="table-responsive">
                                    <table class="table table-hover table-striped table-condensed">

                                        <tbody>
                                            <tr>
                                                <td><i class="pull-right fa fa-edit"></i> Today, 1:00 - Jeff Manzi liked your post.</td>
                                            </tr>
                                            <tr>
                                                <td><i class="pull-right fa fa-edit"></i> Today, 12:23 - Mark Friendo liked and shared your post.</td>
                                            </tr>
                                            <tr>
                                                <td><i class="pull-right fa fa-edit"></i> Today, 12:20 - You posted a new blog entry title "Why social media is".</td>
                                            </tr>
                                            <tr>
                                                <td><i class="pull-right fa fa-edit"></i> Yesterday - Karen P. liked your post.</td>
                                            </tr>
                                            <tr>
                                                <td><i class="pull-right fa fa-edit"></i> 2 Days Ago - Philip W. liked your post.</td>
                                            </tr>
                                            <tr>
                                                <td><i class="pull-right fa fa-edit"></i> 2 Days Ago - Jeff Manzi liked your post.</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </div>

                        </div>
                        <div class="col-xs-12 divider text-center">
                            <div class="col-xs-12 col-sm-4 emphasis">
                                <h2>
                                    <strong>20,7K</strong>
                                </h2>
                                <p>
                                    <small>Followers</small>
                                </p>
                                <button class="btn btn-success btn-block">
                                    <span class="fa fa-plus-circle"></span>&nbsp;&nbsp;Follow</button>
                            </div>
                            <div class="col-xs-12 col-sm-4 emphasis">
                                <h2>
                                    <strong>245</strong>
                                </h2>
                                <p>
                                    <small>Following</small>
                                </p>
                                <button class="btn btn-info btn-block">
                                    <span class="fa fa-user"></span>&nbsp;&nbsp;View Profile</button>
                            </div>
                            <div class="col-sm-4 emphasis">
                                <h2>
                                    <strong>43</strong>
                                </h2>
                                <p>
                                    <small>Likes</small>
                                </p>
                                <button class="btn btn-default btn-block">
                                    <span class="fa fa-user"></span>&nbsp;&nbsp;Likes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END OF PROFILE -->

            <!-- /END OF CONTENT -->
            <!-- FOOTER -->
             <div class="footer-space"></div>
             <div id="footer">
                 <div class="devider-footer-left"></div>
                 <div class="time">
                     <p id="spanDate">
                     <p id="clock">
                 </div>
             </div>
             <!-- / END OF FOOTER -->
        </div>
    </div>
    <!--  END OF PAPER WRAP -->

    <!-- MAIN EFFECT -->
    <script type="text/javascript" src="assets/js/preloader.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/js/app.js"></script>
    <script type="text/javascript" src="assets/js/load.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>


</div></body>

</html>
