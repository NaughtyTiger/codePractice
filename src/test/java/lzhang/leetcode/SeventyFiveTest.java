package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SeventyFiveTest {
  @Test
  public void test(){
    SeventyFive inst=new SeventyFive();

    {
      int[] nums={0};
      inst.sortColors(nums);
      assertEquals("[0]", Arrays.toString(nums));
    }
    {
      int[] nums={0,1,2,0,2,1,1,2,1,2};
      inst.sortColors(nums);
      assertEquals("[0, 0, 1, 1, 1, 1, 2, 2, 2, 2]", Arrays.toString(nums));
    }
    {
      int[] nums={0, 2, 0, 2};
      inst.sortColors(nums);
      assertEquals("[0, 0, 2, 2]", Arrays.toString(nums));
    }
    {
      int[] nums={1, 1, 1, 2, 0};
      inst.sortColors(nums);
      assertEquals("[0, 1, 1, 1, 2]", Arrays.toString(nums));
    }
    {
      int[] nums={2,2,0,0,2,0,2,1,0};
      inst.sortColors(nums);
      System.out.println(Arrays.toString(nums));
//      assertEquals("[0, 1, 1, 1, 2]", Arrays.toString(nums));
    }
    
    
  }
}
