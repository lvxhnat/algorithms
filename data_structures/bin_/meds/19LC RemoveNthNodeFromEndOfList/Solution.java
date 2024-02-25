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
        if (head.next == null) return null;

        // Easiest way is to iterate over all of them, save into a list and refer back
        int listLength = getListNodeLength(head);
        
        if (listLength == n) {
            return head.next;
        }
        
        ListNode curr = head;
        n = n % listLength;
        
        for (int i = 0; i < listLength - n - 1; i++) {
           curr = curr.next;
        }
        if (!(curr.next == null)) {
            curr.next = curr.next.next;
        }
        
        return head;
    }

    public int getListNodeLength(ListNode head) {
        if (head == null) return 0;
        return 1 + getListNodeLength(head.next);
    }
}
