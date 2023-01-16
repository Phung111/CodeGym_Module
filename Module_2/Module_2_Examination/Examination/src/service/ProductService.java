package service;

import model.Product;
import repository.ProductRepository;

import java.util.Comparator;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository;
    public ProductService(){
        productRepository = new ProductRepository();
    }
    public List<Product> getAllProducts(){
        return productRepository.getAll();
    }
    public void updateProductById(long id, Product product){
        productRepository.updateById(id, product);
    }
    public Product findProductById(long id){
        return productRepository.findById(id);
    }
    public void deleteProductById(long id){
        productRepository.deleteById(id);
    }

    public void addProduct(Product product){
        productRepository.add(product);
    }
    public List<Product> sortByPrice(){
        List<Product> products = getAllProducts();
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() - o2.getPrice() > 0) {
                    return 1;
                }else{
                    if (o1.getPrice() - o2.getPrice() == 0) {
                        return 0;
                    }
                }
                return -1;
            }
        };
        products.sort(comparator);
        return products;
    }
}
