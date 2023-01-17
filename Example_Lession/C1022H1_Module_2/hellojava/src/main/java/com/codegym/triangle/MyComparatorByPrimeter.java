package com.codegym.triangle;

public class MyComparatorByPrimeter implements MyComparator<Rectangle>{
    @Override
    public int myComparaTo(Rectangle r1, Rectangle r2) {
        if (r1.getPerimeter() > r2.getPerimeter()) {
            return 1;
        }else {
            if (r1.getPerimeter() < r2.getPerimeter()) {
                return -1;
            }
        }
        return 0;
    }
}
