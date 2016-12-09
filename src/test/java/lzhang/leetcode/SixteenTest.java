package lzhang.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SixteenTest {
  @Test
  public void test(){
    Sixteen inst=new Sixteen();
    assertEquals(2, inst.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    assertEquals(0, inst.threeSumClosest(new int[]{0, 0, 0, 0}, 1));
  }
}
