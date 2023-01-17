package com.codegym.triangle;

public class MyComparatorCircleByArea implements MyComparator<Circle>{
    @Override
    public int myComparaTo(Circle r1, Circle r2) {
        if (r1.getArea() > r2.getArea()) {
            return 1;
        }else{
            if (r2.getArea() == r1.getArea()) {
                return 0;
            }
            else {
                return -1;
            }
        }
    }
}
