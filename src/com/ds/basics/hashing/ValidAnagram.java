package com.ds.basics.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Code No: 242 Valid Anagram
 *
 * @author Karthikeyan.
 */
public class ValidAnagram {

    /**
     * Is Anagram
     * @param s String
     * @param t String
     * @return boolean
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if(charCount.get(c) == null) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return charCount.keySet().stream().noneMatch(e -> charCount.get(e) != 0);
    }

    public static void main(String []args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
        s="rat";
        t="car";
        System.out.println(isAnagram(s,t));
    }
}
