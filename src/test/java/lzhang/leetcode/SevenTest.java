package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SevenTest {
  @Test
  public void test(){
    Seven inst=new Seven();
//    System.out.println(Integer.MAX_VALUE);//2147483647
    assertEquals(-321,inst.reverse(-123));
    assertEquals(1321,inst.reverse(1231));
    assertEquals(2147483641,inst.reverse(1463847412));
    assertEquals(0,inst.reverse(1534236469));
  }
}
