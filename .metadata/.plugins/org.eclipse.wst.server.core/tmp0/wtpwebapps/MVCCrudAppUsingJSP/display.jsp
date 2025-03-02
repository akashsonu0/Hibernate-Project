<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OUTPUT PAGE</title>
</head>
<body bgcolor="lightblue">
	<br>
	<br>
	<br>
	<c:choose>
		<c:when test="${student ne null || !empty student }">
			<!-- PRESENT TABLE DATA -->
			<table border='1' align='center'>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AGE</th>
					<th>ADDRESS</th>
				</tr>
				<tr>
					<td>${student.sid }</td>
					<td>${student.sname }</td>
					<td>${student.sage }</td>
					<td>${student.saddress }</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<!-- PRINT DATA NOT FOUND FOR THE GIVEN ID -->
			<h1 style='color: red; text-align: center;'>RECORD NOT FOUND TO
				DISPLAY</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>