<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta charset="utf-8">
    <title>寻人启事</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <link rel="shortcut icon" href="assets/ico/minus.png">
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
            </ul>
            <!-- END OF BREADCRUMB -->

            <div class="content-wrap">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="nest" id="FootableClose">
                         <form id="findFrom" action="findAction" method="post" name="findFrom">
                            <div class="title-alt">
                               <table>
                            		<tr>
                            			<td style="width:60%">寻找失去联系的同学</td>
                            			<td><input type="text" id="findName" name="userName" value="${userName }" /></td>
                            			<td ><input type="submit" value="查找" onclick="search();" /></td>
                            			<td style="width:10% ; text-align: right;"><a onclick="add();">发布寻人启事</a></td>
                            		</tr>
                            	</table>
                            </div>

                           <div class="body-nest" id="Footable">
                                <table class="table-striped footable-res footable metro-blue" data-page-size="10">
                                   <thead class="cf">
                                            <tr>
                                                <th>所寻之人</th>
                                                <th>地区</th>
                                                <th>学校</th>
                                                <th>发布人</th>
                                                <th>发布时间</th>
                                                <th>查看详情</th>
                                                <th>留言</th>
                                            </tr>
                                        </thead>
                                    <tbody>
                                        	<s:iterator value="#request.findUserList">
	                                        	<tr>
	                                                <td>${userName }</td>
	                                                <td>${address } </td>
	                                                <td class="numeric">${school }</td>
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
                          	</div>
						</form>
                       </div>
                    </div>
                </div>
            </div>
            <!-- /END OF CONTENT -->

            <!-- FOOTER -->
            <div id="footer"></div>
        </div>
    </div>
    <!--  END OF PAPER WRAP -->

    <!-- MAIN EFFECT -->
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="assets/js/app.js"></script>
    <script type="text/javascript" src="assets/js/load.js"></script>
    <script type="text/javascript" src="assets/js/main.js"></script>

    <!-- /MAIN EFFECT -->
    <!-- GAGE -->
    <script type="text/javascript" src="assets/js/toggle_close.js"></script>
    <script src="assets/js/footable/js/footable.js?v=2-0-1" type="text/javascript"></script>
    <script src="assets/js/footable/js/footable.sort.js?v=2-0-1" type="text/javascript"></script>
    <script src="assets/js/footable/js/footable.filter.js?v=2-0-1" type="text/javascript"></script>
    <script src="assets/js/footable/js/footable.paginate.js?v=2-0-1" type="text/javascript"></script>

    <script type="text/javascript">
    $(function() {
        $('.footable-res').footable();
    });
    </script>

</body>

</html>
