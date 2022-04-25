<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Luo kysymys</title>
</head>
<body>
<h2>Luo kysymys</h2>
<form action='/create' method='post'>
Kysymys: <input type='text' name='kysymys'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>