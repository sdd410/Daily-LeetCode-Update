/*
* 142. Linked List Cycle II

Given the head of a linked list, return the node where the cycle begins.
If no cycle, return null.

A cycle exists if a node can be revisited by following next.

pos (not given as input) indicates where tail connects; -1 means no cycle.

Do not modify the list.*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycleWithList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        List<ListNode> cycleList = new ArrayList<>();
        while (head.next != null) {
            cycleList.add(head);
            head = head.next;
            if (cycleList.contains(head)) {
                return head;
            }
        }
        return null;
    }
}