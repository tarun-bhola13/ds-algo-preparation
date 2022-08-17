package com.tarun.leetcode;

import java.util.*;

public class InsertDeleteGetRandom {

    // leetcode 380

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(10));
        System.out.println(set.delete(15));
        System.out.println(set.getRandom());
        System.out.println(set.insert(15));
        System.out.println(set.delete(10));
        System.out.println(set.getRandom());
        System.out.println(set.insert(20));
        System.out.println(set.getRandom());
        System.out.println(set.insert(30));
        System.out.println(set.delete(10));
        System.out.println(set.getRandom());
    }

    public static class RandomizedSet{

        List<Integer> lists;
        Map<Integer,Integer> map ;
        Random random;
        RandomizedSet(){
            lists = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int element){

            if (!map.containsKey(element)){
                lists.add(element);
                map.put(element,lists.size()-1);
                return true;
            }
            return false;
        }

        public boolean delete(int element){
            if (map.containsKey(element)){

                int value = lists.get(lists.size()-1);

                if (value == element){
                    lists.remove(lists.size()-1);
                    map.remove(value);
                    return true;
                }
                int index = map.get(element);
                lists.set(index,value);
                lists.remove(lists.size()-1);
                map.remove(element);
                map.put(value,index);
                return true;
            }

            return false;
        }

        public int getRandom(){

            int rand = random.nextInt(lists.size());
            return lists.get(rand);
        }





    }



}
