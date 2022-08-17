package com.tarun.general;

public class Arrays {

    // Moore's voting algo
    // Kadane's Algo
    // Preprocessing Array Problem(Rainwater storage)
    public static void main(String[] args) {

        int[] input = {1,2,4,1,5,1,1};
//        System.out.println(findElementWithFrequencyGreaterThanNBy2(input));

        int[] inputArray = {-5,-1,-2,-6};

//        for(int i :maxSumSubArray(inputArray)){
//            System.out.print(i+ " " );
//        }

        int[] buildings = {5,4,3,2,1,0,0};
        System.out.println(findRainwaterStorage(buildings));
        System.out.println(optimizeRainwaterStorage(buildings));
    }



    // Moore's voting algorithm
    static int findElementWithFrequencyGreaterThanNBy2(int[] input){
        int index = 0;
        int count = 1;

        for(int i = 1 ; i < input.length ; i++){

            if (input[index] == input[i]){
                count++;
            }else
                count--;

            if (count == 0){
                index = i;
                count = 1;
            }
        }
        int element = input[index];
        count = 0;
        for (int i : input){
            if (element == i){
                count++;
            }
        }

        return count > (input.length / 2) ? element: -1;
    }


    // Kadane's Algorithm

    static int[] maxSumSubArray(int[] input){

        int maxSum = 0;
        int startIndex = 0;
        int endIndex = -1;
        int currSum = 0;
        for (int i = 0 ; i < input.length ; i++){

            currSum = currSum + input[i];

            if (maxSum < currSum){
                maxSum = currSum;
                endIndex = i;
            }
            if (currSum < 0){
                currSum = 0;
                startIndex = i+1;

            }
        }

        if (startIndex > endIndex) {

            maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < input.length; i++) {
                if (input[i] > maxSum) {
                    maxSum = input[i];
                    startIndex = i;
                    endIndex = i;
                }
            }
        }
            int[] result = new int[endIndex - startIndex + 1];
            int j = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                result[j++] = input[i];
            }


        return result;
    }

    // Preprocessing Array Problem(Rainwater storage)

    static int findRainwaterStorage(int[] buildings){

        // using O(N) space & O(N) time
        int length = buildings.length;
        int[] leftMaxBuildings = new int[length];
        int leftIndex = 0;
        int[] rightMaxBuildings = new int[length];
        int rightIndex = length-1;

        for (int i = 0 ; i < length ; i++){
            if (buildings[i] > buildings[leftIndex]){
                leftIndex = i;
            }
            leftMaxBuildings[i] = buildings[leftIndex];
        }

        for (int i = length-1 ; i >= 0 ; i--){
            if (buildings[i] > buildings[rightIndex]){
                rightIndex = i;
            }
            rightMaxBuildings[i] = buildings[rightIndex];
        }

        int maxStorage = 0;

        for (int i = 0 ; i< length ; i++){

            maxStorage = maxStorage + Math.min(leftMaxBuildings[i],rightMaxBuildings[i]) - buildings[i];
        }

        return maxStorage;
    }

    static int optimizeRainwaterStorage(int[] buildings){

        int length = buildings.length;
        int left = 0;
        int right = length-1;
        int maxLeft = buildings[left];
        int maxRight = buildings[right];
        int waterStorage= 0;

        while(left < right){

            if (buildings[left] <= buildings[right]){
                left++;
                maxLeft = Integer.max(maxLeft,buildings[left]);
                waterStorage += maxLeft-buildings[left];
            }else {
                right--;
                maxRight = Integer.max(maxRight,buildings[right]);
                waterStorage += maxRight-buildings[right];
            }
        }

        return waterStorage;
    }

}
