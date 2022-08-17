package com.tarun.leetcode;

public class BackspaceStringCompare {
    // #leetcode 844

    public static void main(String[] args) {
        System.out.println(backSpaceCompare("ab##", "c#d#"));
    }

   static  boolean backSpaceCompare(String s, String t){
        s = removeBackSpaces(s);
        t = removeBackSpaces(t);
        int maxLength = 0;
        int sl = s.length();
        int tl = t.length();
        if(sl == tl){
           maxLength = sl;
        }else if(sl > tl){
            maxLength = sl;
        }else{
            maxLength = tl;
        }
        return s.equals(t);
    }

    private static String removeBackSpaces(String s) {
        int countHash = 0;
        String modifiedString = "";
        for(int i = s.length() -1 ; i >= 0 ; i--){
            if(s.charAt(i) != '#'){
                if(countHash == 0) {
                    modifiedString = s.charAt(i) + modifiedString;
                }else{
                    countHash--;
                }
            }else{
                countHash++;
            }
        }
        return modifiedString;
    }


}
