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
    private TreeNode resultTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer>hm){
        if(inStart>inEnd || postEnd<postStart){
            return null;
        }

        TreeNode root= new TreeNode(postorder[postEnd]);

        int inRoot=hm.get(root.val);
        int rightStart= inEnd- inRoot;

        root.right= resultTree(inorder, inRoot+1, inEnd, postorder, postEnd-rightStart, postEnd-1, hm);
        root.left= resultTree(inorder, inStart, inRoot-1, postorder, postStart, postEnd-rightStart-1, hm);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hm= new HashMap<>();
        int n= inorder.length;
        for(int i=0; i<n; i++){
            hm.put(inorder[i], i);
        }
        TreeNode root= resultTree(inorder, 0, n-1, postorder, 0, n-1, hm);
        return root;
    }
}