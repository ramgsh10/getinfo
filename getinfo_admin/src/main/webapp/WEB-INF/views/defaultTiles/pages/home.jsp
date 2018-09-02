<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<spring:url var="images" value="/resources/images"></spring:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="signIn" modelAttribute="loginData" method="post">
		<form:input path="emailorphone" placeholder="Email Or Phone"/>
		<form:input path="password" placeholder="password"/>
		<button type="submit">SignIn</button>
	</form:form>
	
	<form:form action="signUp" modelAttribute="signUpData" method="post" enctype="multipart/form-data">
		<form:hidden path="userId"/>
		<form:input path="name" placeholder="name"/>
		<form:input path="emailorphone" placeholder="Email Or Phone"/>
		<form:input path="password" placeholder="password"/>
		<form:input type="file" path="file"/>
		<button type="submit">SignUp</button>
	</form:form>
</body>
</html>