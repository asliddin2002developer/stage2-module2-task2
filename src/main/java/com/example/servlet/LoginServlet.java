package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<String> users = Users.getInstance().getUsers();

        String name = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (users.contains(name) && !password.isEmpty()) {
                session.setAttribute("user", name);
                resp.sendRedirect("/user/hello.jsp");
            } else {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super .doGet(req, resp);
    }

}
