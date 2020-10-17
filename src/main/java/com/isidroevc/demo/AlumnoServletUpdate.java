package com.isidroevc.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isidroevc.hibernate.repository.AlumnoRepository;
import com.isidroevc.hibernate.entity.Alumno;

@WebServlet(name = "AlumnoServletUpdate", urlPatterns = {"/alumnos-update"}, loadOnStartup = 1) 
public class AlumnoServletUpdate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        AlumnoRepository alumnoRepository = new AlumnoRepository();
        String textId = request.getParameter("id");
        Long id = Long.parseLong(textId);
        String numeroDeControl = request.getParameter("numeroDeControl");
        String nombre = request.getParameter("nombre");
        String curso = request.getParameter("curso");
        String semestreText = request.getParameter("semestre");
        int semestre = Integer.parseInt(semestreText);
        Alumno alumno = new Alumno(numeroDeControl, nombre, curso, semestre);
        alumno.setId(id);
        alumnoRepository.updateAlumno(alumno);
        request.getRequestDispatcher("index.jsp").forward(request, response); 
    }
}