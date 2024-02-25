class Solution {
    /**
     * This solution is 3ms, 81.52% faster, and 62.03% less memory usage
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode head = res;

        while (l1 != null || l2 != null) {

            int sum = 0;

            if (l1 == null) {
                sum = l2.val + res.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + res.val;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + res.val;
                l2 = l2.next;
                l1 = l1.next;
            }

            if (sum >= 10) {
                sum -= 10;
                res.val = sum;
                res.next = new ListNode(1);
            } else {
                res.val = sum;
                if (l1 != null || l2 != null) {
                    res.next = new ListNode(0);
                }
            }

            res = res.next;
        }

        return head;
    }
}