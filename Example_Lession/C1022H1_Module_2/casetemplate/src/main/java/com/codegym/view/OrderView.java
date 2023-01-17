package com.codegym.view;

import com.codegym.model.ERole;
import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.model.Product;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class OrderView extends GenericView {
    private OrderService orderService;
    private ProductService productService;

    public OrderView() {
        orderService = new OrderService();
        productService = new ProductService();
    }
    public void launcher() {
        if (user.getRole() == ERole.ADMIN) {
            boolean checkActionMenuOrder = false;
            do{
                System.out.println("Menu order");
                System.out.println("Xem danh sách order:                1");
                System.out.println("Thêm order:                         2");
                System.out.println("Xem chi tiết order:                 3");
                System.out.println("Cập nhật trạng thái đơn hàng:        4");

                int actionMenuProduct = Integer.parseInt(scanner.nextLine());
                switch (actionMenuProduct) {
                    case 1:
                        showOrdersView();
                        break;
                    case 2:
                        createOrderView();
                        break;
                    case 3:
                        showDetailOrderView();
                        break;

                }
                checkActionMenuOrder = checkActionMenuOrderContinue();
            }while (checkActionMenuOrder);
        }else {
            boolean checkActionMenuOrder = false;
            do{
                System.out.println("Menu order");
                System.out.println("Xem danh sách order:                1");
                System.out.println("Xem chi tiết order:                 2");

                int actionMenuProduct = Integer.parseInt(scanner.nextLine());
                switch (actionMenuProduct) {
                    case 1:
                        showOrdersView();
                        break;
                    case 2:
                        showDetailOrderView();
                        break;

                }
                checkActionMenuOrder = checkActionMenuOrderContinue();
            }while (checkActionMenuOrder);
        }


    }

    private void showDetailOrderView() {
        System.out.println("Nhập ID order");
        long idOrder = Long.parseLong(scanner.nextLine());
        Order order = orderService.findOrderById(idOrder);
        System.out.println();
        String fmtOrderDetailHeader = String.format("ID ORDER: %-10s|Name Customer: %-20s|Total: %-10s|Status: %-10s", order.getId(), order.getNameCustomer(), order.getTotal(), order.geteStatusOrder());

        System.out.println(fmtOrderDetailHeader);

        String fmtOrderItemHeader = String.format("%-20s|%-5s", "Name Product", "Amount");
        System.out.println(fmtOrderItemHeader);
        for (OrderItem orderItem : order.getOrderItems()) {
            Product product = productService.findProductById(orderItem.getIdProduct());
            String fmtOrderItem = String.format("%-20s|%-5s|%-10s", product.getName(), orderItem.getAmount(), product.getPrice()*orderItem.getAmount());
            System.out.println(fmtOrderItem);
        }
    }

    private void createOrderView() {

    }

    private void showOrdersView() {
        List<Order> orders = orderService.getAllOrders();
        String fmtOrderHeader = String.format("%-10s|%-20s|%-10s|%-20s", "IDORDER", "TEN KHACH HANG", "TONG TIEN", "NGAY DAT");
        System.out.println(fmtOrderHeader);
        for (Order order : orders) {
            String fmtOrderContent = String.format("%-10s|%-20s|%-10s|%-20s", order.getId(), order.getNameCustomer(), order.getTotal(), order.getCreateAt());
            System.out.println(fmtOrderContent);
        }
    }

    private boolean checkActionMenuOrderContinue() {
        boolean checkActionMenuProductContinue = false;
        do {
            System.out.println("Bạn có muốn tiếp tục Quản lý sản phẩm");
            System.out.println("Đồng ý: nhấn Y/ Không đồng ý:  nhấn N");
            String actionMenuProductContinue = scanner.nextLine();
            switch (actionMenuProductContinue) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    checkActionMenuProductContinue = true;
            }
        } while (checkActionMenuProductContinue);
        return false;
    }
}
