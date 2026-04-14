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
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode current = head;
        ListNode next = current.next;
        ListNode prev = null;

        while(current.next != null ){
            
            current.next = prev;

            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
                    
        return current;
    }
}