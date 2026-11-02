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
class BSTIterator {
    private List<Integer> result;
    private int idx;
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        result= new ArrayList<>();
        idx=0;
        inorder(root);
    }
    
    public int next() {
        int value= result.get(idx);
        idx++;
        return value;
        
    }
    
    public boolean hasNext() {
        return idx < result.size();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */