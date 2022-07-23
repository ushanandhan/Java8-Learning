package com.datastructures;

public class LinkedList {
    private Node head;
    private class Node{
        int data;
        Node next;

        Node(int value){
            this.data = value;
            this.next = null;
        }
    }

    LinkedList(){
        head = null;
    }

    public void insertAtBegin(int value){
        Node newNode = new Node(value);
        //When list is empty
        if(head==null){
            head = newNode;
        }else{ //When list is not empty
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtPosition(int position,int value){
        if(position==0){
            insertAtBegin(value);
            return;
        }
        Node newNode = new Node(value);
        Node temp = head;
        for(int i=1;i<position;i++){
            temp = temp.next;
            if(temp==null){
                System.out.println("Invalid position !");
                return;
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
