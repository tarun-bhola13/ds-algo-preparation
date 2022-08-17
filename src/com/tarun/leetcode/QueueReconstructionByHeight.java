package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    // #leetcode - 406
    public static void main(String[] args) {
        int[][] people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        int[][] result = reconstructQueue(people);
        for(int[] res : result){
            System.out.println(res[0]+","+res[1]);
        }
    }

    private static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0] != b[0]){
                return b[0]-a[0];
            }else{
                return a[1]-b[1];
            }
        });
        List<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < people.length ; i++){
            list.add(people[i][1],people[i]);
        }
        return list.toArray(people);
    }
}
