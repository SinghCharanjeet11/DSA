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
    private static int left(TreeNode node){
        int ht=0;
        while(node!=null){
            ht++;
            node=node.left;
        }
        return ht;
    }
    private static int right(TreeNode node){
        int ht=0;
        while(node!=null){
            ht++;
            node= node.right;
        }
        return ht;
    }
    private static int count(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= left(root);
        int right= right(root);
// This is teh case where we have to think as there is no need of going further down as it will return 2^h -1;   left shift of ht gives 2^h.
        if(left==right){
            return (1 << left) -1;
        }
        return 1+count(root.left)+count(root.right);
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return count(root);
        
    }
}