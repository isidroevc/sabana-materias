<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.isidroevc.hibernate.repository.RepositorioCentral"%>
<%@ page import="com.isidroevc.hibernate.entity.Materia"%>
<%@ page import="com.isidroevc.hibernate.entity.User"%>
<%@ page import="com.isidroevc.hibernate.entity.Horario"%>
<%@ page import="com.isidroevc.hibernate.entity.Aula"%>
<%@ page import="com.isidroevc.hibernate.entity.Grupo"%>
<%@ page import="com.isidroevc.hibernate.entity.ProfesorTieneMateriaEnHorarioConGrupo"%>

<%@ page import="com.isidroevc.artifacts.IAuthenticator"%>
<%@ page import="com.isidroevc.artifacts.HttpSessionAuthenticator"%>
<%
IAuthenticator authenticator = new HttpSessionAuthenticator();

RepositorioCentral repositorioCentral = new RepositorioCentral();
Long idProfesor = Long.parseLong(request.getParameter("id"));

if (!authenticator.hasAccess(request, response)) {
  response.sendRedirect("http://localhost:8080/sabana-materias/login.jsp");
}
User profesor = repositorioCentral.findProfesor(idProfesor);
int horasAsignadas = 0;
List<ProfesorTieneMateriaEnHorarioConGrupo> reporteProfesor = repositorioCentral.obtenerReporteProfesor(idProfesor);
for(ProfesorTieneMateriaEnHorarioConGrupo registro : reporteProfesor) {
  horasAsignadas += registro.getMateria().getCreditos();
}
  pageContext.setAttribute("profesor", profesor);
pageContext.setAttribute("reporteProfesor", reporteProfesor);
pageContext.setAttribute("horasAsignadas", horasAsignadas);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

  <title>Sabana</title>
  

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
  <a href="./index.jsp">
    <button class="btn btn-primary">
      Menú
    </button>
  </a>
  <h2>Reporte de profesor</h2>
  <div class="form-container">
  </div>
  <p>Nombre del maestro: ${profesor.nombre}</p>
  <p>Clave del maestro: ${profesor.id}</p>
  <p>Horas asignadas: ${horasAsignadas}</p>
  <div class="tabla-sabana">
    <table class="table table-responsive-lg">
     <thead>
       <th>Clave grupo</th>
       <th>Clave materia</th>
       <th>Nombre materia</th>
       <th>Grupo</th>
       <th>Aula</th>
       <th>No. Alumnos</th>
       <th>Carrera</th>
       <th>Lunes</th>
       <th>Martes</th>
       <th>Miercoles</th>
       <th>Jueves</th>
       <th>Viernes</th>
     </thead>
     <tbody>
      <c:forEach items="${reporteProfesor}" var="registro">
        <tr>
          <td>${registro.id}</td>
          <td>${registro.materia.id}</td>
          <td>${registro.materia.nombre}</td>
          <td>${registro.grupo.nombre}</td>
          <td>${registro.aula.nombre}</td>
          <td>${registro.grupo.numeroAlumnos}</td>
          <td>ISX</td>>
          
          <c:if test="${registro.horario.dias == 'L-M-V'}">
            <td>${registro.horario.detalle}</td>
            <td></td>
            <td>${registro.horario.detalle}</td>
            <td></td>
            <td>${registro.horario.detalle}</td>
          </c:if>
          <c:if test="${registro.horario.dias == 'Ma-J-V'}">
            <td></td>
            <td>${registro.horario.detalle}</td>
            <td></td>
            <td>${registro.horario.detalle}</td>
            <td>${registro.horario.detalle}</td>
          </c:if>
        </tr>
      </c:forEach>
     </tbody>
    </table>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>