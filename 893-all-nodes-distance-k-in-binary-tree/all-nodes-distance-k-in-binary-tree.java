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
    private static void buildGraph(TreeNode node, Map<TreeNode , List<TreeNode>> graph){
        if(node==null){
            return;
        }

        if(node.left!=null){
            if(!graph.containsKey(node.left)){
                graph.put(node.left, new ArrayList<>());
            }
            graph.get(node.left).add(node);
            if(!graph.containsKey(node)){
                graph.put(node, new ArrayList<>());
            }
            graph.get(node).add(node.left);

            buildGraph(node.left, graph);
        }
        if(node.right!=null){
            if(!graph.containsKey(node.right)){
                graph.put(node.right, new ArrayList<>());
            }
            graph.get(node.right).add(node);
            if(!graph.containsKey(node)){
                graph.put(node, new ArrayList<>());
            }
            graph.get(node).add(node.right);

            buildGraph(node.right, graph);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result= new ArrayList<>();
        if(root==null){
            return result;
        }

        Map<TreeNode , List<TreeNode>> graph = new HashMap<>();

        buildGraph(root, graph);

        Queue<TreeNode>q= new LinkedList<>();
        Set<TreeNode> vis= new HashSet<>();
        
        q.offer(target);
        vis.add(target);
        int level=0;

        while(!q.isEmpty()){
            int size= q.size();
            if(level==k){
                break;
            }
            for(int i=0; i<size; i++){
                TreeNode curr= q.poll();
                for(TreeNode neighbor: graph.getOrDefault(curr, Collections.emptyList())){
                    if(!vis.contains(neighbor)){
                        vis.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            level++;
        }
        // All the nodes now are at K distance from target
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }
}