package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EightTest {
  @Test
  public void test(){
    Eight inst=new Eight();
    assertEquals(12,inst.myAtoi("  0012a42"));
    assertEquals(-12,inst.myAtoi("  -0012a42"));
    assertEquals(1,inst.myAtoi("+1"));
    assertEquals(0,inst.myAtoi(""));
    assertEquals(0,inst.myAtoi("+-2"));
    assertEquals(2147483647,inst.myAtoi("2147483648"));
//    inst.myAtoi("  -0012a42");
  }
}
