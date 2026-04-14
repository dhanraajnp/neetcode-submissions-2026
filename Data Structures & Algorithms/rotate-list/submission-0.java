class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: find length and tail
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: normalize k
        k = k % len;
        if (k == 0) return head;

        // Step 3: make it circular
        tail.next = head;

        // Step 4: find new tail
        int stepsToNewTail = len - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
