package com.datastructures;

import org.junit.jupiter.api.Test;

public class CollectionsTest {

    @Test
    void DynamicArrayTest(){
        DynamicArrayList<Integer> intArray = new DynamicArrayList();
        intArray.add(3);
        intArray.add(1);
        intArray.add(2);
        intArray.add(5);
        intArray.display();
        intArray.insertAtPosition(2,4);
        intArray.display();
        intArray.deleteAtPosition(2);
        intArray.display();
        intArray.deleteAtBegin();
        intArray.display();
        intArray.insertAtBegin(7);
        intArray.display();
        System.out.println("Total occupied size is : "+intArray.length());
        System.out.println("Total capacity is : "+intArray.capacity());
        intArray.update(3,8);
        System.out.println(intArray.get(3));
        System.out.println("==================================");
        DynamicArrayList<String> stringArray = new DynamicArrayList<>();
        stringArray.add("abc");
        stringArray.add("def");
        stringArray.add("ghi");
        stringArray.display();
        for (String s: stringArray) {
            System.out.println(s);
        }
    }

    @Test
    void LinkedTest(){
        LinkedList list = new LinkedList();
        list.insertAtBegin(5);
        list.insertAtBegin(6);
        list.display();
        System.out.println();
        list.insertAtPosition(2,1);
        list.insertAtPosition(3,9);
        list.display();
        System.out.println();
        list.deleteAtPosition(2);
        list.display();
        System.out.println();
        System.out.println(list.get(0));
    }
}
