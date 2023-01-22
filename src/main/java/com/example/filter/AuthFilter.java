package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/users/*"
)
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         Object user = request.getAttribute("user");
         if (user == null){
             HttpServletResponse httpResponse = (HttpServletResponse) response;
             httpResponse.sendRedirect("/login.jsp");
         }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
    //write your code here!
}