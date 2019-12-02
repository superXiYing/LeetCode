package list;

/*Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL*/
public class ReverseList {
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode prev = null;
		ListNode current = head;
		ListNode nextTemp;
	
		while(current != null){
		  nextTemp = current.next;
		  current.next = prev;
		  prev = current;
		  current = nextTemp;
		}
	   
		return prev;
	}
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3; n3.next = n4; n4.next = n5;
		common.Util.printWholeList(reverseList(n1));
		
	}

}
