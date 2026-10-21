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
    private static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHt= height(root.left);
        int rightHt= height(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }
    private static int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight= height(root.left);
        int rightHeight= height(root.right);

        int currDiam= leftHeight + rightHeight;

        int leftDiam= diameter(root.left);
        int rightDiam= diameter(root.right);

        return Math.max(currDiam, Math.max(leftDiam, rightDiam));

    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
}