package Comparator;

import Model.Product;

import java.util.Comparator;

public class ComparatorIncreasingByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if ((o1.getNameProduct()).compareTo(o2.getNameProduct())>=1){
            return -1;
        }
        else if ((o1.getNameProduct()).compareTo(o2.getNameProduct())==0){
            return 0;
        }
        else return 1;
    }
}
