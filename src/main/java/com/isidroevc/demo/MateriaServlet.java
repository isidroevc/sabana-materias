package com.isidroevc.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isidroevc.hibernate.entity.Materia;
import com.isidroevc.hibernate.repository.RepositorioCentral;
@WebServlet(name = "MateriaServlet", urlPatterns = {"/materia"}, loadOnStartup = 1) 
public class MateriaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.getWriter().print("Hello, World!");  
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String metodo = request.getParameter("metodo");
        if (metodo.equals("crear")) {
            crear(request, response);
        }
    }

    public void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String creditosText = request.getParameter("creditos");
        int creditos = Integer.parseInt(creditosText);
        Materia materia = new Materia(nombre, creditos);
        RepositorioCentral repositorioCentral = new RepositorioCentral();
        repositorioCentral.crear(materia);
        response.sendRedirect("http://localhost:8080/sabana-materias/verAgregarMaterias.jsp"); 
    }
}