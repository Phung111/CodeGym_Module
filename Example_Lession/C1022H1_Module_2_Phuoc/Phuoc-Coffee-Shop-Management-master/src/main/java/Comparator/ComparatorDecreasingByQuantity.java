package Comparator;

import Model.Product;
import Service.ProductService;

import java.util.Comparator;

public class ComparatorDecreasingByQuantity implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getQuantity()<o2.getQuantity()){
            return 1;
        }
        else if (o1.getQuantity()==o2.getQuantity()){
            return 0;
        }
        else return -1;
    }
}
