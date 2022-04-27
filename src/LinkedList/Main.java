package LinkedList;

import LinkedList.LinkedListArrayOfStrings;

public class Main {
    public static void main(String[] args) {
//        Arrays.CustomArrayOfInt array = new Arrays.CustomArrayOfInt();
//        array.add(5);
//        array.add(7);
//        array.add(9);
//        array.add(11);
//        System.out.println(array.toString());
//        System.out.println("size: " + array.size());
//
//        array.deleteByIndex(1);
//        System.out.println("delete index 1: "+array.toString());
//
//        System.out.println("get index 1: " + array.get(1));
//
//        array.insertValueAtIndex(88, 1);
//        System.out.println(array.toString());
//
//        array.clear();
//        System.out.println(array.toString());

        LinkedListArrayOfStrings linkedList = new LinkedListArrayOfStrings();
        linkedList.addToFront("a");
        linkedList.addToEnd("f");
        System.out.println(linkedList.get(1));
        linkedList.insertValueAtIndex(1, "b");
        linkedList.insertValueAtIndex(2, "c");
        linkedList.insertValueAtIndex(3, "d");
        linkedList.insertValueAtIndex(4, "e");

        System.out.println(linkedList.toString());

        linkedList.deleteByIndex(1);
        System.out.println("after deleting index1: "+linkedList.toString());

        System.out.println(linkedList.deleteByValue("e"));
        System.out.println("after deleting e: " + linkedList.toString());
    }
}
