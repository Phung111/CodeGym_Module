package view.AdminView;

import FeatureApp.BannerApp;
import Model.User;
import Service.OrderService;
import Service.ProductService;
import Service.UserService;
import view.OrderView;
import view.ProductView;

import java.util.Scanner;

public class UserView {
    static Scanner scanner = new Scanner(System.in);
    static ProductView productView = new ProductView();
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    OrderView orderView = new OrderView();
    UserService userService = new UserService();
    public void menuUser(User user) {
        try {
            BannerApp.menuBanner("userView");
            int choice;
            do {

                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        productView.showProductPagination(productService.getAllProducts());
                        menuUser(user);
                        break;
                    case 2:
                        orderView.createOrderView(user);
                        menuUser(user);
                        break;
                    case 3:
                        userService.getOrderbyIDUser(user);
                        menuUser(user);
                        break;
                    case 4:
                        userService.changePasswordtest();
                        menuUser(user);
                        break;
                    case 0:
                        System.exit(5);
                }

            } while (choice != 0);
        } catch (Exception e) {
            System.out.println("ERROR VALUE, TYPE AGAIN");
        }
    }

}
