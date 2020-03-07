<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<% int i=0,j=0; %>
<html>
<head>

</head>
<body>
	<h2>Course Question</h2>
	
	<form:form action="results" method="POST" modelAttribute="course_question_list">
		
		<c:forEach var="itr" items="${course_question_list.courseQuestion}" varStatus="tagStatus">
		
			"Q<%=++i %>" : ${itr.questionName}<br>	
		
			<form:radiobutton path="courseQuestion[${tagStatus.index}].questionOption1" value="<%=++j %>"/> ${itr.questionOption1}<br>
			<form:radiobutton path="courseQuestion[${tagStatus.index}].questionOption2" value="<%=++j %>"/> ${itr.questionOption2}<br>
			<form:radiobutton path="courseQuestion[${tagStatus.index}].questionOption3" value="<%=++j %>"/> ${itr.questionOption3}<br>
			<form:radiobutton path="courseQuestion[${tagStatus.index}].questionOption4" value="<%=++j %>"/> ${itr.questionOption4}<br>
			
			<form:hidden path="courseQuestion[${tagStatus.index}].questionCorrectOption" />
			
			<% j = 0; %>
			<br>
		</c:forEach>
	
		<input type="submit" value="submit"/>
	</form:form>
	
</body>
</html>