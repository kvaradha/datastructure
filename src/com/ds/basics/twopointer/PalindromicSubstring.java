package com.ds.basics.twopointer;

/**
 * Palindromic Substring.
 * Count total number of palindromes
 *
 * @author Karthikeyan
 */
public class PalindromicSubstring {

    /**
     * Count Palindrome.
     *
     * @param str char[]
     * @return int
     */
    public static int countPalindrome(char []str) {
        if(str == null) {
            return 0;
        }
        int countPalindrome = 0;
        for(int i=0; i<str.length; i++) {
            countPalindrome += expandFromCenter(str, i, i);
            countPalindrome += expandFromCenter(str, i, i+1);
        }
        return countPalindrome;
    }

    /**
     * Expand From Center.
     *
     * @param str char[]
     * @param left int
     * @param right int
     * @return int
     */
    public static int expandFromCenter(char []str, int left, int right) {
        int count = 0;
        while(left >= 0 && right < str.length && str[left] == str[right]) {
            int len = (right-left) + 1;
            if(len > 1) {
                System.out.println(new String(str, left, (right - left) + 1));
            }
            count ++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String []args) {
        String a = "babad";
        System.out.println(countPalindrome(a.toCharArray()));
        String b = "abracecarz";
        System.out.println(countPalindrome(b.toCharArray())); // Safely prints "bb"
    }
}
