package list;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 **
 * Input: 
 * 1->2->4, 
 * 1->3->4 
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoLists {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;

		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(4);
		m1.next = m2;
		m2.next = m3;
		m3.next = null;

		printList(mergeTwoLists(n1, m1));

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;

		ListNode start = new ListNode(0);
		ListNode current = start;

		// find the next element
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}

			current = current.next;

		}

		// Add remaining elements of l1 at end of current
		if (l1 != null) {
			current.next = l1;
		}

		// Add remaining elements of l2 at end of current if it's not null
		if (l2 != null) {
			current.next = l2;
		}

		return start.next;
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}
}
