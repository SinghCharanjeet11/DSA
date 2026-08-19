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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // nth node from end is n-size()+1th node from start..
        if(head==null){
            return head;
        }
            ListNode temp=head;
            int count=0;
            while(temp!=null){
                count++;
                temp=temp.next;
            }
            if(n>count){
                return head;
            }
            if(n==count){
                head=head.next;
                return head;
            }
            ListNode temp2=head;
            int pos=count-n;
            for(int i=1;i<pos;i++){
                temp2=temp2.next;
            }
            temp2.next=temp2.next.next;
            return head;
        
    }
}