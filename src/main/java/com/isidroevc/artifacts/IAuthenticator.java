package com.isidroevc.artifacts;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface IAuthenticator {
  public void grantAccess(HttpServletRequest request, HttpServletResponse response);
  public void removeAccess(HttpServletRequest request, HttpServletResponse response);
  public boolean hasAccess(HttpServletRequest request, HttpServletResponse response);
}