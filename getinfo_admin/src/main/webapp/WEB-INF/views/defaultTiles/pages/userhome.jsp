<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="profile-pic">

		<h1>hiii no</h1>
		<div class="imageHolder">

			<a href="/pim/viewPhotograph/empNumber/110" class="tiptip"> <img
				alt="Employee Photo" src="data:image/PNG;base64,${pic}" border="0"
				id="empPic" width="190" height="200">
			</a>

		</div>
</body>
</html>