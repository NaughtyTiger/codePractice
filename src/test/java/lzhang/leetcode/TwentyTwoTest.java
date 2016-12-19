package lzhang.leetcode;

import org.junit.Test;

public class TwentyTwoTest {
  @Test
  public void test(){
    TwentyTwo inst=new TwentyTwo();
    for (String s:inst.generateParenthesis(3)){
      System.out.println(s);
    }
  }
}
