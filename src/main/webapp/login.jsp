<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.isidroevc.hibernate.repository.AlumnoRepository"%>
<%@ page import="com.isidroevc.hibernate.entity.Alumno"%>
<%@ page import="com.isidroevc.artifacts.IAuthenticator"%>
<%@ page import="com.isidroevc.artifacts.HttpSessionAuthenticator"%>

<%
IAuthenticator authenticator = new HttpSessionAuthenticator();
if (authenticator.hasAccess(request, response)) {
  response.sendRedirect("http://localhost:8080/crud-java-web-hibernate/");
}


%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <h1> Login </h1>
  <div class="form-container">
    <form action="login" method="POST">
      <label for="username">Username</label>
      <input type="text" value="" name="username">

      <label for="password">Password</label>
      <input type="password" value="" name="password">
      <input type="submit" value="Actualizar">
    </form>
  </div>
</head>
<div>
</div>
<body>
  
</body>
</html>