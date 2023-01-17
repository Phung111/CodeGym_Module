package com.codegym.stackqueue;

import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> elements;

    public GenericQueue() {
        elements = new LinkedList<>();
    }

    public boolean offer(E e) {
        elements.addLast(e);
        return true;
    }
    public E peek() {
        return elements.getFirst();
    }
    public E poll() {
        return elements.removeFirst();
    }

    public boolean isEmpty(){
        return elements.size() == 0;
    }

    public static void main(String[] args) {
        GenericQueue genericQueue = new GenericQueue();
        genericQueue.offer("Nghia");
        genericQueue.offer("Nhan");
        genericQueue.offer("Thuy");

        while (!genericQueue.isEmpty()) {
            System.out.println(genericQueue.poll());
        }

    }
}
