/*
707. Design Linked List

Design a linked list with the following operations (0-indexed):

MyLinkedList() → Initialize the list.

int get(int index) → Return value at index, or -1 if invalid.

void addAtHead(int val) → Insert val at head.

void addAtTail(int val) → Append val at tail.

void addAtIndex(int index, int val) → Insert val before index. If index == size, append. If index > size, ignore.

void deleteAtIndex(int index) → Delete node at index if valid.

Constraints:

0 <= index, val <= 1000

≤ 2000 calls

Do not use built-in LinkedList.
*/

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class MyLinkedList {

    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        if (size == 0) {
            head = tail = new ListNode(val);
        } else {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            head = tail = new ListNode(val);
        } else {
            ListNode newTail = new ListNode(val);
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index == 0) {
            this.addAtHead(val);
            return;
        }

        if (size == index) {
            this.addAtTail(val);
            return;
        }

        ListNode newNode = new ListNode(val);
        int idx = 0;
        ListNode curr = head;
        while (curr.next != null && idx < index-1) {
            curr = curr.next;
            idx++;
        }
        ListNode shiftElement = curr.next;
        curr.next = newNode;
        newNode.next = shiftElement;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return;
        }
        ListNode curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
        if (index == size) {
            tail = curr;
        }
        return;
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