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
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        if (len % 2 == 0) {
            len = len / 2 - 1;
        } else {
            len = len / 2;
        }

        cur = head;
        while (len != 0) {
            cur = cur.next;
            len--;
        }
        ListNode nextHead = cur.next;
        cur.next = null;
        ListNode newHead = reverse(nextHead);

        while (head != null && newHead != null) {
            if (head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;

        return newHead;
    }
}