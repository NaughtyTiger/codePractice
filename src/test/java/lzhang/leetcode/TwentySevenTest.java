package lzhang.leetcode;

import org.junit.Test;

public class TwentySevenTest {
  @Test
  public void test(){
    TwentySeven inst=new TwentySeven();
    int[] nums=new int[]{3,2,2,3};
    System.out.println(inst.removeElement(nums, 3));
    for (int i=0;i<nums.length;i++){
      System.out.println(nums[i]);
    }
  }
}
