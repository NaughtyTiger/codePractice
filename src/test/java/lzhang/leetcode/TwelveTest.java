package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwelveTest {
  @Test
  public void test(){
    Twelve inst=new Twelve();
    assertEquals("MCMLXXX", inst.intToRoman(1980));
    assertEquals("I", inst.intToRoman(1));
  }
}
