package Service;

import Model.Product;
import Model.User;

import java.util.List;

public interface InterfaceProductService {
    void addProduct(Product product);

    void updateProduct(Product product, long id);

    void removeProductByID (long id, List<Product> products, User user);
    Product findProductByID(long id);

    List<Product> searchProductByName(String name);

    void sortByPrice(List<Product> products);

    void sortByName(List<Product> products);
    void sortByQuantity(List<Product> products);

}
