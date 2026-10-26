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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node= node;
            this.index= index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(root,1));
        int maxWidth=0;

        while(!q.isEmpty()){
            int size= q.size();
            int first=0;
            int last=0;
            for(int i=0; i<size; i++){
                Pair curr= q.poll();
                TreeNode node= curr.node;
                int idx= curr.index;
                if(i==0){
                    first=idx;
                }
                if(i==size-1){
                    last= idx;
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left, 2*idx));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, 2*idx+1));
                }

            }
            maxWidth= Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}