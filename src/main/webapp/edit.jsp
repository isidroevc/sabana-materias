<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.isidroevc.hibernate.repository.AlumnoRepository"%>
<%@ page import="com.isidroevc.hibernate.entity.Alumno"%>
<%
  AlumnoRepository alumnoRepository = new AlumnoRepository();
  String idText = request.getParameter("id");
  Alumno alumno = alumnoRepository.getAlumno(Long.parseLong(idText));
  pageContext.setAttribute("alumno", alumno);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar Alumno</title>
  <h1> Editar Alumno </h1>
  <div class="form-container">
    <form action="alumnos-update" method="POST">
      <input type="hidden" name="id" value="${alumno.id}">
      <input type="hidden" name="numeroDeControl" value="${alumno.numeroDeControl}">
      <label for="numeroDeControl">Número de control</label>
      <input type="text" value="${alumno.numeroDeControl}" disabled>
      <br>
      <label for="nombre">Nombre</label>
      <input type="text" name="nombre"value="${alumno.nombre}">
      <br>
      <label for="curso">Curso</label>
      <input type="text" name="curso" value="${alumno.curso}">
      <br>
      <label for="semestre">Semestre</label>
      <input type="number" name="semestre" value="${alumno.semestre}">
      <input type="submit" value="Guardar">
      <br>
    </form>
  </div>
</head>
<div>
</div>
<body>
  
</body>
</html>