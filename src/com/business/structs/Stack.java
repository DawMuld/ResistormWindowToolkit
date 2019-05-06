/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business.structs;

/**
 *
 * @author daan-
 */
public class Stack<T> {

    private Node<T> head;



    public Stack() {
        head = null;
    }



    public boolean hasNext() {
        return head != null;
    }



    public int size() {
        int size = 0;
        Node<T> node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }



    public T pop() {
        T hold = head.data;
        head = head.next;
        return hold;
    }



    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    public class Node<T> {

        public final T data;
        public Node<T> next;



        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

}
