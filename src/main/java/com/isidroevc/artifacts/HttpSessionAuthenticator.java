package com.isidroevc.artifacts;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class HttpSessionAuthenticator implements IAuthenticator {
  public void grantAccess(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    session.setAttribute("isLogged", "true");
    session.setMaxInactiveInterval(30*60);
  }
  
  public void removeAccess(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    session.setAttribute("isLogged", "false");
    session.setMaxInactiveInterval(30*60);
  }

  public boolean hasAccess(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    String isLogged = (String)session.getAttribute("isLogged");
    if (isLogged == null) {
      return false;
    }
    return isLogged.equals("true");
  }
}