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
    private static ListNode middle(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    private static ListNode merge(ListNode left,ListNode right){
        ListNode result=new ListNode(-1);
        ListNode temp=result;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        if(left!=null){
            temp.next=left;
        }
        else{
            temp.next=right;
        }
        return result.next;

    }
    private static ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=middle(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        return mergeSort(head);
        
    }
}