package com.tarun.leetcode;

public class Largest3SameDigitNumberInString {
    // #leetcode - 2264
    public static void main(String[] args) {

        String num = "2300019000";
        String goodInteger = largestGoodInteger(num);
        System.out.println(goodInteger);
    }

    private static String largestGoodInteger(String num) {
        int count = 0;
        String str = "";
        String maxString = "";
        char[] numArray = num.toCharArray();
        for(int i = 0 ; i < numArray.length ; i++){
            char c = numArray[i];
            if(i>= 1 && c == numArray[i-1]){
                count++;
                str = str+c;
                if(count == 3){
                    if(maxString == ""){
                        maxString = str;
                    }else if(Integer.valueOf(maxString) < Integer.valueOf(str)){
                        maxString = str;
                    }
                }
            }else{
                count = 1;
                str = ""+c;
            }
        }

        return maxString;
    }
}
