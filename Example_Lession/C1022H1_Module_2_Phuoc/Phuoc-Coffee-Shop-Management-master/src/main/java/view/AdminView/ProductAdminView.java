package view.AdminView;

import FeatureApp.BannerApp;
import FeatureApp.PrintColor;
import Model.User;
import Service.UserService;
import view.LoginView;
import view.OrderView;
import view.ProductView;

import java.util.List;
import java.util.Scanner;

public class ProductAdminView {
    public static Scanner scanner = new Scanner(System.in);
    static ProductView productView = new ProductView();
    static OrderView orderView = new OrderView();
    LoginView loginView = new LoginView();
    ManagerUserView managerUserView = new ManagerUserView();
    UserService userService = new UserService();
    public void menuAdminView(User admin) {

        boolean check;
        do {

            check = false;
            BannerApp.menuBanner("Admin-Menu-View");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    productView.mainMenuView(admin);
                    break;
                case "2":
                    orderView.orderMenuView(admin);
                    break;
                case "3":
                    managerUserView.menuUser(admin);
                    break;
                case "0":
                    System.exit(5);
                case "r":
                    loginView.login();
                default:
                    System.out.println(PrintColor.RED+"Wrong Value! Please type again!"+PrintColor.RESET);
                    check = true;
            }
        }
        while (check);
    }

}
