/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */

var removeNthFromEnd = function(head, n) {
	var before=head; 
	var after=head;
	for (var i=0; i<n; i++){
		after=after.next;
	}

	if (after===null){
		return head.next;
	}

	while (after.next!==null){
		after=after.next;
		before=before.next;
	}
	before.next=before.next.next;
	return head;
};
