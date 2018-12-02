<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<%=request.getContextPath()%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="form/addStand" method="post">
        <input type="submit" value="put">
</form>
<a href="./locale.jsp">国际化显示(切换语言浏览器语言也改变)</a><br>
<a href="./pudelete.jsp">表单发送put/delete请求</a><br>
<a href="./upload.jsp">上传文件</a><br>
<a href="./validatefrom.jsp">表单的验证（使用Hibernate-validate）及国际化</a><br>
<a href="./uploadpic.jsp">上传图片</a><br>
<a href="./uploadpic2.jsp">上传图片2</a><br>
</div>
<script>
function openjsp(){
	//javascript：void(0)" onClick="openjsp()
	//<c:url value="/form/addStand"/>
	//（${pageContext.request.contextPath}===${pageContext.request.contextPath}
	$.ajax({
        url:"<%=basePath%>form/addStand",
        //data:{"userName":"brianzhuang","password":"124652"},
        type:"get",
        dataType:"jsp",
        //success: function(data,textstatus){
        //    alert(textstatus);
        //},
        //error:function(jqxhr,textstatus,error){
        //    alert(jqxhr);
        //}
    });
}
</script>
</body>
</html>