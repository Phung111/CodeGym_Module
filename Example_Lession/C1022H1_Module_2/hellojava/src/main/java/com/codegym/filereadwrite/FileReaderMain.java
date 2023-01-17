package com.codegym.filereadwrite;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderMain {
    public static void main(String[] args) {
        FileReaderMain fileReaderMain = new FileReaderMain();
        List<Customer> customers = fileReaderMain.readData("./data/customer.txt", Customer.class);
        fileReaderMain.showList(customers);

        List<Product> products = fileReaderMain.readData("./data/product.txt", Product.class);
        fileReaderMain.showList(products);

    }
    public <T> void showList(List<T> list) {
        for (T p : list) {
            System.out.println(p);
        }
    }

    public List<Product> readData1(String filePath) {
        List<Product> productList = new ArrayList<>();
        try {
            Reader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                //line = "1,Iphone 11,23000.0";
                String[] items = line.split(",");
                long idProduct = Long.parseLong(items[0]);
                double price = Double.parseDouble(items[2]);
                Product p = new Product(idProduct, items[1], price);
                productList.add(p);
            }
            bufferedReader.close();
            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    // Customer.class, Product.class
    public <T> List<T> readData(String filePath, Class<T> cls) {
        List<T> list = new ArrayList<>();
        try {
            Reader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                //line = "1,Iphone 11,23000.0";
                IModel<T> iModel = (IModel<T>) cls.getDeclaredConstructor().newInstance();
                T temp = iModel.parseData(line);
                list.add(temp);
            }
            bufferedReader.close();
            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
