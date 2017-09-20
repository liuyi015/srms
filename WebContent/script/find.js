function search(){
	/*$('#findName').validatebox({
		required : true,
		missingMessage : '请输入要查找的名字',
	});*/
	/*var name=$('#findName').val();
	if(name!=null){
		
	}*/
	$("#findFrom").attr("action","find_toList.action");
	$("#findFrom").submit();
}

function viewDetail(id){
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[0]+"/"+localObj.pathname.split("/")[1]+"/"+localObj.pathname.split("/")[2];
	var newwin = window
	.open(contextPath+"/find_toDetail.action?id="+id+"&"+ "", "",
			"top=100,left=100,height=460,width=860,scrollbars=no,status=no,resizable=yes");
	
}

function message(id){
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[0]+"/"+localObj.pathname.split("/")[1]+"/"+localObj.pathname.split("/")[2];
	var newwin = window
	.open(contextPath+"/find_toMessage.action?id="+id+"&"+ "", "",
			"top=100,left=100,height=460,width=860,scrollbars=no,status=no,resizable=yes");
	
}
function doMessage(thisform){
	with(thisform){
		if(message.value==''){
			alert("请填写你的留言");
			message.focus();
			return false;
		}
	}
}
function add(){
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[0]+"/"+localObj.pathname.split("/")[1]+"/"+localObj.pathname.split("/")[2];
	var newwin = window
	.open(contextPath+"/find_toAdd.action"+ "", "",
			"top=100,left=100,height=460,width=900,scrollbars=no,status=no,resizable=yes");
}

function doAdd(thisform){
	with(thisform){
		if(publisherName.value==''){
			alert("请填写你的名字");
			publisherName.focus();
			return false;
		}
		if(userName.value==''){
			alert("请填写要寻找的人的名字");
			publisherName.focus();
			return false;
		}
		if(address.value==''){
			alert("请填写要寻找的人的地区");
			publisherName.focus();
			return false;
		}
		if(school.value==''){
			alert("请填写要寻找的人的学校");
			publisherName.focus();
			return false;
		}
	}
	
}