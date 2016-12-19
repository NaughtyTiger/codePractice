package lzhang.leetcode;

import org.junit.Test;

public class TwentyFourTest {
  @Test
  public void test(){
    TwentyFour inst=new TwentyFour();
    ListNode head=new ListNode(1);
    ListNode two=new ListNode(2);
    ListNode three=new ListNode(3);
    ListNode four=new ListNode(4);
    ListNode five=new ListNode(5);
    
    head.next=two;
    two.next=four;
    four.next=five;
    five.next=three;
    System.out.println(inst.swapPairs(head));
  }
}
