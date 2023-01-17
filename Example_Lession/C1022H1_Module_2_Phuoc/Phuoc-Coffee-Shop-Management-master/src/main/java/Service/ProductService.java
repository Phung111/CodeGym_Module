package Service;

import FeatureApp.*;
import Model.ActionType;
import Model.ECategory;
import Model.Product;
import Comparator.ComparatorDecreasingByName;
import Comparator.ComparatorIncreasingByName;
import Comparator.ComparatorDecreasingByPrice;
import Comparator.ComparatorIncreasingByPrice;
import Comparator.ComparatorIncreasingQuantity;
import Comparator.ComparatorDecreasingByQuantity;
import Model.User;
import Utils.ValidateUtils;
import view.ProductView;

import java.util.*;

public class ProductService implements InterfaceProductService{
    public static Scanner scanner = new Scanner(System.in);
    public SupportApp eventApp = new SupportApp();
    public FileService fileService;
    public BannerApp bannerApp = new BannerApp();
    public static ProductView productView = new ProductView();
    private final String filePath = "/Users/user/Phuoc-Coffee-Shop-Management/data/product.txt";

    public ProductService() {
        fileService = new FileService();
    }

    public List<Product> getAllProducts(){
        List<String> productLines = fileService.readFile(filePath);
        List<Product> products = converListStringToListProduct(productLines);
        return products;
    }

    public boolean checkRemainQuantityProduct (long idProduct,int quantity){
        Product product = findProductByID(idProduct);
        if (product.getQuantity()>quantity){
            return true;
        }
        else return false;
    }

    public List<Product> converListStringToListProduct(List<String> list){
        List<Product> products = new ArrayList<>();
        for (String item : list){
            String[] items = item.split(",");
            long idProduct = Long.parseLong(items[0]);
            int quantity = Integer.parseInt(items[2]);
            double price = Double.parseDouble(items[3]);
            int idCategory = Integer.parseInt(items[4]);
            ECategory category = ECategory.findCategoryByID(idCategory);
            Product product = new Product();
            product.setIdProduct(idProduct);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setCategory(category);
            product.setNameProduct(items[1]);
            products.add(product);
        }
        return products;
    }

    public List<String> converListProductToListString(List<Product> productList){
        List<String> productLines = new ArrayList<>();
        for (Product product : productList){
            productLines.add(product.toData());
        }
        return productLines;
    }
    public void addProduct(Product product){
        List<Product> products = getAllProducts();
        products.add(product);
        List<String> productLines = converListProductToListString(products);
        fileService.writeFile(filePath,productLines);
    }

//    Tìm product theo ID product => xây dựng hàm update Product, update product đó và ghi file

    public void updateProduct (Product product,long idProduct){
        List<Product> productList = getAllProducts();
        for (Product p : productList){
            if (p.getIdProduct()==idProduct){
                p.updateProduct(product);
            }
        }
        List<String> productLines = converListProductToListString(productList);
        fileService.writeFile(filePath,productLines);
    }

    public Product findProductByID(long id) {
        for (Product product: getAllProducts()){
            if (product.getIdProduct()==id){
                return product;
            }
        }
        return null;
    }

    public String inputProductName (){
        String nameProduct;
        boolean checkContinueAction;
        do {
            checkContinueAction = true;
            System.out.print("【1】ADD NAME PRODUCT");
            nameProduct = scanner.nextLine();
            if (ValidateUtils.validateProductName(ValidateUtils.removeAccent(nameProduct))){
                checkContinueAction = false;
            }
            else System.out.println("The name of product you entered "+PrintColor.RED_BOLD+"DO NOT MATCH"+PrintColor.RESET+"- please try again.");
        }
        while (checkContinueAction);
        return nameProduct;
    }

    public long inputPrice (ActionType type){
        long price;
        boolean checkInputPrice = false;
        switch (type){
            case Add:
                System.out.println("■ Added Value:");
                break;
            case Edit:
                System.out.println("■ Edited Value:");
                break;
        }
        do {
            checkInputPrice = false;
            price = Long.parseLong(scanner.nextLine());
            if (price<0||price>1000000){
                System.out.println("Price must be less than 1000000 and greater than 0");
                checkInputPrice = true;
            }
        }
        while (checkInputPrice);
        return price;
    }

    public void removeProductByID(long idRemove, List<Product> products, User user) {
        AlertApp.alertApp("Student-Remove-Confirm");
        String alert = scanner.nextLine();
        if (alert.toLowerCase().equals("y")) {
            for (int i = 0;i< products.size();i++){
                if (products.get(i).getIdProduct()==idRemove){
                    products.remove(i);
                }
            }
            saveData(products);
            AlertApp.alertApp("Remove-Success");
        }
        if (alert.toLowerCase().equals("n")) {
            productView.mainMenuView(user);
        }

    }


    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productsResult = new ArrayList<>();
        for (Product product : getAllProducts()){
            if ((product.getNameProduct().toUpperCase()).compareTo(name)==0){
                productsResult.add(product);
            }
        }
        return productsResult;
    }

    @Override
    public void sortByPrice(List<Product> products) {
        boolean checkSortByPrice = false;
        do {
            checkSortByPrice = false;
            bannerApp.menuBanner("Sort-by-price");
            int choiceSortByPrice = Integer.parseInt(scanner.nextLine()) ;
            Comparator comparator;
            switch (choiceSortByPrice){
                case 1:
                    comparator = new ComparatorIncreasingByPrice();
                    products.sort(comparator);
                    saveData(products);
                    break;
                case 2:
                    comparator = new ComparatorDecreasingByPrice();
                    products.sort(comparator);
                    saveData(products);
                    break;
                case 0:
//                    eventApp.returnEvent("Return-sorting-menu");
                    break;
                default:
                    System.out.println("Error value! Type again");
                    checkSortByPrice = true;
                    break;
            }
        }
        while (checkSortByPrice);
    }

    @Override
    public void sortByName(List<Product> products) {
        boolean checkSortByName = false;
        do {
            checkSortByName = false;
            bannerApp.menuBanner("Sort-by-name");
            int choiceSortByName = Integer.parseInt(scanner.nextLine());
            Comparator comparator;
            switch (choiceSortByName){
                case 1:
                    comparator = new ComparatorIncreasingByName();
                    products.sort(comparator);
                    saveData(products);
                    break;
                case 2:
                    comparator = new ComparatorDecreasingByName();
                    products.sort(comparator);
                    saveData(products);
                    break;
                default:
                    System.out.println("Error value! Type again");
                    checkSortByName = true;
                    break;
            }
        }
        while (checkSortByName);
    }

    @Override
    public void sortByQuantity(List<Product> products) {
        boolean checkSortByQuantity = false;
        do {
            checkSortByQuantity = false;
            bannerApp.menuBanner("Sort-by-quantity");
            int choiceSortByQuantity = Integer.parseInt(scanner.nextLine());
            Comparator<Product> comparator;
            switch (choiceSortByQuantity){
                case 1:
                    comparator = new ComparatorIncreasingQuantity();
                    products.sort(comparator);
                    saveData(products);
                    break;
                case 2:
                    comparator = new ComparatorDecreasingByQuantity();
                    products.sort(comparator);
                    saveData(products);
                    break;
                default:
                    System.out.println("Error value! Type again");
                    checkSortByQuantity = true;
                    break;
            }
        }
        while (checkSortByQuantity);
    }
    public boolean beExistbyID (long id){
        for (Product product: getAllProducts()){
            if (product.getIdProduct()==id){
                return true;
            }
        }
        return false;
    }

    public void saveData(List<Product> products){
        List<String> productLines = converListProductToListString(products);
        fileService.writeFile(filePath,productLines);
    }

    public void printingAllProduct (){
        for (Product i : getAllProducts()){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ProductService test = new ProductService();
        List<Product> list = test.getAllProducts();
        for (Product p : list) {
            System.out.println(p);
        }
        Product product = test.findProductByID(16703217);
        System.out.println(product);
    }
}
