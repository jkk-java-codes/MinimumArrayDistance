package com.cgi.mimimumarraydistance;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumArrayDistance {

  public static int findMinimumCount(int[] arr) {
    if (arr == null || arr.length < 2) {
      return -1;
    }

    Arrays.sort(arr);

    long minDist = IntStream.range(1, arr.length)
        .mapToLong(i -> {
          if (arr[i] == arr[i - 1]) {
            return 0;
          }
          return (long) arr[i] - (long) arr[i - 1] - 1;
        })
        .min()
        .orElse(Long.MAX_VALUE);

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