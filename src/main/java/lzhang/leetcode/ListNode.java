package lzhang.leetcode;

public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
  public String toString(){
    return val+" "+(next==null?"":next.toString());
  }
}
