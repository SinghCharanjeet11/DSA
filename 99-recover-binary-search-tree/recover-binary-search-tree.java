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
    private void replace(TreeNode root, ArrayList<Integer> collect){
        if(root==null){
            return;
        }
        replace(root.left, collect);
        root.val= collect.get(idx);
        idx++;
        replace(root.right, collect);
    }
    private void inorder(TreeNode root, ArrayList<Integer> collect){
        if(root==null){
            return;
        }
        inorder(root.left, collect);
        collect.add(root.val);
        inorder(root.right, collect);
    }
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> collect= new ArrayList<>();
        inorder(root, collect);

        // Now sort teh collected values
        Collections.sort(collect);
        replace(root, collect);

        
    }
}