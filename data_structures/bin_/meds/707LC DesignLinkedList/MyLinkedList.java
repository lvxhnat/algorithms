class MyLinkedList {

    /**
     * Runtime: 9 ms, faster than 91.36% of Java online submissions for Design
     * Linked List.
     * Memory Usage: 43 MB, less than 86.90% of Java online submissions for Design
     * Linked List.
     */

    Node head;

    public MyLinkedList() {
        this.head = null;
    }

    public int get(int index) {

        Node currentNode = head;

        if (index == 0) {
            if (head == null) {
                return -1;
            }
            return head.val;
        }

        for (int i = 0; i < index; i++) {
            if (currentNode == null || currentNode.next == null) {
                return -1;
            }
            currentNode = currentNode.next;
        }

        return currentNode.val;
    }

    public void addAtHead(int val) {

        Node node = new Node(val);

        if (head == null) {
            head = node;
            return;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void addAtTail(int val) {

        Node node = new Node(val);
        Node currentNode = head;

        if (currentNode == null) {
            head = node;
            return;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            return;
        }
    }

    public void addAtIndex(int index, int val) {
        // [0, 1, 2]
        // Add at index 2 : [0, 1, 3, 2]

        Node node = new Node(val);
        Node currentNode = head;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return;
        }

        node.next = currentNode.next;
        currentNode.next = node;

        return;
    }

    public void deleteAtIndex(int index) {

        // [0, 1, 2]
        // Delete at index 1 [0, 1, 2]

        Node currentNode = head;

        if (index == 0) {
            head = head.next;
            return;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                return;
            }
            if (currentNode.next != null) {
                currentNode.next = currentNode.next.next;
            }
            return;
        }
    }

    public String toString() {
        Node currentNode = head;
        String o = "[";
        while (currentNode != null) {
            if (currentNode.next == null) {
                o += currentNode.val;
            } else {
                o += currentNode.val + ", ";
            }
            currentNode = currentNode.next;
        }
        return o + "]";
    }
}

class Node {

    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */