package com.codegym.filereadwrite;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileWriterMain {
    public static void main(String[] args)  {

        Date date = new Date();
        System.out.println(date);
        // PrintWriter: 1 luồng kí tự để ghi file
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Iphone 11", 23000.0));
        products.add(new Product(2, "Iphone 12", 23000.0));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "Quang Dang"));
        customers.add(new Customer(2, "Thanh Nhan"));


        writeDate(products, "./data/product.txt");
        writeDate(customers, "./data/customer.txt");



    }

    public static <T> void writeDate(List<T> list, String filePath) {
        try {
            File file = new File(filePath);
            PrintWriter printWriter = new PrintWriter(file);
            for (int i = 0; i < list.size(); i++) {
                printWriter.write(list.get(i).toString());
                if (i != list.size() - 1) {
                    printWriter.write("\n");
                }
            }
            printWriter.close();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void docLevel1DungRead() {
        try {
            FileReader fileReader = new FileReader("./data/product.txt");
            String str = "";
            int cCharacter = -1;
            while ((cCharacter = fileReader.read()) != -1) {
                str += (char) cCharacter;
            }
            System.out.println(str);


        } catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void docLevel2DungBoDemCbuff() {
        try {
            FileReader fileReader = new FileReader("./data/product.txt");
            String str = "";

            char [] cbuff = new char[5];
            int count = -1;
            while ((count = fileReader.read(cbuff)) != -1) {
                for (int i = 0; i < count; i++) {
                    str += cbuff[i];
                }
            }
            System.out.println(str);


        } catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
