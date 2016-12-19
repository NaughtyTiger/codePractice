package lzhang.leetcode;

public class TwentyFive {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummyHead=new ListNode(0);
    dummyHead.next=head;

    ListNode before=dummyHead;
    ListNode[] lists=new ListNode[k];
    while (loadListNodes(lists, before)){
      ListNode tmp=lists[k-1];
      ListNode next=tmp.next;
      before.next=tmp;
      for (int i=lists.length-2; i>=0; i--){
        tmp.next=lists[i];
        tmp=tmp.next;
      }
      tmp.next=next;
      before=tmp;
    }
    return dummyHead.next;
  }
  
  private boolean loadListNodes(ListNode[] lists, ListNode before){
    ListNode p=before.next;
    for (int i=0; i<lists.length; i++){
      if (p==null){
        return false;
      }
      lists[i]=p;
      p=p.next;
    }
    return true;
  }
}
