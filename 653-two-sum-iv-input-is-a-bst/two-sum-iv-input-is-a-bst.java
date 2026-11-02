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
 class BSTIterator{
    private Stack<TreeNode> st;
    private boolean reverse;

    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse){
                node= node.right;
            }
            else{
                node=node.left;
            }
        }
    }
    public BSTIterator(TreeNode root, boolean isReverse){
        st= new Stack<>();
        reverse= isReverse;
        pushAll(root);
    }
    public int next(){
        TreeNode top= st.pop();
        if(reverse){
            pushAll(top.left);
        }
        else{
            pushAll(top.right);
        }
        return top.val;
    }
 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }

        BSTIterator left= new BSTIterator(root,false);
        BSTIterator right= new BSTIterator(root,true);

        int i= left.next();
        int j= right.next();

        while(i<j){
            int currSum= i+j;
            if(currSum==k){
                return true;
            }
            else if(currSum>k){
                j= right.next();
            }
            else{
                i= left.next();
            }
        }
        return false;
    
    }
}