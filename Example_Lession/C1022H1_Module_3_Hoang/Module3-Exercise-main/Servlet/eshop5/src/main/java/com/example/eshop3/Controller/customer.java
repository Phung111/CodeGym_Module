package com.example.eshop3.Controller;

import com.example.eshop3.Model.OrderItem;
import com.example.eshop3.Model.Product;
import com.example.eshop3.Model.User;
import com.example.eshop3.Servlet.IProductService;
import com.example.eshop3.Servlet.implement.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "customerServlet", urlPatterns = {"/trangchu", ""})


public class customer extends HttpServlet {
    private IProductService ProductService;

    @Override
    public void init() throws ServletException {
        ProductService = new ProductService();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = ProductService.selectAllProduct();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addtocart":
                addtocart(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchStr = req.getParameter("inputSearch");
        List<Product> productListSearch = ProductService.searchProduct(searchStr);
        req.setAttribute("products", productListSearch);
        req.setAttribute("searchStr", searchStr);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/home.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addtocart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            HttpSession httpSession = req.getSession();
            User user = null;
            if (httpSession.getAttribute("user") != null) {
                user = (User) httpSession.getAttribute("user");
            }

            String id = req.getParameter("id");
            System.out.println("run add to cart");
            Product product = ProductService.selectProduct(id);
            HttpSession httpSessioncart = req.getSession();
            List<OrderItem> orderItemslist = new ArrayList<>();
            if (httpSessioncart.getAttribute("carts") != null) {
                orderItemslist = (List<OrderItem>) httpSessioncart.getAttribute("carts");
            }
            int flag = 0;
            if (orderItemslist != null) {
                for (OrderItem o : orderItemslist) {
                    if (o.getProductId().equals(id)) {
                        int quantity = o.getQuantity();
                        o.setQuantity(quantity + 1);
                        flag++;
                    }
                }
                if (flag == 0) {
                    orderItemslist.add(new OrderItem(product.getId(), product.getName(), product.getPrice(), 1));
                }
            } else {
                orderItemslist.add(new OrderItem(product.getId(), product.getName(), product.getPrice(), 1));
                System.out.println(orderItemslist.size());
            }

            httpSessioncart.setAttribute("carts", orderItemslist);
            resp.sendRedirect("/cart");
        }
    }

