<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
</head>
<body>
<h2>Lisää uusi kysymys</h2>
<form action='/create' method='post'>
Kysymys id: <input type='text' name='kysymys_id'><br> 
Kysymys: <input type='text' name='kysymys'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>