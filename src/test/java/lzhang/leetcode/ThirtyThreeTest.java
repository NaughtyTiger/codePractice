package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThirtyThreeTest {
  @Test
  public void test(){
    ThirtyThree inst=new ThirtyThree();
    int[] nums=new int[]{6,7,1,2,3,4,5};
    assertEquals(0,inst.search(nums, 6));
    assertEquals(1,inst.search(nums, 7));
    assertEquals(2,inst.search(nums, 1));
    assertEquals(3,inst.search(nums, 2));
    assertEquals(4,inst.search(nums, 3));
    assertEquals(5,inst.search(nums, 4));
    assertEquals(6,inst.search(nums, 5));
    assertEquals(-1,inst.search(nums, 10));
    assertEquals(-1,inst.search(nums, 0));
    
    nums=new int[]{3,1};
    assertEquals(1,inst.search(nums, 1));
  }
}
