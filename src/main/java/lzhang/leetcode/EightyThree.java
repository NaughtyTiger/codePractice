package lzhang.leetcode;

public class EightyThree {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode fakeHead=new ListNode(0);
    fakeHead.next=head;
    ListNode p=fakeHead;
    while (p!=null && p.next!=null && p.next.next!=null){
      if (p.next.val==p.next.next.val){
        p.next=p.next.next;
      } else {
        p=p.next;
      }
    }
    return fakeHead.next;
  }
}
