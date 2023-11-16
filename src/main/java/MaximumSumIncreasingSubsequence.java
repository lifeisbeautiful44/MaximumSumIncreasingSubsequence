package main.java;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public static int maxSumIncreasingSubsequence(int[] arr) {
        int length = arr.length;
        int[] maxSumEndingAtIndex = Arrays.copyOf(arr, length);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (isIncreasing(arr, i, j) && maxSumEndingAtIndex[i] < maxSumEndingAtIndex[j] + arr[i]) {
                    maxSumEndingAtIndex[i] = maxSumEndingAtIndex[j] + arr[i];
                }
            }
        }

        return Arrays.stream(maxSumEndingAtIndex).max().orElse(0);
    }

    private static boolean isIncreasing(int[] arr, int i, int j) {
        return arr[i] > arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        int result = maxSumIncreasingSubsequence(arr);
        System.out.println("Maximum Sum Increasing Subsequence: " + result);
    }
}
