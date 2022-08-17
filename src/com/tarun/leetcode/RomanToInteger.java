package com.tarun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // #leetcode - 13

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    private static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans = 0;
        char[] chars = s.toCharArray();
        for(int i =0; i < s.length();i++){
            char c = chars[i];
            ans += map.get(c);

            if((c == 'V' || c == 'X') && (i -1)>= 0 && chars[i-1] == 'I'){
                ans = ans - 2 * map.get('I');
            }else if((c == 'L' || c == 'C') && (i -1)>= 0 && chars[i-1] == 'X'){
                ans = ans - 2 * map.get('X');
            }else if((c == 'D' || c == 'M') && (i -1)>= 0 && chars[i-1] == 'C'){
                ans = ans - 2 * map.get('C');
            }
        }
            return ans;
    }
}
