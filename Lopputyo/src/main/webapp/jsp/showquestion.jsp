<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>   
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kysymys application</title>



</head>
<body>
<h2>Kysymys application</h2>
	<ol>
		<c:forEach var="question" items="${requestScope.questionlist}">
			<li>${question.kysymys} 
			<a href='/delete?kysymys_id=${question.kysymys_id}'>delete</a> 
			<a href='/readtoupdate?kysymys_id=${question.kysymys_id}'>update</a>
		</c:forEach>
	</ol>
<a href='/jsp/createkysymys.jsp'>Create new question</a>

</body>
</html>