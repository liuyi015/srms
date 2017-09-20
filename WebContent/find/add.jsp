<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta charset="utf-8">
    <title>发布寻人启事</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="../assets/css/blueStyle.css">
    <script type="text/javascript" src="../script/find.js"></script>
</head>
<body>

 	<!--/ TITLE -->
    <div>
		<center>
			<label class="pageTitle">
				&nbsp;&nbsp;
				发布寻人启事
			</label>
		</center>
	</div>
	<div>
		<hr class="hrline" />
	</div>
    <!--/ TITLE -->
    <div>
    	<form action="find_doAdd.action" method="post" onsubmit="return doAdd(this);">
		     <table width=100% border=1  cellspacing="0" cellpadding="8" style="border-collapse: collapse;">
				<tr>
					<td  nowrap="nowrap" align=left>
						<span class="title"> 我的姓名</span>
					</td>
					<td align=left>
						<input type="text" name="publisherName">
					</td>
				</tr>
				<tr>
					<td nowrap="nowrap" align=left>
						<span class="title">寻找人的姓名</span>
					</td>
					<td align=left>
						<input type="text" name="userName">
					</td>
				</tr>
				<tr>
					<td  nowrap="nowrap" align=left>
						<span class="title">地区</span>
					</td>
					<td align=left>
						<input type="text" name="address">
					</td>
				</tr>
				<tr>
					<td nowrap="nowrap" align=left>
						<span class="title">学校</span>
					</td>
					<td align=left>
						<input type="text" name="school">
					</td>
				</tr>
				<tr>
					<td nowrap="nowrap" align=left>
						<span class="title"> 留言内容</span>
					</td>
					<td align=left>
						<textarea rows="3" cols="100" name="message"></textarea>
					</td>
				</tr>
			</table>
			<div style="margin-top: 10px">
				<center>
					<input type="submit"  class="btn_2k3"  value="发布"/>
					&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn_2k3" value="取消" onclick="window.close();"/>
				</center>
			</div>
		</form>
    </div>
</body>


