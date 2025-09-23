/*
876. Middle of the Linked List

Given the head of a singly linked list, return its middle node.

If there are two middles, return the second one.

        Example 1:
Input: [1,2,3,4,5] → Output: [3,4,5]

Example 2:
Input: [1,2,3,4,5,6] → Output: [4,5,6]
*/

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
    public ListNode middleNode(ListNode head) {
        ListNode fastJump = head;
        if (head.next == null) {
            return head;
        }
        boolean flag = false;
        while (head.next != null && fastJump.next != null) {
            head = head.next;
            fastJump = fastJump.next.next;
            if (fastJump == null) {
                break;
            }
        }
        return head;
    }
}
