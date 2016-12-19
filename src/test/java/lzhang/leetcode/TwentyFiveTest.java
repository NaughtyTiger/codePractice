package lzhang.leetcode;

import org.junit.Test;

public class TwentyFiveTest {
  @Test
  public void test(){
    TwentyFive inst=new TwentyFive();
    ListNode head=new ListNode(1);
    ListNode two=new ListNode(2);
    ListNode three=new ListNode(3);
    ListNode four=new ListNode(4);
    ListNode five=new ListNode(5);
    
    head.next=two;
    two.next=three;
    three.next=four;
    four.next=five;
    System.out.println(inst.reverseKGroup(head, 3));
  } 
}
