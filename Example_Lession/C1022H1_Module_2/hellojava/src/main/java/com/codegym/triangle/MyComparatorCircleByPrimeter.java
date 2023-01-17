package com.codegym.triangle;

public class MyComparatorCircleByPrimeter implements MyComparator<Circle>{
    @Override
    public int myComparaTo(Circle r1, Circle r2) {
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
