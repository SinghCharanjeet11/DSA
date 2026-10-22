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
    static int maxSum;
    private static int pathUsed(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftGain= Math.max(0, pathUsed(root.left));
        int rightGain= Math.max(0, pathUsed(root.right));
        int currPath= root.val + leftGain + rightGain;

        maxSum= Math.max(maxSum, currPath);

        return root.val + Math.max( leftGain, rightGain);
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        pathUsed(root);
        return maxSum;
    }
}