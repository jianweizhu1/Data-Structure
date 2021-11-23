package com.company;


public class linkedList {
    private Node head;
    public void insert(int data) {
        //create a new node with given data
        Node newNode = new Node(data);
        //check if head is empty. If empty, make the newNode as head. else, add it to the end
        if(head == null) {
            head = newNode;
        }
        //traverse to the end of the list
        else {
           Node current = head;
           //loop until current.next is null
           while (current.next != null) {
               current = current.next;
           }
           current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current.next != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
}