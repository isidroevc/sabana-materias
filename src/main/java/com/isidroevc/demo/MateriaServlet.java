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
        String metodo = request.getParameter("metodo");
        if (metodo.equals("crear")) {
            crear(request, response);
        } else if (metodo.equals("eliminar")) {
            eliminar(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String metodo = request.getParameter("metodo");
        if (metodo.equals("crear")) {
            crear(request, response);
        } else if (metodo.equals("eliminar")) {
            eliminar(request, response);
        } else if (metodo.equals("actualizar")) {
            actualizar(request, response);
        }
    }

    public void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String creditosText = request.getParameter("creditos");
        int creditos = Integer.parseInt(creditosText);
        Materia materia = new Materia(nombre, creditos);
        RepositorioCentral repositorioCentral = new RepositorioCentral();
        repositorioCentral.crearMateria(materia);
        response.sendRedirect("http://localhost:8080/sabana-materias/verAgregarMaterias.jsp"); 
    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idText = request.getParameter("id");
        Long id = Long.parseLong(idText);
        RepositorioCentral repositorioCentral = new RepositorioCentral();
        repositorioCentral.eliminarMateria(id);
        response.sendRedirect("http://localhost:8080/sabana-materias/verAgregarMaterias.jsp"); 
    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("The right method id being executed ===================");
        String idText = request.getParameter("id");
        Long id = Long.parseLong(idText);
        String nombre = request.getParameter("nombre");
        String creditosText = request.getParameter("creditos");
        int creditos = Integer.parseInt(creditosText);
        
        RepositorioCentral repositorioCentral = new RepositorioCentral();
        Materia materia = new Materia(nombre, creditos);
        materia.setId(id);
        System.out.println("The right method id being executed =================== " + materia.getId());
        repositorioCentral.actualizarMateria(materia);
        response.sendRedirect("http://localhost:8080/sabana-materias/verAgregarMaterias.jsp"); 
    }
} 