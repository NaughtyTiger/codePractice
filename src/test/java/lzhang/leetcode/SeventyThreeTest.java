package lzhang.leetcode;

import org.junit.Test;

public class SeventyThreeTest {
  @Test
  public void test(){
    SeventyThree inst=new SeventyThree();
    int[][] sample={{0,0,0,5},{4,3,1,4},{0, 1,1,4},{1,2,1,3},{0,0,1,1}};
    System.out.println(sample);
    inst.setZeroes(sample);
    System.out.println(sample);
  }
}
