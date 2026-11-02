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
    private TreeNode buildBST(int[] inorder, int[] preorder, int left, int right){
        if(left>right  || idx>=preorder.length){
            return null;
        }
        int value= preorder[idx++];
        TreeNode root= new TreeNode(value);

        int i= left;
        while(i<=right && inorder[i]!=value){
            i++;
        }

        root.left= buildBST(inorder, preorder, left, i-1);
        root.right= buildBST(inorder, preorder, i+1, right);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder=Arrays.stream(preorder).toArray();
        Arrays.sort(inorder);
        int n= preorder.length;
        return buildBST(inorder, preorder, 0, n-1);
    }
}