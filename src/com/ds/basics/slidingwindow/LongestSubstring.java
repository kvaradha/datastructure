package com.ds.basics.slidingwindow;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Code No: 3 - Longest Substring Without Repeating Characters
 *
 * @author Karthikeyan
 */
public class LongestSubstring {

    /**
     * Longest Substring Without Repeating Characters
     *
     * @param str String
     * @return int
     */
    public static int longSubStr(String str) {
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> visited = new HashMap<>();
        for(int right =0; right < str.length(); right++) {
            //Check the new element is in the map.
            if(visited.containsKey(str.charAt(right))) {
                //If yes assign get the old index and assign it to left.
                //If only if greater than left.
                left = Math.max(left, visited.get(str.charAt(right)) + 1);
            }
            // Always update the right index.
            // If it is already present, overwrite with new index.
            visited.put(str.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * Longest Substring Without Repeating Characters With Path
     *
     * @param str String
     * @return String
     */
    public static String longSubStrPath(String str) {
        int left=0;
        int []ans = new int[]{-1,-1,-1};
        int max = 0;
        HashMap<Character, Integer> visited = new LinkedHashMap<>();
        for(int right=0; right<str.length(); right++) {
            Character c = str.charAt(right);
            if(visited.containsKey(c)) {
                left = Math.max(left, visited.get(c) + 1);
            }
            //updated visited with new index, if it is already present.
            visited.put(c, right);
            max = Math.max(max, right-left+1);
            if(ans[2] < max) {
                ans[0] = left;
                ans[1] = right;
                ans[2] = max;
            }
        }
        return ans[2] == -1 ? "" : new String(str.toCharArray(), ans[0], ans[2]);
    }

    public static void main(String []args) {
        String str = "abcabcdbb";
        System.out.println(longSubStr(str));
        System.out.println(longSubStrPath(str));
    }
}
