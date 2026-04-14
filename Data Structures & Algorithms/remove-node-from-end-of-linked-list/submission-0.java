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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //Can use 2 pointers as well. 
        // One will goto kth count from start
        //second will start from start and both will move together, so when 
        //first reaches the end, second would have reached length-n position.
        
        ListNode currNode = head;
        int index = 0;
        int length = 0;
        
        while(currNode !=null){
            
            currNode = currNode.next;
            length+=1;
        }
        
        index = length-n;
        int count =0;
        currNode = head;
        ListNode prev = null;
        
        while(count < index ){
            prev = currNode;
            currNode = currNode.next;   
            count++;
        }
        
        if(prev == null)
            return head.next;
        
        prev.next = currNode.next;
        
        return  head;
        
    }
}