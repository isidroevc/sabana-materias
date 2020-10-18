package com.isidroevc.artifacts;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isidroevc.hibernate.entity.User;
public interface IAuthenticator {
  public void grantAccess(HttpServletRequest request, HttpServletResponse response, User user);
  public String getCurrentRol(HttpServletRequest request, HttpServletResponse response);
  public Long getCurrentUserId(HttpServletRequest request, HttpServletResponse response);
  public void removeAccess(HttpServletRequest request, HttpServletResponse response);
  public boolean hasAccess(HttpServletRequest request, HttpServletResponse response);
}