package com.isidroevc.artifacts;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CookieAuthenticator implements IAuthenticator {
  public void grantAccess(HttpServletRequest request, HttpServletResponse response) {
    Cookie cookie = new Cookie("isLogged", "true");
    cookie.setMaxAge(60*60*24);
    response.addCookie(cookie);
  }
  
  public void removeAccess(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("Gerooooo");
    Cookie cookie = new Cookie("isLogged", "false");
    cookie.setMaxAge(0);
    response.addCookie(cookie);
  }

  public boolean hasAccess(HttpServletRequest request, HttpServletResponse response) {
    Cookie[] cookies = request.getCookies();
    Cookie loginCookie = null;
    for(Cookie cookie : cookies) {
      if (cookie.getName().equals("isLogged")) {
        loginCookie = cookie;
      }
    }
    if (loginCookie == null) {
      return false;
    }
    return loginCookie.getValue().equals("true");
  }
}