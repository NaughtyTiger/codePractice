package lzhang.leetcode;

public class TwentyFour {
  public ListNode swapPairs(ListNode head) {
    if (head==null){
      return null;
    } 
    if (head.next==null){
      return head;
    }
    ListNode dummyHead=new ListNode(0);
    dummyHead.next=head;
    ListNode before=dummyHead;
    ListNode first=head;
    ListNode second=head.next;
    while (true){
      before.next=second;
      first.next=second.next;
      second.next=first;
      
      if (first.next==null || first.next.next==null){
        return dummyHead.next;
      }
      before=first;
      second=first.next.next;
      first=first.next;
    }
  }
}