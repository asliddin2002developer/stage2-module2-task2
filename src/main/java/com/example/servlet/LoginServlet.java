package com.example.servlet;

import com.example.Users;

import javax.servlet.RequestDispatcher;
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
        try {
            if (users.contains(req.getParameter("login")) && !req.getParameter("password").isEmpty()) {
                session.setAttribute("user", req.getParameter("login"));
                resp.sendRedirect(req.getContextPath() + "/user/hello.jsp");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath() + "/login.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super .doGet(req, resp);
    }

}
