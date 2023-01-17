package com.codegym.quanlysanpham;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyStore {
    private  List<Product> products;
    private Scanner scanner = new Scanner(System.in);
    public MyStore() {
        products = new ArrayList<>();
        //long id, String name, double price, int quantity, Date createAt
        products.add(new Product(1L, "Iphone X", 10000, 2, new Date()));
        products.add(new Product(2L, "Iphone 11", 10000, 2, new Date()));
        products.add(new Product(3L, "Iphone 12", 10000, 2, new Date()));
        products.add(new Product(4L, "Iphone 13", 10000, 2, new Date()));
    }

    public void laucher() {
        boolean checkActionMenuProduct = false;
        do{
            System.out.println("Menu sản phẩm");
            System.out.println("Xem danh sách:              1");
            System.out.println("Thêm sản phẩm:              2");
            System.out.println("Sửa sản phẩm:               3");
            System.out.println("Xóa sản phẩm:               4");
            int actionMenuProduct = Integer.parseInt(scanner.nextLine());
            switch (actionMenuProduct) {
                case 1:
                    showProductsView();
                    break;
                case 2:
                    createProductView();
                    break;
                case 4:
                    deleteProductView();
                    break;
                case 3:
                    editProductView();
                    break;
            }
            checkActionMenuProduct = checkActionMenuProductContinue();
        }while (checkActionMenuProduct);

    }

    private void editProductView() {
        boolean checkActionMenuEditProduct  = false;
        do{
            System.out.println("Bạn muốn sửa theo: ");
            System.out.println("Sửa theo giá:              1");
            System.out.println("Sửa theo tên:              2");
            System.out.println("Sửa theo số lượng:         3");
            int actionMenuEditProduct = Integer.parseInt(scanner.nextLine());
            switch (actionMenuEditProduct) {
                case 1:

                    break;
                case 2:
                    editNameProductView();
                    break;
                case 3:
                    break;
                default:
                    checkActionMenuEditProduct = true;
            }
        }while (checkActionMenuEditProduct);

    }

    private void editNameProductView() {
        System.out.println("Nhập ID sản phẩm muốn sửa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm muốn sửa ");
        String nameProduct = scanner.nextLine();

        Product product = findProductById(idProduct);
        if (product != null) {
            product.setName(nameProduct);
            updateProductById(idProduct, product);
            showProductsView(products);
        }else{
            System.out.println("ID không tồn tại");
        }


    }

    private void deleteProductView() {
        System.out.println("Nhập ID bạn muốn xóa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        deleteProductById(idProduct);
        showProductsView(products);
    }

    public Product findProductById(long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }

    public void updateProductById(long id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
//                products.get(i).setName(product.getName());
//                products.get(i).setPrice(product.getPrice());
//                products.get(i).setCreateAt(product.getCreateAt());
//                products.get(i).setQuantity(product.getQuantity());
                products.get(i).updateProduct(product);
            }
        }
    }
    public void deleteProductById(long idProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.remove(i);
                break;
            }
        }
    }

    private boolean checkActionMenuProductContinue() {
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

    private void createProductView() {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());
        Date day = new Date();
        long idProduct = System.currentTimeMillis()/1000;

        Product product = new Product(idProduct, name, price, quantity, day);
        products.add(product);
        showProductsView(products);
    }

    public static void main(String[] args) {
        MyStore myStore = new MyStore();
        myStore.laucher();
    }

    private void showProductsView() {
        System.out.printf("%-5s|%-10s|%-10s|%-10s|%-10s\n", "ID", "Name", "Price", "Quantity", "Create At");
        for (Product p : products) {
            System.out.println(p.toViewer());
        }
    }
    private void showProductsView(List<Product> products) {
        System.out.printf("%-5s|%-10s|%-10s|%-10s|%-10s\n", "ID", "Name", "Price", "Quantity", "Create At");
        for (Product p : products) {
            System.out.println(p.toViewer());
        }
    }
}
