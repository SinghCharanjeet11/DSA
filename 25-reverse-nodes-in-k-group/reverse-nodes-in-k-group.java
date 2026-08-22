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
    public ListNode reverseKGroup(ListNode head, int k) {
        // This is to calculate the size ->

        ListNode result=new ListNode(-1);
        ListNode add=result;
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode extra=head;

        while(size>=k){
// These are the steps to reverse the list ->
        
        ListNode curr=extra;
        ListNode prev=null;

        int x=k;
            while(x>0){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                x--;
            }
            add.next=prev;
            add=extra;
            extra=curr;
            size-=k;
        }
        add.next=extra;
        return result.next;
    }
}