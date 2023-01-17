package com.codegym.reviews;

class Calcs{
    static int root;
    Calcs(int root){
        this.root = root++;
    }
    public static void main(String [] args){
        Calcs c = new Calcs(42);
        go();
    }
    static void go(){
        System.out.println(++root);
    }
}