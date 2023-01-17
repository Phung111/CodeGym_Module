package com.codegym.triangle;

public class ShapMain {

    public static void main(String[] args) {
        /*Shape[] shapes = new Shape[5];
        shapes[0] = new Rectangle(4.0, 5.0);
        shapes[1] = new Circle(4.0);
        shapes[2] = new Circle(10.0);
        shapes[3] = new Triangle(5, 5, 9);
        shapes[4] = new Rectangle(7.0, 5.0);*/
//
//        for (Shape s : shapes) {
//            System.out.println(s);
//        }
//        for (Shape s : shapes) {
//            if (s instanceof Circle) {
//                System.out.println(((Circle) s).getArea());
//            }
//            if (s instanceof Rectangle) {
//                System.out.println(((Rectangle) s).getArea());
//            }
//            if (s instanceof Triangle) {
//                System.out.println(((Triangle) s).getArea());
//            }
//        }
//        for (Shape s : shapes) {
//            System.out.println(s.getArea());
//        }

        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle(10.0, 10.0);
        rectangles[1] = new Rectangle(3.0, 1.0);
        rectangles[2] = new Rectangle(2.0, 2.0);
        rectangles[3] = new Rectangle(2.0, 4.0);
        rectangles[4] = new Rectangle(7.0, 1.0);


        MyComparator myComparatorArea = new MyComparatorByArea();
        SortUtils.sort(rectangles, myComparatorArea);

        System.out.println("Sap theo dien tich");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        MyComparator myComparatorPrimeter = new MyComparatorByPrimeter();
        SortUtils.sort(rectangles, myComparatorPrimeter);

        System.out.println("Sap theo chu vi");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.toStringChuVi());
        }


        Circle[] circles = new Circle[5];
        circles[0] = new Circle(10.0);
        circles[1] = new Circle(3.0);
        circles[2] = new Circle(2.0);
        circles[3] = new Circle(2.0);
        circles[4] = new Circle(7.0);

        MyComparator myComparator = new MyComparatorCircleByArea();
        SortUtils.sort(circles, myComparator);
        System.out.println("Sap theo HINH TRÒN THEO dien tich");
        for (Circle c : circles) {
            System.out.println(c);
        }

        System.out.println("So sánh dùng comparable");
        Rectangle[] rectangles1 = new Rectangle[5];
        rectangles1[0] = new Rectangle(10.0, 10.0);
        rectangles1[1] = new Rectangle(3.0, 1.0);
        rectangles1[2] = new Rectangle(2.0, 2.0);
        rectangles1[3] = new Rectangle(2.0, 4.0);
        rectangles1[4] = new Rectangle(7.0, 1.0);

        SortUtils.sort(rectangles1);
        System.out.println("Sap theo dien tich");
        for (Rectangle rectangle : rectangles1) {
            System.out.println(rectangle);
        }


    }
    public void myComparatorV1() {
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle(10.0, 10.0);
        rectangles[1] = new Rectangle(3.0, 1.0);
        rectangles[2] = new Rectangle(2.0, 2.0);
        rectangles[3] = new Rectangle(2.0, 4.0);
        rectangles[4] = new Rectangle(7.0, 1.0);

        for (int i=0; i< rectangles.length-1;i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                // Tạo 1 phương thức so sánh --> HẮN TRƯU TUONG
                MyComparator myComparator = new MyComparatorByArea();
                if (myComparator.myComparaTo(rectangles[i], rectangles[j]) == 1) {
                    Rectangle temp = rectangles[i];
                    rectangles[i] = rectangles[j];
                    rectangles[j] = temp;
                }
                /**
                 if (rectangles[j].getArea() < rectangles[i].getArea()) {
                 Rectangle temp = rectangles[i];
                 rectangles[i] = rectangles[j];
                 rectangles[j] = temp;
                 }
                 **/
            }
        }
        System.out.println("Sap theo dien tich");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
        for (int i=0; i< rectangles.length-1;i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                MyComparator myComparator = new MyComparatorByPrimeter();
                if (myComparator.myComparaTo(rectangles[i], rectangles[j])==1) {
                    Rectangle temp = rectangles[i];
                    rectangles[i] = rectangles[j];
                    rectangles[j] = temp;
                }
                /**
                 if (rectangles[j].getPerimeter() < rectangles[i].getPerimeter()) {
                 Rectangle temp = rectangles[i];
                 rectangles[i] = rectangles[j];
                 rectangles[j] = temp;
                 }
                 **/
            }
        }
        System.out.println("Sap theo chu vi");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.toStringChuVi());
        }
    }

    public void myComparatorV2() {
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle(10.0, 10.0);
        rectangles[1] = new Rectangle(3.0, 1.0);
        rectangles[2] = new Rectangle(2.0, 2.0);
        rectangles[3] = new Rectangle(2.0, 4.0);
        rectangles[4] = new Rectangle(7.0, 1.0);


        MyComparator myComparatorArea = new MyComparatorByArea();
        SortUtils.sort(rectangles, myComparatorArea);

        System.out.println("Sap theo dien tich");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        MyComparator myComparatorPrimeter = new MyComparatorByPrimeter();
        SortUtils.sort(rectangles, myComparatorPrimeter);

        System.out.println("Sap theo chu vi");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.toStringChuVi());
        }
    }
}
