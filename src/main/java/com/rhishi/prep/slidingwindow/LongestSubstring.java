package main.java.com.rhishi.prep.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        String input = "aaabcdpqrst";
        System.out.println(lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);
            while(set.contains(currentChar)) {
                set.remove(s.charAt(windowStart));
                windowStart ++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}