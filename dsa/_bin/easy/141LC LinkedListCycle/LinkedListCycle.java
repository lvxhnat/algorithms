import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> store = new HashMap<>();

        while (head != null) {
            int accumulator = 0;
            if (store.containsKey(head)) {
                return true;
            }
            store.put(head, accumulator);
            head = head.next;
        }
        return false;
    }
}