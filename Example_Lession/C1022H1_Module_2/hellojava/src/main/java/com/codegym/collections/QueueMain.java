package com.codegym.collections;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.security.Key;
import java.util.*;

public class QueueMain {
    public static void main(String[] args) {
        /**
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        Queue<String> pStringQueue1 = new PriorityQueue<>() ;

        //Queue<String> p1 = new Queue();


        Set<String> x1 = new HashSet<>();
        Set<String> x2 = new LinkedHashSet<>();
        Set<String> x3 = new TreeSet<>();
        AbstractSet<String> x4 = new HashSet<>();

        Map<String, String> t1 = new TreeMap<>();
        HashMap<Integer, String> t2 = new HashMap<>();

         Map<String, String> t1 = new HashMap<>();
         t1.put("ID1", "Thuy Thuy");
         t1.put("ID2", "Duy");
         t1.put("ID3", "Phu");
         t1.put("ID4", "Phung");
         // lấy danh sách các key trước
         Set<String> keys = t1.keySet();
         for (String item : keys) {
         System.out.println(t1.get(item));
         }
         // dùng entrySet
         Set<Map.Entry<String,String>> entrys = t1.entrySet();
         for (Map.Entry<String,String> item : entrys) {
         System.out.println(item.getValue());
         }

         **/

        System.out.println(Objects.hash("IP1"));
        System.out.println(Objects.hash("IP1"));

        Product p1 = new Product("IP1");
        Product p2 = new Product("Ip1");
        Product p3 = new Product("ip1");
        Product p4 = new Product("IP1");
        Map<Product, Integer> products = new HashMap<>();

        products.put(p1, 10000);
        products.put(p2, 10000);
        products.put(p3, 10000);
        products.put(p4, 10000);

        Set<Product> keys = products.keySet();
        for (Product item : keys) {
            System.out.println(item.name);
        }

        Set<Product> productSet = new HashSet<>();
        productSet.add(p1);
        productSet.add(p2);
        productSet.add(p3);
        productSet.add(p4);
        for (Product item : productSet) {
            System.out.println(item.name);
        }


    }
}
