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
if (!authenticator.hasAccess(request, response) || !authenticator.getCurrentRol(request, response).equals("jefe")) {
  response.sendRedirect("http://localhost:8080/sabana-materias/login.jsp");
}
RepositorioCentral repositorioCentral = new RepositorioCentral();
List<Materia> materias = repositorioCentral.obtenerMaterias();
List<User> profesores = repositorioCentral.obtenerProfesores();
List<Horario> horarios = repositorioCentral.obtenerHorarios();
List<Aula> aulas = repositorioCentral.obtenerAulas();
List<Grupo> grupos = repositorioCentral.obtenerGrupos();
List<ProfesorTieneMateriaEnHorarioConGrupo> registrosHorario = repositorioCentral.obtenerRegistrosHorario();
pageContext.setAttribute("materias", materias);
pageContext.setAttribute("profesores", profesores);
pageContext.setAttribute("horarios", horarios);
pageContext.setAttribute("grupos", grupos);
pageContext.setAttribute("aulas", aulas);
pageContext.setAttribute("registrosHorario", registrosHorario);
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
  <h2>Guardar registro de horario</h2>
  <div class="form-container">
    <form method="POST" action="./horario">
      <input type="hidden" name="metodo" value="crear" id="">
      <div class="form-group">
        <label for="profesor">Profesor</label>
        <select class="form-control" name="profesor">
          <c:forEach items="${profesores}" var="profesor">
            <option value="${profesor.id}">${profesor.nombre}</option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="materia">Materia</label>
        <select class="form-control" name="materia">
          <c:forEach items="${materias}" var="materia">
            <option value="${materia.id}">${materia.nombre}</option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="horario">Horario</label>
        <select class="form-control" name="horario">
          <c:forEach items="${horarios}" var="horarios">
            <option value="${horarios.id}">${horarios.dias} - ${horarios.detalle}</option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="aula">Aula</label>
        <select class="form-control" name="aula">
          <c:forEach items="${aulas}" var="aula">
            <option value="${aula.id}">${aula.nombre}</option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="aula">Grupo</label>
        <select class="form-control" name="grupo">
          <c:forEach items="${grupos}" var="grupo">
            <option value="${grupo.id}">${grupo.nombre}</option>
          </c:forEach>
        </select>
      </div>
      <button class="btn btn-primary">
        Guardar
      </button>
    </form>
  </div>
  <div class="tabla-sabana">
    <table class="table table-responsive-lg">
     <thead>
       <th>ClaveHorario</th>
       <th>ClaveMateria</th>
       <th>ClaveCarrera</th>
       <th>Materia</th>
       <th>Carrera</th>
       <th>Maestro</th>
       <th>Periodo</th>
       <th>Turno</th>
       <th>Grupo</th>
       <th>NoAlumnos</th>
       <th>Semestre</th>
       <th>Creditos</th>
       <th>Salon</th>
       <th>Lunes</th>
       <th>Martes</th>
       <th>Miercoles</th>
       <th>Jueves</th>
       <th>Viernes</th>
       <th></th>
     </thead>
     <c:forEach items="${registrosHorario}" var="registro">
      <tr>
        <td>${registro.id}</td>
        <td>${registro.materia.id}</td>
        <td>ISX</td>
        <td>${registro.materia.nombre}</td>
        <td>Ingeniería en Sistemas Computacionales</td>
        <td> <a href="./reporteProfesor.jsp?id=${registro.profesor.id}">${registro.profesor.nombre}</a></td>
        <td>Agosto-Diciembre</td>
        <td>${registro.horario.turno.nombre}</td>
        <td>${registro.grupo.nombre}</td>
        <td>${registro.grupo.numeroAlumnos}</td>
        <td>1</td>
        <td>${registro.materia.creditos}</td>
        <td>${registro.aula.nombre}</td>
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
        <td>
          <a href="./horario?metodo=eliminar&id=<c:out value="${registro.id}"/>">
          <button class="btn btn-danger">Eliminar</button>
        </a>
        </td>
      </tr>
    </c:forEach>
    </table>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>