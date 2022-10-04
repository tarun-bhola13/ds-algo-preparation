package com.tarun.leetcode;

public class MinimumTimeToMakeRopeColorful {
    // #leetcode- 1578
    public static void main(String[] args) {
        String colors = "bbbaaa";
        int[] neededTime = {4,9,3,8,8,9};
        System.out.println(minCost(colors, neededTime));
    }

    private static int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        int index = 0;
        int size = colors.length();
        char[] charArray = colors.toCharArray();
        while (index < size) {
            char c = charArray[index];
            int endIndex = index+1;
            while (endIndex < size && charArray[endIndex] == c) {
                endIndex++;
            }
            if(endIndex-index > 1){
                minCost += getMinCostOfRemoval(neededTime,index,endIndex);
            }
            index = endIndex;
        }
        return minCost;
    }

    private static int getMinCostOfRemoval(int[] neededTime, int startIndex, int endIndex) {

        int sum = 0;
        int max = 0;
        for(int i = startIndex; i < endIndex ; i++){
            sum += neededTime[i];
            max = Math.max(max,neededTime[i]);
        }
        return sum - max;
    }
}
