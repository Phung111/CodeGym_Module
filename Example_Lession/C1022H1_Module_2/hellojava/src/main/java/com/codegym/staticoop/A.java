package com.codegym.staticoop;

public class A {
    static public class B {
    }

    public class C {
    }

    public static void main(String[] args) {
        A.C o = new A().new C();

        A.B o1 = new A.B();
    }
}