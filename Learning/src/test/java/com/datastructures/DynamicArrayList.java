package com.datastructures;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArrayList<T> implements Iterable<T>{
    private static final int INITIAL_CAPACITY = 4;
    private T[] array;
    private int size ;
    private int capacity;

    DynamicArrayList(){
        size = 0;
        array = (T[])new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    public void add(T value){
        if(size==capacity){
            expandArray();
        }
        array[size++]=value;
    }

    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public void insertAtPosition(int position,T value){
        if(size==capacity){
            expandArray();
        }
        for(int i = size-1;i>=position;i--){
            array[i+1] = array[i];
        }
        array[position] = value;
        size++;
    }

    public void insertAtBegin(T value){
        insertAtPosition(0,value);
    }
    private void expandArray() {
        capacity*=2;
        array = Arrays.copyOf(array,capacity);
    }

    public void deleteAtPosition(int position){
        if(position<0) {
            System.out.println("Invalid position");
            return;
        }
        for(int i = position+1;i<size;i++,position++){
            array[position] = array[i];
        }
        size--;
        if(capacity>INITIAL_CAPACITY && capacity>3*size){
            shrinkArray();
        }
    }

    public void deleteAtEnd(){
        deleteAtPosition(size-1);
    }

    public void deleteAtBegin(){
        deleteAtPosition(0);
    }
    private void shrinkArray() {
        capacity/=2;
        Arrays.copyOf(array,capacity);
    }

    public int length(){
        return this.size;
    }

    public T get(int index){
        return array[index];
    }

    public void update(int index,T value){
        array[index] = value;
    }

    public void clear(){
        size=0;
    }

    public int capacity(){
        return this.capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
