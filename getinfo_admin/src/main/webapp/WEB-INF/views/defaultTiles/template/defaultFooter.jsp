<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:url var="images" value="/resources/images"></spring:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#backfooter {
	height: 50px;
	color: #ccc;
	font-weight:lighter;
	font-size: 20px;
	background-image: url("${images}/ball_cube.jpg");
	text-align: center;
}
</style>
</head>
<body>
	<div id="backfooter">support@getinfo.com</div>

</body>
</html>