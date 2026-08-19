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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode result= new ListNode(0,head);
        ListNode prev=result;
        int i=1;
        while(i!=left){
            prev=prev.next;
            i++;
        }
        ListNode start=prev.next;
        ListNode extra=start.next;
        int j=0;
        while(j!=right-left){
            start.next=extra.next;
            extra.next=prev.next;
            prev.next=extra;
            extra=start.next;
            j++;
        }
        return result.next;


        
    }
}