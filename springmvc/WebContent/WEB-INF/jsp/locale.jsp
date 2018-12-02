<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fmt:message key="username"></fmt:message><br><br>
    <fmt:message key="password"></fmt:message>
    <br>
<div id="div" align="center" >
	<fmt:bundle  basename="locale_en">
		<fmt:message  key="username" var="usernameref"/>
		<h3>username内容为：${usernameref}</h3>
		<fmt:message key="password" var="passwordref"/>
		<h3>password内容为：${passwordref}</h3>
	</fmt:bundle>
 </div>
 <a href="../default.jsp">返回</a>
 <select onchange="changelang(this.value);">
 	<option value="locale_cn">汉语</option>
 	<option value="locale_en">英语</option>
 </select>
 <script>
 	function changelang(obj){
 		var fmt = document.getElementsByTagName("fmt:message");
 		alert(fmt.length);
 		alert(fmt[0].getAttribute("key"));
 		alert(fmt[0].getAttribute("value"));
 		alert(fmt[0].getAttribute("id"));
 		alert(fmt[0].getAttribute("align"));
 		var i =0;
 		
 		this.setAttribute("basename",obj);
 		//while(i<num){
 	 	//	fmt[i].setAttribute("key",obj);
 	 	//	++i;
 		//}
 	}
 </script>
</body>
</html>
