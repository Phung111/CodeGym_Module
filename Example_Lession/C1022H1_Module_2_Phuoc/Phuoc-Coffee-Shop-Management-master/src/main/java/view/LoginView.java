package view;

import FeatureApp.BannerApp;
import FeatureApp.PrintColor;

import java.util.Scanner;

public class LoginView {
    public static Scanner scanner = new Scanner(System.in);
    public static LoginAdminView loginAdminView = new LoginAdminView();
    public LoginUserView loginUserView = new LoginUserView();
    public void  login(){
        BannerApp.menuBanner("LoginView");
        int choice = Integer.parseInt(scanner.nextLine());
        boolean checkLoginMenu = false;
        do {
            checkLoginMenu = false;
            switch (choice){
                case 1:
                    loginAdminView.loginAdmin();
                    break;
                case 2:
                    loginUserView.loginUser();
                    break;
                case 3:
                    System.exit(5);
                default:
                    System.out.println(PrintColor.RED+"Wrong Value! Please type again!"+PrintColor.RESET);
                    checkLoginMenu = true;
            }
        }
        while (checkLoginMenu);
    }

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.login();
    }

}
