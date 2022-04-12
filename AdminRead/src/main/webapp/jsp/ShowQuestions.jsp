<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Question"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>question application</title>

<%-- <link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css"> --%>
<<<<<<< Updated upstream:AdminRead/src/main/webapp/jsp/showquestion.jsp
<script src="myscriptfile.js"></script>
=======
>>>>>>> Stashed changes:AdminRead/src/main/webapp/jsp/ShowQuestions.jsp

</head>
<body>
	<h2>Kysymykset</h2>
<<<<<<< Updated upstream:AdminRead/src/main/webapp/jsp/showquestion.jsp
	<ol>
		<c:forEach var="question" items="${requestScope.questionlist}">
			<li>${question.question}<a href='/delete?id=${question.id}'>delete</a>
				<a href='/readtoupdate?id=${question.id}'>update</a>
		</c:forEach>
	</ol>
	<%--
<%
ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");

for (int i=0;questionList!=null && i<questionList.size();i++){
	Question f=questionList.get(i);
	out.println(f.getId()+": "+f.getQuestion()+"<a href='/delete?id="+f.getId()+"'>delete</a> <a href='/readtoupdate?id="+f.getId()+"'>update</a>");
}
%>


--%>

=======
    <ol>
        <c:forEach var="question" items="${requestScope.questionlist}">
            <li>${question.question}
            <a href='/delete?KYSYMYS_ID=${question.id}'>delete</a>
            <a href='/readtoupdate?id=${question.id}'>update</a>
        </c:forEach>
    </ol>
	
	
>>>>>>> Stashed changes:AdminRead/src/main/webapp/jsp/ShowQuestions.jsp

</body>
</html>