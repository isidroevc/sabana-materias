<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.isidroevc.hibernate.repository.RepositorioCentral"%>
<%@ page import="com.isidroevc.hibernate.entity.Materia"%>
<%@ page import="com.isidroevc.artifacts.IAuthenticator"%>
<%@ page import="com.isidroevc.artifacts.HttpSessionAuthenticator"%>
<%
IAuthenticator authenticator = new HttpSessionAuthenticator();
if (false && !authenticator.hasAccess(request, response)) {
  response.sendRedirect("http://localhost:8080/sabana-reporte-maestros/login.jsp");
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
  </style>
</head>

<body>
  <h2>Materias</h2>
  <div class="form-container">
    <form method="POST" action="./materia">
      <input type="hidden" name="metodo" value="crear" id="">
      <div class="form-group">
        <label for="exampleInputEmail1">Nombre materia</label>
        <input type="nombre" class="form-control" name="nombre">
      </div>
      <div class="form-group">
        <label for="creditos">Creditos</label>
        <input type="number" class="form-control"  name="creditos">
      </div>
      <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
  </div>
  <div class="tabla-materias">
    <table class="table-responsive-lg">
      <thead>
        <th>
          ID
        </th>
        <th>
          Nombre
        </th>
        <th>
          Creditos
        </th>
      </thead>
      <tbody>
        <c:forEach items="${materias}" var="materia">
          <tr>
            <td><c:out value="${materia.id}"/></td>
            <td><c:out value="${materia.nombre}"/></td> 
            <td><c:out value="${materia.creditos}"/></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>