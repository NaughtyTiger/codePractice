/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  if (head===null){
  	return null;
  }  
  if (head.next===null){
  	return head;
  }
  var dummyHead=new ListNode(0);
  dummyHead.next=head;
  var before=dummyHead;
  var first=head;
  var second=head.next;

  while (true){
  	before.next=second;
  	first.next=second.next;
  	second.next=first;

  	if (first.next===null || first.next.next===null){
  		return dummyHead.next;
  	}
  	before=first;
  	second=first.next.next;
  	first=first.next;
  }
};