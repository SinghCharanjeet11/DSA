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
    // private List<Integer> result;
    // private int idx;
    // private void inorder(TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //     inorder(root.left);
    //     result.add(root.val);
    //     inorder(root.right);
    // }
    Stack<TreeNode> st= new Stack<>();

    public BSTIterator(TreeNode root) {
        // result= new ArrayList<>();
        // inorder(root);
        pushLeft(root);
    }
    private void pushLeft(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode value= st.pop();
        pushLeft(value.right);
        return value.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */