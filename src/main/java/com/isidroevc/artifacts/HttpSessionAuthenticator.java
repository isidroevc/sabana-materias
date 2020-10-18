package com.isidroevc.artifacts;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.isidroevc.hibernate.entity.User;
public class HttpSessionAuthenticator implements IAuthenticator {
  public void grantAccess(HttpServletRequest request, HttpServletResponse response, User user) {
    HttpSession session = request.getSession();
    session.setAttribute("isLogged", "true");
    session.setAttribute("rol", user.getRol());
    session.setAttribute("userId", user.getId());
    session.setMaxInactiveInterval(30*60);
  }
  
  public void removeAccess(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    session.setAttribute("isLogged", "false");
    session.setAttribute("rol", "");
    session.setAttribute("userId", "");
    session.setMaxInactiveInterval(0);
  }

  public boolean hasAccess(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    String isLogged = (String)session.getAttribute("isLogged");
    if (isLogged == null) {
      return false;
    }
    return isLogged.equals("true");
  }

  public String getCurrentRol(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    String rol = (String)session.getAttribute("rol");
    return rol;
  }

  public Long getCurrentUserId(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    String id = (String)session.getAttribute("userId");
    return Long.parseLong(id);
  }
}