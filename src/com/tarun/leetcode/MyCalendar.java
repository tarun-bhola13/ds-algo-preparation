package com.tarun.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    // #leetcode - 729
    TreeMap<Integer,Integer> map ;
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(5,10));
        System.out.println(calendar.book(10,15));
        System.out.println(calendar.book(12,20));
        System.out.println(calendar.book(16,20));

    }

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        if(map.floorEntry(start) != null && start < map.floorEntry(start).getValue()){
            return false;
        }
        if(map.ceilingEntry(start) != null && end > map.ceilingEntry(start).getKey()){
            return false;
        }
        map.put(start,end);
        return true;
    }

}
