package lzhang.leetcode;

import org.junit.Test;

public class EightyFiveTest {
  @Test
  public void test(){
    EightyFive inst=new EightyFive();
    char[][] matric={
        {0,0,1,0},
        {0,0,0,1},
        {0,1,1,1},
        {0,0,1,1}
    };
    System.out.println(inst.maximalRectangle(matric));
  }
}
