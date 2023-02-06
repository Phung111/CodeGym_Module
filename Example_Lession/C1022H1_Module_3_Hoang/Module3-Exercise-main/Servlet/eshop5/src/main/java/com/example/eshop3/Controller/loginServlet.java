package com.example.eshop3.Controller;

import com.example.eshop3.Model.User;
import com.example.eshop3.Servlet.IProductService;
import com.example.eshop3.Servlet.IUserService;
import com.example.eshop3.Servlet.implement.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class loginServlet extends HttpServlet {

    private IUserService iUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<String> errors = new ArrayList<>();
        HttpSession httpSession = req.getSession();
        User user = null;
        if (httpSession.getAttribute("user") != null) {
            user = (User) httpSession.getAttribute("user");
            if (user.getRole() == 1) {
                resp.sendRedirect("/home");
            } else {
                System.out.println(user.getImage());
                resp.sendRedirect("/trangchu");
            }
        } else {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            RequestDispatcher requestDispatcher;
            user = iUserService.checklogin(email, password);
            System.out.println(user);
            if (iUserService.checkEmail(email) == true && iUserService.checkPassword(password) == false) {
                req.setAttribute("errors", "Sai mật khẩu");
                requestDispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
                requestDispatcher.forward(req, resp);
            } else if (iUserService.checkEmail(email) == false && iUserService.checkPassword(password) == true) {
                req.setAttribute("errors", "Sai email");
                requestDispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
                requestDispatcher.forward(req, resp);
            } else if (iUserService.checkEmail(email) == false && iUserService.checkPassword(password) == false) {
                req.setAttribute("errors", "Tai Khoan khong ton tai trong he thong");
                requestDispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
                requestDispatcher.forward(req, resp);
            } else if (iUserService.checkEmail(email) == true && iUserService.checkPassword(password) == true) {
                httpSession.setAttribute("user", user);
                if (user.getRole() == 1) {
                    resp.sendRedirect("/home");
                } else {
                    resp.sendRedirect("/trangchu");
                }
            }
        }
    }
}
