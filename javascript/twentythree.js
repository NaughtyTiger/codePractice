/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
	if (lists.length===0){
		return null;
	}
	if (lists.length===1){
		return lists[0];
	}
	while (lists.length>1){
		var newlists=[];
		for (var i=0; i<Math.floor(lists.length/2); i++){
			var first=lists[i*2];
			var second=lists[i*2+1];
			newlists[i]=mergeTwoLists(first, second);
		}
		if (lists.length%2===1){
			newlists[i]=lists[2*i];
		}
		lists=newlists;
	}
	return lists[0];
};

var mergeTwoLists=function(l1, l2){
	var dummyHead=new ListNode(0);
	var p=dummyHead;
	while (l1!==null || l2!==null){
		if (l1===null){
			p.next=l2;
			break;
		}
		if (l2===null){
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
};