package com.example.customermanager.controller;

import com.example.customermanager.model.Country;
import com.example.customermanager.model.User;
import com.example.customermanager.service.ICountryService;
import com.example.customermanager.service.ICustomerService;
import com.example.customermanager.service.IUserservice;
import com.example.customermanager.service.jdbc.CountryServiceJDBC;
import com.example.customermanager.service.jdbc.CustomerServiceJDBC;
import com.example.customermanager.service.jdbc.UserServiceJDBC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private IUserservice userservice;


    @Override
    public void init() throws ServletException {
        userservice = new UserServiceJDBC();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/admin/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userservice.checkUserNamePassword(username,password)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            resp.sendRedirect("/customers");
        } else {
            req.setAttribute("message", "sai username hoac password");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/admin/login.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}
