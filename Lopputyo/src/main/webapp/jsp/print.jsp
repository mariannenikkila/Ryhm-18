<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    String username = "admin";
    String password = "admin";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>

</head>
<header class="page-header">
    <h1>Admin kirjautumissivu</h1>
    



<h1 style="text-align: center; "> Tällä sivulla voit kirjautua</h1>
<p>	</p>

<form style="text-align: center; " name="loginForm" method="post" action="/loginServlet">
    <label>Käyttäjänimi  <input type="text" name="username"/> </label><br>
    <label>Salasana      <input type="password" name="password"/> </label><br>
    <input type="submit" value="Kirjaudu" />
</form>


</body>
</html>