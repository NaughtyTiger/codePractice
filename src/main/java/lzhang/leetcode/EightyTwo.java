package lzhang.leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class EightyTwo {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode fakeHead=new ListNode(0);
    fakeHead.next=head;
    ListNode p=fakeHead;
    while (p!=null && p.next!=null && p.next.next!=null){
      if(p.next.val==p.next.next.val){
        while(p.next.next!=null && p.next.val==p.next.next.val){
          p.next.next=p.next.next.next;
        }
        p.next=p.next.next;
      } else {
        p=p.next;
      }
    }
    return fakeHead.next;
  }
}
