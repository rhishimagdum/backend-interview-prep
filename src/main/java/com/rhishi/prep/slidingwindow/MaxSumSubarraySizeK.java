package main.java.com.rhishi.prep.slidingwindow;

public class MaxSumSubarraySizeK {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 7, 2, 8};
        System.out.println(maxSum(arr, 2));
    }

    public static int maxSum(int[] arr, int k) {
        int windowStart = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd - windowStart + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);

                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }
}



/*


arr = [2, 1, 5, 1, 3, 2]
k = 3

2
windowSum = 2

2,1
windowSum=3

2,1,5
windowSum=8
maxSum=8

Shrink
1,5
windowSum=8-2=6

expand
1,5,1
windowSum=7
maxSum=8

5,1
windowSum=6

5,1,3
windowSum=9
maxSum=8

1,3
windowSum=4

1,3,2
windowSum=6
maxSum=8





 */