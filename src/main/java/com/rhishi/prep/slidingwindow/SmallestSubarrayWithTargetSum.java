package main.java.com.rhishi.prep.slidingwindow;

public class SmallestSubarrayWithTargetSum {

    public static void main(String[] args) {
        int[] arr = {1,1,1,6, 1, 7, 2, 8, 9, 8, 5};
        System.out.println(smallestSubarrayLength(arr, 3));
    }

    public static int smallestSubarrayLength(int[] arr, int target) {
        int windowStart = 0;
        int windowSum = 0;
        int smallestLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= target) {
                smallestLength = Math.min(
                        smallestLength,
                        windowEnd - windowStart + 1
                );

                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return smallestLength == Integer.MAX_VALUE ? 0 : smallestLength;
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