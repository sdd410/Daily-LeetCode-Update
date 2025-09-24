/*
141. Linked List Cycle

Given the head of a linked list, check if it contains a cycle (a node that can be reached again by following next).

Return:

true → if a cycle exists

false → otherwise
* */

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
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastPointer = head;
        while (fastPointer.next != null
                && fastPointer.next.next != null) {
            head = head.next;
            fastPointer = fastPointer.next.next;
            if (head == fastPointer) {
                return true;
            }
        }
        return false;
    }
}