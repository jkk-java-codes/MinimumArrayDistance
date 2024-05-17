package com.cgi.mimimumarraydistance;

import java.util.Arrays;

public class MinimumArrayDistance {

  public static int findMinimumCount(int[] arr) {
    if (arr == null || arr.length < 2) {
      return -1;
    }

    // Sort the array first
    Arrays.sort(arr);

    // Minimum distance btw element using streams
    long minDist = Arrays.stream(arr, 1, arr.length)
        .mapToLong(i -> {
          int index = Arrays.binarySearch(arr, i);
          return (long) arr[index] - (long) arr[index - 1] - 1;
        })
        .min()
        .orElse(Long.MAX_VALUE);

    // handling duplicates or consecutive numbers
    if (minDist < 0) {
      return 0;
    }

    // Handle distance conversion regarding large values resulting possible overflow
    if (minDist > Integer.MAX_VALUE) {
      throw new ArithmeticException("Distance calculation out of int range.");
    }

    return (int) minDist;
  }

  public static void main(String[] args) {
    int[] numbers = { 1, 32, 100 };
    int minimumCount = findMinimumCount(numbers);
    System.out.println("Minimum number count: " + minimumCount);
  }
}