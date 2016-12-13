package lzhang.leetcode;

public class Nineteen {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode before=head;
    ListNode after=head;
    for (int i=0; i<n; i++){
      after=after.next;
    }
    if (after==null){
      return head.next;
    }
    while (after.next!=null){
      after=after.next;
      before=before.next;
    }
    before.next=before.next.next;
    return head;
  }

  private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}

