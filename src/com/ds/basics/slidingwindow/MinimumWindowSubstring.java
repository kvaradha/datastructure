package com.ds.basics.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Code No: 76 - Minimum Window Substring.
 *
 * @author Karthikeyan
 */
public class MinimumWindowSubstring {

    /**
     * Minimum Window Substring
     * @param s String
     * @param t String
     * @return String
     */
    public static String minWinSubString(String s, String t) {
        HashMap<Character, Integer> actualMap = new LinkedHashMap<>();
        for(Character c : t.toCharArray()) {
            actualMap.put(c, actualMap.getOrDefault(c, 0) + 1);
        }
        int left=0;
        int formed =0;
        int []ans = new int[]{-1, -1, Integer.MAX_VALUE};
        HashMap<Character, Integer> visited = new LinkedHashMap<>();
        for(int right = 0; right < s.length(); right++) {
            Character rc = s.charAt(right);
            // Add it whatever.
            visited.put(rc, visited.getOrDefault(rc, 0) + 1);
            if(actualMap.containsKey(rc)) {
                if(visited.get(rc).intValue() == actualMap.get(rc).intValue()) {
                    formed ++;
                }
            }

            while(left <= right && formed == actualMap.size()) {
                int len = right -left +1;
                if(len < ans[2]) {
                    ans[0] = left;
                    ans[1] = right;
                    ans[2] = len;
                }

                Character lc = s.charAt(left);
                // Subtract it whatever.
                visited.put(lc, visited.getOrDefault(lc, 0) - 1);
                if(actualMap.containsKey(lc)) {
                    if(visited.get(lc) < actualMap.get(lc)) {
                        formed --;
                    }
                }
                left++;
            }
        }
        return ans[2] == Integer.MAX_VALUE ? "" : new String(s.toCharArray(), ans[0], ans[2]);
    }

    /**
     * Minimum Window Substring Size
     * @param s String
     * @param t String
     * @return String
     */
    public static int minWinSubStringSize(String s, String t) {
        HashMap<Character, Integer> actualMap = new LinkedHashMap<>();
        for(Character c : t.toCharArray()) {
            actualMap.put(c, actualMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> visited = new LinkedHashMap<>();
        int formed = 0;
        int left=0;
        int min=Integer.MAX_VALUE;
        for(int right=0; right < s.length(); right++) {
            Character c = s.charAt(right);
            visited.put(c, visited.getOrDefault(c, 0) + 1);
            if(actualMap.containsKey(c)) {
                if (actualMap.get(c).intValue() == visited.get(c).intValue()) {
                    formed++;
                }
            }

            while(left <= right && formed == actualMap.size()) {
                min = Math.min(min, right - left+1);
                Character cl = s.charAt(left);
                visited.put(cl, visited.get(cl) - 1);
                if(actualMap.containsKey(cl)) {
                    if (visited.get(cl) < actualMap.get(cl)) {
                        formed--;
                    }
                }
                left++;
            }
        }
        return min;
    }

    public static void main(String []args) {
        String s = "ADOBECODEBANC";
        // Note this will repeat.
        String t = "ABC";

        System.out.println(minWinSubStringSize(s, t));

        System.out.println(minWinSubString(s, t));
    }
}
