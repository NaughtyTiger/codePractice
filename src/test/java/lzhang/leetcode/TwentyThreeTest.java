package lzhang.leetcode;

import org.junit.Test;

public class TwentyThreeTest {
  @Test
  public void test(){
    TwentyThree inst=new TwentyThree();
    ListNode[] abc=new ListNode[3];
    abc[0]=new ListNode(5);
    abc[1]=null;
    abc[2]=new ListNode(1);
    System.out.println(inst.mergeKLists(abc));
  }
}
