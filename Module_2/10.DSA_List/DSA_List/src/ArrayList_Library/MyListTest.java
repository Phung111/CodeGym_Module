package ArrayList_Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyListTest {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(1);
        System.out.println("array ban đầu");
        System.out.println(arr.toString());
        System.out.println("------------");

        arr.add(2,5);
        System.out.println("add(2,5)");
        System.out.println(arr.toString());
        System.out.println("------------");

//        arr.clear();
//        System.out.println("clear");
//        System.out.println(arr.toString());
//        System.out.println("------------");

        arr.contains(6);
        System.out.println("contains(6)");
        System.out.println(arr.contains(6));
        System.out.println("------------");

        System.out.println("get(3)");
        System.out.println(arr.get(3));
        System.out.println("------------");

        System.out.println("indexof(6)");
        System.out.println(arr.indexOf(6));
        System.out.println("------------");

//        System.out.println("remove(3)");
//        System.out.println(arr.remove(3));
//        System.out.println(arr.toString());
//        System.out.println("------------");

        System.out.println("set(3, 10)");
        System.out.println(arr.set(3, 10));
        System.out.println(arr.toString());
        System.out.println("------------");

        System.out.println("size");
        System.out.println(arr.size());
        System.out.println("------------");

        System.out.println("isEmty");
        System.out.println(arr.isEmpty());
        System.out.println("------------");

        System.out.println("lastIndexOf(1)");
        System.out.println(arr.lastIndexOf(1));
        System.out.println("------------");

    }
    public static void showArray(List<Integer> arr){
//        for (int i = 0; i < arr.size();i++)
//        {
//            System.out.println(arr.get(i));
//        }
//        foreach
        for (Integer ar : arr)
        {
            System.out.println(ar);
        }


//        iterator
//        Iterator itr = arr.iterator();
//        while(itr.hasNext())
//        {
//            Integer obj = (Integer) itr.next();
//            System.out.println(obj);
//        }

//        list iterator;
//        ListIterator<Integer> litr = arr.listIterator();
//
//        System.out.println("\n Using list iterator");
//        while(litr.hasNext()){
//            System.out.println(litr.next());
//        }

    }
}
