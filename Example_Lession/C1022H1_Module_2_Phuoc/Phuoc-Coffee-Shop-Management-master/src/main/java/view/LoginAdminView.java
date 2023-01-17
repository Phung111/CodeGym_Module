package view;

import FeatureApp.BannerApp;
import FeatureApp.InitApp;
import FeatureApp.PrintColor;
import Model.User;
import Service.UserService;
import view.AdminView.ProductAdminView;

import java.util.Scanner;

public class LoginAdminView {
    static LoginView loginView = new LoginView();
    ProductView productView = new ProductView();

    public  static Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    ProductAdminView productAdminView = new ProductAdminView();
    public void loginAdmin (){

        Boolean checkLoginAdmin = false;
        do {
            checkLoginAdmin = false;
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                           LOGIN ADMIN                                                      ");
            System.out.println("                                       【1】. ENTER USERNAME                                                ");
            System.out.println("                                       【2】. ENTER PASSWORD                                                ");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("Enter Username:");
            String username = InitApp.isNotEmpty();
            System.out.println("Enter Password:");
            String password = InitApp.isNotEmpty();
            if (userService.adminLogin(username, password) != null) {
                User admin = userService.adminLogin(username, password);
                BannerApp.menuBanner("Access-Success");
                productAdminView.menuAdminView(admin);
                checkLoginAdmin = false;
            }
            else {
                System.out.println(PrintColor.RED+"Your account is NOT MATCH. Please type again!"+PrintColor.RESET);
                checkLoginAdmin = retryLogin();
            }
        }
        while (checkLoginAdmin);
    }

    public static boolean retryLogin (){
        do {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                               【1】. LOGIN AGAIN                                                 ║");
            System.out.println("║                                               【2】. RETURN                                                      ║");
            System.out.println("║                                               【0】. EXIT                                                        ║");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.print(PrintColor.BLUE_UNDERLINED + "■ Select:" + PrintColor.RESET);
            int choiceRetryLogin = Integer.parseInt(scanner.nextLine());
            switch (choiceRetryLogin){
                case 1:
                    return true;
                case 2:
                    loginView.login();
                    break;
                case 0:
                    System.exit(5);
                default:
                    System.out.println("Error value! Please type again");
            }
        }
        while (true);
    }

}
