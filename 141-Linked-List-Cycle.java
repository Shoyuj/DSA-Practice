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
        ListNode slo= head;
        ListNode fast= head;

        if(head== null || head.next==null)
        return false;

        while (fast != null && fast.next != null) {
    slo = slo.next;
    fast = fast.next.next;

    if (slo == fast)
        return true;
    }

    return false;

    }
}