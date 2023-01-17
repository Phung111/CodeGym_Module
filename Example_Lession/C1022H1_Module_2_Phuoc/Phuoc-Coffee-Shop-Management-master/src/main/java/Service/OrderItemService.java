package Service;

import Model.Order;
import Model.OrderItem;
import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemService {
    FileService fileService;
    Order order = new Order();
    private final String filePath = "/Users/user/Phuoc-Coffee-Shop-Management/data/orderItems.txt";
    public OrderItemService(){
        fileService = new FileService();
    }
    public List<OrderItem> getAllOrderItems (){
        List<String> orderItemsLines = fileService.readFile(filePath);
        List<OrderItem> orderItems = new ArrayList<>();
        for (String line : orderItemsLines ){
            String [] lines = line.split(",");
            long id = Long.parseLong(lines[0]);
            long idProduct = Long.parseLong(lines[1]);
            long idOrder = Long.parseLong(lines[2]);
            int quantity = Integer.parseInt(lines[3]);
            double price = Double.parseDouble(lines[4]);
            OrderItem orderItem = new OrderItem(id,idProduct,idOrder,quantity,price);
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    public OrderItem findOrderItemIDbyIDProduct (long id){
        List<OrderItem> orderItems = getAllOrderItems();
        for (OrderItem orderItem : orderItems){
            if (orderItem.getIdProduct()==id){
                return orderItem;
            }
        }
        return null;
    }

    public void addOrderItem (List<OrderItem> orderItem){
        List<OrderItem> orderItems = getAllOrderItems();
        orderItems.addAll(orderItem);
        List<String> orderItemsLines = converListOrderItemToListString(orderItems);
        fileService.writeFile(filePath,orderItemsLines);
    }

    public List<String> converListOrderItemToListString (List <OrderItem> list){
        List<String> orderItemsLines = new ArrayList<>();
        for (OrderItem orderItem : list){
            orderItemsLines.add(orderItem.toData());
        }
        return orderItemsLines;
    }

    public List<OrderItem> findOrderItemByOrderID (long id){
       List<OrderItem> orderItems = getAllOrderItems();
       List<OrderItem> orderItemsResult = new ArrayList<>();
       for (OrderItem orderItem : orderItems){
           if (orderItem.getIdOrder()==id){
               orderItemsResult.add(orderItem);
           }
       }
       return orderItemsResult;
    }

    public OrderItem findOrderItemByID(long id,List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems){
            if (orderItem.getId()==id){
                return orderItem;
            }
        }
        return null;
    }

    public void saveOrderItemData (List<OrderItem> orderItems){
        List<String> orderItemLines = converListOrderItemToListString(orderItems);
        fileService.writeFile(filePath,orderItemLines);
    }

    public void showOrderItem (Order order){
        for (OrderItem orderItem : order.getOrderItem()){
            System.out.println(orderItem);
        }
    }

    public static void main(String[] args) {
        OrderItemService test = new OrderItemService();
        List<OrderItem> orderItems = test.getAllOrderItems();
        for (OrderItem o : orderItems) {
            System.out.println(o);
        }
    }
}
