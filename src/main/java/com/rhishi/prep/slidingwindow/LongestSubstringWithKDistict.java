package main.java.com.rhishi.prep.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKDistict {

    public static void main(String[] args) {
        String input = "ceceedfrfrfr";
        System.out.println(longestSubstringWithKDistinct(input, 2));
    }

    public static int longestSubstringWithKDistinct(String s, int k) {
        int windowStart = 0;
        int longestSubstringSize = 0;
        Map<Character, Integer> charToCount = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            // Expand
            charToCount.put(
                    currentChar,
                    charToCount.getOrDefault(currentChar, 0) + 1
            );

            // Shrink while invalid
            while (charToCount.size() > k) {
                char leftChar = s.charAt(windowStart);
                charToCount.put(leftChar, charToCount.get(leftChar) - 1);
                if (charToCount.get(leftChar) == 0) {
                    charToCount.remove(leftChar);
                }
                windowStart++;
            }

            // Process valid window
            longestSubstringSize = Math.max(
                    longestSubstringSize,
                    windowEnd - windowStart + 1
            );
        }

        return longestSubstringSize;
    }
}