<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta charset="utf-8">
    <title>查看详情</title>
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
				查看寻人详情
			</label>
		</center>
	</div>
	<div>
		<hr class="hrline" />
	</div>
    <!--/ TITLE -->
    <form action="find_doMessage.action?publisherId=${findUserInfo.publisher}" method="post" onsubmit="return doMessage(this);">
     <table width=100% border=1  cellspacing="0" cellpadding="8" style="border-collapse: collapse;">
		<tr>
			<td width="150" nowrap="nowrap">
				<span class="title">&nbsp;&nbsp; 发布人</span>
			</td>
			<td align=left>
				<span class="title" style="color: blue;">${findUserInfo.publisherName} </span>
			</td>
		</tr>
		<tr>
			<td width="150" nowrap="nowrap">
				<span class="title">&nbsp;&nbsp; 寻找人</span>
			</td>
			<td align=left>
				<span class="title" style="color: blue;">${findUserInfo.userName} </span>
			</td>
		</tr>
		<tr>
			<td width="150" nowrap="nowrap">
				<span class="title">&nbsp;&nbsp; 地址</span>
			</td>
			<td align=left>
				<span class="title" style="color: blue;">${findUserInfo.address} </span>
			</td>
		</tr>
		<tr>
			<td width="150" nowrap="nowrap">
				<span class="title">&nbsp;&nbsp; 发布时间</span>
			</td>
			<td align=left>
				<span class="title" style="color: blue;">${findUserInfo.publishTime} </span>
			</td>
		</tr>
		<tr>
			<td width="150" nowrap="nowrap">
				<span class="title">&nbsp;&nbsp; 学校</span>
			</td>
			<td align=left>
				<span class="title" style="color: blue;">${findUserInfo.school}</span>
			</td>
		</tr>
		<tr>
			<td width="150" nowrap="nowrap">
				<span class="title">&nbsp;&nbsp; 留言信息</span>
			</td>
			<td align=left>
				<span class="title" style="color: blue;">${findUserInfo.message}</span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea rows="3" cols="100" name="message"></textarea>
			</td>
		</tr>
	</table>
	<div style="margin-top: 10px">
		<center>
			<input type="submit"  class="btn_2k3"  value="留言"/>
			&nbsp;&nbsp;&nbsp;
			<input type="button" class="btn_2k3" value="取消" onclick="window.close();"/>
		</center>
	</div>
  </form>

</body>


