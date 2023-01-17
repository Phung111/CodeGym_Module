package com.codegym.staticoop;

public class OuterClass {
     public class InnerClass {


    }

    public static class StaticInnerClass {

    }

    public static void main(String[] args) {
        OuterClass.StaticInnerClass a = new OuterClass.StaticInnerClass();

        OuterClass b = new OuterClass();
        //OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        OuterClass.InnerClass a1 = new OuterClass().new InnerClass();
    }

}
