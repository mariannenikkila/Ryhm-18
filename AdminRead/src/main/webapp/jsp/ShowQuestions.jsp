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

</head>
<body>
	<h2>Kysymykset</h2>
    <ol>
        <c:forEach var="question" items="${requestScope.questionlist}">
            <li>${question.question}
            <a href='/delete?KYSYMYS_ID=${question.id}'>delete</a>
            <a href='/readtoupdate?KYSYMYS_ID=${question.id}'>update</a>
        </c:forEach>
    </ol>
	
	

</body>
</html>

