package lzhang.leetcode;

import org.junit.Test;

public class EightyThreeTest {
  @Test
  public void test(){
    EightyThree inst=new EightyThree();
    ListNode head=new ListNode(1);
    ListNode two=new ListNode(2);
    ListNode three=new ListNode(3);
    ListNode four=new ListNode(3);
    ListNode five=new ListNode(4);
    ListNode six=new ListNode(4);
    ListNode seven=new ListNode(5);
    
    head.next=two;
    two.next=three;
    three.next=four;
    four.next=five;
    five.next=six;
    six.next=seven;
    System.out.println(inst.deleteDuplicates(head));
  }
}
