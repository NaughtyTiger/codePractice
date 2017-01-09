package lzhang.leetcode;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class TwentyThree {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length==0){
      return null;
    }
    if (lists.length==1){
      return lists[0];
    }
    if (lists.length==2){
      return mergeTwoLists(lists[0], lists[1]);
    }
    while(true){
      if (lists.length==1){
        return lists[0];
      }
      ListNode[] newList=new ListNode[(lists.length+1)/2];
      int i=0;
      System.out.println(lists.length);
      for (;i<lists.length/2;i++){
        ListNode first=lists[i*2];
        ListNode second=lists[i*2+1];
        newList[i]=mergeTwoLists(first, second);
      }
      if (lists.length%2==1){
        newList[i]=lists[2*i];
      }
      lists=newList;
    }
  }
  
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummyHead=new ListNode(0);
    ListNode p=dummyHead;
    while (l1!=null || l2!=null){
      if (l1==null){
        p.next=l2;
        break;
      }
      if (l2==null){
        p.next=l1;
        break;
      }
      if (l1.val<l2.val){
        p.next=l1;
        p=l1;
        l1=l1.next;
      } else {
        p.next=l2;
        p=l2;
        l2=l2.next;
      }
    }
    return dummyHead.next;
  }
}
