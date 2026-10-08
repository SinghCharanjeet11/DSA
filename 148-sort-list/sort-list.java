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
    private static ListNode mergeSort(ListNode head){
        // First we will calculate the middle value
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        // Now we have to split the array to peerform the merge operation
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(mid);
        return merge(left, right);

    }
    private static ListNode merge(ListNode left, ListNode right){
        ListNode result= new ListNode(-1);
        ListNode curr= result;
        while(left!=null && right!=null){
            if(left.val<right.val){
                curr.next=left;
                left=left.next;
            }
            else{
                curr.next=right;
                right=right.next;
            }
            curr=curr.next;
        }
        while(left!=null){
            curr.next=left;
            left=left.next;
            curr=curr.next;
        }
        while(right!=null){
            curr.next=right;
            right=right.next;
            curr=curr.next;
        }
        return result.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        return mergeSort(head);
    }
}