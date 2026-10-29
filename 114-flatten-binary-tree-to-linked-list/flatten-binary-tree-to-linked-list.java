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
    private void dfs(TreeNode node, List<TreeNode> list){
        if(node==null){
            return;
        }
        list.add(node);
        dfs(node.left,list);
        dfs(node.right,list);

    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        dfs(root,list);

        // Now we have a arraylist with all the nodes
        for(int i=0; i<list.size()-1; i++){
            TreeNode curr= list.get(i);

            curr.left= null;
            curr.right= list.get(i+1);
        }
        TreeNode last= list.get(list.size()-1);
        last.left=null;
        last.right=null;
    }
}