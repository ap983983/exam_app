<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>


<body>

	<c:url var="updateQuestionLink" value="updateQuestion">
		<c:param name="course_id" value="${course_id}"></c:param>
	</c:url>

	<form:form action="${updateQuestionLink}" modelAttribute="question" method="POST">
	
		QID:<form:input path="questionId"/>
		QNAME:<form:input path="questionName"/><br><br>
		O1:<form:input path="questionOption1"/><br><br>
		O2:<form:input path="questionOption2"/><br><br>
		O3:<form:input path="questionOption3"/><br><br>
		O4:<form:input path="questionOption4"/><br><br>
		CO:<form:input path="questionCorrectOption"/><br><br>
		
		<input type="submit" />
		
	</form:form>


</body>

</html>