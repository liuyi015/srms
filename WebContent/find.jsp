<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta charset="utf-8">
    <title>Apricot 1.3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <script type="text/javascript" src="assets/js/jquery.js"></script>
    <script type="text/javascript" src="script/find.js"></script>

    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    
    <link href="assets/js/footable/css/footable.core.css?v=2-0-1" rel="stylesheet" type="text/css">
    <link href="assets/js/footable/css/footable.standalone.css" rel="stylesheet" type="text/css">
    <link href="assets/js/footable/css/footable-demos.css" rel="stylesheet" type="text/css">
    
	<link rel="stylesheet" href="assets/js/dataTable/lib/jquery.dataTables/css/DT_bootstrap.css">
    <link rel="stylesheet" href="assets/js/dataTable/css/datatables.responsive.css">
    
    <link href="assets/js/stackable/stacktable.css" rel="stylesheet">
    <link href="assets/js/stackable/responsive-table.css" rel="stylesheet">
    <link rel="shortcut icon" href="assets/ico/minus.png">
    
    <script type="text/javascript">
    $(function() {
        $('.footable-res').footable();
    });
    </script>
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div id="status">&nbsp;</div>
    </div>

    <!--  PAPER WRAP -->
    <div class="wrap-fluid">
        <div class="container-fluid paper-wrap bevel tlbr">
            <!-- CONTENT -->
            <!--TITLE -->
            <div class="row">
                <div id="paper-top">
                    <div class="col-sm-3">
                        <h2 class="tittle-content-header">
                            <span class="entypo-layout"></span>
                            <span>寻人启事
                            </span>
                        </h2>

                    </div>

                    <div class="col-sm-7">
                        <div class="devider-vertical visible-lg"></div>
                        <div class="tittle-middle-header">
                            <div class="alert">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <span class="tittle-alert entypo-info-circled"></span>
                                Welcome back,&nbsp;
                                <strong>Dave mattew!</strong>&nbsp;&nbsp;Your last sig in at Yesterday, 16:54 PM
                            </div>
                        </div>

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
                <li><a href="${ pageContext.request.contextPath }/page_home.action" title="Sample page 1">Home</a>
                </li>
                <li><i class="fa fa-lg fa-angle-right"></i>
                </li>
                <li><a href="${ pageContext.request.contextPath }/find.jsp" title="Sample page 1">Blog List</a>
                </li>
            </ul>
            <!-- END OF BREADCRUMB -->


            <div class="content-wrap">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="nest" id="tableStaticClose">
                          <form id="findFrom" action="findAction" method="post" name="findFrom">
                            <div class="title-alt" style="width:100%">
                            	<table>
                            		<tr>
                            			<td style="width:60%">寻找失去联系的同学</td>
                            			<td><input type="text" id="findName" name="findName" /></td>
                            			<td ><input type="submit" value="查找" onclick="search();" /></td>
                            			<td style="width:10% ; text-align: right;"><a href="">发布寻人启事</a></td>
                            		</tr>
                            	</table>
                             
                            </div>
							
                            <div class="body-nest" id="tableStatic">
                                <section id="flip-scroll">
                                    <table class="table table-bordered table-striped cf">
                                        <thead class="cf">
                                            <tr>
                                                <th class="numeric">所寻之人</th>
                                                <th class="numeric">地区</th>
                                                <th class="numeric">学校</th>
                                                <th class="numeric">班级</th>
                                                <th class="numeric">发布人</th>
                                                <th class="numeric">发布时间</th>
                                                <th class="numeric">查看详情</th>
                                                <th class="numeric">留言</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<s:iterator value="#request.findUserList">
	                                        	<tr>
	                                                <td>${userName }</td>
	                                                <td>${address } </td>
	                                                <td class="numeric">${school }</td>
	                                                <td class="numeric">${className }</td>
	                                                <td class="numeric">${publisherName }</td>
	                                                <td class="numeric">${publishTime }</td>
	                                                <td><input type="button" value="查看" onclick='viewDetail("${id}");'></td>
	                                                <td><input type="button" value="留言" onclick='message("${id}");'/></td>
	                                           	 </tr>
                                        	</s:iterator>
                                        </tbody>
                                        <tfoot>
	                                        <tr>
	                                            <td colspan="8">
	                                                <div class="pagination pagination-centered"></div>
	                                            </td>
	                                        </tr>
                                    	</tfoot>
                                    </table>
                                </section>
                            </div>
                         </form>
                        </div>
                    </div>

                </div>
            </div>

            <!-- FOOTER -->
            <div class="footer-space"></div>
            <div id="footer">
                <div class="devider-footer-left"></div>
                <div class="time">
                    <p id="spanDate">
                    <p id="clock">
                </div>
                <div class="copyright">
                <div class="devider-footer"></div>
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


    <!-- GAGE -->
    <script type="text/javascript" src="assets/js/toggle_close.js"></script>
    <script src="assets/js/footable/js/footable.js?v=2-0-1" type="text/javascript"></script>
    <script src="assets/js/footable/js/footable.sort.js?v=2-0-1" type="text/javascript"></script>
    <script src="assets/js/footable/js/footable.filter.js?v=2-0-1" type="text/javascript"></script>
    <script src="assets/js/footable/js/footable.paginate.js?v=2-0-1" type="text/javascript"></script>
    <script src="assets/js/footable/js/footable.paginate.js?v=2-0-1" type="text/javascript"></script>

    <!-- /MAIN EFFECT -->
    <script type="text/javascript" src="assets/js/stackable/stacktable.js"></script>


    <script>
    $(document).on('click', '#run', function(e) {
        e.preventDefault();
        $('#simple-example-table').stacktable({
            hideOriginal: true
        });
        $(this).replaceWith('<span>ran</span>');
    });
    $('#responsive-example-table').stacktable({
        myClass: 'stacktable small-only'
    });
    </script>




</body>

</html>
