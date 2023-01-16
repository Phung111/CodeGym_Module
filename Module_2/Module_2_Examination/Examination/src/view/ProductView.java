package view;

import model.Product;
import service.ProductService;

import java.util.List;
import java.util.Scanner;

import static orther.Format.inputLong;
import static orther.Format.isContinue;

public class ProductView {

    private Scanner scanner = new Scanner(System.in);
    private ProductService productService;
    public ProductView(){
        productService = new ProductService();
    }

    public void launcher(){
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");
            String choiceStr = inputLong();
            if(choiceStr.equals(".")){
                break;
            }
            int choice = Integer.parseInt(choiceStr);
            switch (choice) {
                case 1:
                    showProductAll();
                    boolean isAdd = isContinue("Thêm sản phẩm mới?","(quay lại Quản lý sản phẩm)");
                    if(isAdd){
                        add();
                    } else {
                        return;
                    }
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    sort();
                    break;
                case 6:
                    findHighestPrice();
                    break;
                case 7:
                    readFile();
                    break;
                case 8:
                    writeFile();
                    break;
                case 9:
                    System.out.println("--Thoát chương trình--");
                    System.exit(0);
                    break;
            }
        } while (isContinue("tiếp tục Quản lý sản phẩm","(Thoát Hoàn toàn)"));
    }
    private void showProductAll(){
        List<Product> products = productService.getAllProducts();
        show(products);
    }
    private void show1Product(Product product){
        showHeader();
        show(product);
    }

    private void show(List<Product> products) {
        showHeader();
        for(Product product: products){
            show(product);
        }
    }

    private void show(Product product) {
            System.out.printf("|%-15s|%-30s|%,10d đ|%10s|%-20s|\n",
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getAmount(),
                    product.getDescription()
            );
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private void showHeader(){
        System.out.println("----Xem danh sách----");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("|%-15s|%-30s|%-12s|%-10s|%-20s|\n",
                "Mã sản phẩm","Tên","Giá","Số lượng","Mô tả"
        );
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private void add(){
        do {
            System.out.println("----Thêm mới----");
            Product product = enterProduct();
            if (product == null){
                System.out.println("--Mã sản phẩm đã tồn tại--");
            } else {
                productService.addProduct(product);
                showProductAll();
                System.out.println("--Done--");
            }
        } while (isContinue("tiếp tục Thêm sản phẩm khác", "(trở lại Quản lý sản phẩm)"));
    }

    private Product enterProduct(){
        System.out.println("--Nhập mã sản phẩm--");
        String idStr = inputLong();
        long id = Long.parseLong(idStr);
        Product product = productService.findProductById(id);
        if(product == null){
            System.out.println("--Nhập tên sản phẩm--");
            String name = scanner.nextLine();
            System.out.println("--Nhập giá--");
            String priceStr = inputLong();
            long price = Long.parseLong(priceStr);
            System.out.println("--Nhập số lượng--");
            String amountStr = inputLong();
            long amount = Long.parseLong(amountStr);
            System.out.println("--Nhập mô tả--");
            String description = scanner.nextLine();
            if(description.isEmpty()){
                description = "none";
            }
            product = new Product(id, name, price, amount, description);
        } else {
            product = null;
        }
        return product;
    }

    private void update(){
        showProductAll();
        boolean isContinue = true;
        do {
            System.out.println("---- Cập nhật ----");
            System.out.println("--Nhập mã sản phẩm cần thay đổi--");
            String idStr = inputLong();
            if(idStr.isEmpty()){
                return;
            }
            long id = Long.parseLong(idStr);
            Product product = productService.findProductById(id);
            if (product == null){
                System.out.println("--Không tìm thấy sản phẩm với mã sản phẩm trên, mời nhập lại");
                isContinue = true;
            } else {
                System.out.println("--Nhập vào thông tin mới--");
                Product productEnter = enterProduct();
                productService.updateProductById(id, productEnter);
                System.out.println("--Done--");
                showProductAll();
                isContinue = false;
            }
        } while (isContinue);
    }

    private void remove(){
        showProductAll();
        System.out.println("---- Xoá ----");
        System.out.println("--Nhập mã sản phẩm cần xoá--");
        String idStr = inputLong();
        if(idStr.isEmpty()){
            return;
        }
        long id = Long.parseLong(idStr);
        Product product = productService.findProductById(id);
        if (product == null){
            System.out.println("--Không tìm thấy sản phẩm với mã sản phẩm trên, mời nhập lại");
        } else {
            System.out.println("Sản phẩm tìm thấy với mã sản phẩm bạn nhập--");
            show1Product(product);
            System.out.println("--Bạn có chắc là muốn xoá? [y]Yes/[n]No");
            String choice = scanner.nextLine();
            if(choice.equals("y")){
                productService.deleteProductById(id);
                System.out.println("--Done--");
                showProductAll();
            } else {
                return;
            }
        }
    }

    private void sort(){
        List<Product> products = productService.sortByPrice();
        show(products);
        boolean isfind = isContinue("Tìm sản phẩm có giá cao nhất","(quay lại Quản lý sản phẩm)");
        if(isfind){
            findHighestPrice();
        } else {
            return;
        }
    }

    private void findHighestPrice(){
        System.out.println("---- Tìm sản phẩm có giá lớn nhất ----");
        List<Product> products = productService.getAllProducts();
        long maxPrice = 0;
        Product productMaxPrice = new Product();
        for(Product product: products){
            if(product.getPrice() > maxPrice){
                maxPrice = product.getPrice();
                productMaxPrice = product;
            }
        }
        System.out.println("--Sản phẩm với giá lớn nhất--");
        show1Product(productMaxPrice);
    }

    public void readFile(){
        System.out.println("--Cảnh báo người dùng trước khi cập nhật file danh sách sản phẩm)--");
        System.out.println("[y]Yes or [n]No");
        showProductAll();
        System.out.println("--Done--");
    }

    public void writeFile(){
        System.out.println("--Cảnh báo người dùng trước khi nhập bộ nhớ (xoá toàn bộ danh sách sản phm đang có trong bộ nhớ)--");
        System.out.println("[y]Yes or [n]No");

        showProductAll();
        System.out.println("--Done--");
    }
}
