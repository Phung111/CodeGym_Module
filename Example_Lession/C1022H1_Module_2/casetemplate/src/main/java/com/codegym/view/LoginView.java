package com.codegym.view;

import com.codegym.model.ERole;
import com.codegym.model.User;
import com.codegym.service.UserService;

public class LoginView extends GenericView{
    private UserService userService;
    public LoginView() {
        userService = new UserService();
    }

    public void menuAdminView(User user) {
        GenericView view;
        boolean checkActionMenuAdminContinue = true;
        do{
            System.out.println("Admin menu");
            System.out.println("Quản lý sản phẩm:               1");
            System.out.println("Quản lý hóa đơn:                2");
            System.out.println("Quản lý user:                   3");
            int actionMenuAdmin = Integer.parseInt(scanner.nextLine());
            switch (actionMenuAdmin) {
                case 1:
                    view = new ProductView();
                    view.setUser(user);
                    view.launcher();
                    break;
                case 2:
                    view = new OrderView();
                    view.setUser(user);
                    view.launcher();
                    break;
                default:
                    checkActionMenuAdminContinue = false;
            }
        }while (checkActionMenuAdminContinue);

    }
    public void menuUserView(User user) {
        GenericView view;
        System.out.println("User menu");
        boolean checkActionMenuUserContinue = true;
        do{
            System.out.println("User menu");
            System.out.println("Quản lý hóa đơn:                1");
            int actionMenuUser = Integer.parseInt(scanner.nextLine());
            switch (actionMenuUser) {
                case 1:
                    view = new OrderView();
                    view.setUser(user);
                    view.launcher();

                    break;
                default:
                    checkActionMenuUserContinue = false;
            }
        }while (checkActionMenuUserContinue);
    }

    @Override
    public void launcher() {

        boolean checkUserPassword = false;
        do{
            System.out.println("Đăng nhập đi bạn");
            System.out.println("Nhập username: ");
            String username = scanner.nextLine();
            System.out.println("Nhập password: ");
            String password = scanner.nextLine();

            User checkUser = userService.checkUserNamePassword(username, password);
            if ( checkUser != null) {
                // Co ton tai user
                if (checkUser.getRole() == ERole.ADMIN) {
                    menuAdminView(checkUser);
                }else{
                    menuUserView(checkUser);
                }
            }else{
                System.out.println("Nhập sai !! nhập lại");
                checkUserPassword = true;
            }
        }while (checkUserPassword);

    }
}
