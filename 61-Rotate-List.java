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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        int n=1;
        if(head==null)
        return null;
        while(tail.next!=null)
        {
        tail=tail.next;
        n++;
        }

        k=k%n;

        tail.next=head;
        ListNode curr=head;

        for(int i=0;i<n-k-1;i++)
        {
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;

        return head;
    }
}