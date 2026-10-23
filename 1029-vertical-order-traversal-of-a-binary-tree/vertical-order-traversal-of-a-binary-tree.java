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
    static class Entry {
        int col;
        int row;
        int value;

        Entry(int col, int row, int value) {
            this.col = col;
            this.row = row;
            this.value = value;
        }
    }
    private void dfs(TreeNode node,int row,int col,List<Entry> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new Entry(col,row,node.val));
        dfs(node.left,row + 1,col - 1,nodes);
        dfs(node.right,row + 1,col + 1,nodes);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        List<Entry> nodes= new ArrayList<>();
        dfs(root, 0, 0, nodes);

        nodes.sort((a,b)->{
            if(a.col!=b.col){
                return Integer.compare(a.col, b.col);
            }
            if(a.row!=b.row){
                return Integer.compare(a.row, b.row);
            
            }
            return Integer.compare(a.value, b.value);
        });

        List<List<Integer>> answer= new ArrayList<>();
        Integer prevCol= null;

        for (Entry entry : nodes) {
            if (prevCol== null || entry.col != prevCol) {
                answer.add(new ArrayList<>());
                prevCol = entry.col;
            }
            answer.get(answer.size() - 1).add(entry.value);
        }
        return answer;

    }
}