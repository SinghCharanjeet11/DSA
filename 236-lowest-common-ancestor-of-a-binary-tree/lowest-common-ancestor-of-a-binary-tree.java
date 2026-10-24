/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean path(TreeNode node, List<TreeNode> pa, TreeNode target){
        if(node==null){
            return false;
        }
        pa.add(node);
        if(node==target){
            return true;
        }
        if(path(node.left, pa, target) || path(node.right, pa, target)){
            return true;
        }
        pa.remove(pa.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP= new ArrayList<>();
        List<TreeNode> pathQ= new ArrayList<>();
        
        path(root, pathP, p);
        path(root, pathQ, q);

        TreeNode lca=null;
        int min= Math.min(pathP.size(), pathQ.size());
        for(int i=0; i<min; i++){
            if(pathP.get(i)!=pathQ.get(i)){
                break;
            }
            lca=pathP.get(i);
        }
        return lca;
    }
}