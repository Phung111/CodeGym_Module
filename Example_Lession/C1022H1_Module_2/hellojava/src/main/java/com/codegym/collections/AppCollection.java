package com.codegym.collections;

import java.util.*;

public class AppCollection {
    public static void main(String[] args) {



        Stack<String> nganXep = new Stack<>();
        nganXep.add("C08");
        nganXep.add("C09");



        List<String> students = new ArrayList<>();
        // add()
        students.addAll(nganXep);

        List<String> studentsLinkedList = new LinkedList<>();
        studentsLinkedList.addAll(nganXep);

        LinkedList<String> stringLinkedList1 = new LinkedList<>();
        stringLinkedList1.addAll(nganXep);

        printCollection(stringLinkedList1);






    }

    public static void printCollection(Collection<String> ds) {
        List<String> temps = new ArrayList<>();


        temps.addAll(ds);
        for (int i = 0; i < temps.size(); i++) {
            System.out.println(temps.get(i));
        }
    }
    public static void printCollectionList(List<String> ds) {

        for (int i = 0; i < ds.size(); i++) {
            System.out.println(ds.get(i));
        }
    }
}
