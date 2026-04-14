/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        //HINT ::
        /**
        * Find the mid point using 2 pointers
        * Take second half of the list and reverse it
        * then inject the reversed list with the first half
        **/
        
        ListNode lastItem = null;
        ListNode temp = head;
        ListNode slow = temp;
        ListNode fast = temp.next;
        
		// This is used to calculate mid points of list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode current = slow.next;
        slow.next = null;
        ListNode prev = null;
        
		// Reverse the second half of the list
        while(current != null){
            ListNode temp1 = current.next;
            current.next = prev;
            prev = current;
            current = temp1;
        }
        
        temp = head;
        ListNode temp3 = new ListNode(0);
		
		//Inject reverse half of list in first half and assign it to new linkedlist temp3
        while(temp != null || prev != null){
            
            if(temp != null){
                 temp3.next = temp;
                 temp = temp.next;
                 temp3 = temp3.next;
            }
            
            if(prev != null){
                 temp3.next = prev;
                 prev = prev.next;
                 temp3 = temp3.next;
            }
        }
		// assign back the new list temp3 back to head
            head = temp3;
    }
}