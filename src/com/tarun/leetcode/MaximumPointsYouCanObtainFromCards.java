package com.tarun.leetcode;

public class MaximumPointsYouCanObtainFromCards {
    // #leetcode - 1423
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    private static int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += cardPoints[i];
        }
        int startIndex = k - 1, endIndex = cardPoints.length - 1;
        int currentSum = maxSum;
        while (startIndex >= 0 && endIndex >= cardPoints.length-k) {
            currentSum = currentSum - cardPoints[startIndex] + cardPoints[endIndex];
            maxSum = Math.max(maxSum, currentSum);
            startIndex--;
            endIndex--;
        }
        return maxSum;
    }
}
