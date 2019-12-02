package list;

import java.util.ArrayList;
import java.util.List;

public class isParlindrom {
	public static boolean isPalindrome(ListNode head) {
		//return true for null and only one node list
        if((head == null) ||(head.next == null))
            return true;
        
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            if(list.get(i).val != list.get(j).val)
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
	
	public static void main(String[] args){
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(0);
		n1.next = n2;
		System.out.println(isPalindrome(n1));
		
	}
}
