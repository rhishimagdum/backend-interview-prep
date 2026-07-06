package main.java.com.rhishi.prep.hashmap;

import java.util.*;

public class TwoNumberSum {

    public static void main(String[] args) {
        int[] numbers = {3, 2, 5, 6};
        int target = 5;

        getSumPair(numbers, target);
    }

    public static void getSumPair(int[] numbers, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int pair = target - numbers[i];

            if (numberToIndex.containsKey(pair)) {
                System.out.println(
                        "Pair found at indexes: "
                                + numberToIndex.get(pair)
                                + " and "
                                + i
                );
                return;
            }

            numberToIndex.put(numbers[i], i);
        }

        System.out.println("Pair not found");
    }
}