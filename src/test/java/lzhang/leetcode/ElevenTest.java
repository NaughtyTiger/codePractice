package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ElevenTest {
  @Test
  public void test(){
    Eleven inst=new Eleven();
    assertEquals(2, inst.maxArea(new int[]{1,1,1}));
    assertEquals(4, inst.maxArea(new int[]{1, 2, 4, 3}));
  }
}
