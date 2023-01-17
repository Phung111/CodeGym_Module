package com.codegym.view;

import com.codegym.CompartorByName;
import com.codegym.CompartorByPrice;
import com.codegym.model.Product;
import com.codegym.service.ProductService;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductView {

    private Scanner scanner = new Scanner(System.in);
    private ProductService productService;
    public ProductView() {
        productService = new ProductService();
    }

    public void laucher() {
        boolean checkActionMenuProduct = false;
        do{
            System.out.println("Menu sản phẩm");
            System.out.println("Xem danh sách:              1");
            System.out.println("Thêm sản phẩm:              2");
            System.out.println("Sửa sản phẩm:               3");
            System.out.println("Xóa sản phẩm:               4");
            System.out.println("Sắp xếp theo giá:           5");
            System.out.println("Sắp xếp theo tên:           6");
            System.out.println("Tìm kiếm theo tên:          7");
            System.out.println("Tìm kiếm theo giá:          8");
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
                case 5:
                    sortProductsByPriceView();
                    break;
                case 6:
                    sortProductsByNameView();
                    break;
                case 7:
                    searchProductByNameView();
                    break;
            }
            checkActionMenuProduct = checkActionMenuProductContinue();
        }while (checkActionMenuProduct);

    }

    private void searchProductByNameView() {
        System.out.println("Nhập tên bạn muốn tìm kiếm");
        String nameSearch = scanner.nextLine();
        List<Product> results = productService.searchProductsByName(nameSearch);
        showProductsView(results);
    }

    private void sortProductsByNameView() {
        List<Product> products = productService.getAllProducts();

        Comparator<Product> comparator = new CompartorByName();
        products.sort(comparator);
        showProductsView(products);
    }

    private void sortProductsByPriceView() {
        List<Product> products = productService.getAllProducts();
        Comparator<Product> comparator = new CompartorByPrice();
        products.sort(comparator);
        showProductsView(products);
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

        Product product = productService.findProductById(idProduct);
        if (product != null) {
            product.setName(nameProduct);
            productService.updateProductById(idProduct, product);
            showProductsView(productService.getAllProducts());
        }else{
            System.out.println("ID không tồn tại");
        }


    }

    private void deleteProductView() {
        System.out.println("Nhập ID bạn muốn xóa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        productService.deleteProductById(idProduct);
        showProductsView(productService.getAllProducts());
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
        productService.addProduct(product);
        showProductsView(productService.getAllProducts());
    }

    private void showProductsView() {
        System.out.printf("%-5s|%-10s|%-10s|%-10s|%-10s\n", "ID", "Name", "Price", "Quantity", "Create At");
        for (Product p : productService.getAllProducts()) {
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
