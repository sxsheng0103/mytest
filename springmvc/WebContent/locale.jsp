<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" >
	<fmt:message key="username"></fmt:message><br><br>
    <fmt:message key="userpass"></fmt:message>
    <br>
	<fmt:bundle  basename="locale_en">
		<fmt:message  key="username" var="usernameref"/>
		<h3>username内容为：${usernameref}</h3>
		<fmt:message key="password" var="passwordref"/>
		<h3>password内容为：${passwordref}</h3>
	</fmt:bundle>
	<fmt:bundle  basename="locale_cn">
		<fmt:message  key="username" var="usernameref"/>
		<h3>username内容为：${usernameref}</h3>
		<fmt:message key="password" var="passwordref"/>
		<h3>password内容为：${passwordref}</h3>
	</fmt:bundle>
    <a href="./default.jsp">返回</a>
 </div>
 <select onchange="changelang(this.value);">
 	<option value="i18n">汉语</option>
 	<option value="i18n2">英语</option>
 </select>
 <script>
 	function changelang(obj){
 		var fmt =  document.getElementsByTagName("fmt:message");
 		var num = fmt.length;
 		var i =0;
 		while(i<num){
 	 		fmt[i].setAttribute("key",obj);
 	 		++i;
 		}
 	}
 </script>
</body>
</html>