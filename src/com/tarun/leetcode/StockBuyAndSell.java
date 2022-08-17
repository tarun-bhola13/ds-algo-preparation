package com.tarun.leetcode;

public class StockBuyAndSell {
    //leetcode 121 & 122

    public static void main(String[] args) {

        int[] stockPrices = {3,5,1,7,4,9,3};

        int maxProfit = findMaxProfitInSingleTransaction(stockPrices);
        System.out.println("Max Profit obtained with single transaction : "+maxProfit);
        maxProfit = findMaxProfitInMultipleTransactions(stockPrices);
        System.out.println("Max Profit with infinite transaction is : "+maxProfit );
    }

    private static int findMaxProfitInMultipleTransactions(int[] stockPrices) {
        // TC = O(N) SC = O(1)
        int maxProfit = 0;
        for (int i = 1 ; i < stockPrices.length ; i++){

            if (stockPrices[i] > stockPrices[i-1]) {
                maxProfit += stockPrices[i] - stockPrices[i - 1];
            }

        }
        return maxProfit;
    }

    private static int findMaxProfitInSingleTransaction(int[] stockPrices) {
        // TC = O(N) SC = O(1)

        int minSoFar = stockPrices[0];
        int maxProfit = 0;

        for (int i = 1 ; i < stockPrices.length ; i++){

            minSoFar = Math.min(minSoFar,stockPrices[i]);
            int profit = stockPrices[i]- minSoFar;
            maxProfit = Math.max(maxProfit,profit);

        }
        return maxProfit;
    }


}
