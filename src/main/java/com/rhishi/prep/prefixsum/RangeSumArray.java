package main.java.com.rhishi.prep.prefixsum;

public class RangeSumArray {

    private final int[] prefixSum;

    public RangeSumArray(int[] arr) {
        prefixSum = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
    }

    public int getRangeSum(int left, int right) {
        if (left < 0 || right >= prefixSum.length - 1 || left > right) {
            throw new IllegalArgumentException("Invalid range");
        }

        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 4, 5, 1, 4};

        RangeSumArray rangeSumArray = new RangeSumArray(input);

        System.out.println(rangeSumArray.getRangeSum(1, 3));
        System.out.println(rangeSumArray.getRangeSum(0, 5));
    }
}




