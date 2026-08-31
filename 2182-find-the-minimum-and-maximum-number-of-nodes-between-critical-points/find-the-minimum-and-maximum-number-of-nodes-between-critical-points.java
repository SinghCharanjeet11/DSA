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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next==null){
            return new int[]{-1,-1};
        }
        ArrayList<Integer>ans=new ArrayList<>();
        ListNode temp=head.next;
        ListNode prev=head;
        ListNode nt=temp.next;
        int idx=1;
        while(nt!=null){
            if((prev.val>temp.val && nt.val>temp.val)
                    ||(prev.val<temp.val && nt.val<temp.val)){

                ans.add(idx);
            }
            prev=temp;
            temp=nt;
            nt=nt.next;
            idx++;

        }
        if(ans.size()<2){
            return new int[]{-1,-1};
        }
        int min = Integer.MAX_VALUE;

        for (int i=1; i < ans.size(); i++) {
            min=Math.min(min,ans.get(i) - ans.get(i-1));
        }
        int max = ans.get(ans.size() - 1) - ans.get(0);
        return new int[]{min, max}; 
    }
}