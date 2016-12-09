package lzhang.leetcode;

import org.junit.Test;

public class SeventeenTest {
  @Test
  public void test(){
    Seventeen inst=new Seventeen();
    for (String tmp:inst.letterCombinations("23")){
      System.out.println(tmp);
    }
  }
}
