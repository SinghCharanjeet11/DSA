/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int scount=0;
    private int kthsmallest=-1;

    private void findsmallest(TreeNode root, int k){
        if(root==null || scount>=k){
            return;
        }
        findsmallest(root.left, k);
        scount++;
        if(scount==k){
            kthsmallest= root.val;
            return;
        }
        findsmallest(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        findsmallest(root, k);
        return kthsmallest;
    }
}