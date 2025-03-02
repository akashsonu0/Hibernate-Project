<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TARGET PAGE</title>
</head>
<body>
	<br>
	<br>
	<br>
	<!--  List :: policyList take and print the result -->
	<c:choose>
		<c:when test="${policyList ne null && !empty policyList }">

			<!-- print records -->
			<table border='1' align='center'>
				<tr>
					<th>SERIALNO</th>
					<th>POLICYID</th>
					<th>POLICYNAME</th>
					<th>POLICYTYPE</th>
					<th>COMPANY</th>
					<th>TENURE</th>
				</tr>
				<c:forEach var="dto" items="${policyList }">
					<tr>
						<td>${dto.serialNo }</td>
						<td>${dto.policyId }</td>
						<td>${dto.policyName }</td>
						<td>${dto.policyType }</td>
						<td>${dto.company }</td>
						<td>${dto.tenure}</td>
					</tr>
				</c:forEach>
			</table>

			<!--  BUILD UI TO PRESENT PAGINATION -->
			<center>

				<!-- CREATING PREVIOUS BUTTON -->
				<c:if test="${pageNo>1 }">
					<b><a href='controller?pageNo=${pageNo-1}&s1=link'>PREVIOUS</a></b> &nbsp; &nbsp;	
				</c:if>

				<!-- USE pagesCount to prepare a link for pagination -->
				<c:forEach var='i' begin='1' end="${pagesCount }" step="1">
					<b><a href='controller?pageNo=${i}&s1=link'>[${i}]</a></b> &nbsp; &nbsp;
				</c:forEach>

				<!-- CREATING NEXT BUTTON -->
				<c:if test="${pageNo<pagesCount }">
					<b><a href='controller?pageNo=${pageNo+1}&s1=link'>NEXT</a></b> &nbsp; &nbsp;
				</c:if>
			</center>



		</c:when>
		<c:otherwise>
			<!-- Print records not available -->
			<h1 style='color: red; text-align: center;'>NO RECORDS FOUND</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>