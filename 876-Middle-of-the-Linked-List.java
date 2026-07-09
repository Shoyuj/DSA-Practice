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
        
        ListNode node = head;
        ListNode mn = head;
        int c=0;

        while(node!=null)
        {
            if(node.next==null)
            return mn;
            
            mn=mn.next;
            node = node.next.next;
        }
        return mn;
    }
}