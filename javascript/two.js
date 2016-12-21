/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}

var addTwoNumbers = function(l1, l2) {
	if (l1===null || l2===null){
		return l1 || l2;
	}

	var dummyHead=new ListNode(0);
	var cursor=dummyHead;
	var carry=false;
	while (true){
		// console.log("l1 "+l1.val);
		// console.log("l2 "+l2.val);
		if(l1==null && l2==null){
			break;
		}
		var number=getNum(l1)+getNum(l2)+(carry?1:0);
		carry=number>=10;
		var tmpListNode=new ListNode(number%10);
		cursor.next=tmpListNode;
		cursor=tmpListNode;
		l1=getNext(l1);
		l2=getNext(l2);
	}
	if(carry){
		cursor.next=new ListNode(1);
	}
	return dummyHead.next;
};

function getNext(node){
	return node===null?null:node.next;
}

var getNum=function(node){
	if(node===null){
		return 0;
	} 
	return node.val;
}

var l1=new ListNode(2);
var p=l1;
p.next=new ListNode(4);
p=p.next;
p.next=new ListNode(3);

var l2=new ListNode(5);
p=l2;
p.next=new ListNode(6);
p=p.next;
p.next=new ListNode(4);

addTwoNumbers(l1, l2);