/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersection=null;
        ListNode tempA=headA;
        ListNode tempB=headB;
        int sizeA=0;
        int sizeB=0;

        while(tempA!=null){
            sizeA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            sizeB++;
            tempB=tempB.next;
        }
        if(sizeA>sizeB){
            while(sizeA!=sizeB){
                headA=headA.next;
                sizeA--;
            }
        }
        else{
            while(sizeB!=sizeA){
                headB=headB.next;
                sizeB--;
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return intersection;
        
    }
}