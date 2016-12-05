package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThirteenTest {
  @Test
  public void test(){
    Thirteen inst=new Thirteen();
    assertEquals(1,inst.romanToInt("I"));
    assertEquals(1001,inst.romanToInt("MI"));
    assertEquals(621,inst.romanToInt("DCXXI"));
  }
}
