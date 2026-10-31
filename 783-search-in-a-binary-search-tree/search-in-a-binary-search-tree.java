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
    private TreeNode search(TreeNode root, int target){
        if(root==null || root.val==target){
            return root;
        }
        if(root.val>target){
            return search(root.left, target);
        }
        else{
           return search(root.right, target);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
         return search(root,val);
        
    }
}