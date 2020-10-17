package com.isidroevc.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.isidroevc.hibernate.repository.UserRepository;
import com.isidroevc.hibernate.entity.User;
import com.isidroevc.artifacts.IAuthenticator;
import com.isidroevc.artifacts.HttpSessionAuthenticator;
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"}, loadOnStartup = 1) 
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        IAuthenticator authenticator = new HttpSessionAuthenticator();
        authenticator.removeAccess(request, response);
        response.sendRedirect("http://localhost:8080/sabana-reporte-maestros/login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserByUsername(username);
        
        if (user == null || !user.getPassword().equals(password)) {
          response.sendRedirect("http://localhost:8080/sabana-reporte-maestros/login.jsp");
          return;
        }
        IAuthenticator authenticator = new HttpSessionAuthenticator();
        authenticator.grantAccess(request, response);
        response.sendRedirect("http://localhost:8080/sabana-reporte-maestros/index.jsp");
    }
}