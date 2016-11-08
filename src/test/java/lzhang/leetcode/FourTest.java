package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FourTest {
  @Test
  public void test(){
    Four inst=new Four();
    assertEquals(2.0,inst.findMedianSortedArrays(
        new int[]{1,2},new int[]{3}),0.0001);
    assertEquals(2.0,inst.findMedianSortedArrays(
        new int[]{1,3},new int[]{2}),0.0001);
    assertEquals(3.0,inst.findMedianSortedArrays(
        new int[]{1,2},new int[]{3,4,5}),0.0001);
    assertEquals(2.0,inst.findMedianSortedArrays(
        new int[]{1,2},new int[]{1,2,3}),0.0001);
    assertEquals(2.0,inst.findMedianSortedArrays(
        new int[]{1,1,3,3},new int[]{1,1,3,3}),0.0001);
    assertEquals(1.0,inst.findMedianSortedArrays(
        new int[]{1,1},new int[]{1,1}),0.0001);
    assertEquals(2.5,inst.findMedianSortedArrays(
        new int[]{1,2},new int[]{3,4}),0.0001);
    assertEquals(5,inst.findMedianSortedArrays(
        new int[]{1,2,3,7,8,9},new int[]{4,5,6}),0.0001);
    assertEquals(5,inst.findMedianSortedArrays(
        new int[]{1,2,3,4,8,9},new int[]{5,6,7}),0.0001);
    assertEquals(4.5,inst.findMedianSortedArrays(
        new int[]{1,2,3,4,5},new int[]{7,8,9}),0.0001);
  }
}
