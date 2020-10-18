package com.isidroevc.artifacts;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isidroevc.hibernate.entity.User;
public class CookieAuthenticator implements IAuthenticator {
  public void grantAccess(HttpServletRequest request, HttpServletResponse response, User user) {
    Cookie cookie = new Cookie("isLogged", "true");
    Cookie rolCookie = new Cookie("rol", user.getRol());
    cookie.setMaxAge(60*60*24);
    rolCookie.setMaxAge(60*60*24);
    response.addCookie(cookie);
    response.addCookie(rolCookie);
  }
  
  public void removeAccess(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("Gerooooo");
    Cookie cookie = new Cookie("isLogged", "false");
    Cookie rolCookie = new Cookie("rol", "");
    cookie.setMaxAge(0);
    rolCookie.setMaxAge(0);
    response.addCookie(cookie);
    response.addCookie(rolCookie);
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

  public String getCurrentRol(HttpServletRequest request, HttpServletResponse response) {
    Cookie[] cookies = request.getCookies();
    Cookie rolCookie = null;
    for(Cookie cookie : cookies) {
      if (cookie.getName().equals("rol")) {
        rolCookie = cookie;
      }
    }
    if (rolCookie == null) {
      return "";
    }
    return rolCookie.getValue();
  }

  public Long getCurrentUserId(HttpServletRequest request, HttpServletResponse response) {
    Cookie[] cookies = request.getCookies();
    Cookie rolCookie = null;
    for(Cookie cookie : cookies) {
      if (cookie.getName().equals("userId")) {
        rolCookie = cookie;
      }
    }
    if (rolCookie == null) {
      return  -1L;
    }
    return Long.parseLong(rolCookie.getValue());
  }
}