<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% int i=0; %>
<html>

<body>

  
	<button onclick="window.location.href='${pageContext.request.contextPath}/admin/showInsertForm?course_id=${course_id}'" >Add Customer</button>
	
	<table border="1">
	
	<tr>
		<th>S.No</th>
		<th>QName</th>
		<th>O1</th>
		<th>O2</th>
		<th>O3</th>
		<th>O4</th>
		<th>CO</th>
		<th>Edit/Delete</th>
	</tr>
	
	<c:forEach items="${questions_list}" var="itr">
		

			<c:url var="updateLink" value="/admin/showUpdateForm">
				<c:param name="questionId" value="${itr.questionId}"></c:param>
				<c:param name="course_id" value="${course_id}"></c:param>
			</c:url>
			
			<c:url var="deleteLink" value="/admin/deleteQuestion">
				<c:param name="questionId" value="${itr.questionId}"></c:param>
				<c:param name="course_id" value="${course_id}"></c:param>
			</c:url>
			
		<tr>
			<td>${itr.questionId}</td>
			<td>${itr.questionName}</td>
			<td>${itr.questionOption1}</td>
			<td>${itr.questionOption2}</td>
			<td>${itr.questionOption3}</td>
			<td>${itr.questionOption4}</td>
			<td>${itr.questionCorrectOption}</td>
			<td><a href="${updateLink}">Edit</a>/<a href="${deleteLink}">Delete</a></td>
		</tr>
	
	</c:forEach>
	
	
	</table>

</body>

</html>