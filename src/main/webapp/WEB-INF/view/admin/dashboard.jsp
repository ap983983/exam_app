<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
	
	<body>
		
		<c:forEach var="cht_itr" items="${course_chart}">
			<tr>
				<td>${cht_itr.key}</td>
				<td>
					<c:forEach var="course_itr" items="${cht_itr.value}">
						<a href="courseQuestions?course_id=${course_itr.courseId}">${course_itr.courseName}</a><br>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	
	</body>
	
</html>