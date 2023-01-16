package repository;

import model.Product;

public class ProductRepository extends FileContext<Product> {
    public ProductRepository(){
        filePath = "./Examination/src/data/product.csv";
        tClass = Product.class;
    }
}
