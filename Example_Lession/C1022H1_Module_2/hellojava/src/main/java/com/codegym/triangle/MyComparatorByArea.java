package com.codegym.triangle;

public class MyComparatorByArea implements MyComparator<Rectangle>{
    @Override
    public int myComparaTo(Rectangle r1, Rectangle r2) {
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
