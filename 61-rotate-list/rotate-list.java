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
        if(head==null || head.next==null){
            return head;
        }
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        k= k%size;
        if(k==0){
            return head;
        }
        int split=size-k;
        ListNode prev=head;
        for(int i=1;i<split;i++){
            prev=prev.next;
        }
        ListNode start=prev.next;
        prev.next=null;
        ListNode traverse=start;
        while(traverse.next!=null){
            traverse=traverse.next;
        }
        traverse.next=head;
        return start;

    }
}