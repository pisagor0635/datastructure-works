package com.ab.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListBasicWork {
    public static void main(String[] args) {

        //add
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Izmir");
        cities.add("Ankara");
        cities.add("Istanbul");

        //read by using iterator
        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //read by using foreach
        for (String city:cities){
            System.out.println(city);
        }

        //add beginning - end
        cities.addFirst("Berlin");
        cities.addLast("Krakov");

        //remove beginning - end
        cities.removeFirst();
        cities.removeLast();

        //get wit index
        cities.get(1);

        cities.forEach(System.out::println);
    }
}
