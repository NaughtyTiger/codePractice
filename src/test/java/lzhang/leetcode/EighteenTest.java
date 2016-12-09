package lzhang.leetcode;

import java.util.List;

import org.junit.Test;

public class EighteenTest {
  @Test
  public void test(){
    Eighteen inst=new Eighteen();
    for (List<Integer> tmp: inst.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)){
      System.out.println(tmp);
    }
  }
}
