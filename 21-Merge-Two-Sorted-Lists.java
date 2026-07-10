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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode();
        ListNode dummy=res;

        if(l1==null && l2 == null)
        return null;

        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                dummy.next=new ListNode(l1.val);
                l1=l1.next;
                dummy=dummy.next;
            }
            else
            {
                dummy.next = new ListNode(l2.val);
                l2=l2.next;
                dummy=dummy.next;
            }
        }

        if(l1==null)
        dummy.next=l2;

        if(l2== null)
        dummy.next=l1;


        return res.next;
    }
}