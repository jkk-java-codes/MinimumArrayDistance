package com.cgi.mimimumarraydistance;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MinimumArrayDistanceTest {

  @Test
  public void testMinDist() {
    int[] arr = { 1, 4, 10 };
    int minimumDistance = 2;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_NoGaps() {
    int[] arr = { 1, 2, 3 };
    int minimumDistance = 0;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_SameNumbers() {
    int[] arr = { 1, 1, 1 };
    int minimumDistance = 0;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_SameLengthGaps() {
    int[] arr = { 1, 3, 5 };
    int minimumDistance = 1;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_UnsortedArray() {
    int[] arr = { 10, 1, 4 };
    int minimumDistance = 2;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_SingleElement() {
    int[] arr = { 10 };
    int minimumDistance = -1;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_EmptyArray() {
    int[] arr = {};
    int minimumDistance = -1;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_One_Number() {
    int[] arr = { 1000 };
    int minimumDistance = -1;
    assertEquals(minimumDistance, MinimumArrayDistance.findMinimumCount(arr));
  }

  @Test
  public void testMinDist_max_integers_limitation() {
    int[] arr = { Integer.MIN_VALUE, Integer.MAX_VALUE };
    try {
      MinimumArrayDistance.findMinimumCount(arr);
    } catch (ArithmeticException e) {
      // Expected to catch the overflow issue
      assertEquals("Distance calculation out of int range.", e.getMessage());
    }

  }
}