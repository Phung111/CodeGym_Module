package view;

import FeatureApp.*;
import Model.*;
import Utils.DateUtil;
import Service.OrderItemService;
import Service.OrderService;
import Service.ProductService;
import view.AdminView.ProductAdminView;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    static Scanner scanner = new Scanner(System.in);
    Order order;
    BannerApp bannerApp = new BannerApp();
    OrderService orderService;
    ProductService productService;
    OrderItemService orderItemService;
    Status status;
    static ProductAdminView productAdminView = new ProductAdminView();

    public OrderView() {
        productService = new ProductService();
        orderService = new OrderService();
        orderItemService = new OrderItemService();
    }

    public void orderMenuView(User user) {
        boolean checkOrderView = false;
        do {
            checkOrderView = false;
            bannerApp.menuBanner("OrderView");
            List<Order> orderList = orderService.getAllOrderList();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showDetailOrderView(orderList);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "2":
                    createOrderView(user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "3":
                    updateOrderView(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "4":
                    searchOrderByStatusView(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "5":
                    searchOrderByDurationTime(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "6":
                    printingAllOrders(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "7":
                    removeOrder(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "8":
                    orderService.getTotalProfit(orderList,user);
                    checkOrderView = InitApp.checkContinueActionOrder();
                    break;
                case "0":
                    System.exit(5);
                case "r":
                    productAdminView.menuAdminView(user);
                default:
                    checkOrderView = true;
                    break;
            }
        }
        while (checkOrderView);
    }

    private void removeOrder(List<Order> list,User user) {
        AlertApp.alertApp("Student-Remove-Confirm");
        String alert = scanner.nextLine();
        if (alert.toLowerCase().equals("y")) {
            System.out.println("Enter ID Order you want to remove");
            long idRemove = Long.parseLong(scanner.nextLine());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == idRemove) {
                    list.remove(i);
                }
            }
            orderService.saveOrderData(list);
            AlertApp.alertApp("Remove-Success");
        }if (alert.toLowerCase().equals("n")) {
            orderMenuView(user);
        }

    }

    public void searchOrderByDurationTime(List<Order> list,User user) {
        boolean checkContinue;
        do {
            checkContinue = false;
            BannerApp.menuBanner("Search-Order-ByDurationTime");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Order> list1 = orderService.searchOrderByDate(list);
                    System.out.printf("%10s %20s %15s %20s", "ID Product", "Ordered Date", "Total", "OrderItems");
                    System.out.println();
                    for (Order order1 : list1) {
                        System.out.println(order1);
                    }
                    checkContinue = InitApp.checkContinueSearchOrderByDurationTime();
                    break;
                case "2":
                    List<Order> list2 = orderService.searchOrderByMonth(list);
                    System.out.printf("%10s %20s %15s %20s", "ID Product", "Ordered Date", "Total", "OrderItems");
                    System.out.println();
                    for (Order order1 : list2) {
                        System.out.println(order1);
                    }
                    checkContinue = InitApp.checkContinueSearchOrderByDurationTime();
                    break;
                case "r":
                    orderMenuView(user);
                default:
                    System.out.println(PrintColor.RED_BOLD + "Error Value. Type again" + PrintColor.RESET);
                    checkContinue = true;
            }
        }
        while (checkContinue);
    }

    private void searchOrderByStatusView(List<Order> list,User user) {
        boolean checkOrderStatus;
        do {
            checkOrderStatus = false;
            BannerApp.menuBanner("Search-Order-Status-View");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Order> listOrderedResult = orderService.searchOrderByStatus(list, "Pending");
                    System.out.println("                                                   " + PrintColor.YELLOW_BOLD + "LIST OF ORDER IS PENDING" + PrintColor.RESET + "                      ");
                    printingAllOrders(listOrderedResult,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "2":
                    List<Order> listOrderedResult1 = orderService.searchOrderByStatus(list, "Processing");
                    System.out.println("                                                   " + PrintColor.GREEN_BOLD + "LIST OF ORDER IS PENDING" + PrintColor.RESET + "                      ");
                    printingAllOrders(listOrderedResult1,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "3":
                    List<Order> listOrderedResult2 = orderService.searchOrderByStatus(list, "Paid");
                    System.out.println("                                                   " + PrintColor.RED_BOLD + "LIST OF ORDER IS PENDING" + PrintColor.RESET + "                      ");
                    printingAllOrders(listOrderedResult2,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "4":
                    List<Order> listOrderedResult3 = orderService.searchOrderByStatus(list, "NotPaid");
                    System.out.println("                                                   " + PrintColor.GREEN_BOLD + "LIST OF ORDER IS PENDING" + PrintColor.RESET + "                      ");
                    printingAllOrders(listOrderedResult3,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "5":
                    List<Order> listOrderedResult4 = orderService.searchOrderByStatus(list, "Canceled");
                    System.out.println("                                                   " + PrintColor.RED + "LIST OF ORDER IS PENDING" + PrintColor.RESET + "                      ");
                    printingAllOrders(listOrderedResult4,user);
                    checkOrderStatus = InitApp.checkContinueSearchOrderStatusMenu();
                    break;
                case "r":
                    orderMenuView(user);
            }
        }
        while (checkOrderStatus);
    }

    public void printingAllOrders(List<Order> orderList, User user) {
        System.out.printf("%14s %20s %11s %11s %35s %39s %21s %15s %10s", "ID Order", "Ordered Date","Total","Status", "OrderItems","ID User","NameUser","Phone Number","Address");
        System.out.println();
        for (Order order : orderList) {
            for (OrderItem orderItem : order.getOrderItem()) {
                Product product = productService.findProductByID(orderItem.getIdProduct());
                String temp = String.valueOf(order.getStatus());
                System.out.printf("║%13s║ %19s║ %10s║ %10s║ %17s║ %23s║ %10s║ %5s║ %10s║ %20s║ %15s║ %10s║",order.getId(),DateUtil.convertDateToString(order.getDateOrder()),
                        getTotal(order),temp,orderItem.getId(),product.getNameProduct(), SupportApp.formatNumber(orderItem.getPrice())
                        ,orderItem.getQuantity(),order.getIdUser(),order.getNameUser(),user.getMobile(),user.getAddress());
                System.out.println();
            }
        }
    }



    //    Nếu Order không exist sẽ báo lỗi thoát khỏi hàm
//    Xét tiếp orderItem của order đó nếu = null thì tạo mới thêm vào, còn nếu không thì update 1670597
    public void updateOrderView(List<Order> orderList,User user) {
        System.out.print("■ Enter ID Order you want to update:");
        long id = Long.parseLong(scanner.nextLine());
        Order order1 = orderService.getOrderByID(id, orderList);
        if (order1 != null) {
            if (order1.getOrderItem().size() > 0) {
                boolean checkUpdateOrderView;
                do {
                    checkUpdateOrderView = false;
                    bannerApp.menuBanner("Update-Order-View");
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            System.out.print("■ Enter date you want to update:");
                            String date = scanner.nextLine();
                            order1.setDateOrder(DateUtil.convertStringToDate(date));
                            orderService.saveOrderData(orderList);
                            AlertApp.alertApp("Update-Success");
                            checkUpdateOrderView = InitApp.checkContinueUpdateOrder();
                            break;
                        case "2":
                            orderItemService.showOrderItem(order1);
                            List<OrderItem> orderItems = orderItemService.getAllOrderItems();
                            System.out.println("■ Enter ID OrderItem you want to update:");
                            long idOrderItem = Long.parseLong(scanner.nextLine());
                            OrderItem orderItem = orderItemService.findOrderItemByID(idOrderItem, orderItems);
                            System.out.print("■ Enter ID product you want to update:");
                            long idProduct = Long.parseLong(scanner.nextLine());
                            System.out.print("■ Enter quantity orderItem you want to update:");
                            int quantity = Integer.parseInt(scanner.nextLine());
                            System.out.print("■ Enter Price orderItem you want to update:");
                            double price = Double.parseDouble(scanner.nextLine());
                            orderItem.setQuantity(quantity);
                            orderItem.setIdProduct(idProduct);
                            orderItem.setPrice(price);
                            orderItemService.saveOrderItemData(orderItems);
                            AlertApp.alertApp("Update-Success");
                            checkUpdateOrderView = InitApp.checkContinueUpdateOrder();
                            break;
                        case "3":
                            System.out.println("Enter STATUS you want to update");
                            String status = scanner.nextLine();
                            Status choicedStatus = Status.findStatusByName(status);
                            order1.setStatus(choicedStatus);
                            orderService.saveOrderData(orderList);
                            AlertApp.alertApp("Update-Success");
                            checkUpdateOrderView = InitApp.checkContinueUpdateOrder();
                            break;
                        case "r":
                            orderMenuView(user);
                        default:
                            System.out.println("Error value! Type again");
                            checkUpdateOrderView = true;
                    }
                }
                while (checkUpdateOrderView);
            } else {
                System.out.println("Size=0");
                productService.printingAllProduct();
                long idProduct = checkIDProduct();
                Product product = productService.findProductByID(idProduct);
                int quantity = checkInputQuantity(order1, idProduct);
                OrderItem orderItem;
                if ((orderItem = checkProductExistinOrder(order1, product.getIdProduct())) != null) {
                    orderItem.setQuantity(quantity + orderItem.getQuantity());
                } else {
                    OrderItem newOrderItem = new OrderItem(System.currentTimeMillis() / 100000, product.getIdProduct(), order1.getId(), quantity, product.getPrice());
                    order1.addOrderItem(newOrderItem);
                }
                order1.setTotal(getTotal(order1));
                showOrderItemsByOrder(order1,user);
                orderItemService.addOrderItem(order1.getOrderItem());
                orderService.saveOrderData(orderList);
                AlertApp.alertApp("Update-Success");
            }
        } else System.out.println(PrintColor.RED + "Order is not exist" + PrintColor.RESET);
    }

    //
//    Tạo 1 orderItem mới
//            B1: Nhập ID product và kiểm tra id có đúng không
//            B2: Tìm product đó dựa vào id product
//            B3: Kiểm tra ID product nhập vào đã có trong orderItem chưa
//            B4: Kiểm tra product đã orderItem chưa
//            B3: Kiem tra số lượng nhập vào
//                +  Rồi so sánh với số lượng tồn product, lay so lượng nhập vào rồi cộng với s lượng trong orderItem.
//                + Neu chua: -> tạo ra order item mới với số lượng họ nhập vào.
    public void createOrderView(User user) {
        order = new Order();
        order.setId(System.currentTimeMillis() / 1000000);
        order.setDateOrder(new Date());
        order.setStatus(status.Pending);
        order.setIdUser(System.currentTimeMillis()/100000);
        boolean checkCreateOrder;
        do {
            checkCreateOrder = true;
            productService.printingAllProduct();
            long idProduct = checkIDProduct();
            Product product = productService.findProductByID(idProduct);
            int quantity = checkInputQuantity(order, idProduct);
            if (quantity == -1) {
                continue;
            }
            OrderItem orderItem;
            if ((orderItem = checkProductExistinOrder(order, product.getIdProduct())) != null) {
                orderItem.setQuantity(quantity + orderItem.getQuantity());
            } else {
                OrderItem newOrderItem = new OrderItem(System.currentTimeMillis() / 100000, product.getIdProduct(), order.getId(), quantity, product.getPrice());
                order.addOrderItem(newOrderItem);
            }
            showOrderItemsByOrder(order,user);
            checkCreateOrder = InitApp.checkContinueAddOrder();
        }
        while (checkCreateOrder);
        order.setTotal(getTotal(order));
        order.setNameUser(user.getFullname());
        order.setAddressUser(user.getAddress());
        order.setPhoneNumber(user.getMobile());
        orderItemService.addOrderItem(order.getOrderItem());
        orderService.addOrder(order);
        AlertApp.alertApp("Add-Success");
    }

    public int checkInputQuantity(Order order, long idProduct) {
        boolean checkInputQuantityAction = false;
        do {
            checkInputQuantityAction = false;
            System.out.print("■ Enter quantity you want to add:");
            int quantity = Integer.parseInt(scanner.nextLine());
            OrderItem orderItem = checkProductExistinOrder(order, idProduct);
            if (orderItem != null) {
                if (productService.checkRemainQuantityProduct(idProduct, quantity + orderItem.getQuantity())) {
                    return quantity;
                }
            } else {
                if (productService.checkRemainQuantityProduct(idProduct, quantity)) {
                    return quantity;
                }
            }
            Product product = productService.findProductByID(idProduct);
            System.out.printf("Store is: %d. Your order is run out of store", product.getQuantity());
            checkInputQuantityAction = InitApp.checkContinueActionMenu();
        }
        while (checkInputQuantityAction);
        return -1;
    }

    public long checkIDProduct() {
        boolean checkidproduct;
        do {
            checkidproduct = false;
            System.out.print("■ Enter ID product you want to add:");
            long id = Long.parseLong(scanner.nextLine());
            int flag = 0;
            for (Product product : productService.getAllProducts()) {
                if (product.getIdProduct() == id) {
                    return id;
                } else {
                    flag = -1;
                }
            }
            if (flag == -1) {
                System.out.println("Error Value! Type again");
                checkidproduct = true;
            }
        }
        while (checkidproduct);
        return -1;
    }

    public OrderItem checkProductExistinOrder(Order order, long idProduct) {
        for (OrderItem orderItem : order.getOrderItem()) {
            if (orderItem.getIdProduct() == idProduct) {
                return orderItem;
            }
        }
        return null;
    }

    public void showDetailOrderView(List<Order> orderList) {
        System.out.println("Enter ID Order that you want to show:");
        System.out.print("■ Select:");
        long idFindedOrder = Integer.parseInt(scanner.nextLine());
        Order findedOrder = orderService.getOrderByID(idFindedOrder, orderList);
        showDetailOrderViewByID(findedOrder);
    }

    public void showDetailOrderViewByID(Order order) {
        System.out.println("╔══════════════════════════════════════" + PrintColor.GREEN + "YOUR BILL" + PrintColor.RESET + "═══════════════════════════════════════════════╗");
        System.out.println("\t" + "\t" + "Order ID: " + order.getId() + "\t" + "Created:" + DateUtil.convertDateToString(order.getDateOrder())+",User: "+PrintColor.BLUE_BOLD+order.getNameUser()+PrintColor.RESET);
        for (OrderItem orderItem : order.getOrderItem()) {
            Product product = productService.findProductByID(orderItem.getIdProduct());
            System.out.println(
                    String.format("\t \t \t \t %-20s|%-15s|%-10s|%-10s", product.getNameProduct(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getQuantity() * orderItem.getPrice())
            );
        }
        System.out.println("                        \t \t \t \t\t \t \t" + PrintColor.RED_BOLD + "Total" + PrintColor.RESET + ": " + getTotal(order));
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public void showOrderItemsByOrder(Order order,User user) {
        System.out.println("╔═════════════════════════════════════LIST PRODUCT THAT ORDERED═══════════════════════════════════════╗");
        System.out.println("          User: "+user.getFullname()+"\tPhone Number:"+user.getMobile()+"\tAddress: "+user.getAddress());
        for (OrderItem orderItem : order.getOrderItem()) {
            Product product = productService.findProductByID(orderItem.getIdProduct());
            System.out.println(String.format("\t \t \t \t %-20s|%-15s|%-10s|%-10s", product.getNameProduct(), orderItem.getPrice(), orderItem.getQuantity(), orderItem.getQuantity() * orderItem.getPrice()));
        }
        System.out.println("                        \t \t \t \t\t \t \t" + PrintColor.RED_BOLD + "Total" + PrintColor.RESET + ": " + getTotal(order));
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    public long getTotal(Order order) {
        long total = 0;
        for (OrderItem orderItem : order.getOrderItem()) {
            total += orderItem.getPrice() * orderItem.getQuantity();
        }
        return total;
    }

    public static void main(String[] args) {
        OrderService orderService1 = new OrderService();
        OrderView test = new OrderView();

    }

}
