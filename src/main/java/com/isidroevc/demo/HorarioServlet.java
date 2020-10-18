package com.isidroevc.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isidroevc.hibernate.entity.Materia;
import com.isidroevc.hibernate.entity.ProfesorTieneMateriaEnHorarioConGrupo;
import com.isidroevc.hibernate.repository.RepositorioCentral;
@WebServlet(name = "HorarioServlet", urlPatterns = {"/horario"}, loadOnStartup = 1) 
public class HorarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String metodo = request.getParameter("metodo");
        if (metodo.equals("eliminar")) {
            eliminar(request, response);
        } 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String metodo = request.getParameter("metodo");
        if (metodo.equals("crear")) {
            crear(request, response);
        }
    }

    public void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfesorTieneMateriaEnHorarioConGrupo registroHorario 
            = new ProfesorTieneMateriaEnHorarioConGrupo(
                Long.parseLong(request.getParameter("profesor")),
                Long.parseLong(request.getParameter("materia")),
                Long.parseLong(request.getParameter("horario")),
                Long.parseLong(request.getParameter("aula")),
                Long.parseLong(request.getParameter("grupo"))
            );
        RepositorioCentral repositorioCentral = new RepositorioCentral();
        repositorioCentral.crearRegistroHorario(registroHorario);
        response.sendRedirect("http://localhost:8080/sabana-materias/sabana.jsp"); 
    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idText = request.getParameter("id");
        Long id = Long.parseLong(idText);
        RepositorioCentral repositorioCentral = new RepositorioCentral();
        repositorioCentral.eliminarRegistroHorario(id);
        response.sendRedirect("http://localhost:8080/sabana-materias/sabana.jsp"); 
    }
} 