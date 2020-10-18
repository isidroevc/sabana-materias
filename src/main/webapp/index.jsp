<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.isidroevc.hibernate.repository.RepositorioCentral"%>
<%@ page import="com.isidroevc.hibernate.entity.Materia"%>
<%@ page import="com.isidroevc.artifacts.IAuthenticator"%>
<%@ page import="com.isidroevc.artifacts.HttpSessionAuthenticator"%>
<%
IAuthenticator authenticator = new HttpSessionAuthenticator();
if (!authenticator.hasAccess(request, response) || !authenticator.getCurrentRol(request, response).equals("jefe")) {
  response.sendRedirect("http://localhost:8080/sabana-materias/login.jsp");
}
RepositorioCentral repositorioCentral = new RepositorioCentral();
List<Materia> materias = repositorioCentral.obtenerMaterias();
pageContext.setAttribute("materias", materias);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

  <title>Lista de alumnos</title>
  

  <br>
  <style>
    td { 
    padding: 10px;
  }

  table { 
    border-spacing: 10px;
    border-collapse: separate;
}
.form-container {
  width: 800px;
  margin-left: 50px;
}
h1 {
  width: 100%;
  text-align: center;
}
div.menu-container {
  width: 100%;
  display: flex;
  justify-content: center;
}
div.buttons-container {
  width: 40%;
  display: flex;
  flex-direction: column;
}
.menu-button {
  margin: 10px;
  width: 100%;
} 
  </style>
</head>

<body>
  <h1>Menú</h1>
  <div class="menu-container">
    <div class="buttons-container menu-button">
      <a href="./verAgregarMaterias.jsp">
        <button class="menu-button btn btn-primary">Materias</button>
      </a>
      <a href="./sabana.jsp">
        <button class="menu-button btn btn-primary">Sabana</button>
      </a>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>