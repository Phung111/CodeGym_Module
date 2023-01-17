package Service;

import FeatureApp.BannerApp;
import FeatureApp.InitApp;
import FeatureApp.PrintColor;
import Model.*;
import Utils.DateUtil;
import view.OrderView;

import java.text.NumberFormat;
import java.util.*;

public class OrderService {
    public static Scanner scanner = new Scanner(System.in);
    public static OrderView orderView = new OrderView();

    OrderItemService orderItemService = new OrderItemService();
    FileService fileService;
    public OrderService (){
        fileService = new FileService();
    }

    private String filePath = "/Users/user/Phuoc-Coffee-Shop-Management/data/order.txt";
    public List<Order> getAllOrderList (){
        List<String> orderLines = fileService.readFile(filePath);
        List<Order> orderList = new ArrayList<>();
        for (String orderline : orderLines){
            String[] orderlines1 = orderline.split(",");
            long id = Long.parseLong(orderlines1[0]);
            long idUser = Long.parseLong(orderlines1[2]);

            double total = Double.parseDouble(orderlines1[6]);
            Status status = Status.findStatusByName(orderlines1[7]);
            Order order = new Order(id, DateUtil.convertStringToDate(orderlines1[1]),total);
            order.setPhoneNumber(orderlines1[4]);
            order.setAddressUser(orderlines1[5]);
            order.setIdUser(idUser);
            order.setNameUser(orderlines1[3]);
            order.setStatus(status);
            List<OrderItem> orderItems = orderItemService.findOrderItemByOrderID(order.getId());
            order.setOrderItem(orderItems);
            orderList.add(order);
        }
        return orderList;
    }

    public void addOrder(Order newOrder){
        List<Order> orderList = getAllOrderList();
        orderList.add(newOrder);
        List<String> orderLines = convertListOrdertoListString(orderList);
        fileService.writeFile(filePath,orderLines);
    }

    public Order getOrderByID (long id, List<Order> orderList){
        for (Order order : orderList){
            if (order.getId()==id){
                return order;
            }
        }
        return null;
    }

    public void saveOrderData (List<Order> orderList){
        List<String> orderLines = convertListOrdertoListString(orderList);
        fileService.writeFile(filePath,orderLines);
    }
    public List<String> convertListOrdertoListString (List<Order> orderList){
        List<String> orderListLines = new ArrayList<>();
        for (Order order : orderList){
            orderListLines.add(order.toData());
        }
        return orderListLines;
    }

    public List<Order> convertListStringtoListOrder (List<String> list){
        List<Order> orderList = new ArrayList<>();
        for (String orderLine : list ){
            String [] orderLines = orderLine.split(",");
            long idOrder = Long.parseLong(orderLines[0]);
            Date date = DateUtil.convertStringToDate(orderLines[1]);
            double total = Double.parseDouble(orderLines[2]);
            Status status = Status.findStatusByName(orderLines[3]);
            Order newOrder = new Order(idOrder,date,total);
            newOrder.setStatus(status);
            orderList.add(newOrder);
        }
        return orderList;
    }

    public List<Order> searchOrderByDate (List<Order> list){
        List<Order> orderList = new ArrayList<>();
        System.out.println("Enter Date (dd-mm-yyyy)");
        String sdate = scanner.nextLine();
        for (Order order : list){
            if (getDataByDate(DateUtil.convertDateToString(order.getDateOrder())).equals(sdate)){
                orderList.add(order);
            }
        }
        return orderList;
    }

    public List<Order> searchOrderByMonth (List<Order> list){
        List<Order> orderList = new ArrayList<>();
        System.out.println("Enter Month (mm)");
        String sMonth = scanner.nextLine();
        for (Order order : list){
            if (getDataByMonth(DateUtil.convertDateToString(order.getDateOrder())).equals(sMonth)){
                orderList.add(order);
            }
        }
        return orderList;
    }
    public String getDataByDate(String date){
        date = date.trim();
        if (date.indexOf(" ")>=0){
            int index = date.lastIndexOf(" ");
            return date.substring(index+1);
        }
        else return date;
    }
    public String getDataByMonth(String month){
        month = month.trim();
        if (month.indexOf(" ")>=0){
            int index = month.lastIndexOf(" ");
            return month.substring(index+4,index+6);
        }
        else return month;
    }
    public List<Order> searchOrderByStatus (List<Order> orderList, String nameStatus){
        List<Order> result = new ArrayList<>();
        for (Order order : orderList){
            String temp = String.valueOf(order.getStatus());
            if (temp.equals(nameStatus)){
                result.add(order);
            }
        }
        return result;
    }

    public void getTotalProfit (List<Order> orderList,User user) {
        boolean check;
        do {
            BannerApp.menuBanner("profitMenu");
            check = false;
            List<Order> paidOrderList = searchOrderByStatus(orderList, "Paid");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter the Day you want to show:");
                    double total1 = 0;
                    String month1 = scanner.nextLine();
                    List<Order> orderList1 = new ArrayList<>();
                    for (Order order : paidOrderList) {
                        if (getDataByDate(DateUtil.convertDateToString(order.getDateOrder())).equals(month1)) {
                            total1 += orderView.getTotal(order);
                            orderList1.add(order);
                        }
                    }
                    orderView.printingAllOrders(orderList1,user);
                    System.out.print(PrintColor.BLUE_UNDERLINED + "■ Total:" + PrintColor.RESET+total1+"\n");
                    check = InitApp.checkContinueActionShowProfit();
                    break;
                case "2":
                    System.out.println("Enter the Month you want to show:");
                    double total = 0;
                    String month = scanner.nextLine();
                    List<Order> orderList2 = new ArrayList<>();
                    for (Order order : paidOrderList) {
                        if (getDataByMonth(DateUtil.convertDateToString(order.getDateOrder())).equals(month)) {
                            total += orderView.getTotal(order);
                            orderList2.add(order);
                        }
                    }
                    orderView.printingAllOrders(orderList2,user);
                    System.out.print(PrintColor.BLUE_UNDERLINED + "■ Total:" + PrintColor.RESET+total+"\n");
                    check = InitApp.checkContinueActionShowProfit();
                    break;
                case "r":
                    orderView.orderMenuView(user);
                default:
                    System.out.println("Wrong value! Type again");
                    check = true;
            }
        }
        while (check);
    }


    public static void main(String[] args) {
        OrderService test = new OrderService();
        List<Order> list = test.getAllOrderList();
        UserService userService = new UserService();
        User user = userService.adminLogin("phuoc","123");
        test.getTotalProfit(list,user);

    }

}
