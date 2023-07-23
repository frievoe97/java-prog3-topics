package collections;

import java.util.LinkedList;

public class ArrayList {

    private static void printArrayList(java.util.ArrayList<String> arrayList){
        for (Object element : arrayList) {
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        java.util.ArrayList<String> arrayList = new java.util.ArrayList<>();
        LinkedList linkedList = new LinkedList();

        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        printArrayList(arrayList);

        arrayList.remove("b");
        arrayList.remove("c");

        printArrayList(arrayList);
    }
}
