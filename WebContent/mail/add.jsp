<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../assets/js/jquery.js"></script>
<link rel="stylesheet" href="../assets/css/style.css">
<link rel="stylesheet" href="../assets/css/loader-style.css">
<link rel="stylesheet" href="../assets/css/bootstrap.css">
<link rel="stylesheet" href="../assets/css/mail.css">
</head>
<body>
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
                    <form role="form">
                        <div class="form-group">
                            <input type="email" placeholder="To" id="exampleInputEmail1" class="form-control">
                        </div>
                        <div class="form-group">

                            <input type="email" placeholder="Subject" id="exampleInputPassword1" class="form-control">
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


                        <button class="btn" type="submit">发送</button>
                        <button class="btn" type="submit">
                            <span class="fontawesome-save"></span>&nbsp;&nbsp;保存为草稿</button>
                    </form>

                </div>

            </div>
        </div>

    </div>

</div>
</body>
</html>