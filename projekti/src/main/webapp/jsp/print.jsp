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
<title>Hello, JSP!</title>
<style>
body {background-color: gray;}
h1   {color: black;}
h1   {font: bold;}
p    {color: red;}


menu {
  display: flex;
  list-style: none;
  padding: 0;
  width: 400px;
  
}

li {
  flex-grow: 1;
}

button {
  width: 100%;
  background: #404040;
  color: white;
  font: bold;
}


header.page-header {
    background: no-repeat left/cover url(/media/examples/puppy-header-logo.jpg);
    display: flex;
    height: 120px;
    min-width: 120px;
    align-items: center;
    color: #fff;
    text-shadow: #000 0 0 .2em;
}

</style>
</head>
<header class="page-header">
    <h1>Admin kirjautumissivu</h1>
    
    <menu>
  <li><button onclick="window.location.href='https://w3docs.com';">Etusivu</button></li>
  <li><button  onclick="cut()">Ehdokkaat</button></li>
  <li><button  onclick="paste()">Kirjaudu</button></li>
</menu>
</header>
<body>


<h1 style="text-align: center; "> Tällä sivulla voit kirjautua</h1>
<p>	</p>

<form style="text-align: center; " name="loginForm" method="post" action="/loginServlet">
    <label>Käyttäjänimi  <input type="text" name="username"/> </label><br>
    <label>Salasana      <input type="password" name="password"/> </label><br>
    <input type="submit" value="Kirjaudu" />
</form>


</body>
</html>