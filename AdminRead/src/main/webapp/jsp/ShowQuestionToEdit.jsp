<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kysymys application</title>
</head>
<body>
<h2>Muokkaa kysymyksiä</h2>
<form action='update' method='post'>
Kysymys id: <input type='text' name='kysymys_id' value='${requestScope.question.id}' readonly><br> 
Kysymys: <input type='text' name='kysymys' value='${requestScope.question.question}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>