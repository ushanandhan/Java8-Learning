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
                throw new IndexOutOfBoundsException("Invalid Position");
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

    public void deleteAtPosition(int position){
        if(head==null){
            throw new IndexOutOfBoundsException("Deletion attempted on empty List");
        }
        if(position ==0){
            deleteAtBeginning();
            return;
        }
        Node temp = head;
        Node previous = null;
        for(int i = 1;i<position;i++){
            previous = temp;
            temp = head.next;
        }
        previous.next = temp.next;

    }

    public void deleteAtBeginning(){
        if(head==null){
            throw new IndexOutOfBoundsException("Deletion attempted on empty List");
        }
        head = head.next;
    }

    public int get(int index){
        if(index == 0){
            return head.data;
        }
        Node temp = head;
        for(int i = 1;i<index;i++){
            temp = temp.next;
        }
        return temp.data;
    }
}
