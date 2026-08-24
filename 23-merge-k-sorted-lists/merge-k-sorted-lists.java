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
    private static ListNode merge(ListNode head1,ListNode head2){
        ListNode result = new ListNode(-1);
        ListNode curr=result;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                curr.next= head1;
                curr=head1;
                head1=head1.next;
            }
            else {
                curr.next= head2;
                curr=head2;
                head2=head2.next;
            }
        }
        if(head1!=null){
            curr.next=head1;
        }
        else {
            curr.next=head2;
        }
        return result.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if( lists.length==1){
            return lists[0];
        }
        ListNode result=null;
        for (int i = 0; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;

        
    }
}