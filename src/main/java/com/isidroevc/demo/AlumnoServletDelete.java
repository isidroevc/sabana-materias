package com.isidroevc.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isidroevc.hibernate.repository.AlumnoRepository;
import com.isidroevc.hibernate.entity.Alumno;

@WebServlet(name = "AlumnoServletDelete", urlPatterns = {"/delete"}, loadOnStartup = 1) 
public class AlumnoServletDelete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String id = request.getParameter("id");
        AlumnoRepository alumnoRepository = new AlumnoRepository();
        alumnoRepository.deleteAlumno(Long.parseLong(id));
        request.getRequestDispatcher("index.jsp").forward(request, response); 
    }
}