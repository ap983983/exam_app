<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DashBoard</title>
</head>
<body>
	
	<h3>Section List</h3>
	<table>
		<th>
			<tr>Section</tr>
			<tr>courses</tr>
		</th>
		<c:forEach var="cht_itr" items="${course_chart}">
			<tr>
				<td>${cht_itr.key}</td>
				<td>
					<c:forEach var="course_itr" items="${cht_itr.value}">
						<a href="courses?course_id=${course_itr.courseId}">${course_itr.courseName}</a><br>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>