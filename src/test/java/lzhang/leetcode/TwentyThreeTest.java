package lzhang.leetcode;

import org.junit.Test;

public class TwentyThreeTest {
  @Test
  public void test(){
    TwentyThree inst=new TwentyThree();
    ListNode[] abc=new ListNode[2];
    abc[0]=null;
    abc[1]=new ListNode(1);
    System.out.println(inst.mergeKLists(abc));
  }
}
