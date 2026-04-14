/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode onept = head;
        ListNode twopt = head;
        
        
        while(onept!=null){
            
            if(onept.next!=null)
                onept = onept.next;
            else 
                return false;
            
            if(twopt.next!=null && twopt.next.next!=null)
                twopt = twopt.next.next; 
            else 
                return false;
            
            if(onept == twopt){
                return true;
            }
            
        }
        
        return false;
    }
}