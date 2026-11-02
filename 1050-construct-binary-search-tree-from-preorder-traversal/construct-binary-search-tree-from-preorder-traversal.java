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
    int idx=0;
    // Not static as its value will change after each value inserted in root
    private TreeNode buildBST(int[] preorder, int limit){
        if(idx==preorder.length || preorder[idx]>limit){
            return null;
        }
        TreeNode root= new TreeNode(preorder[idx++]);

        root.left= buildBST(preorder, root.val);
        root.right= buildBST(preorder, limit);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MAX_VALUE);
    }
}