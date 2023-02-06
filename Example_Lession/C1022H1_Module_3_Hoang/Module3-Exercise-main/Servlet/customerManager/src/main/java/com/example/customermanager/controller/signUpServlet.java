package com.example.customermanager.controller;

import com.example.customermanager.model.User;
import com.example.customermanager.service.IUserservice;
import com.example.customermanager.service.jdbc.UserServiceJDBC;
import com.example.customermanager.utils.ValidateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signup")
public class signUpServlet extends HttpServlet {

    private IUserservice userservice;

    @Override
    public void init() throws ServletException {
        userservice = new UserServiceJDBC();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/admin/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        User user = new User();
        String fullname = req.getParameter("fullname");
        user.setFullname(fullname);
        validateusernameView(errors,req,user);
        validateEmailView(errors,req,user);
        checkpassword(errors,req,user);

        if (errors.isEmpty()) {
            user.setId(userservice.getAllUser().size()+1);
            userservice.addCustomer(user);
            req.setAttribute("message", "Ban da tao thanh cong");
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("errors", errors);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/admin/signup.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private void validateEmailView(List<String> errors, HttpServletRequest req, User user) {
        String email = req.getParameter("email");
        user.setEmail(email);
        if (userservice.checkEmailSignup(email) == false) {
            errors.add("duplicate Email");
        } else {
            if (ValidateUtils.isEmailValid(email) == false) {
                errors.add("email khong dung dinh dang");
            }
        }
    }

    private void validateusernameView(List<String> errors, HttpServletRequest req, User user) {
        String username = req.getParameter("username");
        user.setUsername(username);
        if (userservice.checkUsernameSignup(username) == false) {
            errors.add("duplicate username");
        } else {
            if (ValidateUtils.isUsernameValid(username) == false) {
                errors.add("username khong dung dinh dang");
            }
        }
    }

    private  void checkpassword(List<String> errors, HttpServletRequest req, User user) {
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        if (password1.equals(password2)) {
            user.setPassword(password1);
        } else {
            errors.add("Mat khau khong trung");
        }
    }
}
