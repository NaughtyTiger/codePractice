package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiveteenTest {
  @Test
  public void test(){
    Fiveteen inst=new Fiveteen();
    
    assertEquals("[[-1, -1, 2], [-1, 0, 1]]", inst.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
    assertEquals("[[-2, 1, 1]]", inst.threeSum(new int[]{-3,7,-2,1,1,6}).toString());
    assertEquals("[[0, 0, 0]]", inst.threeSum(new int[]{-3, 0, 0, 0, 0, 6}).toString());
  }
}
