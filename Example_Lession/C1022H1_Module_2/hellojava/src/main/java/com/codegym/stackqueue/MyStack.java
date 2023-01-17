package com.codegym.stackqueue;

public class MyStack<E> {
    private static final int INITIAL_SIZE = 5;
    private E[] elements;
    private int count = 0;
    public MyStack() {
        elements = (E[]) new Object[INITIAL_SIZE];
    }
    public void push(E e){
        ensureCapacity();
        elements[count++] = e;
    }
    public E pop() {
        int index = count-1;
        E temp = elements[index];
        elements[count-1]= null;
        count--;
        return temp;
    }
    private void ensureCapacity() {
        if(count >= elements.length){
            E[] newElements = (E[]) new Object[elements.length * 2 + 1];
            System.arraycopy(elements, 0, newElements, 0, count); elements =
                    newElements;
        }
    }
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("America");
        stack.push("Canada");
        stack.push("France");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}