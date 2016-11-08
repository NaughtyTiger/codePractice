package lzhang.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SixTest {
  @Test
  public void test(){
    Six inst=new Six();
    assertEquals("PAHNAPLSIIGYIR",inst.convert("PAYPALISHIRING", 3));
  }
}
